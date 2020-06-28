package leetcode.每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/3/22
 */
public class 使数组唯一的最小增量 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                ans += A[i] - pre;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        使数组唯一的最小增量 obj = new 使数组唯一的最小增量();
        System.out.println(obj.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(obj.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
