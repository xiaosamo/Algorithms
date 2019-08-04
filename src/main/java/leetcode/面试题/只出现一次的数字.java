package leetcode.面试题;

import java.util.HashMap;

/**
 * @author yuan
 * @date 2019/3/3
 * @description
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer k : map.keySet()) {
            if (map.get(k) == 1) {
                return k;
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {

        int a = 2;
        int b = 3;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a=" + a + ",b=" + b); // a=3,b=2
    }

}
