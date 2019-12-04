package 面试题.奇安信;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/12/3
 * @description
 */
public class 求最长不重复字符子串 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int max_length_substring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(set.size(), max);
            } else {
                set.clear();
                set.add(s.charAt(i));
            }
        }
        return max;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = max_length_substring(_s);
        System.out.println(String.valueOf(res));

    }
}
