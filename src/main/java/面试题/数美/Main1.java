package 面试题.数美;

import java.io.*;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        // input.txt文件路径
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)), "UTF-8"));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (contains(line)) {
                System.out.println(line);
            }
        }
    }

    private static boolean contains(String s) throws IOException {
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\keyword.conf";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)), "UTF-8"));
        String line = null;
        String[] split = s.split(" ");
        while ((line = br.readLine()) != null) {
            if (split[0].contains(line)) {
                return true;
            }
        }
        return false;
    }
}
