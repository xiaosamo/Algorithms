package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/12/18
 * @description
 */
public class 唯一摩尔斯密码词 {
    String[] swap = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };


    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(swap[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }


}
