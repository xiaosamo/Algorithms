package other;

/**
 * \d([0-9]):数字
 * \\D:非数字
 * \s:空白字符 空格，\t制表符，\n换行符等
 * \S:非空白字符
 * \w:单词字符 [a-zA-Z_0-9]
 * \W:非单词字符
 * ^、$代表开始和结尾标记，可以不写
 * +号表示至少出现一次
 * 
 */
public class 正则表达式 {
    public static void main(String[] args) {
        String data = "a"; //非数字
        String regex = "\\D";
        System.out.println(data.matches(regex));
    }
}
