package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/2/20
 * @description
 */
public class 数组中的第K个最大元素2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        k = len - k + 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, Comparator.reverseOrder());

        for (int i = 0; i < len; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        return maxHeap.peek();
    }
}
