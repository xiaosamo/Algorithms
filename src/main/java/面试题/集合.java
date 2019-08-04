package 面试题;

import java.util.*;

/**
 * @author yuan
 * @date 2019/3/12
 * @description 集合（京东2017秋招真题）
 */
public class 集合 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            for (int i = 0; i < m; i++) {
                set.add(in.nextInt());
            }
            set.forEach(i -> System.out.print(i + " "));
        }
    }
}
