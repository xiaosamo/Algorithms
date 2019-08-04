package 基础练习;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author yuan
 * @date 2019/2/22
 * @description 三向单词查找树
 */
public class TST<Value> {
    private Node root;

    private class Node{
        /**
         * 字符
         */
        char c;
        /**
         * 左中右子三向单词查找树
         */
        Node left,mid, right;
        /**
         * 值
         */
        Value val;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        }
        return x;
    }

    public void put(String key,Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            x.val = val;
        }
        return x;
    }


    public Iterable<String> keyWithPrefix(String prefix){
        Queue<String> q = new LinkedList<>();
        Node x = get(root, prefix, 0);
        if (x == null) {
            return q;
        }
        if (x.val != null) {
            q.offer(prefix);
        }
        collect(x.mid, prefix, q);
        return q;
    }

    private void collect(Node x, String prefix, Queue<String> q) {
        if (x == null) {
            return;
        }
        collect(x.left, prefix, q);
        if (x.val != null) {
            q.offer(prefix + x.c);
        }
        collect(x.mid, prefix + x.c, q);
        collect(x.right, prefix, q);
    }

    public static void main(String[] args) {
        TST<Integer> tst = new TST<>();
//        tst.put("abc", 3);
//        tst.put("abcd", 4);
//        tst.put("abdc", 4);

        tst.put("apple", 1);
        System.out.println(tst.get("apple"));   // 返回 true
        System.out.println(tst.get("app"));     // 返回 false
        System.out.println();
        tst.keyWithPrefix("app").forEach(i -> System.out.println(i)); // 返回 true
        System.out.println();
        tst.put("app", 1);
        System.out.println(tst.get("app"));     // 返回 true

//        System.out.println(tst.get("abc"));
//        System.out.println(tst.get("abcc"));
//        System.out.println(tst.get("abcd"));
//        tst.keyWithPrefix("abc").forEach(i -> System.out.println(i));

    }
}
