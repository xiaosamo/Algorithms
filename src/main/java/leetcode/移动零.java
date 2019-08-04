package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 从后向前遍历直到其元素为0，然后根据lastIndex与curIndex之间的差值，将元素前移。
 */
public class 移动零 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int count = nums.length - i - 1;
                for (int j = 0; j < count; j++) {
                    nums[i + j] = nums[i + j + 1];
                }
                nums[index--] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));

    }
}
