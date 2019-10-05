package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 电话号码的字母组合 {
    String[] s = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return result;
        }
        dfs(digits, 0, "");
        return result;
    }

    private void dfs(String num, int index, String cur) {
        if (index == num.length()) {
            result.add(cur);
            return;
        }
        int t = num.charAt(index) - '0';
        for (int i = 0; i < s[t].length(); i++) {
            dfs(num, index + 1, cur + s[t].charAt(i));
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合 obj = new 电话号码的字母组合();
        List<String> result = obj.letterCombinations("22");
        for (String s : result) {
            System.out.println(s);
        }
    }



}
