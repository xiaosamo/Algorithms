package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/6
 * @description
 */
public class Excel表列序号 {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum = sum * 26 + c - 'A' + 1;
        }
        return sum;
    }
}
