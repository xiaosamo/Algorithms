package 面试题.奇安信;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/12/3
 * @description
 * 结束进程树
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定n个进程，这些进程满足以下条件：
 *
 * （1）每个进程有唯一的PID，其中PID为进程ID
 *
 * （2）每个进程最多只有一个父进程，但可能有多个子进程，用PPID表示父进程ID
 *
 * （3）若一个进程没有父进程，则其PPID为0
 *
 * （4）PID、PPID都是无符号整数
 *
 * 结束进程树的含义是当结束一个进程时，它的所有子进程也会被结束，包括子进程的子进程。
 *
 *
 * 现在给定大小为n的两组输入列表A和B（1 <= n <= 100），列表A表示进程的PID列表，列表B表示列表A对应的父进程的列表，即PPID列表。
 *
 * 若再给定一个PID，请输出结束该PID的进程树时总共结束的进程数量。
 */
public class 结束进程树 {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        String[] s2 = in.nextLine().split(" ");

//        String[] s1 = "3 1 5 21 10".split(" ");
//        String[] s2 = "0 3 3 1 5".split(" ");

        int n = s1.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(s1[i]);
            b[i] = Integer.valueOf(s2[i]);
        }
        int pid = in.nextInt();
        System.out.println(solve(a, b, pid,n));

    }

    private static int solve(int[] a, int[] b, int pid,int n) {

//        if (pid == 0) {
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                if (a[i] == 0)  ++ count;
//                if (b[i] == 0)  ++ count;
//            }
//            return count;
//        }

        boolean ok = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == pid) {
                set.add(pid);
                ok = true;
            }
        }
        if (!ok) {
            return 0;
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, pid, a, b, vis);
        }
        return set.size();
    }

    private static void dfs(int index, int pid, int[] a, int[] b, boolean[] vis) {
        if (index >= a.length) {
            return;
        }
        if (b[index] == pid) {
            // 相等
            set.add(a[index]);
            dfs(index, a[index], a, b,vis);
        } else {
            dfs(index + 1, pid, a, b, vis);
        }


    }


}
