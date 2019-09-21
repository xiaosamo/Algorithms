/**
 * @author yuan
 * @date 2019/9/20
 * @description
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");

        System.out.println(s1== s2);
        System.out.println(s1== s3);

        System.out.println();

        Integer a = new Integer(3);
        Integer b = 3;
        int c= 3;
        System.out.println(a==b);
        System.out.println(a==c);

    }
}
