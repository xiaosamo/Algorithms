package leetcode;

/**
 * @author yuan
 * @date 2019/12/4
 * @description
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int index = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] == target) {
                index = middle;
                break;
            }
            if (nums[l] <= nums[middle]) {
                // 左半边有序
                if (nums[l] <= target && target < nums[middle]) {
                    // 目标值是否在左区间，如果是，缩小到左区间
                    r = middle - 1;
                } else {
                    // 不是，则在右区间
                    l = middle + 1;
                }
            } else {
                // 右半边有序
                if (nums[middle] < target && target <= nums[r]) {
                    // 如果在右区间
                    l = middle + 1;

                } else {
                    // 在左区间
                    r = middle - 1;
                }
            }
        }
        return index == -1 ? -1 : nums[index];
    }
}
