package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/12/9
 * @description
 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        // 将区间按起始时间排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] previous = null;
        List<int[]> result = new ArrayList<>();

        for (int[] current : intervals) {
            if (previous == null || current[0] > previous[1]) {
                // 如果是第一个区间，或当前区间和前一个区间没有重叠
                result.add(previous = current);
            } else {
                // 区间重叠，更新前一个区间的结束时间
                previous[1] = Math.max(current[1], previous[1]);
            }
        }
        // 集合转数组
        return result.toArray(new int[result.size()][]);
    }
}
