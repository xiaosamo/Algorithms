package leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/4/19
 */
public class 统计重复个数 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        Map<Character, Integer> m1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            m1.merge(c, n1, Integer::sum);
        }

        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            m2.merge(c, n2, Integer::sum);
        }


        int ans = 0;
        for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
            int count1 = m1.get(entry.getKey());
            ans = Math.max(ans, count1 - entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        统计重复个数 obj = new 统计重复个数();
        System.out.println(obj.getMaxRepetitions("aaa", 3, "aa", 1));
    }
}
