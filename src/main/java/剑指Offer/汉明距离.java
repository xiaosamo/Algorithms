package 剑指Offer;

import java.util.BitSet;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int n = x ^ y; // 异或，相同为0，不同为1
        // 然后计算1的数量即可
        int num = 0;
        while (n > 0) {
            ++num;
            n = n & (n - 1);
        }
        return num;
    }
}
