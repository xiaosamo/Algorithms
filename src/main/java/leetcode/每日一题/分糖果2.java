package leetcode.每日一题;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/5
 */
public class 分糖果2 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        int cur = 1;
        // 糖果的数量 >= 当前要分的糖果数
        while (candies >= cur) {
            ans[i] += cur;
            candies -= cur;
            cur++;
            i = (i + 1) % num_people;
        }
        // 如果还剩下糖果，要分掉
        if (i < num_people && candies > 0) {
            ans[i] += candies;
        }
        return ans;
    }

    public static void main(String[] args) {
        分糖果2 obj = new 分糖果2();
        System.out.println(Arrays.toString(obj.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(obj.distributeCandies(10, 3)));
        System.out.println(Arrays.toString(obj.distributeCandies(60, 4)));
    }
}
