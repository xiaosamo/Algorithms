package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 字典序排数 {
    public static List<Integer> lexicalOrder(int n) {

        /**
         * 超时
         */
        List<String> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i + "");
        }

        Collections.sort(list);


        for (int i = 0; i < n; i++) {
            result.add(i, Integer.valueOf(list.get(i)));
        }

        return result;
    }

    public static List<Integer> lexicalOrder2(int n) {

        /**
         * 还是超时
         */
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {

            if (i <= n) {
                list.add(i);
//                System.out.println(i);
            }
            dfs(i, n,list);
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        return list;
    }

    public static void dfs(int t, int n, List<Integer> list) {
        for (int i = 0; i <= 9; i++) {
            Integer s = Integer.valueOf(t + "" + i);
            if (s > n) {
                break;
            }

            list.add(s);
            if ((s + "").length() < (n + "").length()) {
                dfs(s, n, list);
            }
//            System.out.println(s);
        }
    }


    public static List<Integer> lexicalOrder3(int n) {
        // 模拟
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) {
                    cur /= 10;
                }
                cur += 1;
                while (cur % 10 == 0) {
                    cur /= 10;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }



    public static void main(String[] args) {
        /**
        List<Integer> list = lexicalOrder(13);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
//        lexicalOrder2(13);
        lexicalOrder3(13);

    }
}
