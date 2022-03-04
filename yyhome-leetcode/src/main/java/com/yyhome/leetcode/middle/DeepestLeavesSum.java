package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1302 层数最深叶子节点的和
 * @Author: linabell
 * @Date: 2022/3/3 18:08
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(TreeNode.createTree(1,2,3,4,5,null,6,7,null,null,null,null,8)));
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(TreeNode.createTree(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)));
        System.out.println(new DeepestLeavesSum().deepestLeavesSum2(TreeNode.createTree(1,2,3,4,5,null,6,7,null,null,null,null,8)));
        System.out.println(new DeepestLeavesSum().deepestLeavesSum2(TreeNode.createTree(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)));
    }

    /**
     * 执行耗时:16 ms,击败了6.34% 的Java用户
     * 内存消耗:43.8 MB,击败了14.43% 的Java用户
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        int lastLevel = 1;
        int nextLevel = 0;
        int total = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            total += poll.val;
            lastLevel--;
            if (poll.left != null) {
                queue.offer(poll.left);
                nextLevel++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nextLevel++;
            }
            if (lastLevel == 0) {
                if (nextLevel == 0) {
                    return total;
                }
                total = 0;
                lastLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return total;
    }

    int deepLevel = 1;
    int total = 0;

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:44.2 MB,击败了5.01% 的Java用户
     * @param root
     * @return
     */
    public int deepestLeavesSum2(TreeNode root) {
        deep(root, 1);
        return total;
    }

    private void deep(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null){
            if (level > deepLevel) {
                deepLevel = level;
                total = node.val;
            } else if (level == deepLevel) {
                total += node.val;
            }
        }
        deep(node.left, level + 1);
        deep(node.right, level + 1);
    }
}
