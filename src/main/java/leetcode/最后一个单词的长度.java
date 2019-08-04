package leetcode;

public class 最后一个单词的长度 {
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" "));
    }
}
