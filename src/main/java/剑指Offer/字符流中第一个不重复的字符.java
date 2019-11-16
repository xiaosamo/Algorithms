package 剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class 字符流中第一个不重复的字符 {

    StringBuilder sb = new StringBuilder();
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        sb.append(ch);
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch)+1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        字符流中第一个不重复的字符 obj = new 字符流中第一个不重复的字符();
        obj.Insert('g');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('o');
        System.out.println(obj.FirstAppearingOnce());

        obj.Insert('o');
        System.out.println(obj.FirstAppearingOnce());

        obj.Insert('g');
        System.out.println(obj.FirstAppearingOnce());

        obj.Insert('l');
        System.out.println(obj.FirstAppearingOnce());

        obj.Insert('e');
        System.out.println(obj.FirstAppearingOnce());






    }
}
