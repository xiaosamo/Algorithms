package 面试题.去哪儿;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/9/7
 * @description
 */
public class 文本嗅探 {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {

        int[] res = new int[m];
        int t = 0;
        for (int i = 0; i < m; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {

                if (A[j].contains(keys[i])) {
                    index = j;
                }

                if (A[j].equals(keys[i])) {
                    index = j;
                    break;
                }
            }
            res[t++] = index;
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        if (sum == -1 * m) {
            return new int[]{-1};
        }
        return res;
    }

    public static void main(String[] args) {
        文本嗅探 obj = new 文本嗅探();
        int[] res = obj.containKeyword(new String[]{"nowcoder", "hello", "now"}, 3, new String[]{"coder", "now"}, 2);
        System.out.println(Arrays.toString(res));

        System.out.println("nowcoder".contains("coder"));

    }
}
