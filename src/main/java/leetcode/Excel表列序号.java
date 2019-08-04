package leetcode;

/**
 * @author yuan
 * @date 2019/1/31
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

    public static void main(String[] args) {
        Excel表列序号 obj = new Excel表列序号();
        System.out.println(obj.titleToNumber("A"));
        System.out.println(obj.titleToNumber("AB"));
        System.out.println(obj.titleToNumber("ZY"));
    }
}
