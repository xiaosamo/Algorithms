package 紫书;

import java.util.*;
//一个结构体有两个元素String x，int y，排序，如果x相等y升序，否者x升序。

/**
 * 强行对实现它的每个类的对象进行整体排序，实现此接口的对象列表（和数组）可以通过Collections.sort或Arrays.sort进行自动排序。就是输入完了直接就默认排序了，
 */
class structSort implements Comparable<structSort>{

    String x;
    int y;
    public int compareTo(structSort o1) {
        if(this.x.compareTo(o1.x) == 0){
            return this.y - o1.y;
        }
        return this.x.compareTo(o1.x);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        structSort a[] = new structSort[10];
        for (int i = 0; i < n; i++) {
            a[i] = new structSort();
            a[i].x = cin.next();
            a[i].y = cin.nextInt();
        }
        Arrays.sort(a,0,n);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i].x+" "+a[i].y);
        }
    }
}