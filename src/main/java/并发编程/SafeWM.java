package 并发编程;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuan
 * @date 2020/2/19
 * 设置库存
 * 极客时间 并发编程
 */
public class SafeWM {
    class WMRange{
        final int upper;
        final int lower;
        WMRange(int upper,int lower){
            this.upper = upper;
            this.lower = lower;
        }
    }

    final AtomicReference<WMRange> rf = new AtomicReference<>(new WMRange(0, 0));

    // 设置库存上限
    void setUpper(int v){
        WMRange newRange;
        WMRange oldRange;
        do{
            // 每个回合都需要重新获取旧值
            oldRange = rf.get();
            // 检查参数合法性
            if(v < oldRange.lower){
                throw new IllegalArgumentException();
            }
            newRange = new
                    WMRange(v, oldRange.lower);
        }while(!rf.compareAndSet(oldRange, newRange));
    }
}
