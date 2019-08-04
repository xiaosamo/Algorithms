package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/3/12
 * @description
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int l =minDepth(root.left);
        int r =minDepth(root.right);
        if(l==0 ||r==0) {
            //在左子树和右子树中仅有一个存在的情况下，返回存在的值（即其中一颗树的minDepth为0）
            return l+r+1;
        }
        //在左子树和右子树都存在的情况下返回两者最小值
        return Math.min(l,r)+1;
    }




}
