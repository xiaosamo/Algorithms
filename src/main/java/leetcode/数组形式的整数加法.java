package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/3/10
 * @description
 */
public class 数组形式的整数加法 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        String s = String.valueOf(K);

        int q = 0;
        int i, j, t;
        for (i = A.length - 1, j = s.length() - 1; i >= 0 || j >= 0; i--, j--) {
            // t = s.charAt(j) - '0' + A[i] + q;
            t = q;
            if (j >= 0) {
                t += s.charAt(j) - '0';
            }
            if (i >= 0) {
                t += A[i];
            }
            q = 0;
            if (t > 9) {
                q = t / 10;
                t %= 10;
            }
            list.add(t);
        }
        if (q > 0) {
            list.add(q);
        }

        for (i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
//        result.forEach(k -> System.out.print(k + " "));
//        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        数组形式的整数加法 obj = new 数组形式的整数加法();
        obj.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        obj.addToArrayForm(new int[]{2,7,4}, 181);
        obj.addToArrayForm(new int[]{2,1,5}, 806);
        obj.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1);
        obj.addToArrayForm(new int[]{6}, 809);
        obj.addToArrayForm(new int[]{}, 123);
    }
}
