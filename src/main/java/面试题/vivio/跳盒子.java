package 面试题.vivio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author yuan
 * @date 2019/11/25
 * @description
 */
public class 跳盒子 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String inputStr = br.readLine();
        String inputStr = "2 2 3 0 4";
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        dfs(input, input.length, 0,0);
        if (Integer.MAX_VALUE == min) {
            // 不可到达，返回-1
            return -1;
        }
        return min;
    }

    static int min = Integer.MAX_VALUE;
    private static void dfs(int[] input, int n, int index,int count) {
        if (index >= n - 1) {
            min = Math.min(count, min);
            return;
        }
        for (int i = input[index]; i >= 1; i--) {
            //可以前进的步数
            dfs(input, n, index + i, count + 1);
        }
    }
}
