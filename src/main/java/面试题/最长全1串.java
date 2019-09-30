package 面试题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/30
 * @description
 * error
 */
public class 最长全1串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        bfs(a, n, k);

        System.out.println(maxL);
//        System.out.println(getNum(new int[]{1, 1, 1, 1, 0, 1, 0, 1, 0, 1}));
    }

    static int maxL = 0;
    private static void bfs(int[] a, int n, int k) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a));
        int index = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            maxL = Math.max(maxL, getNum(node.a));


            while (index < a.length) {
                if (a[index] != 0) {
                    ++index;
                    continue;
                }
                int t=0;
                int[] cloneA = a.clone();
                for (int i = index; i < cloneA.length; i++) {
                    if (cloneA[i] == 0) {
                        index = i;
                        cloneA[i] = 1;
                        ++t;
                        if (t == k) {
                            break;
                        }
                    } else {
                        ++index;
                    }
                }
                if (t == k) {
                    q.offer(new Node(cloneA));
                }
                ++index;
            }

        }

    }

    static class Node{
        public Node(int []a){
            this.a = a.clone();
        }

        int []a;
    }

    private static int getNum(int []a){
        int num = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                ++num;
            } else {
                num = 0;
            }
            max = Math.max(max,num);
        }
        return max;
    }

}
