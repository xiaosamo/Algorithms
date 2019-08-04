package 剑指Offer;

/**
 * @author yuan
 * @date 2019/7/13
 * @description
 */


public class 二叉树的下一个结点 {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

//    public TreeLinkNode GetNext(TreeLinkNode pNode) {
//        if (pNode.right != null) {
//            TreeLinkNode p = pNode.right;
//            while (p.left != null) {
//                p = p.left;
//            }
//            return p;
//        } else {
//            while (pNode.next != null) {
//                TreeLinkNode p = p.next;
//                if (p) {
//                }
//            }
//
//        }
//
//    }
}