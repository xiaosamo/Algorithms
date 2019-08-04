package leetcode;

import java.math.BigInteger;

/**
 * @author yuan
 * @date 2019/1/28
 * @description
 */
public class 存在重复元素3 {
    public boolean containsNearbyDuplicate(int[] nums, int k, int t) {
        int l = nums.length;
        if (l == 0) {
            return false;
        }
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                BigInteger b = BigInteger.valueOf(nums[i]);
                b = b.subtract(BigInteger.valueOf(nums[j]));
                long temp = Long.valueOf(b.abs().toString());
                temp = Math.abs(temp);
                if (temp <= t && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        存在重复元素3 obj = new 存在重复元素3();
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(obj.containsNearbyDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
        System.out.println(obj.containsNearbyDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647));
    }
}
