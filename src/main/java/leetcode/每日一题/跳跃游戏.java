package leetcode.每日一题;

import java.io.Serializable;

/**
 * @author yuan
 * @date 2020/4/17
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 */
public class 跳跃游戏 implements Serializable {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new 跳跃游戏().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new 跳跃游戏().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new 跳跃游戏().canJump(new int[]{0}));
        System.out.println(new 跳跃游戏().canJump(new int[]{2, 0}));
    }
}
