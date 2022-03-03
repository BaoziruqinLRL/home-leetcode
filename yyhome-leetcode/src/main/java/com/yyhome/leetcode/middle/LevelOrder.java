package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102 二叉树的层序遍历
 * @author: lirl
 * @date: 2021/5/11
 */
public class LevelOrder {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new LevelOrder().levelOrder(TreeNode.createTree(3,9,20,null,null,15,7))));
    }

    /**
     * 执行耗时:6 ms,击败了10.31% 的Java用户
     * 内存消耗:38.8 MB,击败了25.24% 的Java用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode poll = queue.poll();
                li.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(li);
        }
        return res;
    }
}
