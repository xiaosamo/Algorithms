package 牛客面试题;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

    }
}
