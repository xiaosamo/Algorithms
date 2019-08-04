package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 快乐数 {
    public static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int sum=0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        if (sum == 1) {
            return true;
        }
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return isHappy(sum);
//        return  == false ? false : isHappy(sum);

    }

    public static void main(String[] args) {
        System.out.println(isHappy(18));
    }
}
