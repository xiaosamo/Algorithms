package 校赛;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class 千军万马过独木桥 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            int n = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] a) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int i : a) {
//            minHeap.add(i);
//            maxHeap.add(i);
//        }
//        int sum = 0;
//        while (minHeap.size() > 2) {
//            int l = minHeap.poll();
//            int h = minHeap.poll();
//            minHeap.add(l);
//            sum += h;
//            sum += l;
//        }
//        while (maxHeap.size() > 2) {
//            int h = maxHeap.poll();
//            int l = maxHeap.poll();
//            sum += h;
//            minHeap.poll();
//        }

        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        for (int i : a) {
            q1.add(i);
        }
        int l = 0;
        int r = a.length - 1;
        int sum = 0;
        Integer t1 = q1.poll();
        Integer t2 = q1.poll();
        q2.add(t2);
        q1.add(t1);


        sum = sum + t1 + t2;

        return sum;

    }

    private static int solve2(int[] a, int index) {
        if (a.length == 1) {
            return a[0];
        }
        if (a.length == 2) {
            return Math.max(a[0], a[1]);
        }
        return 1;

//        solve2(a);
    }
}
