package nod51;

import java.util.Scanner;

/**
 * 解法2：贪心+二分
 * 思路：
 * 新建一个low数组，low[i]表示长度为i的LIS结尾元素的最小值。对于一个上升子序列，显然其结尾元素越小，越有利于在后面接其他的元素，也就越可能变得更长。因此，我们只需要维护low数组，对于每一个a[i]，如果a[i] > low[当前最长的LIS长度]，就把a[i]接到当前最长的LIS后面，即low[++当前最长的LIS长度]=a[i]。
 * 那么，怎么维护low数组呢？
 * 对于每一个a[i]，如果a[i]能接到LIS后面，就接上去；否则，就用a[i]取更新low数组。具体方法是，在low数组中找到第一个大于等于a[i]的元素low[j]，用a[i]去更新low[j]。如果从头到尾扫一遍low数组的话，时间复杂度仍是O(n^2)。我们注意到low数组内部一定是单调不降的，所有我们可以二分low数组，找出第一个大于等于a[i]的元素。二分一次low数组的时间复杂度的O(lgn)，所以总的时间复杂度是O(nlogn)。
 */

public class 最长递增子序列2 {
    static int n;
    public static void main(String []args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            n = in.nextInt();
            int []a=new int[n+1];
            int []low=new int[n+1];
            for(int i=1;i<=n;i++){
                a[i] = in.nextInt();
                low[i] = Integer.MAX_VALUE;    //由于low中存的是最小值，所以low初始化为INF
            }
            int ans=1;    //初始时LIS长度为1
            low[1]=a[1];
            for(int i=2;i<=n;i++){
                if(a[i]>=low[ans]){       //若a[i]>=low[ans]，直接把a[i]接到后面
                    low[++ans]=a[i];
                }else{       //否则，找到low中第一个>=a[i]的位置low[j]，用a[i]更新low[j]
                    low[lower_bound(low,1,ans,a[i])]=a[i];
                }
            }
            System.out.println(ans);
        }
    }

    //二分查找，返回a数组中第一个>=v的位置
    static int lower_bound(int []a,int x,int y,int v){
        int m;
        while(x<y){
            m = x + (y - x) / 2;
            if(a[m]>=v) y=m;
            else x=m+1;
        }
        return x;
    }
}
