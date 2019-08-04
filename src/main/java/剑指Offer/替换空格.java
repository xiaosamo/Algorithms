package 剑指Offer;

/**
 * @author yuan
 * @date 2019/1/30
 * @description
 */
public class 替换空格 {
    /**
     * 在原字符串上替换
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();


    }

    public static void main(String[] args) {
        替换空格 obj = new 替换空格();
//        System.out.println(obj.replaceSpace(new StringBuffer("We Are Happy.")));
        System.out.println(obj.replaceSpace(new StringBuffer("helloworld ")));
    }
}
