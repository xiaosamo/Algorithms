package leetcode.多线程;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 * 使用锁
 * https://leetcode-cn.com/problems/print-in-order/solution/gou-zao-zhi-xing-ping-zhang-shi-xian-by-pulsaryu/
 */
public class 按序打印 {

    static class Foo{


        private boolean firstFinished = false;
        private boolean secondFinished = false;

        private final Object lock = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (lock) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }

        }
    }

}
