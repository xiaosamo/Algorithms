package 基础练习;

import other.Bag;

/**
 * @author yuan
 * @date 2019/3/12
 * @description 无向图
 */
public class Graph {
    /**
     * 顶点的数量
     */
    private int V;
    /**
     * 边的数量
     */
    private int E;

    /**
     * 邻接表
     */
    private Bag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(Graph G) {
        this(G.V);
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**
     * 返回对顶点的数量
     * @return
     */
    public int V(){
        return V;
    }

    /**
     * 返回边的数量
     * @return
     */
    public int E(){
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    /**
     * 在顶点v和w之间添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        // 验证顶点v、w
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        ++E;
    }

    /**
     * 返回和v相邻的所有的顶点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * 返回与顶点v的相邻的边数
     * @param v
     * @return
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + " \n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        System.out.println(g.toString());

    }
}
