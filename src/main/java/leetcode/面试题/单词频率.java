package leetcode.面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/3/1
 */
public class 单词频率 {
    class WordsFrequency {


        Map<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String w : book) {
                map.merge(w, 1, Integer::sum);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
