package other;

import java.util.Scanner;

/**
 * 给定一个日期，输出这个日期是该年的第几天？
 * 年/月/日
 */
public class 计算第几天
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        int []dd={0,31,28,31,30,31,30,31,31,30,31,30,31};
        while (in.hasNext())
        {
            String s = in.nextLine();
            String[] date = s.split("/");
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);

            int ans=0;
            if (y%400==0||(y%4==0&&y%100!=0)&&m>2) ++d;
            for(int i=0;i<m;i++) ans+=dd[i];
            ans+=d;
            System.out.println(ans);
            
        }

    }


    
}
