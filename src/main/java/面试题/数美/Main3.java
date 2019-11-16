package 面试题.数美;


import java.io.*;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class Main3 {

    // 根节点
    private static Node root = new Node();

    public static void main(String[] args) throws IOException {
        // input.txt文件路径
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\domain.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)),
                "UTF-8"));

        TrieST2<Integer> st = new TrieST2<>();

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            add(rev(line)); // 反转后添加
            st.put(rev(line), 1);
        }

//        System.out.println(search(rev("*.sports.sina.com.cn")));
        System.out.println(search(rev("roll.sports.sina.com.cn")));

//        Iterable<String> iterable = st.keysWithPrefix(rev("roll.sports.sina.com.cn"));
//
//        for (String s : iterable) {
//            System.out.println(s);
//        }
    }

    private static String rev(String s){
        return new StringBuilder(s).reverse().toString();
    }

    private static class Node{
        private int count;
        private char  ch;
        private boolean isEnd;
        private Node[] next;
        Node(){
            count = 1;
            next = new Node[256];
            isEnd = false;
        }
    }

    public static void add(String val) {
        if (val == null || val.length() == 0) {
            return;
        }
        Node node = root;
        char[] chars = val.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (node.next[chars[i]] == null) {
                node.next[chars[i]] = new Node();
                node.next[chars[i]].ch = chars[i];
            } else {
                node.next[chars[i]].count++;
            }
            node = node.next[chars[i]];
        }
        node.isEnd=true;
    }

    public static boolean search(String val) {
        if (val == null || val.length() == 0) {
            return false;
        }
        String ans = "";
        char[] chars = val.toCharArray();
        Node node = root;
        for (int i = 0; i < chars.length; i++) {
            if (node.next[chars[i] ] == null) {
                return false;
            } else {
                node = node.next[chars[i]];
            }
            ans += node.ch;

            for (int j = 0; j < 256; j++) {
                if (node.next[j] != null &&node.next[j].ch == '*') {
                    System.out.println(ans);
                    ans += "*";
                    return true;
                }
            }
//            if (node.next[chars[i+1]].ch == '*') {
//                return true;
//            }
        }
        return node.count > 0;
    }



}
