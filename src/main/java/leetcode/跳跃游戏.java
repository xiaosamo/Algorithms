package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/12
 * @description
 */
public class 跳跃游戏 {
    /**
     * 超时
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    private boolean jump(int[] nums,  int index) {
        if (index + 1 == nums.length) {
            return true;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (jump(nums, index + i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。否则继续往前，若最后剩下的元素大于1个，则可以判断为假。否则就是真，时间复杂度O(n)就可以，不知道有没有大佬可以继续优化。
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                ++distance;
            }
        }
        return distance <= 1;
    }

        public static void main(String[] args) {
        跳跃游戏 obj = new 跳跃游戏();
        System.out.println(obj.canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(obj.canJump(new int[]{3, 2, 1, 0, 4})); // false
//        System.out.println(obj.canJump(new int[]{}));
        System.out.println(obj.canJump(new int[]{0})); // t
        System.out.println(obj.canJump(new int[]{2,0,0})); // t
    }
}
