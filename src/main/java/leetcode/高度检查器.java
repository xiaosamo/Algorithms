package leetcode;

/**
 * @author yuan
 * @date 2020/1/8
 * @description
 */
public class 高度检查器 {
    public int heightChecker(int[] heights) {
        if(heights.length ==0) return 0;



        int count = 0;
        int cur = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > cur) {
                ++count;
            } else {
                cur = heights[i];
            }
        }
        return count;
    }
}
