package 剑指Offer;

import java.util.*;

/**
 * @author yuan
 * @date 2019/2/15
 * @description
 */
public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>() ;
        if (str == null || str.length() == 0) {
            return result;
        }
        TreeSet<String> set = new TreeSet<>();
        Permutation(str.toCharArray(), 0, set);
        result.addAll(set);
        return result;

    }

    private void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if (begin == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }

        for (int i = begin; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[begin];
            chars[begin] = temp;

            Permutation(chars, begin + 1, result);

            temp = chars[i];
            chars[i] = chars[begin];
            chars[begin] = temp;
        }
    }

    public static void main(String[] args) {
        字符串的排列 obj = new 字符串的排列();
        ArrayList<String> list = obj.Permutation("abc");
//        ArrayList<String> list = obj.Permutation("0123456789");
        list.forEach(s -> System.out.println(s));

    }

}
