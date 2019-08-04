package 面试题;

/**
 * @author yhf
 * @date 2019/5/7
 * @description
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
//        s.replaceAll("")
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        if (split.length == 0) {
            return "";
        }
        for (int i = split.length - 1; i > 0; i--) {
            sb.append(split[i] + " ");
        }
        sb.append(split[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        翻转字符串里的单词 obj = new 翻转字符串里的单词();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello world!  "));
        System.out.println(obj.reverseWords("a good   example"));

        float a = 2;
        int c = 2;
        long l = 2;
                
        double d = 2.0;


    }
}
