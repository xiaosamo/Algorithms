package leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/4/9
 * 暴力
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, new char[2 * n],ans);
        return ans;
    }

    private void dfs(int index, char[] cur, List<String> ans) {
        if (index == cur.length) {
            if (isOk(cur)) {
                ans.add(String.valueOf(cur));
            }
        } else {
            cur[index] = '(';
            dfs(index + 1, cur, ans);

            cur[index] = ')';
            dfs(index + 1, cur, ans);
        }
    }

    private boolean isOk(char []s) {
        int balance = 0;
        for (char c : s) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        括号生成 obj = new 括号生成();
        obj.generateParenthesis(3).forEach(s -> System.out.println(s));
    }
}
