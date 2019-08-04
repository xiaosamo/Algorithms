package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2018/12/20
 */
public class 超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int k = 1;k<n ; k++) {
            for (int i = 0; i < primes.length; i++) {
                int t = k * primes[i];
                set.add(t);
            }
//            if (set.size() > n) {
//                break;
//            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        list.forEach(i -> System.out.println(i));

        return list.get(n);
    }

    public static void main(String[] args) {
        超级丑数 obj = new 超级丑数();
        int[] a = {2, 7, 13, 19};
        System.out.println(obj.nthSuperUglyNumber(12, a));

    }
}
