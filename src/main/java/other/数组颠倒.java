package other;

import java.util.Arrays;

public class 数组颠倒 {

    private static void rev(int []a){
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            int t = a[i];
            a[i] = a[N - i - 1];
            a[N - i - 1] = t;
        }
    }
//    for(int i=0;i<N/2;i++)
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        rev(a);
        System.out.println(Arrays.toString(a));

    }


}
