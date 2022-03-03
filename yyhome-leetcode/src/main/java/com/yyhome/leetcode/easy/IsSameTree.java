package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 100 相同的树
 * @author miluo
 * @date 2020-07-15
 */
public class IsSameTree {

    public static void main(String[] args) {
        System.out.println(new IsSameTree().isSameTree(TreeNode.createTree(1,2,3,4,5,6,7),TreeNode.createTree(1,2,3)));
        System.out.println(new IsSameTree().isSameTree(TreeNode.createTree(1,2,3,4,5,6,7),TreeNode.createTree(1,2,3,4,5,6,7)));
        System.out.println(new IsSameTree().isSameTree(TreeNode.createTree(1,2,3,8,7,9),TreeNode.createTree(1,2,3)));
        System.out.println(new IsSameTree().isSameTree(TreeNode.createTree(1,null,2,4,null,null,3),TreeNode.createTree(1,null,4,2,null,null,3)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.9 MB,击败了5.55% 的Java用户
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null){
            return q == null;
        }else if (q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }
        // 终止递归条件，任一方为根节点，或者当前节点值不同
        boolean pRoot = (p.left == null && p.right == null);
        boolean qRoot = (q.left == null && q.right == null);
        if (pRoot && qRoot){
            return true;
        }else if (pRoot || qRoot){
            return false;
        }else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

}
