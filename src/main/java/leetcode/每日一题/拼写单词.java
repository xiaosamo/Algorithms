package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/17
 */
public class 拼写单词 {
    private int[] map = new int[26];
    public int countCharacters(String[] words, String chars) {
        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i) - 'a']++;
        }

        int sum = 0;
        for (String w : words) {
            if (isOk(w)) {
                sum += w.length();
            }
        }
        return sum;
    }

    private boolean isOk(String word) {
        int[] temp = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            temp[index]++;
            if (temp[index] > map[index]) {
                return false;
            }
        }
        return true;
    }
}
