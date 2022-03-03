package com.yyhome.leetcode.data;

import lombok.var;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author miluo
 * @date 2020-07-15
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) { val = x; }

    public static TreeNode createTree(Integer... values){
        if (values == null || values.length == 0){
            return new TreeNode(0);
        }
        int index = 1;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (index < values.length){
            var currentNode = queue.poll();
            if (currentNode != null) {
                if (values[index] != null) {
                    currentNode.left = new TreeNode(values[index++]);
                    queue.offer(currentNode.left);
                }else{
                    index++;
                }
                if (index < values.length) {
                    if (values[index] != null) {
                        currentNode.right = new TreeNode(values[index++]);
                        queue.offer(currentNode.right);
                    }else{
                        index++;
                    }
                }
            }
        }
        return root;
    }

    public static void print(TreeNode root){
        System.out.println(root == null ? "null" : root.val);
    }

    public static void print(TreeNode root, int printType){
        switch (printType){
            case 1:
                // 深度优先遍历
                depthPrint(root);
                break;
            case 2:
                // 广度优先遍历
                maxPrint(root);
                break;
            default:
                break;
        }
        System.out.println("");
    }

    private static void depthPrint(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val + " -> ");
        depthPrint(node.left);
        depthPrint(node.right);
    }

    private static void maxPrint(TreeNode node){
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " -> ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }
}
