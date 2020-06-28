package leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/6
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
 */
public class 面试题57和为s的连续正数序列 {
    /**
     * 暴力法，上限是target/2
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int max = target / 2 + 1;
        for (int i = 1; i <= max; i++) {
            int sum=0;
            int j =i;
            while (sum < target) {
                sum += j++;
            }
            if (sum == target) {
                res.add(getList(i, j-1));
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 双指针
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1, r = 2; // 起始位置[1,2]
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) {
                r++;
            } else if (sum > target) {
                l++;
            } else {
                res.add(getList(l, r));
                l++; // 将 [l,r]的序列放进答案数组，且我们知道以l为起点的合法解最多只有一个，所以需要枚举下一个起点，指针l向右移动
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private int[] getList(int first, int last) {
        int[] res = new int[last - first + 1];
        for (int i = first, j = 0; i <= last; i++) {
            res[j++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        面试题57和为s的连续正数序列 obj = new 面试题57和为s的连续正数序列();
        int[][] res = obj.findContinuousSequence2(9);
        for (int[] row : res) {
            for (int i : row) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }
}
