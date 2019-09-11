package 面试题.广联达;

/**
 * @author yuan
 * @date 2019/9/6
 * @description
 *
 * 【编程题】给定数组，任意相邻两个元素的差的绝对值为1，设计一个算法，在该数组中可以查找某个元素的位置，如果该元素的值多次出现，返回第一次的位置。例如{4, 5, 6, 5, 6, 7, 8, 9, 10, 9}元素9出现了两次，第一次出现的位置7。
 *
 */
public class Main4 {
    private static int findFirst(int[] nums, int target) {
        int index = 0;
        while (index < nums.length && nums[index] != target) {
            int delta = target - nums[index];
            index += Math.abs(delta);
        }

        if (index < nums.length) {
            return index;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findFirst(new int[]{4, 5, 6, 5, 6, 7, 8, 9, 10, 9}, 9));
    }
}
