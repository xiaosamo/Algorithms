package 剑指Offer;

import java.util.*;

/**
 * 分苹果问题，回溯
 * @author yuan
 * @date 2019/6/22
 * @description
 */
public class 组合总和 {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || target <= 0) {
            return new ArrayList<>(result);
        }
        dfs(candidates, new LinkedList<>(), target,0);
        return new ArrayList<>(result);
    }

    private void dfs(int[] a, LinkedList<Integer> list, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = index; i < a.length; i++) {
            if (a[i] <= target) {
                list.add(a[i]);
                dfs(a, list, target - a[i], i);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        组合总和 obj = new 组合总和();
        List<List<Integer>> lists = obj.combinationSum(new int[]{2, 3, 6, 7}, 7);
//        List<List<Integer>> lists = obj.combinationSum(new int[]{2, 3, 5}, 8);

        for (List<Integer> list : lists) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }


}
