package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/22
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/ji-shu-onxian-xing-tan-ce-fa-onpai-xu-onlogn-yi-ya/
 *
 */
public class 使数组唯一的最小增量2 {
    public int minIncrementForUnique(int[] A) {
        int []count = new int[80000];

        // 统计次数
        for (int a : A) {
            count[a]++;
        }

        int ans = 0;
        // 遍历count数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        for (int i = 0; i < 80000; i++) {
            if (count[i] > 1) {
                int t = count[i] - 1;
                ans +=t;
                count[i + 1] += t;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        使数组唯一的最小增量2 obj = new 使数组唯一的最小增量2();
        System.out.println(obj.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(obj.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
