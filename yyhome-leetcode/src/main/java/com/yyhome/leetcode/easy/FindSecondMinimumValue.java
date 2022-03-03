package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 671 二叉树中第二小的节点
 * @author: lirl
 * @date: 2021/3/31
 */
public class FindSecondMinimumValue {

    public static void main(String[] args){
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.createTree(2,2,2147483647)));
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.createTree(1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1)));
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.createTree(2,2,5,null,null,5,7)));
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.createTree(2,2,2)));
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(TreeNode.createTree(1,1,2,1,1,2,2)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.8 MB,击败了32.21% 的Java用户
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null){
            return -1;
        }
        long min;
        if (root.left.val == root.right.val){
            min = Math.min(cycle(root.left), cycle(root.right));
        } else {
            min = Math.min(Math.max(root.left.val, root.right.val), cycle(root.left.val < root.right.val ? root.left : root.right));
        }
        return min == Long.MAX_VALUE ? -1 : (int)min;
    }

    public long cycle(TreeNode node){
        if (node.left == null){
            return Long.MAX_VALUE;
        }
        if (node.left.val == node.right.val){
            return Math.min(cycle(node.left), cycle(node.right));
        } else {
            return Math.min(Math.max(node.left.val, node.right.val), cycle(node.left.val < node.right.val ? node.left : node.right));
        }
    }
}
