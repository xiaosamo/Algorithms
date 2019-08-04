package 基础练习;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/21
 * @description 单词查找树，参考算法第4版
 */
public class TrieST<Value> {
    /**
     * 基数
     */
    private static int R = 256;

    /**
     * 根节点
     */
    private Node root;

    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    /**
     * 返回以x作为根节点的子单词查找树中与key相关联的值
     * @param x
     * @param key
     * @param d 当前的遍历深度
     * @return
     */
    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key,Value val) {
        root = put(root, key, val, 0);
    }

    /**
     * 如果key存在以x为根节点的子单词查找树中则更新与它相关联的值
     * @param x
     * @param key
     * @param val
     * @param d
     * @return
     */
    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        // 找到第d个字符所对应的子单词查找树
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    /**
     * 查找所有的键
     * @return
     */
    public Iterable<String> keys(){
        return keysWithPrefix("");
    }

    /**
     * 匹配以pre为前缀的键
     * @param pre
     * @return
     */
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.offer(pre);
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    /**
     * 匹配含通配符的键('.'能匹配所有字符)
     * @param pat
     * @return
     */
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) {
            return;
        }
        if (d == pat.length() && x.val != null) {
            q.offer(pre);
        }
        if (d == pat.length()) {
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    /**
     * 查找s中的最长的键
     *
     * @param s
     * @return
     */
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }
        // 当前节点非空，更新length
        if (x.val != null) {
            length = d;
        }
        // 已经遍历到s的末尾，返回
        if (d == s.length()) {
            return length;
        }
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    /**
     * 删除操作
     * @param key
     */
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) {
            return x;
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST<>();
        trieST.put("abc", 3);
        trieST.put("acc", 1);
        trieST.put("bb", 1);

        System.out.println(trieST.get("abc")); // 3

        System.out.println();

        Iterable iterable = trieST.keysThatMatch("a.c");
        iterable.forEach(i -> System.out.println(i)); // abc acc

        System.out.println();

        trieST.delete("abc");
        System.out.println(trieST.get("abc")); // null

    }
}
