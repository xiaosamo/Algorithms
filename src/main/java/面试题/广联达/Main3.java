package 面试题.广联达;

/**
 * @author yuan
 * @date 2019/9/6
 * @description
 *
 * https://www.nowcoder.com/test/question/done?tid=27165720&qid=174730#summary
 *
 * 【编程题】给出一个非负整数数组，你最初定位在数组的第一个位置，数组中的每个元素的值代表你在那个位置可以跳跃的最大长度。判断你是否能到达数组的最后一个位置。
 *
 * 例如：A = [2,3,1,1,4]，返回 true
 *
 * A = [3,2,1,0,4]，返回 false
 */
public class Main3 {

    public boolean canJump(int []a) {
        int maxN = 0; // 当前位置能到达的最大距离
        for (int i = 0; i <= maxN; i++) {
            maxN = Math.max(maxN, a[i] + i);
            if (maxN >= a.length - 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Main3 obj = new Main3();

        System.out.println(obj.canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(obj.canJump(new int[]{3, 2, 1, 0, 4})); // false
    }
}
