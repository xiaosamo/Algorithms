package leetcode.多线程;

import java.util.concurrent.Semaphore;

/**
 * @author yuanshijia
 * @date 2019-08-06
 * @description
 * https://leetcode-cn.com/problems/print-foobar-alternately/solution/jing-dian-tong-bu-wen-ti-sheng-chan-zhe-yu-xiao-fe/
 * 本质就是生产者与消费者问题，foo是生产者，bar是消费者，要先生产才能被消费，且商品缓冲区上限为1
 *
 * acquire 就是 值+1
 * release 就是 值-1
 * 简单理解就是当值是0，就可以继续执行，不为零就等待变为0后再执行
 */
public class 交替打印FooBar {
    class FooBar {

        private int n;

        /**
         * empty信号量初始值设为1  空缓冲区数量
         */
        private Semaphore empty = new Semaphore(1);
        /**
         * full 信号量初始值设为0  满缓冲区数量
         */
        private Semaphore full = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                empty.acquire(); // 申请一个空的缓冲区

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                full.release(); // 缓冲区的数量+1
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                full.acquire(); // 申请一个满缓冲区，当缓冲区有商品时才能实现消费者行为

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                empty.release(); // 空缓冲区数量+1
            }
        }
    }
}
