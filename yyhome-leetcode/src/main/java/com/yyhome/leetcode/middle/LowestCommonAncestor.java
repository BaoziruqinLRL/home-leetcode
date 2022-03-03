package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 面试题 04.08 首个共同祖先
 * 236
 * @author: lirl
 * @date: 2021/4/14
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode.print(new LowestCommonAncestor().lowestCommonAncestor(TreeNode.createTree(3,5,1,6,2,0,8,null,null,7,4), TreeNode.createTree(5), TreeNode.createTree(1)));
        TreeNode.print(new LowestCommonAncestor().lowestCommonAncestor(TreeNode.createTree(3,5,1,6,2,0,8,null,null,7,4), TreeNode.createTree(5), TreeNode.createTree(4)));
    }

    /**
     * 执行耗时:7 ms,击败了99.89% 的Java用户
     * 内存消耗:40.3 MB,击败了88.52% 的Java用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
