package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/11/23
 * @description
 */
public class 课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] g = new int[numCourses][numCourses];

        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            g[prerequisites[i][1]][prerequisites[i][0]]++;
            indegree[prerequisites[i][0]]++; // 统计顶点的入度
        }

        int[] result = new int[numCourses];
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            result[cnt++]=v;
            for (int u = 0; u < g[v].length; u++) {
                if (g[v][u] > 0 && --indegree[u] == 0) {
                    queue.add(u);
                }
            }
        }
        if (cnt != numCourses) {
            return new int[]{};
        }
        return result;
    }
}
