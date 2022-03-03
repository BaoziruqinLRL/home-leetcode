package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 101 对称二叉树
 */
public class IsSymmetric {

    public static void main(String[] args){
        System.out.println(new IsSymmetric().isSymmetric(TreeNode.createTree(1,2,2,3,4,4,3)));
        System.out.println(new IsSymmetric().isSymmetric(TreeNode.createTree(1,2,2,null,3,null,3)));
        System.out.println(new IsSymmetric().isSymmetric(TreeNode.createTree(2,3,3,4,5,5,4,null,null,8,9,null,null,9,8)));
        System.out.println(new IsSymmetric().isSymmetric(TreeNode.createTree(6,82,82,null,53,53,null,-58,null,null,-58,null,-85,-85,null,-9,null,null,-9,null,48,48,null,33,null,null,33,81,null,null,81,5,null,null,5,61,null,null,61,null,9,9,null,91,null,null,91,72,7,7,72,89,null,94,null,null,94,null,89,-27,null,-30,36,36,-30,null,-27,50,36,null,-80,34,null,null,34,-80,null,36,50,18,null,null,91,77,null,null,95,95,null,null,77,91,null,null,18,-19,65,null,94,null,-53,null,-29,-29,null,-53,null,94,null,65,-19,-62,-15,-35,null,null,-19,43,null,-21,null,null,-21,null,43,-19,null,null,-35,-15,-62,86,null,null,-70,null,19,null,55,-79,null,null,-96,-96,null,null,-79,55,null,19,null,-70,null,null,86,49,null,25,null,-19,null,null,8,30,null,82,-47,-47,82,null,30,8,null,null,-19,null,25,null,49)));
    }

    public boolean isSymmetric(TreeNode root) {
        return to(root,root);
    }

    private boolean to(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }else{
            return to(left.left,right.right) && to(left.right,right.left);
        }
    }
}
