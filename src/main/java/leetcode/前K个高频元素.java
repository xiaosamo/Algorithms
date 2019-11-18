package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/11/18
 * @description
 */
public class 前K个高频元素 {
    static class Node{
        int num;
        int count;

        Node(int num, int count) {
            this.count = count;
            this.num = num;
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }

        }
        // 单词出现次数越多的优先级越高
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<Integer> result = new ArrayList<>();
        while (k-- > 0) {
            result.add(pq.poll().num);
        }
        return result;
    }

}
