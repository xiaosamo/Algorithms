package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/2
 * @description
 */
public class 最常见的单词 {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 需要排除的单词
        Set<String> set = new HashSet<>();
        for (String b : banned) {
            set.add(b);
        }

        paragraph = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] split = paragraph.split(" ");

        HashMap<String, Integer> map = new HashMap<>(2 * split.length);

        for (String s : split) {
            if (s.trim().length() == 0 || set.contains(s)) {
                continue;
            }
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        int max = 0;
        String result = "";

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        最常见的单词 obj = new 最常见的单词();
//        String s = obj.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        String s = obj.mostCommonWord("a.", new String[]{});
        String s2 = obj.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"});


        System.out.println(s);
        System.out.println(s2);
        System.out.println(obj.mostCommonWord("abc abc? abcd the jeff!", new String[]{"abc", "abcd", "jeff"}));

    }
}
