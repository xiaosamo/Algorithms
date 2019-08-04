package other;

import 蓝桥杯.算法训练.Main;

/**
 * 剑指offer：替换空格 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {

    public static String replaceSpace(String str) {
        int len = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "We Are Happy";
        System.out.println(replaceSpace(str));

    }
}
