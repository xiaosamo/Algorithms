package leetcode.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 * CountDownLatch
 *
 */
public class 按序打印2 {

    static class Foo{


        private CountDownLatch countDownLatchA = new CountDownLatch(1);
        private CountDownLatch countDownLatchB = new CountDownLatch(1);
        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatchA.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatchA.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatchB.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatchB.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
