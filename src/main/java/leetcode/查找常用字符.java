package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2020/1/20
 * @description
 */
public class 查找常用字符 {
    public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, i + 1);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == A.length) {
                result.add(String.valueOf(entry.getKey()));
            }
        }
        return result;

    }
}
