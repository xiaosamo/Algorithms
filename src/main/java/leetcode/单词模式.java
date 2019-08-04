package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2018/12/21
 */
public class 单词模式 {
    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(split[i])) {
                    return false;
                } else {
                    map.put(c, split[i]);
                }

            } else {
                String s = map.get(c);
                if (!s.equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        单词模式 obj = new 单词模式();
        System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
        System.out.println(obj.wordPattern("abba", "dog cat cat fish"));
        System.out.println(obj.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(obj.wordPattern("abba", "dog dog dog dog"));
    }
}
