package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 572 另一个树的子树
 * @author: lirl
 * @date: 2021/3/29
 */
public class IsSubtree {

    public static void main(String[] args){
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(3,4,5,1,2), TreeNode.createTree(4,1,null,null,2)));
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(1,1), TreeNode.createTree(1)));
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(1), TreeNode.createTree(1)));
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(3,4,5,1,2), TreeNode.createTree(4,1,2)));
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(3,4,5,1,2,null,null,null,null,0), TreeNode.createTree(4,1,2)));
        System.out.println(new IsSubtree().isSubtree(TreeNode.createTree(3,4,5,1,2,null,null,0), TreeNode.createTree(4,1,2)));
    }

    boolean eq = false;

    /**
     * 执行耗时:20 ms,击败了5.43% 的Java用户
     * 内存消耗:39.7 MB,击败了5.02% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tv = tTreeValue(t);
        sTreeValue(s, t.val, tv);
        return eq;
    }

    public String tTreeValue(TreeNode node){
        if (node == null){
            return "";
        }
        if (node.left == null && node.right == null){
            return "" + node.val;
        }
        return "" + tTreeValue(node.left) + node.val + tTreeValue(node.right);
    }

    public String sTreeValue(TreeNode node, int vRootVal, String tv){
        if (eq || node == null){
            return "";
        }
        String res = "" + sTreeValue(node.left, vRootVal, tv) + node.val +  sTreeValue(node.right, vRootVal, tv);
        if (node.val == vRootVal && !eq){
            eq = res.equals(tv);
        }
        return res;
    }
}
