package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 606 根据二叉树创建字符串
 * @author: lirl
 * @date: 2021/3/30
 */
public class Tree2str {

    public static void main(String[] args){
        System.out.println(new Tree2str().tree2str(TreeNode.createTree(1,2,3,4)));
        System.out.println(new Tree2str().tree2str(TreeNode.createTree(1,2,3,null,4)));
    }

    StringBuilder sb = new StringBuilder();

    /**
     * 执行耗时:2 ms,击败了94.74% 的Java用户
     * 内存消耗:38.5 MB,击败了75.17% 的Java用户
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        cycle(t);
        return sb.toString();
    }

    public void cycle(TreeNode t){
        if (t == null){
            return;
        }
        sb.append(t.val);
        if (t.left != null){
            sb.append("(");
            cycle(t.left);
            sb.append(")");
        }
        if (t.right != null) {
            if (t.left == null){
                sb.append("()");
            }
            sb.append("(");
            cycle(t.right);
            sb.append(")");
        }
    }
}
