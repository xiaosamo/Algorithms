package leetcode;

import java.util.*;

/**
 * 用Java 8的computeIfAbsent方法
 */
public class 字母异位词分组2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // 如果键存在，添加 key -> sort(word) , val -> word
            // 否则，执行指定的函数
            map.computeIfAbsent(sort(word), (unused) -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {

        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams(s);


//        String[] copys = s.clone();
//        s[1] = "hello";
//        System.out.println(Arrays.toString(s));
//        System.out.println(Arrays.toString(copys));
    }
}
