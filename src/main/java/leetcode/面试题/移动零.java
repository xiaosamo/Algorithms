package leetcode.面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[index--] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        // 非0的个数
        int index = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }

    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        移动零 obj = new 移动零();
        obj.moveZeroes(a);

    }
}
