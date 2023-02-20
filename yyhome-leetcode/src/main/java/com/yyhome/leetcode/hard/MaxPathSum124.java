package com.yyhome.leetcode.hard;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 124 二叉树中的最大路径和
 * @Author: linabell
 * @Date: 2023/2/8 17:01:32
 */
public class MaxPathSum124 {

    public static void main(String[] args) {
        /**
         *            1
         *       -2     -3
         *      1  3  -2
         *    -1
         */
        System.out.println(new MaxPathSum124().maxPathSum(TreeNode.createTree(1,-2,-3,1,3,-2,null,-1)));
        System.out.println(new MaxPathSum124().maxPathSum(TreeNode.createTree(-3)));
        System.out.println(new MaxPathSum124().maxPathSum(TreeNode.createTree(1, 2, 3)));
        System.out.println(new MaxPathSum124().maxPathSum(TreeNode.createTree(-10,9,20,null,null,15,7)));
    }

    private int max = Integer.MIN_VALUE;

    /**
     * 执行耗时:1 ms,击败了24.47% 的Java用户
     * 内存消耗:43.3 MB,击败了20.70% 的Java用户
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        search(root);
        return max;
    }

    public int search(TreeNode root) {
        max = Math.max(max, root.val);
        int leftPlus= root.val, rightPlus = root.val;
        if (root.left != null) {
            int left = search(root.left);
            max = Math.max(max, left);
            leftPlus += left;
        }
        if (root.right != null) {
            int right = search(root.right);
            max = Math.max(max, right);
            rightPlus += right;
        }
        max = Math.max(max, Math.max(leftPlus, Math.max(rightPlus, leftPlus + rightPlus - root.val)));
        return Math.max(root.val, Math.max(leftPlus, rightPlus));
    }

}
