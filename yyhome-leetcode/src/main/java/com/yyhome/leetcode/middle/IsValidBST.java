package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 04.05 合法二叉搜索树
 * @author: lirl
 * @date: 2021/4/14
 */
public class IsValidBST {

    public static void main(String[] args) {
        System.out.println(new IsValidBST().isValidBST(TreeNode.createTree(1,1)));
        System.out.println(new IsValidBST().isValidBST(TreeNode.createTree(10,5,15,null,null,6,20)));
        System.out.println(new IsValidBST().isValidBST(TreeNode.createTree(2,1,3)));
        System.out.println(new IsValidBST().isValidBST(TreeNode.createTree(5,1,4,null,null,3,6)));

        System.out.println(new IsValidBST().isValidBST2(TreeNode.createTree(1,1)));
        System.out.println(new IsValidBST().isValidBST2(TreeNode.createTree(10,5,15,null,null,6,20)));
        System.out.println(new IsValidBST().isValidBST2(TreeNode.createTree(2,1,3)));
        System.out.println(new IsValidBST().isValidBST2(TreeNode.createTree(5,1,4,null,null,3,6)));
    }

    private List<Integer> sorted = new ArrayList<>();

    /**
     * 执行耗时:3 ms,击败了7.40% 的Java用户
     * 内存消耗:38.4 MB,击败了13.79% 的Java用户
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        middleSort(root);
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i) <= sorted.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public void middleSort(TreeNode node) {
        if (node != null) {
            middleSort(node.left);
            sorted.add(node.val);
            middleSort(node.right);
        }
    }

    private long last = Long.MIN_VALUE;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了25.08% 的Java用户
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (last >= root.val) {
            return false;
        }
        last = root.val;
        boolean right = isValidBST2(root.right);
        return left && right;
    }
}
