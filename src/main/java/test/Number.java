package test;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yuan
 * @date 2020/4/24
 * http://www.10086api.com.cn/console/Index.aspx
 */
public class Number {
    private static Random random = new Random();
    private static final int N = 5000;
    public static void main(String[] args) throws IOException {
        File f = new File("d:/number.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        int i=0;
        while (i < N) {
            String num = get();
            if (isMobile(num)) {
                writer.write(num);
                writer.newLine();
                i++;
            }
        }
        writer.flush();
        writer.close();
    }

    private static String get(){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String s2="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        p = Pattern.compile(s2);
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
