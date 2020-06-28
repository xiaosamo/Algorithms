package leetcode.每日一题;

import java.util.ArrayList;

/**
 * @author yuan
 * @date 2020/3/30
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    public static void main(String[] args) {
        圆圈中最后剩下的数字 obj = new 圆圈中最后剩下的数字();
        System.out.println(obj.lastRemaining(5, 3));
    }
}
