package leetcode.面试题;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 打乱数组 {

    private int[] before;
    private int[] shuff;
    private int n;

    public 打乱数组(int[] nums) {
        n = nums.length;
        before = new int[n];
        shuff = new int[n];
        for (int i = 0; i < n; i++) {
            before[i] = nums[i];
            shuff[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return before;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int t = shuff[i];
            shuff[i] = shuff[j];
            shuff[j] = t;
        }
        return shuff;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        打乱数组 obj = new 打乱数组(a);

        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));


        Random random = new Random();
        for (int i = 0; i < 100; i++) {
//            System.out.println(random.nextInt(10));
        }
    }
}
