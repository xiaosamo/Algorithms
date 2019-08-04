package 排序算法;

import edu.princeton.cs.algs4.Shell;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuan
 * @date 2019/2/22
 * @description
 */
public class Example {
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
//        System.out.println();


//        Integer c = 3;
//        Integer d = c;
//        System.out.println(d);
//        c = 5;
//        System.out.println(d);


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

//        show(a);
//        show(d);


        byte b = -127;
        System.out.println(b);
        int i = b & 0xff;
        int iB = b;
        System.out.println(i);
        System.out.println(iB);

        System.out.println();
        System.out.println(-4 % 3);
        System.out.println(Math.abs(Integer.MAX_VALUE));

        String h1 = "hello";
        String h2 = "hello";
        String h3 = new String("hello");
        String h4 = new String("hello");
        System.out.println(h1 == h2);
        System.out.println(h1 == h3);
        h1 = "java";

        System.out.println(h1 == h2);
//        System.out.println(h3 == h4);



    }


}
