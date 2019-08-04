package 剑指Offer;

/**
 * @author yuan
 * @date 2019/6/1
 * @description
 */
public class 数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                // 如果同时出现，则是重复数字
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // 交换
                swap(numbers, numbers[i], i);
            }
        }
        return false;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        数组中重复的数字 obj = new 数组中重复的数字();
        int[] a = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] b = new int[2];
        System.out.println(obj.duplicate(a, a.length, b));
        System.out.println(b[0]);

    }
}
