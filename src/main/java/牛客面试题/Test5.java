package 牛客面试题;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.print(fun1());
        Object o = new Object();
    }

    public static String fun1() {
        try {
            System.out.print("A");
            return fun2();
        } finally {
            System.out.print("B");
        }
    }

    public static String fun2() {
        System.out.print("C");
        return "D";
    }
}
