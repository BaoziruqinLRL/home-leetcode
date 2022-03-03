package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 617 合并二叉树
 * @author: lirl
 * @date: 2021/3/30
 */
public class MergeTrees {

    public static void main(String[] args){
        TreeNode.print(new MergeTrees().mergeTrees(TreeNode.createTree(1,3,2,5), TreeNode.createTree(2,1,3,null,4,null,7)),2);

        TreeNode.print(new MergeTrees().mergeTrees2(TreeNode.createTree(1,3,2,5), TreeNode.createTree(2,1,3,null,4,null,7)),2);
    }

    /**
     * 执行耗时:1 ms,击败了41.47% 的Java用户
     * 内存消耗:38.7 MB,击败了69.23% 的Java用户
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        TreeNode root = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
        cycle(root1 == null ? null : root1.left, root2 == null ? null : root2.left, root, true);
        cycle(root1 == null ? null : root1.right, root2 == null ? null : root2.right, root, false);
        return root;
    }

    public void cycle(TreeNode r1, TreeNode r2, TreeNode node, boolean left){
        if (r1 == null && r2 == null){
            return;
        }
        TreeNode n = new TreeNode((r1 == null ? 0 : r1.val) + (r2 == null ? 0 : r2.val));
        if (left){
            node.left = n;
        } else {
            node.right = n;
        }
        cycle(r1 == null ? null : r1.left, r2 == null ? null : r2.left, n, true);
        cycle(r1 == null ? null : r1.right, r2 == null ? null : r2.right, n, false);
    }

    /**
     * 执行耗时:1 ms,击败了41.47% 的Java用户
     *内存消耗:38.9 MB,击败了33.15% 的Java用户
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode n = new TreeNode(root1.val + root2.val);
        n.left = mergeTrees2(root1.left, root2.left);
        n.right = mergeTrees2(root1.right, root2.right);
        return n;
    }
}
