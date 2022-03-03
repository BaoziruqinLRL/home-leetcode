package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 103 二叉树的锯齿形层序遍历
 * @author: lirl
 * @date: 2021/5/12
 */
public class ZigzagLevelOrder {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new ZigzagLevelOrder().zigzagLevelOrder(TreeNode.createTree(3,9,20,null,null,15,7))));
    }

    /**
     * 执行耗时:6 ms,击败了17.74% 的Java用户
     * 内存消耗:39.1 MB,击败了5.08% 的Java用户
     * 双向队列不太行呀
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        BlockingDeque<TreeNode> deque = new LinkedBlockingDeque<>();
        deque.addFirst(root);
        boolean left = true;
        while (!deque.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int length = deque.size();
            while (length-- > 0) {
                if (left) {
                    TreeNode node = deque.pollFirst();
                    li.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    li.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }
            left = !left;
            res.add(li);
        }
        return res;
    }
}
