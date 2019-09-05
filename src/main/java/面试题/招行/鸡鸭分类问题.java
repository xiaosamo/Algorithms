package 面试题.招行;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/5
 * @description
 */
public class 鸡鸭分类问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println(solve(s));
    }

    /**
     * 贪心
     * 记录相对位置的变化
     * 比如 1121221 1的下标位置为 0 1 3 6
     *      1111222 目标1的位置为 0 1 2 3
     * 需要移动次数 (6-3) + (3-2) + （1-1） + (0-0) = 4
     * 同理求2的相对下标
     *
     * @param s
     * @return
     */
    private static int solve(String s) {
        char[] chars = s.toCharArray();
        List<Integer> nc = new ArrayList<>();
        List<Integer> nd = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'C') {
                nc.add(i);
            } else {
                nd.add(i);
            }
        }

        int sum1 = 0;
        for (int i = 0, j = 0; i < nc.size(); i++, j++) {
            sum1 += nc.get(j) - i;
        }

        int sum2 = 0;
        for (int i = 0, j = 0; i < nd.size(); i++, j++) {
            sum2 += nd.get(j) - i;
        }
        return Math.min(sum1, sum2);
    }
}
