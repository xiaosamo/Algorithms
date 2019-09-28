package 面试题.多线程.两个线程交替输出;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yuan
 * @date 2019/9/28
 * @description
 * 最简单、简洁的写法
 * locksupport支持先调用unpark
 */
public class T08_00_LockSupport {
    private static Thread t1,t2;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();


        t1 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.unpark(t2); // 让t2运行
                LockSupport.park(); // 当前线程阻塞
            }
        });

        t2 = new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                LockSupport.park(); // 先阻塞
                System.out.print(c); // 唤醒后输出
                LockSupport.unpark(t1); // 让t1输出

            }
        });

        t1.start();
        t2.start();
    }
}
