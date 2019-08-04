package leetcode;

public class _4的幂 {
    public static boolean isPowerOfThree(int num) {
        // num&(num-1) 判断一个数是否为2的幂数
        // 2、4的幂级数为1,4,16，即0001，0100,10000，也就是1出现在1,3,5,7。。。。位置上。0x55555555在32位系统里表示0b01010101010101010101010101010101。
        return ((num & (num-1)) == 0) && num > 0 && ((num  & 0x55555555) != 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(-2147483648));
        System.out.println(isPowerOfThree(4));
        System.out.println(isPowerOfThree(16));

    }

}
