package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历 145
 * @Author: lrl
 * @Date: 2024/2/2 16:16:08
 */
public class PostorderTraversal145 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new PostorderTraversal145().postorderTraversal(TreeNode.createTree())));
        // 4 5 2 6 7 3 1
        System.out.println(JSON.toJSONString(new PostorderTraversal145().postorderTraversal(TreeNode.createTree(1, 2, 3, 4, 5, 6, 7))));
        System.out.println(JSON.toJSONString(new PostorderTraversal145().postorderTraversal(TreeNode.createTree(1, null, 2, 3))));
        System.out.println(JSON.toJSONString(new PostorderTraversal145().postorderTraversal(TreeNode.createTree(1))));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.6 MB,击败了22.55% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> revertResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            revertResult.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = revertResult.size() - 1; i >= 0; i--) {
            result.add(revertResult.get(i));
        }
        return result;
    }
}
