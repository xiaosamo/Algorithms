package leetcode.每日一题;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yuan
 * @date 2020/4/10
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        if (words.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("  hello world!".trim());

    }
}
