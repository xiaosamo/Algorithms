package leetcode;

/**
 * @author yhf
 * @date 2019/5/2
 * @description
 */
public class 词典中最长的单词 {

    private Node root;

    static class Node{
        Node[] next = new Node[26];
        boolean isWordEnd = false;
        Node(){}
    }

    private void insert(String word) {
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

    private boolean search(String word) {
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


    public String longestWord(String[] words) {
        for (String w : words) {
            insert(w);
        }

        find(root, new StringBuilder());
        return ans;
    }

    private String ans = "";

    /**
     * 搜索最深的单词
     * @param x
     * @param cur
     */
    private void find(Node x, StringBuilder cur) {

        for (int i = 0; i < 26; i++) {
            if (x.next[i] != null && x.next[i].isWordEnd) {
                char c = (char) ('a' + i);
                cur.append(c);
                if (cur.length() > ans.length()) {
                    ans = cur.toString();
                }
                find(x.next[i], cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        词典中最长的单词 obj = new 词典中最长的单词();
        obj.insert("abc");
//        String[] words = {"w", "wo", "wor", "worl", "world"};
//        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};

        System.out.println(obj.longestWord(words));

//        System.out.println(obj.search("abc"));
//        System.out.println(obj.search("aaa"));
//        System.out.println(obj.search("ab"));

    }
}
