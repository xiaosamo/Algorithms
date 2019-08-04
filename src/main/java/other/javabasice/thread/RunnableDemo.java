package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class RunnableDemo {
    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable("Thread1");
        MyRunnable runnable2 = new MyRunnable("Thread2");
        MyRunnable runnable3 = new MyRunnable("Thread3");

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);

        t1.start();
        t2.start();
        t3.start();

    }
}
