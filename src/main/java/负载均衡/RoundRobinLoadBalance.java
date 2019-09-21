package 负载均衡;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * https://www.cnblogs.com/markcd/p/8456870.html
 *
 * 先来了解一下什么是加权轮询。这里从最简单的轮询开始讲起，所谓轮询是指将请求轮流分配给每台服务器。举个例子，我们有三台服务器 A、B、C。我们将第一个请求分配给服务器 A，第二个请求分配给服务器 B，第三个请求分配给服务器 C，第四个请求再次分配给服务器 A。这个过程就叫做轮询。轮询是一种无状态负载均衡算法，实现简单，适用于每台服务器性能相近的场景下。但现实情况下，我们并不能保证每台服务器性能均相近。如果我们将等量的请求分配给性能较差的服务器，这显然是不合理的。因此，这个时候我们需要对轮询过程进行加权，以调控每台服务器的负载。经过加权后，每台服务器能够得到的请求数比例，接近或等于他们的权重比。比如服务器 A、B、C 权重比为 5:2:1。那么在8次请求中，服务器 A 将收到其中的5次请求，服务器 B 会收到其中的2次请求，服务器 C 则收到其中的1次请求。
 *
 * 2、算法逻辑
 *
 * (1) 轮询所有节点，计算当前状态下所有节点的effectiveWeight之和totalWeight；
 * (2) currentWeight = currentWeight + effectiveWeight;  选出所有节点中currentWeight中最大的一个节点作为选中节点；
 * (3) 选中节点的currentWeight = currentWeight - totalWeight；
 *
 * 初始currentWeight值为{0, 0, 0}
 *
 *
 */
public class RoundRobinLoadBalance extends LoadBalance{

    private static final List<Node> nodes = Collections.synchronizedList(new ArrayList<>(10));

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {

        // 初始化
        if (nodes.isEmpty()) {
            for (int i = 0; i < invokers.size(); i++) {
                nodes.add(new Node(invokers.get(i), invokers.get(i).getWeight()));
            }
        }

        int totalWeight = 0;

        // 最大的权重
        Node maxWeigth = nodes.get(0);

        for (Node node : nodes) {
            totalWeight += node.effectiveWeight;
            node.currentWeight = node.currentWeight + node.effectiveWeight;

            if (node.currentWeight > maxWeigth.currentWeight) {
                maxWeigth = node;
            }
        }
        // 选择的需要减去totalWeight
        maxWeigth.currentWeight -= totalWeight;
        return maxWeigth.invoker;
    }

    private static class Node {

        final Invoker invoker;
        /**
         * 配置文件或初始化时约定好的每个节点的权重
         */
        final Integer weight;

        /**
         * 有效权重，初始化为weight。
         * 在通讯过程中发现节点异常，则-1；
         * 之后再次选取本节点，调用成功一次则+1，直达恢复到weight；
         * 此变量的作用主要是节点异常，降低其权重。
         */
        Integer effectiveWeight;
        /**
         * 节点当前权重，初始化为0。
         */
        Integer currentWeight;

        public Node(Invoker invoker, Integer weight) {
            this.invoker = invoker;
            this.weight = weight;
            this.effectiveWeight = weight;
            this.currentWeight = 0;
        }

    }
}
