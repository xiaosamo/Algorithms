package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuanshijia
 * @date 2019-08-05
 * @description
 */
public class 路径总和2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.left == null && root.right == null && root.val == sum) {
                cur.add(root.val);
                // 如果是叶子节点
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return result;
            }

            if (root.left != null) {
                cur.add(root.val);
                pathSum(root.left, sum - root.val);
                cur.remove(cur.size() - 1);
            }

            if (root.right != null) {
                cur.add(root.val);
                pathSum(root.right, sum - root.val);
                cur.remove(cur.size() - 1);
            }
        }
        return result;
    }
}
