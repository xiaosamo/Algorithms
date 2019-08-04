package leetcode;

/**
 * @author yuan
 * @date 2019/1/28
 * @description
 */
public class 存在重复元素2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = nums.length;
        if (l == 0) {
            return false;
        }
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        存在重复元素2 obj = new 存在重复元素2();
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(obj.containsNearbyDuplicate(new int[]{99, 99}, 2));

    }
}
