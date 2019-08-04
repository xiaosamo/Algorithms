package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2019/1/22
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        int[][] a = new int[numRows + 1][numRows + 1];
        a[1][1] = 1;
        result.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                list.add(a[i][j]);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        杨辉三角 obj = new 杨辉三角();
        List<List<Integer>> lists = obj.generate(5);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");

            }
            System.out.println();
        }

    }
}
