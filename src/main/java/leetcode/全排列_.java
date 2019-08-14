package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/1/21
 */
public class 全排列_ {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int n = nums.length;
        dfs(n, list, 0);
        return result;
    }


    private void dfs(int n, List<Integer> list, int index) {
        if (index == n) {
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i < n; i++) {
            list.forEach(t-> System.out.print(t));
            System.out.println();
            Collections.swap(list, index, i);
            dfs(n, list, index + 1);
            Collections.swap(list, index, i);
        }
    }

    public static void main(String[] args) {
        全排列_ obj = new 全排列_();
        int[] a = {1, 2, 3};
        obj.permute(a);
    }
}
