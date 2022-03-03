package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

import java.util.Arrays;

/**
 * 108 有序数组转为二叉搜索树
 * @author: lirl
 * @date: 2021/3/8
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        TreeNode.print(new SortedArrayToBST().sortedArrayToBST(new int[]{-10,-3,0,5,9}),1);
        TreeNode.print(new SortedArrayToBST().sortedArrayToBST(new int[]{1,3}),1);
    }

    /**
     * 执行耗时:1 ms,击败了5.24% 的Java用户
     * 内存消耗:38.3 MB,击败了45.13% 的Java用户
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int middle = nums.length / 2;
        TreeNode leftNode = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
        TreeNode rightNode = middle == nums.length - 1 ? null : sortedArrayToBST(Arrays.copyOfRange(nums,middle + 1,nums.length));
        TreeNode currentNode = new TreeNode(nums[middle]);
        currentNode.left = leftNode;
        currentNode.right = rightNode;
        return currentNode;
    }
}
