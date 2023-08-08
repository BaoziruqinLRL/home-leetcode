package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 求根节点到叶节点数字之和 129
 * @Author: lrl
 * @Date: 2023/8/8 16:15:43
 */
public class SumNumbers129 {

    public static void main(String[] args) {
        System.out.println(new SumNumbers129().sumNumbers(TreeNode.createTree(1,2,3)));
        System.out.println(new SumNumbers129().sumNumbers(TreeNode.createTree(4,9,0,5,1)));
    }

    int result;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了45.32% 的Java用户
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        result = 0;
        sum(root, 0);
        return result;
    }

    public void sum(TreeNode root, int cur) {
        if (root.left == null && root.right == null) {
            result += (cur * 10 + root.val);
        }
        if (root.left != null) {
            sum(root.left, cur * 10 + root.val);
        }
        if (root.right != null) {
            sum(root.right, cur * 10 + root.val);
        }
    }
}
