package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/1/23
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int p = nums[0], ans = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] == p + 1) {
                p = nums[i];
                ++ans;
            } else if (nums[i] == p) {
                continue;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        最长连续序列 obj = new 最长连续序列();
        int[] a = {100, 4, 200, 1, 3, 2};
        int[] b = {0,1,1,2};
        int[] c = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
//        System.out.println(obj.longestConsecutive(a));
//        System.out.println(obj.longestConsecutive(b));
        System.out.println(obj.longestConsecutive(c));
    }
}
