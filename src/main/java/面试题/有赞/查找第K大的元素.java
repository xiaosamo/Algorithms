package 面试题.有赞;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/9
 * @description
 * 给定一个无序的整型数组A[n],数组大小大于等于3,允许有值相同的元素;请设计算法找到该数组排序后第三大的元素值并输出.
 */
public class 查找第K大的元素 {

    public static int solve(int []a){
        int l = 0, r = a.length - 1;
        int index = partition(a, l, r);

        while (index != a.length - 3) {
            if (index > a.length - 3) {
                r = index - 1;
            } else {
                l = index + 1;
            }
            index = partition(a, l, r);
        }
        return a[index];
    }

    private static int partition(int[] a, int l, int r) {
        int i = l, j = r;
        int base = a[l];
        while (i < j) {
            while (i < j && a[j] >= base) {
                --j;
            }
            while (i < j && a[i] <= base) {
                ++i;
            }
            swap(a, i, j);
        }
        swap(a, l, i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] a = new int[str.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solve(a));
//        solve(new int[]{1, 2, 3, 4, 5});
//        solve(new int[]{1, 1, 2, 2, 3});
    }
}
