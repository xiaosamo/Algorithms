package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/3/14
 * @description
 */
public class 组合_old {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < k) {
            return result;
        }
        List<Integer> list = new LinkedList<>();
        dfs(n, k, 1, list, result);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> list,List<List<Integer>> result) {
        if (k == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (list.size() > 0 && i <= list.get(list.size() - 1)) {
                continue;
            }
            list.add(i);
            dfs(n, k - 1, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合_old obj = new 组合_old();
        List<List<Integer>> list = obj.combine(4, 2);
        for (List<Integer> li : list) {
            for (Integer i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
