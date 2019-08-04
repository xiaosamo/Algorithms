package nod51;

import java.util.*;

public class Anigram单词1095 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            Map<String,Integer> input = new HashMap<>();
            Map<String, Integer> ans = new HashMap<>();
            for(int i=0;i<n;i++) {
                String s = in.next();

                if (!input.containsKey(s)) input.put(s, 1);
                else input.put(s, input.get(s) + 1);
                s = rev(s);

                if (!ans.containsKey(s)) ans.put(s, 1);
                else ans.put(s, ans.get(s) + 1);
            }
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                String s = in.next();
                int sum=0;
                if (ans.containsKey(rev(s))) {
                    String rs = rev(s);
                    sum += ans.get(rs);
//                    System.out.println("ans="+ans.get(rs));
                    if (input.containsKey(s)) {
                        sum -= input.get(s);
//                        System.out.println("input=" + input.get(s));
                    }
                }
                if(sum<0) sum=0;
                System.out.println(sum);
            }
        }
    }
    //对单词排序
    static String rev(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
