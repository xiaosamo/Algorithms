package leetcode;

/**
 * @author yuan
 * @date 2019/4/4
 * @description
 */
public class 数字的补数 {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '0' ? '1' : '0';
        }
        s = String.valueOf(chars);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 2 + (s.charAt(i) - '0');

        }
        return sum;
    }

    public static void main(String[] args) {
        数字的补数 obj = new 数字的补数();
        obj.findComplement(5);
        obj.findComplement(1);
    }
}
