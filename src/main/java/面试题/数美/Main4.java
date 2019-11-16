package 面试题.数美;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/10/15
 * @description
 */
public class Main4 {
    public static void main(String[] args) throws IOException {
        // input.txt文件路径
        String src = "D:\\java\\Algorithms\\src\\main\\java\\面试题\\数美\\input.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)), "UTF-8"));

        String line = null;
        HashMap<String, Double> map = new HashMap<>();

        int count = 0;
        String name = "";
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            name = split[0];
            if (!map.containsKey(split[1])) {
                map.put(split[1], 1.0);
            } else {
                map.put(split[1], map.get(split[1]) + 1.0);
            }
//            System.out.println(line);
            ++count;
        }
        double ans = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double t = entry.getValue() / count;
            ans -= t * (Math.log(t) / Math.log((double) 2)); // t*log2
        }
        System.out.println(name + "," + ans);
    }
}
