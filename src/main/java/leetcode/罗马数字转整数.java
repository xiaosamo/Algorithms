package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public static int romanToInt(String s) {
        if (s == null || s.trim().length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                // 右边比左边大
                num -= map.get(s.charAt(i));
            } else {
                num += map.get(s.charAt(i));

            }
        }
        num += map.get(s.charAt(s.length() - 1));
        return num;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
