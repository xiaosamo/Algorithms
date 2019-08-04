package 蓝桥杯.模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/21
 * @description
 */
public class 轻重搭配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        //贪心: 使用双指针 在后半段数组中查找比a[i]大两倍的第一个元素 并且指针q是一直增加的
        int q = n / 2;
        int ans = n;
        for (int i = 0; i < n / 2; i++) {
            while (q < n && a[q] < a[i] * 2) {
                q++;
            }
            if (q == n) {
                break;
            }
            // 匹配到了一个，票数就-1
            --ans;
            q++;
        }
        System.out.println(ans);

    }
}
