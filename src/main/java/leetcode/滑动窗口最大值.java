package leetcode;


import java.util.*;

/**
 * @author yuan
 * @date 2019/11/16
 * @description
 */
public class 滑动窗口最大值 {
    /**
     * 使用双端队列
     * 复杂度O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        // 双端队列保存最大数的下标，队头即为最大的数，可以根据这个下标判断窗口大小
        Deque<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            // 当前元素与队尾元素比较，不断从尾部抛出小于当前元素的，加入当前元素
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.pollLast();
            }
            // 添加当前元素值的下标
            queue.offer(i);

            if (i - queue.getFirst() >= k) {
                // 如果超过窗口大小，将最大值删除
                queue.poll();
            }
            if (i - k + 1 >= 0) {
                // 如果窗口有k个元素了，记录最大值
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        滑动窗口最大值 obj = new 滑动窗口最大值();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = obj.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));

    }
}
