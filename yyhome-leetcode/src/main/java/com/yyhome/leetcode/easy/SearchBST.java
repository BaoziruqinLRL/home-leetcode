package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 700 二叉搜索树中的搜索
 * @author: lirl
 * @date: 2021/4/7
 */
public class SearchBST {

    public static void main(String[] args){
        TreeNode.print((new SearchBST().searchBST(TreeNode.createTree(4,2,7,1,3), 2)),2);
        TreeNode.print((new SearchBST().searchBST(TreeNode.createTree(4,2,7,1,3), 5)),2);
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了21.06% 的Java用户
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        TreeNode leftRes = searchBST(root.left, val);
        if (leftRes != null && leftRes.val == val){
            return leftRes;
        }
        TreeNode rightRes = searchBST(root.right, val);
        if (rightRes != null && rightRes.val == val){
            return rightRes;
        }
        return null;
    }
}
