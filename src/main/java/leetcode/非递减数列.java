package leetcode;

/**
 * @author yuan
 * @date 2020/3/2
 * 未通过
 */
public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int lastNum = nums[0];

        int count = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (lastNum > nums[i]) {
                // 遇到递减的，看下一个
                // 比如3,4,2,3
                if (i - 2 >= 0 && lastNum > nums[i - 2] && lastNum < nums[i]) {
                    return false;
                } else {
                    ++count;
                }
            }
            lastNum = nums[i];
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        非递减数列 obj = new 非递减数列();

        System.out.println(obj.checkPossibility(new int[]{4, 2, 1})); // false
        System.out.println(obj.checkPossibility(new int[]{4, 2, 3}));// true
        System.out.println(obj.checkPossibility(new int[]{3,4,2,3}));// false
    }
}
