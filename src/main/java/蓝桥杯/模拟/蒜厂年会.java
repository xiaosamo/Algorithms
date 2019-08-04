package 蓝桥杯.模拟;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 * 思路：
 *
 * 1、如果子序列的最大和在 1 到 n 的范围内，直接输出最大和即可
 *
 * 2、如果子序列的最大和横跨了尾部和头部，则先求出连续的最小子序列和然后用总和减去最小子串和就是最大子串和
 *
 * 所以求 1 到 n 中的最大和最小的连续子序列和（记为Mx，和Mi），然后输出 Mx 和 sum-Mi 中的最大值即可。
 */
public class 蒜厂年会 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }


        long sum = 0;

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        long maxSum = 0;
        long minSum = 0;


        for (int i = 0; i < n; i++) {
            sum += a[i];
            maxSum += a[i];
            minSum += a[i];

            max = Math.max(max, maxSum);
            min = Math.min(min, minSum);

            if (maxSum < 0) {
                maxSum = 0;
            }
            if (minSum > 0) {
                minSum = 0;
            }
        }
        System.out.println(Math.max(max, sum - min));



//        int[] dp = new int[n + 1];
//        dp[0] = a[0];
//
//        // 最大子序列和
//        int maxSum = Integer.MIN_VALUE;
//        // 最小子序列和
//        int minSum = Integer.MAX_VALUE;
//
//        for (int i = 1; i < n; i++) {
//            if (a[i] > 0) {
//                dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
//            } else {
//                dp[i] = 0;
//            }
//
//            maxSum = Math.max(maxSum, dp[i]);
//
//            if (a[i] < 0) {
//                dp[i] = Math.min(a[i], dp[i - 1] + a[i]);
//            } else {
//                dp[i] = 0;
//            }
//
//            minSum = Math.min(minSum, dp[i]);

//        }

//        System.out.println(maxSum);
//        System.out.println(minSum);
//        System.out.println(sum - min);
//        System.out.println(Math.max(maxSum, sum - minSum));
    }
}
