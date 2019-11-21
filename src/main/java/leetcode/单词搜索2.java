package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/11/21
 * @description
 */
public class 单词搜索2 {

    int[][] dt = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1},
    };

    /**
     * 前缀树
     */
    class Trie{
        Node root = new Node();
        class Node {
            boolean isEnd = false;
            Node[] children = new Node[26];
            String val; // 记录单词
        }

        private void add(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                    cur = cur.children[c - 'a'];
                } else {
                    cur = cur.children[c - 'a'];
                }
            }
            cur.isEnd = true;
            cur.val = word;
        }
    }

    Set<String> result = new HashSet<>(); // 结果需要去重
    public List<String> findWords(char[][] board, String[] words) {

        // 构建字典树
        Trie trie = new Trie();
        for (String s : words) {
            trie.add(s);
        }

        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                dfs(board, vis, i, j, m, n, trie.root);
                vis[i][j] = false;
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board,boolean[][] vis, int x, int y, int m, int n, Trie.Node cur) {
        cur = cur.children[board[x][y] - 'a'];
        if (cur == null) {
            return;
        }
        if (cur.isEnd) {
            result.add(cur.val);
//            System.out.println(cur.val);
            // 找到单词后不能回退，因为可能是“aaa” “aaad”这样的单词得继续回溯
//            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dt[i][0];
            int ny = y + dt[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                vis[nx][ny] = true;
                dfs(board, vis, nx, ny, m, n, cur);
                vis[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) {
        单词搜索2 obj = new 单词搜索2();
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'},
        };
        String[] s = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        obj.findWords(board, s);
    }
}
