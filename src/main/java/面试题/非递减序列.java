package 面试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class 非递减序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        int cnt = 0;
        for (int i = 1; i < list.size() && cnt <= 1; i++) {
            if (list.get(i) < list.get(i - 1)) {
                ++cnt;
            }
        }
        System.out.println(cnt == 1 ? 1 : 0);
    }
}
