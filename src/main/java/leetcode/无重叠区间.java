package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yuan
 * @date 2019/12/14
 * @description
 */
public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // 如果当前区间和上一个区间重叠
                end = Math.min(end, intervals[i][1]);
                ++count;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    /**
     * 按照结束时间排序
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int end = intervals[0][1]; // 记录当前的结束时间
        int count = 1; // 记录没有重叠的区间数量

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // 如果当前区间和前一个区间没有重叠
                end = intervals[i][1];
                count++;
            }
        }
        // 需要删除的区间数量 = 总区间 - 没有重叠的区间数量
        return intervals.length - count;
    }



    }
