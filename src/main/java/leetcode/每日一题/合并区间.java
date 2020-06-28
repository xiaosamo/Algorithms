package leetcode.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuan
 * @date 2020/4/16
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || n == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();
        int lastLeft = intervals[0][0], lastRight = intervals[0][1];
        for (int i = 1; i < n ; i++) {
            // 如果上一个区间包含当前区间，跳过
            if (intervals[i][1] <= lastRight) {
                continue;
            }

            if (intervals[i][0] <= lastRight) {
                lastRight = Math.max(lastRight, intervals[i][1]);
            } else {
                res.add(new int[]{lastLeft, lastRight});
                lastLeft = intervals[i][0];
                lastRight = intervals[i][1];
            }
        }
        res.add(new int[]{lastLeft, lastRight});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int [][]res;


        res = new 合并区间().merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] r : res) { System.out.println(Arrays.toString(r)); }
        System.out.println();

         res = new 合并区间().merge(new int[][]{{8, 10}, {15, 18}, {1, 3}, {2, 6}});
        for (int[] r : res) { System.out.println(Arrays.toString(r)); }

        System.out.println();
        res = new 合并区间().merge(new int[][]{{1, 4}, {2, 3}});
        for (int[] r : res) { System.out.println(Arrays.toString(r)); }

        System.out.println();
        res = new 合并区间().merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        for (int[] r : res) { System.out.println(Arrays.toString(r)); }

        System.out.println();
        res = new 合并区间().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for (int[] r : res) { System.out.println(Arrays.toString(r)); }

    }
}
