package 蓝桥杯.模拟;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 * 通过map<string, int> mp，将字符串与数进行匹配，这样子，对于ba，我们就可以mp[ba]++,mp[a]++ ，对于每一个字符串都这样子从头到尾，这样子表示以这个为后缀的出现过了一次，那么这样子的复杂度大概为O(n*10)，就不会超时，
 */
public class 后缀字符串3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            str[i] = in.next();
            for (int j = 0; j < str[i].length(); j++) {

                String t = str[i].substring(j);
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 1);
                }
            }
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(map.get(str[i]));
        }
    }
}
