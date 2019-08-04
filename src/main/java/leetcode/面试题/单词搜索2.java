package leetcode.面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/3/9
 * @description
 */
public class 单词搜索2 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (String w : words) {
            dfs(board, w, result);

        }
        return result;
    }

    private void dfs(char[][] board, String word, List<String> result) {
        for (int i = 0; i < 4; i++) {
//            int nx=
        }
    }
}
