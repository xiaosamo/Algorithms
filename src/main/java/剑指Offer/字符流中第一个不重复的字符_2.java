package 剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 */
public class 字符流中第一个不重复的字符_2 {

    StringBuilder sb = new StringBuilder();
    char[] hash = new char[256];

    public void Insert(char ch) {
        sb.append(ch);
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int size = sb.length();
        for (int i = 0; i < size; i++) {
            if (hash[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        字符流中第一个不重复的字符_2 obj = new 字符流中第一个不重复的字符_2();
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
