package 面试题.有赞;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/9
 * @description
 */
public class 字符串旋转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(";");
        System.out.println(solve(split));
    }

    private static boolean solve(String[] str) {
        String a = str[0], b = str[1];
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length() - 1; i++) {
            if (b.contains(a.substring(0, i + 1)) && b.contains(a.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 第一个字符串叠加起来问题会简单很多
     * youzanyouzan -> zanyou
     * @param str
     * @return
     */
    public static boolean solve2(String []str) {

        if(str[0].length()!=str[1].length()){
            return false;
        }
        str[0] = str[0]+str[0];
        return str[0].contains(str[1]);
    }

}
