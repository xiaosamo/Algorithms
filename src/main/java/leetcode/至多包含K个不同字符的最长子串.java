package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2019/12/19
 * @description
 */
public class 至多包含K个不同字符的最长子串 {
    public int lengthOfLongestSubstringKDistinct(String s,int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);

            // 统计次数
            map.put(cj, map.getOrDefault(cj, 0) + 1);

            // 如果map大小超过k，移动慢指针i
            while (map.size() > k) {
                char ci = s.charAt(i);

                // 计数-1
                map.put(ci, map.get(ci) - 1);
                // 如果计数为0，从map删除
                if (map.get(ci) == 0) {
                    map.remove(ci);
                }

                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
