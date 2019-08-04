package 牛客面试题;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(Test2.a);
    }

    static class Test2 {
        public static final String a = "JD";

        static {
            System.out.print("OK");
        }

    }
}
