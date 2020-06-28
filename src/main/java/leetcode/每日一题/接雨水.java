package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/4/4
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 */
public class 接雨水 {
    /**
     * 暴力 O(n^2)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];

        }
        return ans;
    }

    /**
     * 在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。但是我们可以提前存储这个值。因此，可以通过动态编程解决。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n]; // 找到数组中从下标 i 到最左端最高的条形块高度
        int[] rightMax = new int[n];  // 找到数组中从下标 i 到最右端最高的条形块高度

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }


        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

        public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        接雨水 obj = new 接雨水();

//        System.out.println(obj.trap(a));
        System.out.println(obj.trap(new int[]{0, 2, 0}));
    }
}
