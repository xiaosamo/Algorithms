package leetcode;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 计数质数 {
    public int countPrimes(int n) {
        int num = 0;
        // 筛选小于n的素数
        boolean[] vis = new boolean[n + 1];

        //        prime(vis, n);
        primeFast(vis, n);

        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                ++num;
            }
        }
        return num;
    }

    private boolean isPrime(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 筛洗小于n的质数 O（NlogN)
     * 对应不超过n的每个非负整数p，删掉2p、3p、4p...
     * 当处理完所有的数后，还没被删掉的就是素数
     * @param vis
     * @param n
     */
    private void prime(boolean[] vis, int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                vis[j] = true;
            }
        }
    }

    /**
     * 改进
     * @param vis
     * @param n
     */
    private void primeFast(boolean[] vis, int n) {
        int m = (int) Math.sqrt(n + 0.5);
        for (int i = 2; i <= m; i++) {
            if (!vis[i]) {
                // 内层循环不必从i*2开始，因为它已经在i=2时被筛选掉了
                for (int j = i * i; j <= n; j += i) {
                    vis[j] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        计数质数 obj = new 计数质数();
//        for (int i = 2; i <= 100; i++) {
//            if (obj.isPrime(i)) {
//                System.out.println(i);
//            }
//        }
        System.out.println(obj.countPrimes(10));
        System.out.println(obj.countPrimes(2));

    }
}
