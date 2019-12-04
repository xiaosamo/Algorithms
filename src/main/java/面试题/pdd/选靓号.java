package 面试题.pdd;

import java.util.*;

/**
 * @author yuan
 * @date 2019/11/25
 * @description
 */
public class 选靓号 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        solve(n, k, s.toCharArray());
    }

    static class Node{
        int count;
        String s;

        Node(int count, String s) {
            this.count = count;
            this.s = s;
        }
    }

    static int max = -1;
    private static void solve(int n, int k, char[] chars) {
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, String.valueOf(chars)));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.count > max) {
                max = poll.count;
            }

            for (int i = 0; i < chars.length; i++) {

            }

        }

    }
}
