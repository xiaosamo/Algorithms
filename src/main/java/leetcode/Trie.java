package leetcode;

/**
 * @author yuan
 * @date 2019/1/23
 * @description R向单词查找树
 */
public class Trie {

    private Node root;
    private static int R = 26;
    private class Node{
        Node[] next = new Node[R];
        char c;
        boolean isWordEnd = false;
    }


    /** Inserts a word into the trie. */
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node x = search(root, word, 0);
        if (x == null) {
            return false;
        }
        return x.isWordEnd;
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
        Node x = search(root, prefix, 0);
        return x != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
