package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/1/20
 * @description
 */
public class 重复N次的元素 {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == A.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
