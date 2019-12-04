package leetcode;

/**
 * @author yuan
 * @date 2019/12/4
 * @description
 */
public class 在排序数组中查找元素的第一个和最后一个位置_ {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        int index = search(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int l = index,r=index;
        while (l >= 0 && nums[l] == target) --l;
        while (r < nums.length && nums[r] == target) ++r;
        return new int[]{l, r};

    }
    private int search(int []nums,int l,int r,int target){
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
