package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;
import lombok.var;

/**
 * 验证二叉搜索树 98
 * @author miluo
 * @date 2019-10-31
 */
public class ValidBST {

    public static void main(String[] args){
        var root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        System.out.println(isValidBST(root1));
        var root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(null));
        // [3,null,30,10,null,null,15,null,45]
        var root3 = new TreeNode(3);
        root3.right = new TreeNode(30);
        root3.right.left = new TreeNode(10);
        root3.right.left.right = new TreeNode(15);
        root3.right.left.right.right = new TreeNode(45);
        System.out.println(isValidBST(root3));
    }


    private static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return isValid(root,null,null);
    }

    private static boolean isValid(TreeNode root, Integer downLimit, Integer upLimit){
        if (root != null) {
            int currentVal = root.val;
            if ((downLimit != null && currentVal <= downLimit) ||
                    (upLimit != null && currentVal >= upLimit)){
                return false;
            }
            return isValid(root.left,downLimit,currentVal) && isValid(root.right,currentVal,upLimit);
        }
        return true;
    }

}
