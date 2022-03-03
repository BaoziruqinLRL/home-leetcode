package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 563 二叉树的坡度
 * @author: lirl
 * @date: 2021/3/29
 */
public class FindTilt {

    public static void main(String[] args){
        System.out.println(new FindTilt().findTilt(TreeNode.createTree(1,2,3)));
        System.out.println(new FindTilt().findTilt(TreeNode.createTree(4,2,9,3,5,null,7)));
        System.out.println(new FindTilt().findTilt(TreeNode.createTree(21,7,14,1,1,2,2,3,3)));
    }

    private int res = 0;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了99.51% 的Java用户
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        if (root != null){
            cycle(root);
        }
        return res;
    }

    public int cycle(TreeNode root){
        if (root.left == null && root.right == null){
            return root.val;
        }
        int leftNum = root.left == null ? 0 : cycle(root.left);
        int rightNum = root.right == null ? 0 : cycle(root.right);
        res += Math.abs(leftNum - rightNum);
        return root.val + leftNum + rightNum;
    }
}
