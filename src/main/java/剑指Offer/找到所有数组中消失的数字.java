package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2019/10/6
 * @description
 */
public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        找到所有数组中消失的数字 obj = new 找到所有数组中消失的数字();
        int[] a = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        obj.findDisappearedNumbers(a);
        System.out.println(Arrays.toString(a));
    }
}
