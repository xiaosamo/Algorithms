package leetcode.每日一题;

import java.util.*;

/**
 * @author yuan
 * @date 2020/3/20
 */
public class 最小的k个数_用堆 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 构建大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : arr) {
            if (heap.size() < k) {
                heap.add(i);
            } else if (i < heap.peek()) {
                heap.poll();
                heap.add(i);
            }
        }

        int []ans = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i++] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        最小的k个数_用堆 obj = new 最小的k个数_用堆();
        System.out.println(Arrays.toString(obj.getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }




}
