package other.javabasice.thread;

/**
 * @author yuan
 * @date 2019/3/22
 * @description
 */
public class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
        System.out.println(cycleWait.value); // null

//        while (cycleWait.value == null) {
//            Thread.sleep(100);
//        }

        t.join();

        // 5s 后
        System.out.println(cycleWait.value);
    }
}
