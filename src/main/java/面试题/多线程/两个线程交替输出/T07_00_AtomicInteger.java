package 面试题.多线程.两个线程交替输出;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuan
 * @date 2019/9/28
 * @description
 * 模拟自旋锁
 * 重量级锁需要在操作系统种，由用户态向内核态转换，而自旋可以直接在用户态完成；
 * 当线程竞争不大时，自旋锁效率很高，但如果线程很多，还是用重量级锁好
 *
 */
public class T07_00_AtomicInteger {
    static AtomicInteger threadNo = new AtomicInteger(1);// 1表示1线程运行


    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            for (int i = 1; i <= 26; i++) {
                while (threadNo.get() !=1) {}
                System.out.print(i);
               threadNo.set(2);
            }
        });

        Thread t2 = new Thread(()->{
            for (char c = 'A'; c <= 'Z'; c++) {
                while (threadNo.get() != 2) {}
                System.out.print(c);
                threadNo.set(1);
            }
        });

        t1.start();
        t2.start();

    }
}
