package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * 和组合总和类似，不过需要去重
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class 组合总和2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 先排序
        dfs(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<Integer> list,int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                // 这种写法效率更快
                break;
            }

            if (i != start && candidates[i] == candidates[i - 1]) {
                // 去重，剪掉相同的分支
                continue;
            }

            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合总和2 obj = new 组合总和2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = obj.combinationSum2(candidates, 8);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
