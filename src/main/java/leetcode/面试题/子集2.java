package leetcode.面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/4/5
 * @description
 */
public class 子集2 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums.length == 0) {
                return res;
            }
            res.add(new ArrayList<>());
            dfs(0,nums,res,new ArrayList<>());
            return res;
        }
        public void dfs(int curIdx,int[] nums,List<List<Integer>> res,List<Integer> l){
            for(int i = curIdx;i < nums.length;i++){
                l.add(nums[i]);
                res.add(new ArrayList<>(l));
                // 注意这里不是index+1，而是i+1
                dfs(i + 1,nums,res,l);
                l.remove(l.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.subsets(new int[]{0,1,4});
    }

}
