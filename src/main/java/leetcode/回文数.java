package leetcode;

public class 回文数 {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(len - i - 1) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }
}
