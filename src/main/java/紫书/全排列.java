package 紫书;

import java.util.Arrays;
import java.util.Scanner;

public class 全排列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = {1, 2, 3};
        int[] b = new int[3];
        String s = "1234";
//        permutation(a, 0);
//        permutation2(s, "");
        permutation3(a.length, b, 0);
    }

    static void permutation(int[] a, int cur) {
        if (a.length == cur) { //边界
            System.out.println(Arrays.toString(a));
        }
        for (int i = cur; i < a.length; i++) {
            swap(a, cur, i);   //  交换元素
            permutation(a, cur + 1);     //交换后，再进行全排列算法
            swap(a, cur, i);    //还原成原来的数组，便于下一次的全排列
        }
    }

    static void permutation2(String str, String cur) {
        /**
         * 递归树：
         　　　　　str:　　 a 　　　　 b	　　　　　　	c
         　　　　　　　　ab ac	　　	ba bc	　　　　	ca cb
         　　result:	 abc acb	　　 bac bca　     　 cab cba
         */
        if (cur.length() == str.length()) { //边界
            System.out.println(cur);
        }
        for (int i = 0; i < str.length(); i++) {
            if (cur.indexOf(str.charAt(i)) < 0) {  //如果str[i]没出现过
                permutation2(str, cur + str.charAt(i));   //就递归调用
            }

        }
    }

    static void swap(int[] a, int cur, int i) {
        int t = a[cur];
        a[cur] = a[i];
        a[i] = t;
    }

    static void permutation3(int n,int []a,int cur){
        if(cur==n){
            for(int i=0;i<n;i++) System.out.print(a[i]+" ");
            System.out.println();
        }
        else{
            System.out.println("no");
            for(int i=1;i<=n;i++) {       //尝试在a[cur]中填各种整数
                boolean ok = true;
                for(int j=0;j<cur;j++) {
                    if(a[j]==i) ok = false;    //如果i在a[0]~a[cur]中出现过，则不能再选
                    if (ok) {
                        a[cur]=i;
                        System.out.println("a[cur]="+a[cur]);
                        permutation3(n,a,cur+1);  //递归
                    }
                }
            }
        }
    }
}
