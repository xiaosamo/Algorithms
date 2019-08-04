package other;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2018/12/13
 */
public class 练习 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(in.next()
                    .replace("你会", "会")
                    .replace("吗", "")
                    .replace("?", "")
                    .replace("？", ""));

        }
    }
}
