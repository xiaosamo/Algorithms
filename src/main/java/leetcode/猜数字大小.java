package leetcode;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 猜数字大小 {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (r + l) >>> 1;
            int g = guess(m);
            if (g < 0) {
                r = m - 1;
            } else if (g > 0) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }

    private int guess(int m) {
        return 1;
    }
}
