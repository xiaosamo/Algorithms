import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author yuan
 * @date 2019/11/25
 * @description
 */
public class Test2 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");

        String a = "java";
        String b = "java";
        String c = "ja";
        String d = "va";

        String e = c + d;

        String f = b;

        System.out.println(a == b);
        System.out.println(a == d);
        System.out.println(a == "java");

        System.out.println(a == f);
        System.out.println(e == f);

    }

    static void pong() {
        System.out.print("pong");
    }
}
