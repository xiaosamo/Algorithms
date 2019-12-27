package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/12/18
 * @description
 * 有向图(无环)遍历，dfs
 */
public class 所有可能的路径 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        if (n == 0) {
            return result;
        }

        Map<Integer, List<Integer>> adg = new HashMap<>();

        boolean[] vis = new boolean[n+1];

        // 构建有向图
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int v : graph[i]) {
                list.add(v);
            }
            adg.put(i, list);
        }

        vis[0] = true;
        dfs(adg, 0, n, vis, new ArrayList<>(Arrays.asList(0)));
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> adg, int s, int e, boolean[] vis, List<Integer> list) {
        if (s == e) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < adg.get(s).size(); i++) {
            int v = adg.get(s).get(i);
            if (!vis[v]) {
                vis[v] = true;
                list.add(v);
                dfs(adg, v, e, vis,list);
                vis[v] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        所有可能的路径 obj = new 所有可能的路径();
        int[][] g = {
                {1, 2},
                {3},
                {3},
                {}
        };
        obj.allPathsSourceTarget(g);

    }
}
