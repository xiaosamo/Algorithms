package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable interruptTask = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    // 在正常运行任务时，经常检测本线程的中断标志位，如果设置了中断标志就停止线程
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") loop " + i);
                    }

                } catch (InterruptedException e) {
                    // 当线程处于阻塞状态，调用interrupt()会抛出InterruptedException异常
                    System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") catch InterruptedException " + e.getMessage());
                }

            }
        };

        Thread t1 = new Thread(interruptTask, "t1");
        System.out.println(t1.getName() + " (" + t1.getState() + ") is new. ");

        t1.start();
        System.out.println(t1.getName() + " (" + t1.getState() + ") is started. ");

        // 主线程中断300ms，然后主线程给t1发"中断"指令
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");


        Thread.sleep(300);
        System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");


    }
}
