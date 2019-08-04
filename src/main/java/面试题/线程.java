package 面试题;

import java.util.concurrent.CountDownLatch;

/**
 * @author yhf
 * @date 2019/5/9
 * @description
 */
public class 线程 {

    private static CountDownLatch latch = new CountDownLatch(3);



    public static void main(String[] args) throws InterruptedException {
        Work work1 = new Work("A");
        Work work2 = new Work("B");
        Work work3 = new Work("C");
        work1.start();
        work2.start();
        work3.start();

        latch.await();



    }

    static class Work extends Thread{

        private String id;
        public Work(String id) {
            this.id = id;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(id);
            }
            latch.countDown();

        }
    }
}
