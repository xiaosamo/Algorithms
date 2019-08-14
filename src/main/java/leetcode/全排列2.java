package leetcode;

import java.util.*;

/**
 * @author yuanshijia
 * @date 2019-08-12
 * @description
 */
public class 全排列2 {

    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        dfs(nums, 0, new int[nums.length], new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int index, int[] vis, List<Integer> list) {
        if (index == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                list.add(nums[i]);
                dfs(nums, index + 1, vis, list);
                vis[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }




    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        全排列2 obj = new 全排列2();
//        obj.permuteUnique(new int[]{1, 2, 3});
        obj.permuteUnique(new int[]{1, 1, 2});
    }
}
