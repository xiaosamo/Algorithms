package leetcode.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/7
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/hua-dong-chuang-kou-by-likoujson/
 *
 * 1、剑指offer面试题59
 * 2、用Deque来模拟队列，一个存储队列数据，一个存储最大值
 * 3、入队：如果当前值大于队尾元素，就移除，否则就添加到队尾，保证队列有最大值
 * 4、出队：弹出队列头，但是还需要判断弹出的是不是最大值，是的话，就给最大值给移除
 * 4、队列的最大值就是 最大值队列的头
 *
 */
public class 面试题59队列的最大值 {
    static class MaxQueue {

        // 记录数据
        LinkedList<Integer> queue;
        // 记录最大值，队列的最大值就是 最大值队列的头
        LinkedList<Integer> maxQueue;


        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
                maxQueue.pollLast();
            }
            queue.offer(value);
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer val = queue.poll();
            // 弹出队列头，但是还需要判断弹出的是不是最大值，是的话，就给最大值给移除
            if (val.equals(maxQueue.peekFirst())) {
                maxQueue.pop();
            }
            return val;
        }
    }
}
