package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/11/24
 * @description
 * https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 */
public class 组合 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1);
        return result;
    }

    private void dfs(int n, int k, List<Integer> list, int start) {
        if (k < 0) {
            return;
        }

        if (k == 0) {
            result.add(new ArrayList<>(list));
        }
        // i<=n
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            dfs(n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合 obj = new 组合();
        List<List<Integer>> lists = obj.combine(4, 2);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
