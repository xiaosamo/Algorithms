package leetcode;

/**
 * @author yuan
 * @date 2019/2/20
 * @description 单词查找树，需要匹配'.'
 */
public class 添加与搜索单词 {

    static class WordDictionary {
        private Node root;
        private static int R = 26;

        static class Node {
            private boolean isWordEnd = false;
            private Node[] next = new Node[R];
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            root = put(root, word, 0);
        }

        private Node put(Node x, String word, int d) {
            if (x == null) {
                x = new Node();
            }
            if (d == word.length()) {
                x.isWordEnd = true;
                return x;
            }
            char c = word.charAt(d);
            x.next[c - 'a'] = put(x.next[c - 'a'], word, d + 1);
            return x;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node x, String pat, int d) {
            if (x == null) {
                return false;
            }
            if (d == pat.length()) {
                return x.isWordEnd;
            }
            char c = pat.charAt(d);
            if (c == '.') {
                // 搜索所有节点
                for (int i = 0; i < R; i++) {
                    if (search(x.next[i], pat, d + 1)) {
                        return true;
                    }
                }
            } else {
                return search(x.next[c - 'a'], pat, d + 1);
            }
            return false;
        }
    }



    public static void main(String[] args) {

        WordDictionary dic = new WordDictionary();

//        dic.addWord("a");
//        System.out.println(dic.search("aa")); // false
//
//        System.out.println();
//
//        dic.addWord("bad");
//        dic.addWord("dad");
//        dic.addWord("mad");
//        System.out.println(dic.search("pad"));// -> false
//        System.out.println(dic.search("bad"));// -> true
//        System.out.println(dic.search(".ad"));// -> true
//        System.out.println(dic.search("b.."));// -> true
//
//        System.out.println();
//
//        dic.addWord("ran");
//        dic.addWord("rune");
//        dic.addWord("runner");
//        dic.addWord("runs");
//
//
//        System.out.println(dic.search("r.n"));

        dic.addWord("abc");
        System.out.println(dic.search("abc"));
//        System.out.println(dic.search("aaa"));
        System.out.println(dic.search("a.c"));

    }
}
