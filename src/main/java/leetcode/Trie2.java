package leetcode;


/**
 * @author yuan
 * @date 2019/2/22
 * @description 三向单词查找树
 */
public class Trie2 {
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
        boolean isWordEnd = false;
    }

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
        char c = word.charAt(d);
        if (c < x.c) {
            return search(x.left, word, d);
        } else if (c > x.c) {
            return search(x.right, word, d);
        } else if (d < word.length() - 1) {
            return search(x.mid, word, d + 1);
        }
        return x;
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node x = search(root, prefix, 0);
        return x != null;
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
            // 此时d = word.length - 1，到了单词的尾部
            x.isWordEnd = true;
        }
        return x;
    }


    public static void main(String[] args) {
        Trie2 tst = new Trie2();

        tst.insert("apple");
        System.out.println(tst.search("apple"));   // 返回 true
        System.out.println(tst.search("app"));     // 返回 false
        System.out.println();
        System.out.println(tst.startsWith("app")); // 返回 true
        System.out.println();
        tst.insert("app");
        System.out.println(tst.search("app"));     // 返回 true

    }
}
