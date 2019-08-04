package hdu;

import java.util.*;

public class Main2066
{
    static int maxn=1005;
    static ArrayList<Edge>[] G = new ArrayList[maxn];
    static class Edge
    {
        public int e;
        public int w;
        Edge(int e, int w){this.e=e;this.w=w;}
        Edge(){}
    }

    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int T,S,D,s,e,w;

        while (in.hasNext())
        {
            for (int i = 0; i < G.length; i++) G[i] = new ArrayList<>();
            T = in.nextInt();S = in.nextInt();D = in.nextInt();
            int[] st = new int[S]; //起点集合
            int[] et = new int[D]; //终点集合
            for (int i = 0; i < T; i++)
            {
                s = in.nextInt();
                e = in.nextInt();
                w = in.nextInt();
                G[s].add(new Edge(e, w));
                G[e].add(new Edge(s, w));
            }
            for (int i = 0; i < S; i++) st[i] = in.nextInt();
            for (int i = 0; i < D; i++) et[i] = in.nextInt();

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < st.length; i++)
            {
                for (int j = 0; j < et.length; j++)
                {
                    ans = Math.min(ans, spfa(st[i], et[j]));
                }
            }
            System.out.println(ans);
        }
    }

    static int spfa(int v,int ed)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[maxn];
        int[] vis = new int[maxn];
        for (int i = 0; i < dist.length; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        q.offer(v);
        dist[v] = 0;
        vis[v]=1;
        while (!q.isEmpty())
        {
            int s = q.poll();
            vis[s]=0; //恢复未访问标记
            for (int i = 0; i < G[s].size(); i++)
            {
                int e = G[s].get(i).e;
                int w = G[s].get(i).w;
                if (dist[e] > dist[s] + w)
                {
                    dist[e] = dist[s] + w;
                    if (vis[e] == 0)
                    {
                        vis[e] = 1;
                        q.offer(e);
                    }
                }
            }
        }
        return dist[ed];
    }

}
