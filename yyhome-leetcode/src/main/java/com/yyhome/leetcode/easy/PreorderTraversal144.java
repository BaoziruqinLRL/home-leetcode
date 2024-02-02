package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.*;

/**
 * 144二叉树前序遍历
 * @Author: lrl
 * @Date: 2024/2/2 14:46:24
 */
public class PreorderTraversal144 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new PreorderTraversal144().preorderTraversal(TreeNode.createTree())));
        System.out.println(JSON.toJSONString(new PreorderTraversal144().preorderTraversal(TreeNode.createTree(1, 2, 3, 4, 5, 6, 7))));
        System.out.println(JSON.toJSONString(new PreorderTraversal144().preorderTraversal(TreeNode.createTree(1, null, 2, 3))));
        System.out.println(JSON.toJSONString(new PreorderTraversal144().preorderTraversal(TreeNode.createTree(1))));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了7.89% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            result.add(pop.val);
        }
        return result;
    }
}
