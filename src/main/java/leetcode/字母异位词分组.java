package leetcode;

import java.util.*;

/**
 *
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 1.新建，Map<String,List<String>>
 2.遍历字符串数组里的每个字符串          把每个字符串---》字符数组，并对其进行排序          排序后的字符数组--》字符串，作为key，去查找并添加进Map<String,List<String>> 
 3.最后，输出Map<String,List<String>> 里的所有的value

 ---------------------

 本文来自 Iovems 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/Regemc/article/details/79959591?utm_source=copy
 */
public class 字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
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
