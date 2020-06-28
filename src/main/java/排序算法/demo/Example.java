package 排序算法.demo;

import 排序算法.Heap;


public class Example {


    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] a = {5, 4, 1, 3, 5, 3, 1, 0, 3, 8};
        Double[] d = new Double[N];
        for (int i = 0; i < N; i++) {
            // (0-100)
            d[i] = Math.floor(Math.random() * 100);

        }

//        Selection.sort(a);
//        Selection.sort(d);

//        Insertion.sort(a);
//        Insertion.sort(d);

//        Shell.sort(a);
//        Shell.sort(d);

//        InsertionX.sort(a);
//        InsertionX.sort(d);

//        Arrays.sort(a);
//        Merge.sort(a);

//        Arrays.sort(d);
//        Merge.sort(d);

        Heap.sort(a);
        Heap.sort(d);

        show(a);
        show(d);



    }


}
