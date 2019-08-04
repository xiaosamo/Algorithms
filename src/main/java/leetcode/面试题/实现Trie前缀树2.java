package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/9
 * @description
 */
public class 实现Trie前缀树2 {

    private Node root;

    private class Node{
        Node[] next = new Node[26];
        boolean isWordEnd = false;
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == word.length()) {
            x.isWordEnd = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c - 'a'] = insert(x.next[c - 'a'], word, d + 1);
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
        if (d == word.length()) {
            return x;
        }
        char c = word.charAt(d);
        return search(x.next[c - 'a'], word, d + 1);
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(root, prefix, 0) != null;
    }

    public static void main(String[] args) {
        实现Trie前缀树2 trie = new 实现Trie前缀树2();
//        trie.insert("aaa");
        trie.insert("abc");
//        System.out.println(trie.search("aaa"));
//        System.out.println(trie.search("aab"));
//        System.out.println(trie.search("abc"));
//        System.out.println(trie.search("ab"));
//        System.out.println(trie.startsWith("ab"));
//

//        "sdfsd".endsWith()

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
