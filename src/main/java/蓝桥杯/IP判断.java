package 蓝桥杯;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class IP判断 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
//            String s = in.next();
            String s = in.nextLine();

            if (s.equals("End of file")) {
                break;//判断是否结束
            }
            System.out.println(s);

            if (solve(s)) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }

    private static boolean solve(String s) {
        // 如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");
        String[] split = s.split("\\.");
        for (int i = 0; i < split.length; i++) {
            try {
                Integer a = Integer.valueOf(split[i]);
                if (a < 0 || a > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
