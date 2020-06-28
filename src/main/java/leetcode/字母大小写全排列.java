package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/1/20
 * @description
 */
public class 字母大小写全排列 {
    HashSet<String> result = new HashSet<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0,"");
        return new ArrayList<>(result);
    }

    private void dfs(char[] chars, int index, String cur) {
        if (index == chars.length) {
            result.add(cur);
            return;
        }


        if (Character.isDigit(chars[index])) {
            dfs(chars, index + 1, cur + chars[index]);
        } else {
            dfs(chars, index + 1, cur + Character.toUpperCase(chars[index]));
            dfs(chars, index + 1, cur + Character.toLowerCase(chars[index]));
        }
    }

    public static void main(String[] args) {
        字母大小写全排列 obj = new 字母大小写全排列();
        List<String> list = obj.letterCasePermutation("a1b2");
        list.forEach(i -> System.out.println(i));
    }
}
