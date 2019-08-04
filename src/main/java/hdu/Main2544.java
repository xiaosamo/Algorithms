package hdu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2544
{
    static int maxn=100005;
    static ArrayList<Edge>[] G = new ArrayList[maxn];
    static class Edge
    {
        public int e;
        public int w;
        Edge(){}
        Edge(int e,int w){this.e=e;this.w=w;}
    }
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            for(int i=0;i<G.length;i++) {G[i]=new ArrayList<>();}

            int n=in.nextInt();int m=in.nextInt();
            if(n==0&&m==0) return;
            for (int i = 0; i < m; i++)
            {
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();
                G[s].add(new Edge(e,w));
                G[e].add(new Edge(s,w));
            }
            System.out.println(spfa(1, n));
        }

    }


    static int spfa(int v, int et)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[maxn];
        int[] vis = new int[maxn];
        for (int i = 0; i < dist.length; i++){ dist[i] = Integer.MAX_VALUE;}

        q.offer(v);
        dist[v]=0;
        vis[v]=1;
        while (!q.isEmpty())
        {
            int s = q.poll();
            vis[s]=0;       //记得恢复未访问标记
            for (int i = 0; i < G[s].size(); i++)
            {
                int e = G[s].get(i).e;
                int w = G[s].get(i).w;
                if (dist[e] > dist[s] + w)
                {
                    dist[e]=dist[s]+w;
                    if (vis[e] == 0)
                    {
                        vis[e] = 1;
                        q.offer(e);
                    }
                }
            }
        }
        return dist[et];
    }


}
