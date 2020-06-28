package leetcode.每日一题;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuan
 * @date 2020/3/27
 */
public class 卡牌分组 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        int n = deck.length;
        search:
        for (int x = 2; x <= n; x++) {
            if (n % x == 0) {
                for (int v : values) {
                    if (v % x != 0) {
                        // 不满足，继续搜索下一个x
                        continue search;
                    }
                }
                return true;
            }
        }
      return false;
    }

    public static void main(String[] args) {

    }
}
