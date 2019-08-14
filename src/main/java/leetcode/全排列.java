package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/1/21
 */
public class 全排列 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis, new ArrayList<>());
        return result;
    }



    private void dfs(int[] nums, boolean[] vis, List<Integer> cur) {
        if (cur.size() == nums.length) {
            // 注意是加入cur的值，而不是引用
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                cur.add(nums[i]);
                dfs(nums, vis, cur);
                cur.remove(cur.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        全排列 obj = new 全排列();
        int[] a = {1, 2, 3};
        obj.permute(a);
    }
}
