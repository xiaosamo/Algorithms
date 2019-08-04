package poj;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 单词统计2418 {
    public static void main(String []args) {
        Scanner in =new Scanner(System.in);
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        String line="";
        double sum=0;
        while (in.hasNextLine()) {
            line = in.nextLine();
            ++sum;
            if (!map.containsKey(line)) map.put(line, 1.0);
            else map.put(line, map.get(line) + 1);
        }
        for (Map.Entry<String, Double> m : map.entrySet()) {
            System.out.printf("%s %.4f\n", m.getKey(), (m.getValue() / sum) * 100);
        }

    }
    
}
