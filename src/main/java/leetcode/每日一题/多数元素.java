package leetcode.每日一题;

import utils.T;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuan
 * @date 2020/3/13
 */
public class 多数元素 {
    /**
     * 随机法，随机找一个数，判断是不是，直到找到为止
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int num;
        do {
             num = nums[random.nextInt(0, nums.length)];
        } while (!isMajority(num,nums));
        return num;
    }


    private boolean isMajority(int num, int[] nums) {
        int count=0;
        for (int n : nums) {
            if(num == n)++count;
        }
        return count > nums.length / 2;
    }

    public static void main(String[] args) {
        多数元素 obj = new 多数元素();
        System.out.println(obj.majorityElement(new int[]{3, 2, 3}));
    }

}
