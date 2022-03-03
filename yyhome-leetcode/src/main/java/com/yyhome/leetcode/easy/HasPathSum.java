package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 112 路径总和
 * @author: lirl
 * @date: 2021/3/9
 */
public class HasPathSum {

    public static void main(String[] args) {
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1,2,null,3,null,4,null,5),6));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(5,4,8,11,null,13,4,7,2,null,null,null,1),22));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1,2,3),5));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1,2),0));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1,2),1));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1,2),3));
        System.out.println(new HasPathSum().hasPathSum(TreeNode.createTree(1),1));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了66.50% 的Java用户
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return totalNum(root, targetSum, 0);
    }

    public boolean totalNum(TreeNode node, int targetSum, int currentNum){
        if (node == null){
            return false;
        }
        if (node.left == null && node.right == null){
            return targetSum == (currentNum + node.val);
        }
        boolean leftNum = totalNum(node.left, targetSum, currentNum + node.val);
        boolean rightNum = totalNum(node.right, targetSum, currentNum + node.val);
        return leftNum || rightNum;
    }
}
