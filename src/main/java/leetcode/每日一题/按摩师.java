package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/3/24
 */
public class 按摩师 {
    int max = 0;
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    private void dfs(int index, int cur, int[] nums) {
        if (index >= nums.length) {
            max = Math.max(max, cur);
            return;
        }
        dfs(index + 2, cur + nums[index], nums);
        dfs(index + 1, cur, nums);
    }

    public static void main(String[] args) {
        按摩师 obj = new 按摩师();
        System.out.println(obj.massage(new int[]{1, 2, 3, 1}));
    }
}
