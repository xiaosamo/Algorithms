import java.io.Console;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/6/23
 * @description
 */
public class Test {
    public static void main(String[] args) {


        double d = 2.38 / 240;
        double t = Math.pow(d, 1.0 / 3.0);
        System.out.println(110 * t);

        double d1 = 1.83 / 236.45;
        double t2 = Math.pow(d1, 1.0 / 3.0);
        System.out.println(110 * t2);


        double d3 = Math.sqrt(3380.18);
        System.out.println(d3);


        double d4 = Math.sqrt(5281.82);
        System.out.println(d4);


        System.out.println();
        test();
    }

    private static void test(){

        Console console = System.console();
        String username = console.readLine("username:");
        char[] password = console.readPassword("pass:");
        System.out.println(username + " " + String.valueOf(password));

//        " is the"
//        int n=
//        1;
//        n++;
//        System.out.println(n);
//        String s;
//        int b;
//        System.out.println(b);
    }
}
