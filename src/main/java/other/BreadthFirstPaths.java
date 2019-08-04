package other;

import 基础练习.Graph;
import 基础练习.Stack;


/**
 * @author yuan
 * @date 2019/3/13
 * @description BFS广度优先搜索
 */
public class BreadthFirstPaths {
    /**
     * 标记该顶点是否访问过
     */
    private boolean[] marked;

    /**
     * 到达该节点的已知路径上的最后一个顶点
     */
    private int[] edgeTo;

    /**
     * 起点
     */
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    // 保存最短路径的最后一条边
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 返回从起点s到v的路径
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

        BreadthFirstPaths bfs = new BreadthFirstPaths(g, 0);
        for (Integer v : bfs.pathTo(3)) {
            System.out.println(v);
        }

    }

}