package leetcode.面试题;//package leetcode.面试题;
//
///**
// * @author yuan
// * @date 2019/3/4
// * @description
// */
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//class Solution2 {
//    public List<List<Integer>> permute(int[] nums) {
//
//
//    }
//
//    private void dfs(int index, int[] nums, List<List<Integer>> result) {
//        if (index == nums.length) {
//            List<Integer> li = new ArrayList<>();
////            Arrays.stream(nums).forEach(i -> li.add(i));
//            Arrays.stream(nums).forEach(li::add);
//            result.add(li);
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            swap(nums, index, i);
//            dfs(index + 1, nums, result);
//            swap(nums, index, i);
//        }
//    }
//    private void swap(int []a,int i,int j){
//        int temp = a[i];
//        a[i]= a[j];
//        a[j] = temp;
//    }
//
//    public static void main(String[] args) {
//        Solution2 solution = new Solution2();
//        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
//        for (List<Integer> li : result) {
//            for (Integer i : li) {
//                System.out.print(i + " ");
//
//            }
//            System.out.println();
//        }
//    }
//}
