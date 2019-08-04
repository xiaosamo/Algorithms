package hdu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1102
{
    static class Edge implements Comparable
    {
        public int s;
        public int e;
        public int w;
        Edge(){}
        Edge(int s,int e,int w){this.s=s;this.e=e;this.w=w;}

        @Override
        public int compareTo(Object o)
        {
            Edge t = (Edge) o;
            return t.w<w?1:-1;
        }
    }

    static int maxn=1005;
    static ArrayList<Edge> G = new ArrayList<>();
    static int[] par = new int[maxn];

    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            //初始化
            G.clear();
            for (int i=0;i<=n;i++) par[i]=i;
//            for (int i=0;i<n;i++)
//            {
//                int s = in.nextInt();
//                int e = in.nextInt();
//                int w = in.nextInt();
//                G.add(new Edge(s, e, w));
//            }
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    int w = in.nextInt();
                    G.add(new Edge(i, j, w));
                }
            }

            //已经修好了q条路
            int q = in.nextInt();
            for (int i = 0; i < q; i++)
            {
                int s = in.nextInt();int e = in.nextInt();
                Merge(s, e);
            }
            //排序
            Collections.sort(G);

            int cnt=q; //表示已经连接好了q条路
            int ans=0;
            for (int i = 0; i < G.size(); i++)
            {
//                System.out.println(G.get(i).s + " " + G.get(i).e + " " + G.get(i).w);
                if (GetRoot(G.get(i).s) != GetRoot(G.get(i).e))
                {
                    Merge(G.get(i).s, G.get(i).e);
                    ans+=G.get(i).w;
//                    ++cnt;
                }
                if (cnt==n-1) break;
            }
            System.out.println(ans);
        }

    }

    static int GetRoot(int a)
    {
        return par[a] == a ? a : (par[a] = GetRoot(par[a]));
    }

    static void Merge(int a, int b)
    {
        int p1 = GetRoot(a);
        int p2 = GetRoot(b);
        if (p1==p2) return;
        par[p2]=p1;
    }


}
