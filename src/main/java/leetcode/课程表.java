package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/11/23
 * @description
 * 拓扑排序
 */
public class 课程表 {
    /**
     * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] g = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            g[prerequisites[i][1]][prerequisites[i][0]]++;
            indegree[prerequisites[i][0]]++; // 统计顶点的入度
        }

        Queue<Integer> queue = new LinkedList<>();

        // 遍历所有顶点，将入度为0的加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
//            System.out.println(v);// 输出顶点
            ++cnt;
            for (int u = 0; u < g[v].length; u++) {
                // 与v相邻的顶点入度-1，并将入度为0的加入队列
                if (g[v][u] > 0 && --indegree[u] == 0) {
                    queue.add(u);
                }
            }
        }
        return cnt == numCourses; // 如果能全部输出顶点，说明无环
    }

    public static void main(String[] args) {
        课程表 obj = new 课程表();
        int[][] pre = {
                {1, 0},
                {1, 2},
                {0, 1}
        };
        obj.canFinish(3, pre);
    }
}
