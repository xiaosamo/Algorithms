package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/16
 */
public class 字符串压缩 {
    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        char[] chars = S.toCharArray();

        int curNum = 1;
        char last = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (last == chars[i]) {
                curNum++;
            } else {
                sb.append(last).append(curNum);
                last = chars[i];
                curNum = 1;
            }

        }
        if (curNum > 0) {
            sb.append(last).append(curNum);
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        字符串压缩 obj = new 字符串压缩();
        System.out.println(obj.compressString(s));
    }
}
