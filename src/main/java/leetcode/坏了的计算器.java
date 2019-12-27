package leetcode;

import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/12/15
 * @description
 */
public class 坏了的计算器 {
    boolean found = false;
    public int brokenCalc(int X, int Y) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        pq.add(X);
        while (pq.peek() != Y) {
            pq.add(pq.poll() * 2);
            ++count;

            if (pq.peek() > 0) {
                ++count;
                pq.add(pq.poll() - 1);
            }
        }
        return count;
    }

    private int dfs(int cur, int y, int count) {
        if (cur == y) {
            found = true;
            return count;
        }
        if (found) {
            return count;
        }

        if (cur < 0 || y < 0) {
            return 0;
        }

        if (cur > y) {
            return dfs(cur - 1, y, count + 1);
        } else {
            return dfs(cur * 2, y, count + 1);

        }

//
//        System.out.println("cur=" + cur);
//
//        int a = dfs(cur * 2, y, count + 1);
//
//        int b = dfs(cur - 1, y, count + 1);
//        if (a == -1) {
//            return b;
//        }
//        if (b == -1) {
//            return a;
//        }
//        return Math.min(a, b);
    }

    public static void main(String[] args) {
        坏了的计算器 obj = new 坏了的计算器();
        System.out.println(obj.brokenCalc(2, 3));
        System.out.println(obj.brokenCalc(5, 8));
        System.out.println(obj.brokenCalc(3, 10));
    }
}
