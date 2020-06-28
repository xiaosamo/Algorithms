package leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/4/9
 * 剪纸
 */
public class 括号生成2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0,0, n,new StringBuilder(),ans);
        return ans;
    }

    private void dfs(int open, int close, int n, StringBuilder cur, List<String> ans) {
        if (cur.length() == n * 2) {
            ans.add(cur.toString());
            return;
        }

        // 左括号没有填满
        if (open < n) {
            cur.append('(');
            dfs(open + 1, close, n, cur, ans);
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }
        // 填右括号
        if (close < open) {
            cur.append(')');
            dfs(open, close + 1, n, cur, ans);
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }
    }


}
