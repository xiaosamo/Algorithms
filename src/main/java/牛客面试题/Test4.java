package 牛客面试题;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.print(B.c);
    }

    static class A {

        static {
            System.out.print("A");
        }
    }
    static class B extends A{
        static {
            System.out.print("B");
        }
        public final static String c = "C";
    }

}
