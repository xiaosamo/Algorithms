package 面试题._58;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/13
 * @description
 */
public class 大鱼吃小鱼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (in.hasNextInt()) {
            pq.add(in.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                pq.add(a + b);
            } else {
                int num = 1;
                while (pq.peek() == a) {
                    ++num;
                    pq.poll();
                }
                pq.add(a + pq.poll());
                for (int k = 0; k < num; k++) {
                    pq.add(a);
                }
            }
        }
        System.out.println(pq.peek());

    }
}
