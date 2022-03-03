package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 111 二叉树的最小深度
 * @author: lirl
 * @date: 2021/3/9
 */
public class MinDepth {

    public static void main(String[] args) {
        System.out.println(new MinDepth().minDepth(TreeNode.createTree(3,9,20,null,null,15,7)));
        System.out.println(new MinDepth().minDepth(TreeNode.createTree(2,null,3,null,4,null,5,null,6)));
    }

    /**
     * 执行耗时:7 ms,击败了68.99% 的Java用户
     * 内存消耗:59.1 MB,击败了50.62% 的Java用户
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.min(nodeDepth(root.left,2), nodeDepth(root.right,2));
    }

    public int nodeDepth(TreeNode node, int depth){
        if (depth == 2 && node == null){
            return Integer.MAX_VALUE;
        }
        if (node == null){
            return depth - 1;
        }
        if ((node.left == null && node.right == null) || (node.left != null && node.right != null)) {
            int leftDepth = nodeDepth(node.left, depth + 1);
            int rightDepth = nodeDepth(node.right, depth + 1);
            return Math.min(leftDepth, rightDepth);
        }else{
            int minDepth;
            if (node.left == null){
                minDepth = nodeDepth(node.right, depth + 1);
            }else{
                minDepth = nodeDepth(node.left, depth + 1);
            }
            return minDepth;
        }
    }
}
