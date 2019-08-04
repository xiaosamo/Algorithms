package leetcode;

/**
 * @author yuan
 * @date 2019/2/5
 * @description
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    //二分查找下界
    public int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target <= nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l < nums.length && nums[l] == target) {
            return l;
        }
        return -1;
    }

    //二分查找求上界
    public int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target >= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (r >= 0 && nums[r] == target) {
            return r;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int a = lowerBound(nums, target);
        int b = upperBound(nums, target);
        return new int[]{a, b};
    }
}
