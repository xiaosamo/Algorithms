package 面试题.数美;

import java.io.*;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        // input.txt文件路径
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)),
                "UTF-8"));

        int[] count = new int[99999 / 100+1];
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            int n = Integer.valueOf(line);
            count[n / 100]++;
        }

        int t=0;
        for (int i = 0; i < count.length; i++) {
            String s = t + "-" + (t += 99);
            System.out.println(s + " " + count[i]);
            ++t;
        }
    }
}
