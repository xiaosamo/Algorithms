package 剑指Offer;

/**
 * @author yuan
 * @date 2019/9/21
 * @description
 */
public class 不用加减乘除做加法 {
    public int Add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Add(a ^ b, (a & b) << 1);
    }
}
