package leetcode.面试题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/3/6
 * @description 将数组排序，再输出为字符串。
 *
 * 那么问题来了，排序规则是什么？
 *
 * 很简单，将两个数字颠倒连接比较就好了，比如10，2：比较102和210，显然210 大，那么排序就是2，10。
 *
 * 为了方便这种操作，我们简化，直接比较时候就转成String类型，这样比较好实现字符串的连接，否则纯数字还要考虑位数等等问题。
 */
public class 最大数 {

    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] strNums = new String[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder res = new StringBuilder();
        for (String s : strNums) {
            res = res.append(s);
        }
        return res.charAt(0) == '0' ? "0" : res.toString();

    }

    public String largestNumber2(int[] nums) {
        String[] max = {""};
        StringBuilder ans = new StringBuilder();
        Arrays.stream(nums)
                .mapToObj(n-> Integer.valueOf(n).toString())
                .sorted( (a,b)->{
                    String num1 = a +b;
                    String num2 = b +a;
                    return num2.compareTo(num1);
                })
                .forEach( n ->{
                    max[0] += n;
                });
        return max[0].replaceAll("^(0+)\\B", "");
    }




    public static void main(String[] args) {
        最大数 obj = new 最大数();
//        int[] a = {3, 30, 34, 5, 9};
//        int[] a = {3};
        int[] a = {10, 2};
        System.out.println(obj.largestNumber(a));
//        System.out.println(obj.less(34,9));
    }
}
