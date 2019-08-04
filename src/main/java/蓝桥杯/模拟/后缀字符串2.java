package 蓝桥杯.模拟;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 */
public class 后缀字符串2 {
    private static Node root = new Node();

    private static int num = 0;

    static class Node{
        Node[] next = new Node[26];
        char c;
        boolean isWorldEnd = false;
    }

    private static void put(String s) {
        root = put(root, 0, s);
    }

    private static Node put(Node x, int d, String s) {
        char c = s.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }

        if (d == s.length() - 1) {
            x.isWorldEnd = true;
            return x;
        }

        x.next[c - 'a'] = put(x.next[c - 'a'], d + 1, s);
        return x;
    }

    private static boolean search(String s) {
        Node x = search(root, 0, s);
        return x != null && x.isWorldEnd;
    }

    private static int startWith(String pre) {
        Queue<String> queue = new LinkedList<>();
        collect(search(root, 0, pre), pre, queue);
        return queue.size();
//        return queue;
    }

    private static void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) {
            return;
        }
        if (x.isWorldEnd) {
            queue.offer(pre);
        }
        for (char c = 0; c < 26; c++) {
            collect(x.next[c], pre + c, queue);
        }
    }

    private static Node search(Node x, int d, String s) {
        if (x == null) {
            return null;
        }
        char c = s.charAt(d);

        if (x.isWorldEnd) {
            ++num;
        }

        if (d == s.length() - 1) {
            return x;
        }
        return search(x.next[c - 'a'], d + 1, s);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = new StringBuilder(in.next()).reverse().toString();
            put(str[i]);
        }
//        System.out.println(search());
        for (String s : str) {
            num = 0;
            System.out.println(startWith(s));
//            search(s);
//            System.out.println(search(s));
//            System.out.println(num);

//            System.out.println();
        }
//        Iterable it = startWith("a");
//        it.forEach(s -> System.out.println(s));

//        System.out.println(startWith("abce"));

    }


}
