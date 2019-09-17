package leetcode.多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author yuanshijia
 * @date 2019-08-08
 * @description
 */
public class 打印零与奇偶数 {
    class ZeroEvenOdd {
        private int n;


        private Semaphore s1 = new Semaphore(1);
        private Semaphore s2 = new Semaphore(0);
        private Semaphore s3 = new Semaphore(0);
        private Semaphore s4 = new Semaphore(0);


        private volatile boolean flag = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                if (flag) {
                    s1.acquire();
                } else {
                    s3.acquire();
                }

                printNumber.accept(0);

                if (flag) {
                    s2.release();
                }else{
                    s4.release();
                }
            }
        }

        /**
         * 奇数
         * @param printNumber
         * @throws InterruptedException
         */
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i+=2) {
                s2.acquire();
                printNumber.accept(i);
                flag = false;
                s3.release();
            }
        }


        /**
         * 偶数
         * @param printNumber
         * @throws InterruptedException
         */
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i+=2) {
                s4.acquire();
                printNumber.accept(i);
                flag = true;
                s1.release();
            }
        }

    }
}
