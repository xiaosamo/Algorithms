package 校赛;


import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Demo1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//
//        while (in.hasNext()) {
//            String s = in.next();
//
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//
//            // 最小的串
//            String minS = new String(chars);
//
//            StringBuilder builder = new StringBuilder(minS);
//
//            // 最大的串
//            String maxS = builder.reverse().toString();
//
//            if (maxS.equals(s)) {
//                System.out.println(s);
//            } else {
//                System.out.println(sort(s));
//            }
//        }
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }

    }


    public static String sort(String str){
//        int m = Integer.MAX_VALUE;
        String res = str;
        //利用toCharArray可将字符串转换为char型的数组
        char[] s1 = str.toCharArray();
        for (int i = s1.length-1; i >= 0; i--) {
            for (int j = i - 1; j >=0; j--) {
                if (s1[i] > s1[j]) {
                    char temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
                String t = new String(s1);
//                if (t.compareTo(str) > 0) {
//                    return t;
//                }
//                System.out.println(t);
                int a = t.compareTo(res);
                if (t.compareTo(str) > 0 && a < 0) {
                    res = t;
                }
            }

        }
        return res;
//        return new String(s1);
        //再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
//        String st = new String(s1);
//        return st;
    }

}
