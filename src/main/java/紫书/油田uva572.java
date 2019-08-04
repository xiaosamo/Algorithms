package 紫书;

import java.util.Scanner;

public class 油田uva572 {
//    public static String []map=new String[100];
    public static char [][]map=new char[100][100];
    static int n,m;

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            m=in.nextInt();
            n=in.nextInt();
            in.nextLine();
            if(m==0&&n==0) break;
            for(int i=0;i<m;i++){
                String s = in.nextLine();
                map[i] = s.toCharArray();
            }
            int ans=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]=='@'){
                        dfs(i,j);++ans;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y) {
        map[x][y]='*';
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int nx=x+dx,ny=y+dy;
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&map[nx][ny]=='@'){
                    dfs(nx,ny);
                }
            }
        }


    }
}
