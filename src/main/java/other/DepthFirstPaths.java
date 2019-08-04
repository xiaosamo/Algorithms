package other;

import 基础练习.Graph;
import 基础练习.Stack;

/**
 * @author yuan
 * @date 2019/3/13
 * @description DFS
 */
public class DepthFirstPaths {
    /**
     * 标识
     */
    private boolean[] marked;

    /**
     * 从起点到一个顶点的已知路径上的最后一个顶点
     */
    private int []edgeTo;

    private int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 返回从s到v的路径
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
        for (Integer v : dfs.pathTo(3)) {
            System.out.println(v);
        }
    }
}
