package 面试题.两个线程轮流输出;

/**
 * @author yuan
 * @date 2019/9/17
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.print("foo");

            }
        });

        thread.run();
        System.out.println("bar");

    }
}
