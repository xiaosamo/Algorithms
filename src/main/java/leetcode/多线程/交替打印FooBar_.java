package leetcode.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 */
public class 交替打印FooBar_ {
    class FooBar {
        private int n;

        private Semaphore s1 = new Semaphore(0);
        private Semaphore s2 = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                printFoo.run();

                s1.release(); // 释放一个许可
                // printFoo.run() outputs "foo". Do not change or remove this line.

                s2.acquire();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                s1.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                s2.release();
            }
        }
    }
}
