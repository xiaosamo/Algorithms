package 面试题.东方财富;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 * 求字符串的全部组合
 * 比如输入A,A,B
 */
public class Demo2 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(",");
        boolean[] vis = new boolean[split.length];
        dfs(split, 0,"",vis);
        System.out.println(set.size());

    }

    private static void dfs(String[] str, int index,String cur,boolean[]vis) {
        if (index == str.length) {
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (!set.contains(cur + str[i]) && !vis[i]) {
                vis[i] = true;
                set.add(cur + str[i]);
                System.out.println(cur+str[i]);
                dfs(str, index + 1, cur + str[i],vis);
                vis[i] = false;
            }
        }
    }
}
