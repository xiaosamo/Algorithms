package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 括号生成 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return result;
    }

    private void dfs(int n, int l, int r,String cur) {
        if (l > n || r > n || r > l) {
            return;
        }
        if (l == n && r == n) {
            result.add(cur);
            return;
        }
        dfs(n, l + 1, r, cur + "(");
        dfs(n, l, r + 1, cur + ")");

    }

    public static void main(String[] args) {
        括号生成 obj = new 括号生成();
        obj.generateParenthesis(3);
    }

}
