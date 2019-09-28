package 面试题.多线程.两个线程交替输出;

/**
 * @author yuan
 * @date 2019/9/28
 * @description
 * 模拟自旋锁
 * 重量级锁需要在操作系统种，由用户态向内核态转换，而自旋可以直接在用户态完成；
 * 当线程竞争不大时，自旋锁效率很高，但如果线程很多，还是用重量级锁好
 *
 */
public class T06_00_cas {
    /**
     * 还可以用其他的，比如int类型
     */
    enum ReadyToRun {T1, T2,} // T1表示线程1运行，T2表示线程2运行

    private static volatile ReadyToRun r = ReadyToRun.T1; // 线程1先运行，需要volatile

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            for (int i = 1; i <= 26; i++) {
                while (r != ReadyToRun.T1) {}
                System.out.print(i);
                r = ReadyToRun.T2;
            }
        });

        Thread t2 = new Thread(()->{
            for (char c = 'A'; c <= 'Z'; c++) {
                while(r!=ReadyToRun.T2) {}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        });

        t1.start();
        t2.start();

    }
}
