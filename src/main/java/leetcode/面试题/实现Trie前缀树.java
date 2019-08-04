package leetcode.面试题;

import leetcode.Trie2;

/**
 * @author yuan
 * @date 2019/3/9
 * @description
 */
public class 实现Trie前缀树 {

    private Node root;


    private class Node{
        char c;
        Node left,mid, right;
        boolean isWordEnd = false;
    }


    public void insert(String word) {
        root = insert(root, word,0);

    }

    private Node insert(Node x, String word, int d) {
        char c = word.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = insert(x.left, word, d);
        } else if (c > x.c) {
            x.right = insert(x.right, word, d);
        } else if (d < word.length() - 1) {
            x.mid = insert(x.mid, word, d + 1);
        } else {
            x.isWordEnd = true;
        }
        return x;
    }


    public boolean search(String word) {
        Node x = search(root, word, 0);
        return x != null && x.isWordEnd;
    }

    private Node search(Node x, String word, int d) {
        if (x == null) {
            return null;
        }
        char c = word.charAt(d);
        if (c < x.c) {
            return search(x.left, word, d);
        } else if (c > x.c) {
            return search(x.right, word, d);
        } else if (d < word.length() -1) {
            return search(x.mid, word, d + 1);
        }
        return x;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(root, prefix, 0) != null;
    }

    public static void main(String[] args) {
        实现Trie前缀树 trie = new 实现Trie前缀树();
//        trie.insert("aaa");
        trie.insert("abc");
//        System.out.println(trie.search("aaa"));
//        System.out.println(trie.search("aab"));
//        System.out.println(trie.search("abc"));
//        System.out.println(trie.search("ab"));
//        System.out.println(trie.startsWith("ab"));
//

//        实现Trie前缀树 tst = new 实现Trie前缀树();
//        tst.insert("apple");
//        System.out.println(tst.search("apple"));   // 返回 true
//        System.out.println(tst.search("app"));     // 返回 false
//        System.out.println();
//        System.out.println(tst.startsWith("app")); // 返回 true
//        System.out.println();
//        tst.insert("app");
//        System.out.println(tst.search("app"));     // 返回 true


    }



}
