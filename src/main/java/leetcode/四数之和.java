package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/1/11
 */
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int l = nums.length;
        for (int a = 0; a < l; a++) {
            for (int b = a + 1; b < l; b++) {
                for (int c = b + 1; c < l; c++) {
                    int t = target - (a + b + c);
                    if (binary(nums, c + 1, nums.length - 1, t) >= 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(a);
                        li.add(b);
                        li.add(c);
                        li.add(t);
                        result.add(li);
                    }
                }
            }
        }
        return result;

    }

    private static int binary(int []a,int l,int r,int target) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] == target) {
                return m;
            } else if (target > a[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    /**
     * O（n^3)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
//                if (nums[j] == nums[j - 1]) {
//                    continue;
//                }

                int l = j + 1, r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];

                    if (sum == target) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            --r;
                        }
                        set.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[l], nums[r]}));
                        ++l;
                        --r;
                    } else if (sum > target) {
                        --r;
                    } else {
                        ++l;
                    }
                }
            }


        }
        return new ArrayList<>(set);
    }


    public static void main(String[] args) {

        四数之和 obj = new 四数之和();
        int[] a = {1, 0, -1, 0, -2, 2};
        int[] b = {0, 0, 0, 0};

        List<List<Integer>> lists = obj.fourSum2(b, 0);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
