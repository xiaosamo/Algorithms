package 面试题.数美;


import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class Main3_2 {

    public static void main(String[] args) throws IOException {
        // input.txt文件路径
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\domain.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)),
                "UTF-8"));

        String line = null;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        Scanner in = new Scanner(System.in);
        String input = in.next();

        int max = 0;
        String ans = "";
        for (String s : list) {
            if (isOk(s,input) && s.length() > max) {
                max = s.length();
                ans = s;
            }
        }
        System.out.println(ans);
    }

    private static boolean isOk(String s, String input) {
        if (input.length() < s.length()) {
            return false;
        }
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) == '*') {
                ++i;
                while (input.charAt(j)!='.') ++j;
            }else if (s.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
