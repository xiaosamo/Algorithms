package 负载均衡;

import java.util.List;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * LoadBalance 中文意思为负载均衡，它的职责是将网络请求，或者其他形式的负载“均摊”到不同的机器上。避免集群中部分服务器压力过大，而另一些服务器比较空闲的情况。
 */
public abstract class LoadBalance {

    public Invoker select(List<Invoker> invokers) {
        if (invokers == null || invokers.isEmpty()) {
            return null;
        }
        if (invokers.size() == 1) {
            // 如果 invokers 列表中仅有一个 Invoker，直接返回即可，无需进行负载均衡
            return invokers.get(0);
        }
        // 调用 doSelect 方法进行负载均衡，该方法为抽象方法，由子类实现
        return doSelect(invokers);
    }

    protected abstract Invoker doSelect(List<Invoker> invokers);
}
