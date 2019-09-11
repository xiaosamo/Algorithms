package 面试题.有赞;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/9
 * @description
 */
public class 查找数组众数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().replace("[", "").replace("]", "").split(",");
        int[] a = new int[split.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(split[i]);
        }

        System.out.println(solve(a));
    }

    /**
     * 根据众数的定义，如果数组中一次删去两个不同的数，那么最后剩下来的数一定是众数
     * 时间复杂度为O(n)
     * 我们可以考虑在遍历数组的时候保存两个值，一个是数组中的一个数字，另一个是次数，
     * 当我们遍历到下一个数字的时候如果下一个数字和我们之前保存的数字相同则次数加1，如果次数为零那么我们需要保存下一个数字，并把次数设为1.
     * @param a
     * @return
     */
    private static int solve(int []a) {
        int cnt = 0;
        int ans = a[0];
        for (int i : a) {
            if (i == ans) {
                ++cnt;
            } else {
                --cnt;
                if (cnt < 0) {
                    ans = i;
                    cnt = 1;
                }
            }
        }
        return ans;
    }
}
