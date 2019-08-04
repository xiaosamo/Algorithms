package 排序算法;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/17
 * @description 快速排序
 */
public class Quick {
    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        // 选择一个基数
        int base = a[left];

        int i = left, j = right;
        while (i < j) {
            // 从右往左找比基数小的数
            while (i < j && a[j] >= base) {
                --j;
            }
            if (i < j) {
                // 将找到的比基数小的数放在基数的左边
                // a[i]已经保存在base中，可以将后面的数填入
                a[i++] = a[j];
            }

            // 从左往右找比基数大的数
            while (i < j && a[i] <= base) {
                ++i;
            }
            if (i < j) {
                // 将找到的比基数大的数放在基数的右边
                a[j--] = a[i];
            }
        }
        // 此时i==j，把基数放到i的位置
        a[i] = base;
        // 再分别对基数的左边和后边排序
        sort(a, left, i - 1);
        sort(a, i + 1, right);

    }

    /**
     * 版本2
     *
     * @param a
     */
    public void sort2(int[] a, int left, int right) {

        if (left < right) {
            int index = partition(a, left, right);
            sort2(a, left, index - 1);
            sort2(a, index + 1, right);

        }

    }

    /**
     * 切分
     * @param a
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] a, int left, int right) {
        // 选择一个基数
        int base = a[left];

        int i = left, j = right;
        while (i < j) {
            while (i < j && a[j] >= base) {
                --j;
            }
            while (i < j && a[i] <= base) {
                ++i;
            }
            // 交换
            if (i < j) {
                swap(a, i, j);
            }
        }
        // 此时i==j
        swap(a, left, i);
//        a[i] = base;
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {

        Quick quick = new Quick();
        int[] a = {4, 5, 6, 3, 1, 3, 5, 6, 9, 7, 10};
//        Arrays.sort(a);

        System.out.println(Arrays.toString(a));
        int[] b = {10};
        quick.sort2(a, 0, a.length - 1);
//        quick.sort2(b, 0, b.length - 1);
//        quick.sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        quick.sort2(new int[]{}, 0, 0);

    }

}
