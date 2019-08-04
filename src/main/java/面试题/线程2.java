package 面试题;

import kotlin.jvm.Synchronized;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * @author yhf
 * @date 2019/5/9
 * @description
 */
public class 线程2 {
    private static final int num = 10;


    public static void main(String[] args) throws IOException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < num; i++) {
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                s2.release();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    try {
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    s3.release();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    try {
                        s3.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");
                    s1.release();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

        new BufferedWriter(new FileWriter("sdf.txt"));
//        new BufferedReader(new FileIn("sdf.txt"));
//        ReetrankLock


    }

}
