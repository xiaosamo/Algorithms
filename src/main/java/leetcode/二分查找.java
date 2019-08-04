package leetcode;

/**
 * @author yuan
 * @date 2019/2/5
 * @description
 */
public class 二分查找 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // 注意，+-的优先级高于>> <<
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
