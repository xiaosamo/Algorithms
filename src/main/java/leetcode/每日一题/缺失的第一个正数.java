package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/6/27
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 注意，这里交换顺序不能变，否则可能下标越界
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(new 缺失的第一个正数().firstMissingPositive(new int[]{3, 4, -1, 4}));
    }
}
