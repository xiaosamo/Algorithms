package leetcode;

/**
 * @author yuan
 * @date 2019/11/23
 * @description
 * https://leetcode-cn.com/problems/decode-ways/solution/jie-ma-fang-fa-cyu-yan-shi-xian-by-davidly/
 */
public class 解码方法 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            // 注意,0 01 012 都是非法的
            return 0;
        }
        return decode(s.toCharArray(), s.length() - 1);
    }

    /**
     * 递归
     * @param chars
     * @param index
     * @return
     */
    private int decode(char[] chars, int index) {
        if (index <= 0) {
            // 如果只有一个字符
            return 1;
        }
        int count = 0;
        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr > '0') {
            // 当前字符>0，因为有10、20这两种情况
            count = decode(chars, index - 1);
        }
        if (prev == '1' || (prev == '2' && curr <= '6')) {
            // 如果<=26
            count += decode(chars, index - 2);
        }
        return count;
    }


    /**
     * 动态规划
     * 状态压缩
     * 1.当前是1~9的数字，tmp = cur（即dp[i] = dp[i-1]）
     * 2.前一位和当前位的两位数>=10 && <=26， tmp += prev （即dp[i] += dp[i-2]）
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            // 注意,0 01 012 都是非法的
            return 0;
        }
        char[] chars = s.toCharArray();
        int prev = 1, curr = 1; //dp[-1] = dp[0] = 1
        for (int i = 1; i < chars.length; i++) {
            int tmp = 0;
            if (chars[i] > '0') {
                tmp = curr;  //dp[i] = dp[i-1]
            }
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                tmp += prev; // dp[i] += dp[i-2]
            }
            prev = curr;
            curr = tmp;
        }
        return curr;
    }


        public static void main(String[] args) {
        解码方法 obj = new 解码方法();
        System.out.println(obj.numDecodings2("12"));
        System.out.println(obj.numDecodings2("226"));
    }
}
