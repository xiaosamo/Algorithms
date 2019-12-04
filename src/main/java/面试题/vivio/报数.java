package 面试题.vivio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuan
 * @date 2019/11/25
 * @description
 * https://www.nowcoder.com/question/next?pid=20555525&qid=637399&tid=29491854
 */
public class 报数 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {

        int n = input[0];
        int m = input[1];

        // 用队列模拟
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (q.size() == 1) {
                sb.append(q.getFirst());
                break;
            }
            for (int j = 1; j < m; j++) {
                q.addLast(q.removeFirst());
            }
            sb.append(q.removeFirst() + " ");
        }
        return sb.toString();
    }
}
