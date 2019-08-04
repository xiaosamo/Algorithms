package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Thread1");
        MyThread m2 = new MyThread("Thread2");
        MyThread m3 = new MyThread("Thread3");

        m1.start();
        m2.start();
        m3.start();
    }
}
