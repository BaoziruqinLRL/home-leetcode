package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653 两数之和 Ⅳ - 输入BST
 * @author: lirl
 * @date: 2021/3/31
 */
public class FindTarget {

    public static void main(String[] args) {
        System.out.println(new FindTarget().findTarget(TreeNode.createTree(5,3,6,2,4,null,7), 9));
        System.out.println(new FindTarget().findTarget(TreeNode.createTree(5,3,6,2,4,null,7), 28));
    }

    /**
     * 执行耗时:4 ms,击败了55.14% 的Java用户
     * 内存消耗:39.4 MB,击败了80.37% 的Java用户
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return cycle(root, set, k);
    }

    public boolean cycle(TreeNode node, Set<Integer> set, int k){
        if (node == null){
            return false;
        }
        if (set.contains(k - node.val)){
            return true;
        }
        set.add(node.val);
        return cycle(node.left, set, k) || cycle(node.right, set, k);
    }
}
