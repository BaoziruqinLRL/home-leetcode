package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 530 二叉搜索树的最小绝对差
 * @author: lirl
 * @date: 2021/3/29
 */
public class GetMinimumDifference {

    public static void main(String[] args){
        System.out.println(new GetMinimumDifference().getMinimumDifference(TreeNode.createTree(1, null, 3, 2, null)));
        System.out.println(new GetMinimumDifference().getMinimumDifference(TreeNode.createTree(236,104,701,null,227,null,911)));
        System.out.println(new GetMinimumDifference().getMinimumDifference(TreeNode.createTree(2,null,4443,1329,null,null,2917,null,4406)));
    }

    Integer min = Integer.MAX_VALUE;
    Integer last = Integer.MAX_VALUE;

    /**
     * 执行耗时:1 ms,击败了71.44% 的Java用户
     * 内存消耗:38.1 MB,击败了67.45% 的Java用户
     * 中序遍历二叉树是单调递增的
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        cycle(root);
        return min;
    }

    /**
     * 二叉搜索树中序遍历是递增序列，此时只需要判断相邻两节点的差值即可
     * @param node
     */
    public void cycle(TreeNode node){
        if (node == null){
            return;
        }
        cycle(node.left);
        min = Math.min(Math.abs(node.val - last), min);
        last = node.val;
        cycle(node.right);
    }
}
