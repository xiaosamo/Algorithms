package 剑指Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/2/19
 * @description 最大堆，时间复杂度O(nlgk)
 * 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶(堆中最大的元素)小，删除堆顶，新数入堆。
 * 否则抛弃
 */
public class 最小的K个数2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>(input.length);
        int len = input.length;
        if (k > len || k < 1) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(input[i]);
            } else if (input[i] < maxHeap.peek()) {
                // 如果当前整数比堆中最大的元素还小，用这个整数替换已有的最大值
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        最小的K个数2 obj = new 最小的K个数2();
        ArrayList<Integer> list = obj.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(9);
        queue.add(3);
        queue.add(1);
        System.out.println(queue.poll());

    }

}
