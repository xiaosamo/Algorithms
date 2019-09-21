package 剑指Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuanshijia
 * @date 2019-07-25
 * @description
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (size < 1 || num.length < size) {
            return result;
        }
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        // 维护一个大小为 size 的大顶堆
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }

        result.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            result.add(heap.peek());
        }
        return result;
        
    }

}
