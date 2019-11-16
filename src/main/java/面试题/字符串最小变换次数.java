package 面试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class 字符串最小变换次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String ans = in.next();

        System.out.println(solve(s, ans));
    }

    private static int solve(String s, String ans) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(s, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.str.equals(ans)) {
                return node.n;
            }
            char[] chars = node.str.toCharArray();
            int len = node.str.length();
            if (len < ans.length()) {
                // 插入一个字符
                for (int i = 0; i < len; i++){
                    if (chars[i] != ans.charAt(i)) {
                        StringBuilder sb = new StringBuilder(node.str);
                        sb.append(new char[]{ans.charAt(i)}, i, 1);
                        queue.offer(new Node(sb.toString(), node.n + 1));
                        break;
                    }
                }
            } else if (len > ans.length()) {
                // 删除一个字符
                for (int i = 0; i < len; i++){
                    if (chars[i] != ans.charAt(i)) {
                        queue.offer(new Node(new StringBuilder(node.str).deleteCharAt(i).toString(), node.n + 1));
                        break;
                    }
                }
            } else {
                // 更改一个字符
                for (int i = 0; i < len; i++) {
                    if (chars[i] != ans.charAt(i)) {
                        chars[i] = ans.charAt(i);
                        queue.offer(new Node(String.valueOf(chars), node.n + 1));
                        break;
                    }
                }
            }

        }
        return -1;
    }

    static class Node{
        private String str;
        private int n;
        public Node(String str, int n) {
            this.str = str;
            this.n = n;
        }
    }
}
