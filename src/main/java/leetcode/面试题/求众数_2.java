package leetcode.面试题;

import java.util.ArrayList;

/**
 * @author yuan
 * @date 2019/3/3
 * @description 摩尔投票法
 */
public class 求众数_2 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int time = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (time == 0) {
                result = nums[i];
                time = 1;
            } else if (nums[i] == result) {
                ++time;
            } else {
                --time;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        求众数_2 obj = new 求众数_2();
        System.out.println(obj.majorityElement(new int[]{3, 2, 3}));
        System.out.println(obj.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }

}
