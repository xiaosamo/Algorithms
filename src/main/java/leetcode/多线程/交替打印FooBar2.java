package leetcode.多线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 * 使用阻塞队列
 * 其实和信号量一样
 */
public class 交替打印FooBar2 {
    class FooBar {

        private int n;

        private BlockingQueue<Integer> q1 = new ArrayBlockingQueue<>(1);
        private BlockingQueue<Integer> q2 = new ArrayBlockingQueue<>(1);

        public FooBar(int n) {
            this.n = n;
        }


        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                q1.put(1);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                q2.take();

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                q1.take();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                q2.put(1);
            }
        }
    }
}
