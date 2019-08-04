package leetcode;

/**
 * @author yuan
 * @date 2019/2/16
 * @description
 */
public class 缺失数字 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        // 数组的和
        int dataSum = 0;
        for (int i = 0; i < len; i++) {
            dataSum += nums[i];
        }
        // 下标的和
        int indexSum = len * (len + 1) / 2;
        return indexSum - dataSum;
    }

    public static void main(String[] args) {
        缺失数字 obj = new 缺失数字();
        obj.missingNumber(new int[]{3, 0, 1});
    }
}
