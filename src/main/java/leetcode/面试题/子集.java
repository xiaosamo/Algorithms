package leetcode.面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/4/5
 * @description 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
//        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index > nums.length) {
            return;
        }
        // 可以为空的情况
//        result.add(new ArrayList<>(cur));
//        cur.forEach(i -> System.out.print(i + " "));
        System.out.println();
        for (int i = index; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            if (cur.size() > 0 && nums[i] < cur.get(cur.size() - 1)) {
                continue;
            }
            cur.add(nums[i]);
            dfs(nums, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        子集 obj = new 子集();
//        obj.subsets(new int[]{1, 2, 3});
        obj.subsets(new int[]{0,1,4});
    }

}
