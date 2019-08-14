import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;

/**
 * @author yuanshijia
 * @date 2019-08-14
 * @description
 */
public class 三数之和_ {
    /**
     * 注意的是，只有数组不含有相同元素才能使用这种解法，否则二分查找的结果会出错
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 应该注意这里的下标必须大于 j，否则会重复统计。
                int index = binarySearch(nums, -nums[i] - nums[j]);
                if (index > 0 && index != i && index != j) {
                    result.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        三数之和_ obj = new 三数之和_();
        List<List<Integer>> lists = obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
