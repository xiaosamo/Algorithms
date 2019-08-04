package other.javabasice.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author yuan
 * @date 2019/4/2
 * @description
 */
public class Worker {
    public static void main(String[] args) {
        // 工人数
        int n = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < n; i++) {
            new Work(i, semaphore).start();
        }
    }

    static class Work extends Thread{
        private int num;
        private Semaphore semaphore;

        public Work(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器...");
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
