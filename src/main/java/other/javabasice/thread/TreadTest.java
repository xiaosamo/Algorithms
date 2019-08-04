package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class TreadTest {
    private static void attack(){
        System.out.println("Fight");
        System.out.println("Current Thread is：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                attack();
            }
        };


        System.out.println("Current main Thread is：" + Thread.currentThread().getName());
         t.start();
         // 等待线程执行完毕
         t.join();
         // 再次执行start方法，会抛出异常
        t.start();
    }
}
