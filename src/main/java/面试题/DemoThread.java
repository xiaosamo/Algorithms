package 面试题;

/**
 * @author yuan
 * @date 2019/9/10
 * @description
 * 程序运行结果不确定
 */
public class DemoThread extends Thread{
    public static void main(String args[]) {
        DemoThread threadOne = new DemoThread();
        DemoThread threadTwo = new DemoThread();
        threadOne.start();
        System.out.print("thread one.");
        threadTwo.start();
        System.out.print("thread two.");
    }
    @Override
    public void run() {
        System.out.print("Thread.");
    }
}
