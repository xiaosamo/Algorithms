package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/1
 */
public class 有效括号的嵌套深度 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }
}
