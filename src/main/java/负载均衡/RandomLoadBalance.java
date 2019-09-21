package 负载均衡;

import java.util.List;
import java.util.Random;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * RandomLoadBalance 是加权随机算法的具体实现，它的算法思想很简单。假设我们有一组服务器 servers = [A, B, C]，他们对应的权重为 weights = [5, 3, 2]，权重总和为10。现在把这些权重值平铺在一维坐标值上，[0, 5) 区间属于服务器 A，[5, 8) 区间属于服务器 B，[8, 10) 区间属于服务器 C。接下来通过随机数生成器生成一个范围在 [0, 10) 之间的随机数，然后计算这个随机数会落到哪个区间上。比如数字3会落到服务器 A 对应的区间上，此时返回服务器 A 即可。权重越大的机器，在坐标轴上对应的区间范围就越大，因此随机数生成器生成的数字就会有更大的概率落到此区间内。只要随机数生成器产生的随机数分布性很好，在经过多次选择后，每个服务器被选中的次数比例接近其权重比例。比如，经过一万次选择后，服务器 A 被选中的次数大约为5000次，服务器 B 被选中的次数约为3000次，服务器 C 被选中的次数约为2000次。
 *
 * http://dubbo.apache.org/zh-cn/docs/source_code_guide/loadbalance.html
 */
public class RandomLoadBalance extends LoadBalance{

    private final Random random = new Random();
    @Override
    protected Invoker doSelect(List<Invoker> invokers) {

        int len = invokers.size();

        int totalWeight = 0;
        boolean sameWeight = true;
        // 计算总权重，并检测每个的权重是否相同
        for (int i = 0; i < len; i++) {
            Integer weight = invokers.get(i).getWeight();
            totalWeight += weight;
            if (sameWeight && i > 0 && !invokers.get(i - 1).getWeight().equals(weight)) {
                sameWeight = false;
            }
        }

        if (totalWeight > 0 && !sameWeight) {
            // 随机获取一个 [0, totalWeight) 区间内的数字
            int offset = random.nextInt(totalWeight);
            for (int i = 0; i < len; i++) {
                offset -= invokers.get(i).getWeight();
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        // 如果所有服务提供者权重值相同，此时直接随机返回一个即可
        return invokers.get(random.nextInt(invokers.size()));
    }
}
