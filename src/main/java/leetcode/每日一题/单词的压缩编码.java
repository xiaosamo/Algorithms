package leetcode.每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/3/28
 */
public class 单词的压缩编码 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));


        for (String w : words) {
            for (int k = 1; k < w.length(); k++) {
                set.remove(w.substring(k));
            }
        }

        int ans = 0;
        for (String w : set) {
            ans += w.length() + 1;
        }
        return ans;
    }

    public int minimumLengthEncoding2(String[] words) {
        int N = words.length;
        // 反转每个单词
        String[] reversed_words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = words[i];
            String rword = new StringBuilder(word).reverse().toString();
            reversed_words[i] = rword;
        }
        // 字典序排序
        Arrays.sort(reversed_words);

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i+1 < N && reversed_words[i+1].startsWith(reversed_words[i])) {
                // 当前单词是下一个单词的前缀，丢弃
            } else {
                res += reversed_words[i].length() + 1; // 单词加上一个 '#' 的长度
            }
        }
        return res;
    }


    public static void main(String[] args) {
        单词的压缩编码 obj = new 单词的压缩编码();
        System.out.println(obj.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(obj.minimumLengthEncoding(new String[]{"me", "time"}));
    }
}
