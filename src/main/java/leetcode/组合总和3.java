package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 */
public class 组合总和3 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] vis = new boolean[10];
        dfs(k, n, new ArrayList<>(),vis,1);
        return result;
    }

    private void dfs(int k, int n, List<Integer> list, boolean[] vis, int start) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i =start; i <= 9; i++) {
            if (!vis[i]) {
                list.add(i);
                vis[i] = true;
                dfs(k - 1, n - i, list, vis, i + 1);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        组合总和3 obj = new 组合总和3();
        List<List<Integer>> lists = obj.combinationSum3(3, 9);

        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
