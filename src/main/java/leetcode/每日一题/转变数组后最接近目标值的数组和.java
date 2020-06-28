package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/6/14
 */
public class 转变数组后最接近目标值的数组和 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int n = arr.length;
        int num = target / n;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int k = num; k < target; k++) {
            int s = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= k) {
                    s += (n - i) * k;
                    break;
                } else {
                    s+=arr[i];
                }
            }
            int cur = Math.abs(target - s);
            if (cur == 0) {
                return k;
            }
            if (cur < min) {
                min = cur;
                ans = k;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new 转变数组后最接近目标值的数组和().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new 转变数组后最接近目标值的数组和().findBestValue(new int[]{2,3,5}, 10));
        System.out.println(new 转变数组后最接近目标值的数组和().findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }
}
