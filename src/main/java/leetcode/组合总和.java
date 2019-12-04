package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * 题解：https://leetcode-cn.com/circle/article/GV6eQ2/
 */
public class 组合总和 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target,  new ArrayList<>(),0);
        return result;
    }

    private void dfs(int[] candidates, int target,  List<Integer> list,int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        组合总和 obj = new 组合总和();
        int[] candidates = {2, 3, 5};
        List<List<Integer>> lists = obj.combinationSum(candidates, 8);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
