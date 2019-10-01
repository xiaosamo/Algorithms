package 面试题;

import java.util.*;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 表达式求值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println(solve(a, b, c));
    }

    private static int solve(int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        list.add(a + b * c);
        list.add(a * (b + c));
        list.add(a * b * c);
        list.add((a + b) * c);
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
