package 校赛;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/18
 * @description
 */
public class 无限法则_BFS {
    static class Node{
        String s;
        int step;
        Node(String s, int step) {
            this.s=s;
            this.step = step;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0) {
            String s = in.next();
            if (isok(s)) {
                // 如果有h n i s t 5字
                bfs(s);
            } else {
                System.out.println("-1");
            }
        }
    }

    private static boolean isok(String s) {
        return s.contains("h") && s.contains("n") && s.contains("i") && s.contains("s") && s.contains("t");
    }

    private static void bfs(String s) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        queue.add(new Node(s, 0));
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (t.s.contains("hnist")) {
                System.out.println(t.step);
                return;
            }
            for (int i = 0; i < t.s.length() - 1; i++) {
                // 每次和后面字符一个交换
                String st = swap(t.s, i);
                if (!set.contains(st)) {
                    queue.add(new Node(st, t.step + 1));
                    set.add(st);
                }
            }
        }
    }

    private static String swap(String s, int i){
        char[] chars = s.toCharArray();
        char c = chars[i];
        chars[i] = chars[i+1];
        chars[i + 1] = c;
        return String.valueOf(chars);
    }
}
