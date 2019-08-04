package 排序算法;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/2/23
 * @description 比较排序算法
 */
public class SortCompare {
    /**
     * 计算排序时间，返回秒
     * @param alg
     * @param a
     * @return
     */
    public static double time(String alg,Double []a) {
        Stopwatch timer = new Stopwatch();
        if ("Insertion".equals(alg)) {
            Insertion.sort(a);
        }
        if ("InsertionX".equals(alg)) {
            InsertionX.sort(a);
        }
        if ("Selection".equals(alg)) {
            Selection.sort(a);
        }
        if ("Quick".equals(alg)) {
            Arrays.sort(a);
        }
        if ("Shell".equals(alg)) {
            Sell.sort(a);
        }
        if ("Merge".equals(alg)) {
            Merge.sort(a);
        }
        if ("Heap".equals(alg)) {
            Heap.sort(a);
        }

        return timer.elapsedTime();
    }

    /**
     * 使用算法alg将T个长度为N的数组排序
     * @param alg
     * @param N
     * @param T 排序次数
     * @return 排序时间，单位秒
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 测试次数
            for (int i = 0; i < N; i++) {
                // [0,1)的随机数
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }


    public static void main(String[] args) {
        int N = 10000;
        int T = 10000;
//        double t1 = timeRandomInput("Insertion", N, T);
//        double t2 = timeRandomInput("Selection", N, T);
        double t3 = timeRandomInput("Quick", N, T);
        double t4 = timeRandomInput("Shell", N, T);
//        double t5 = timeRandomInput("InsertionX", N, T);
        double t6 = timeRandomInput("Merge", N, T);
        double t7 = timeRandomInput("Heap", N, T);


//        System.out.printf("Insertion time = %.1fs\n", t1);
//        System.out.printf("Selection time = %.1fs\n", t2);
        System.out.printf("Quick time = %.1fs\n", t3);
        System.out.printf("Shell time = %.1fs\n", t4);
//        System.out.printf("InsertionX time = %.1fs\n", t5);
        System.out.printf("Merge time = %.1fs\n", t6);
        System.out.printf("Heap time = %.1fs\n", t7);
    }

}
