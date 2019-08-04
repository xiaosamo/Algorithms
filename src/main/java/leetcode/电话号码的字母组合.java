package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static List<String> letterCombinations(String digits) {
        // 需要搜索的集合列表
        List<String> strList = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int n = digits.charAt(i) - '0';
            strList.add(str[n]);
        }
//        dfs();
        return strList;

    }

    private static void dfs(List<String> strList, int n, List<String> result) {
        if (n == strList.size()) {
            return;
        }

//        for () {
//        }
        char[] chars = strList.get(n).toCharArray();
        for (char c : chars) {
            if (n == strList.size()) {
                for (int i = 0; i < result.size(); i++) {
//                String s = result.get(i);
                    result.set(i, result.get(i) + c);
//                result.add(c + "");
                }
            } else {
                result.add(c + "");
            }
            dfs(strList, n + 1, result);
        }

    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
