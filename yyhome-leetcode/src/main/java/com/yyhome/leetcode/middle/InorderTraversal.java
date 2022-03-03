package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.*;

/**
 * 94 二叉树的中序遍历
 * @author: lirl
 * @date: 2021/5/8
 */
public class InorderTraversal {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(TreeNode.createTree(1,null,2,3))));
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(TreeNode.createTree())));
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(TreeNode.createTree(1))));
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(TreeNode.createTree(1,2))));
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(TreeNode.createTree(1,null,2))));
    }

    /**
     * 执行耗时:2 ms,击败了43.36% 的Java用户
     * 内存消耗:36.5 MB,击败了90.48% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (!set.contains(node)) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
                set.add(node);
            } else {
                res.add(node.val);
            }
        }
        return res;
    }
}
