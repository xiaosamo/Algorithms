package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 用Stream
 */
public class 字母异位词分组3 {
    public List<List<String>> groupAnagrams(String[] strs) {

        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(word -> sort(word)))
                .values().stream()
                .collect(Collectors.toList());


    }

    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {

        字母异位词分组3 obj = new 字母异位词分组3();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        obj.groupAnagrams(s);
    }
}
