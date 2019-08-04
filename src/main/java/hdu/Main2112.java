package hdu;

import java.util.*;

public class Main2112
{
    static final int maxn=20000;
    static ArrayList<Edge>[] E = new ArrayList[maxn]; //边

    static class Edge
    {
        public int e; //终点
        public int w; //权值

        Edge(int e, int w)
        {
            this.e = e;
            this.w = w;
        }
        Edge(){}
    }
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        for (int i = 0; i < E.length; i++)
        {
            E[i] = new ArrayList<>();
        }

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < m; i++)
        {
            int s = in.nextInt();
            int e = in.nextInt();
            int w = in.nextInt();

            E[s].add(new Edge(e, w));
        }
        spfa(1,n);
    }

    static void spfa(int v,int n)
    {
        int[] dist = new int[maxn];
        //初始化
        for (int i = 0; i < dist.length; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        int[] vis = new int[maxn];
        Queue<Integer> q = new LinkedList<>();
        dist[v] = 0;  //顶点到自身距离为0
        q.offer(v);  //顶点入队
        vis[v] = 1; //访问标记
        while (!q.isEmpty())
        {
            int s = q.poll();
            for (int i = 0; i < E[s].size(); i++)
            {
                int e = E[s].get(i).e;
                if (dist[e] > dist[s] + E[s].get(i).w)
                {
                    dist[e] = dist[s] + E[s].get(i).w;
                    if (vis[e] == 0)
                    {
                        q.offer(e);
                        vis[e] = 1;
                    }
                }
            }
        }
        for (int i = 2; i <=n; i++)
        {
            System.out.println(dist[i]);
        }
    }
    
}
