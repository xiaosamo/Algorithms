package leetcode;

import java.util.*;

/**
 * @author yuanshijia
 * @date 2019-08-12
 * @description
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class 全排列2_ {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        // 修改 1：首先排序，之后才有可能发现重复分支
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] vis = new boolean[nums.length];
        dfs(n, new Stack<>(), nums, vis);
        return result;
    }


    private void dfs(int n, Stack<Integer> stack, int[] nums, boolean[] vis) {
        if (n == stack.size()) {
            result.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                // 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                // 这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue;
                }
                stack.push(nums[i]);
                vis[i] = true;
                dfs(n, stack, nums, vis);
                vis[i] = false;
                stack.pop();
            }


        }
    }

    public static void main(String[] args) {
        全排列2_ obj = new 全排列2_();
//        obj.permuteUnique(new int[]{1, 2, 3});
        obj.permuteUnique(new int[]{1, 1, 2});
    }
}
