import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        K = n - K + 1; // 第K大的数即为第n - K + 1小的数
        int l = 0, r = n - 1;
        int index = partition(a,l,r);
        while(index != K-1){
            if(index > K-1){
                r = index - 1;
            }else{
                l = index + 1;
            }
            index = partition(a,l,r);
        }
        return a[index];
    }
    
    /**
    * 切分
    */
    private int partition(int []a,int l,int r){
        int base = a[l];
        int i=l,j=r;
        while(i<j){
            while(i<j && a[j]>= base) --j;
            while(i<j && a[i]<= base) ++i;
            if(i<j) swap(a,i,j);
        }
        swap(a,i,l);
        return i;
    }
    private static void swap(int []a,int i,int j){
        int t = a[i];
        a[i]= a[j];
        a[j]= t;
           
    }

    public static void main(String[] args) {
        Finder obj = new Finder();
        System.out.println(obj.findKth(new int[]{1, 3, 5, 2, 2}, 5, 3));
    }
}