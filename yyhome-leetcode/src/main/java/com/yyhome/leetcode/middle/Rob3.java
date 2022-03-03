package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337 打家劫舍Ⅲ
 * @author: lirl
 * @date: 2021/7/29
 */
public class Rob3 {

    public static void main(String[] args){
        /**
         *        2
         *      1   3
         *       4
         */
        System.out.println(new Rob3().rob(TreeNode.createTree(2,1,3,null,4)));
        /**
         *          5
         *        4
         *          2
         *        3   1
         */
        System.out.println(new Rob3().rob(TreeNode.createTree(5,4,null,null,2,3,1)));
        /**
         *        4
         *      1
         *    2
         *      3
         */
        System.out.println(new Rob3().rob(TreeNode.createTree(4,1,null,2,null,3)));
        System.out.println(new Rob3().rob(TreeNode.createTree(3,2,3,null,3,null,1)));
        System.out.println(new Rob3().rob(TreeNode.createTree(3,2,3,null,3,null,1,null,null,null,7)));
        System.out.println(new Rob3().rob(TreeNode.createTree(3,4,5,1,3,null,1)));
    }

    /**
     * sMap表示以当前节点为根，且选择了当前节点后该棵子树所能得到的最大值
     * usMap表示以当前节点为根，不选择当前节点后该棵子树所能得到的最大值
     */
    Map<TreeNode, Integer> sMap = new HashMap<>();
    Map<TreeNode, Integer> usMap = new HashMap<>();

    /**
     * 执行耗时:3 ms,击败了40.43% 的Java用户
     * 内存消耗:38.3 MB,击败了5.30% 的Java用户
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        // 选择了根节点和不选择根节点产生的值的最大值为结果
        return Math.max(sValue(root) - root.val, usValue(root));
    }

    public int dfs(TreeNode node, boolean select, int rootDp, int gpDp) {
        if (node != null) {
            int val = node.val;
            int selectValue = 0, unSelectValue;
            if (!select) {
                // 若上一个节点未选择，则可以选择该节点
                selectValue = gpDp - val + sValue(node);
            }
            // 无论上一个节点选没选，该节点都可以不选
            unSelectValue = rootDp + usValue(node);
            // 返回选了或不选当前节点的情况中的最大值
            return Math.max(selectValue, unSelectValue);
        } else {
            return rootDp;
        }
    }

    /**
     * 不选当前节点的最大值
     * @param node
     * @return
     */
    private int usValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (!usMap.containsKey(node)) {
            usMap.put(node, dfs(node.left, false, 0, 0) + dfs(node.right, false, 0, 0));
        }
        return usMap.get(node);
    }

    /**
     * 选择了当前节点的最大值
     * @param node
     * @return
     */
    private int sValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (!sMap.containsKey(node)) {
            sMap.put(node, dfs(node.left, true, node.val, 0) + dfs(node.right, true, node.val, 0));
        }
        return sMap.get(node);
    }
}
