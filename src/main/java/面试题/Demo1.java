package 面试题;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/4/29
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String start = in.next();
        String end = in.next();

        if (start.length() == 3) {
            start = "0" + start;
        }

        if (end.length() == 3) {
            end = "0" + end;
        }

        Integer e = Integer.valueOf(end.substring(0, 2)) * 60 + Integer.valueOf(end.substring(2));
        Integer s = Integer.valueOf(start.substring(0, 2)) * 60 + Integer.valueOf(start.substring(2));

        Integer min = e - s;
        System.out.printf("航班飞行时间为%d小时%d分钟\n", min / 60, min % 60);

    }
}
