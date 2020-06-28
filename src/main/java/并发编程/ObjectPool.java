package 并发编程;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author yuan
 * @date 2020/2/12
 * 信号量快速实现一个限流器
 */
public class ObjectPool<T,R> {
    final List<T> pool;


    // 用信号量实现限流器
    final Semaphore semaphore;

    public ObjectPool(int size,T t) {
        pool = new Vector<>();

        for (int i = 0; i < size; i++) {
            pool.add(t);
        }

        semaphore = new Semaphore(size);
    }


    // 利用对象池的对象，调用 func

    private R exec(Function<T, R> function) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            // 为获取到的线程分配一个对象 t
            t = pool.remove(0);
            return function.apply(t);
        }finally {
            // 执行完回调函数之后，释放对象
            pool.add(t);
            semaphore.release();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ObjectPool<Long, String> pool = new ObjectPool<>(10, 2L);


        pool.exec(t -> {
            System.out.println(t);

            return t.toString();
        });

    }
}
