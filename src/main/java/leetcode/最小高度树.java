package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2020/3/29
 */
public class 最小高度树 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Integer>[] adjLists = new ArrayList[n];
        int[] degree = new int[n]; //各个节点的度
        for (int i = 0; i < n; i++){
            adjLists[i] = new ArrayList<>();
        }

        // 构建图
        for (int[] edge  : edges) {
            adjLists[edge[0]].add(edge[1]);
            adjLists[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 顶点入队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int len = queue.size();
            n -= len;
            for (int k = 0; k < len; k++) {
                int t = queue.poll();
                for (int v : adjLists[t]) {
                    if (degree[v] > 1 && --degree[v] == 1) {
                        queue.add(v);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        最小高度树 obj = new 最小高度树();
        String s = "[[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]"
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
        System.out.println(s);

        int[][] e = {{1, 0}, {1, 2}, {1, 3}};
        int[][] e2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};


        System.out.println(obj.findMinHeightTrees(4, e));
        System.out.println(obj.findMinHeightTrees(6, e2));
    }
}
