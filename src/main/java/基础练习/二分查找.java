package 基础练习;

import java.util.Arrays;

public class 二分查找 {
    public static void main(String[] args) {
        二分查找 obj = new 二分查找();
        int []a={4,3,5,6,76,341,4,32,56,4};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(obj.search(a, 4));
        System.out.println(obj.lowerBound(a, 4));
        System.out.println(obj.upperBound(a, 4));
//        System.out.println(obj.search(a, 76));
//        System.out.println(obj.search(new int[]{1}, 1));

    }


    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // 是<= 当nums={1}只有一个元素的情况
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

    /**
     * 二分查找下界
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 二分查找求上界
     * @param nums
     * @param target
     * @return
     */
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
}
