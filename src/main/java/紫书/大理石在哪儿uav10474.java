package 紫书;

import java.util.Arrays;
import java.util.Scanner;

public class 大理石在哪儿uav10474
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            int N = in.nextInt();
            int Q = in.nextInt();
            if (N==0&&Q==0) break;
            int[] a = new int[N + 1];
            for (int i = 0; i < N; i++) a[i] = in.nextInt();
            while(in.hasNext())
            {
                int x = in.nextInt();
                Arrays.sort(a);
                int p = Arrays.binarySearch(a, x);
                System.out.println(p);
                
            }
        }

    }

}
