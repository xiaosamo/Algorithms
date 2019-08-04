package 蓝桥杯.算法训练;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class 队列操作
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < n; i++)
        {
            int m = in.nextInt();
            switch (m)
            {
                case 1:
                    int a = in.nextInt();
                    queue.add(a);
                    break;
                case 2:
                    if (queue.isEmpty())
                    {
                        System.out.println("no");
                        System.exit(0);

                    }
                    else
                    {
                        System.out.println(queue.poll());
                    }
                    break;
                case 3:
                    System.out.println(queue.size());
                    break;
            }
        }
    }
}
