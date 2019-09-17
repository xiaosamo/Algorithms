package leetcode.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 * https://mp.weixin.qq.com/s?__biz=MzI1NDQ3MjQxNA==&mid=2247489989&idx=1&sn=76fc6b53ac9c7e9a3bf127e6ace66c3c&chksm=e9c5e074deb26962dcb2aa82df61e93847b60b106f92fa0b38f7d8cea07d12d7eb3f8cf180a5&mpshare=1&scene=1&srcid=&sharer_sharetime=1568648956437&sharer_shareid=51ea38d307ea1d06fd23e54a65343b69#rd
 * CountDownLatch
 * 还可以循环屏障、Semaphore等
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
