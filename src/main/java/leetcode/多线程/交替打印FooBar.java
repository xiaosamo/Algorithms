package leetcode.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 */
public class 交替打印FooBar {
    class FooBar {
        private int n;
        private CyclicBarrier cyclicBarrier;

        public FooBar(int n) {
            this.n = n;
            cyclicBarrier = new CyclicBarrier(n);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            }
        }
    }
}
