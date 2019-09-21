package 负载均衡;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 * 简单随机选择
 */
public class RandomSelect extends LoadBalance{

    @Override
    protected Invoker doSelect(List<Invoker> invokers) {
        /**
         * Java7新增的类，给多线程并发生成随机数使用的。为什么ThreadLocalRandom要比Random快呢，这是因为Random在生成随机数的时候使用了CAS（compare and set），但是ThreadLocalRandom却没有使用。
         */
        int index = ThreadLocalRandom.current().nextInt(invokers.size());
        return invokers.get(index);
    }
}
