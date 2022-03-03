package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 1145 二叉树着色游戏
 * @author: lirl
 * @date: 2021/7/6
 */
public class BtreeGameWinningMove {

    public static void main(String[] args){
        System.out.println(new BtreeGameWinningMove().btreeGameWinningMove(TreeNode.createTree(1,2,3,4,5,6,7,8,9,10,11), 11, 3));
    }

    int xLeft = 0, xRight = 0;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.1 MB,击败了73.21% 的Java用户
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int half = n/2+1;
        return xLeft >= half || xRight >= half || (n - xLeft - xRight - 1) >= half;
    }

    public int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, x);
        int right = dfs(root.right, x);
        if (root.val == x) {
            xLeft = left;
            xRight = right;
        }
        return left + right + 1;
    }
}
