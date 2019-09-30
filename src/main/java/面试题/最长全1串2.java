package 面试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/30
 * @description
 * https://blog.csdn.net/weixin_42564710/article/details/98513244
 * 双指针，一次遍历。O（n）时间复杂度。
 */
public class 最长全1串2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }


        int i=0,j=0;

        int max = 0;
        while (j < n) {
            if (a[i] == 1) {
                ++j;
            } else if (k > 0) {
                --k;
                ++j;

            } else {
                max = Math.max(max, j - i);
                // 遇到第一个0停止
                while (i < j && a[i] == 1) {
                    ++i;
                }
                ++i;
                ++j;
            }
        }
        max = Math.max(max, j - i);
        System.out.println(max);
    }

}
