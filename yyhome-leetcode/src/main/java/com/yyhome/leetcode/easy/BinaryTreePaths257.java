package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径 257
 * @Author: lrl
 * @Date: 2024/2/4 10:34:19
 */
public class BinaryTreePaths257 {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new BinaryTreePaths257().binaryTreePaths(TreeNode.createTree(1, 2, 3, null, 5))));
        System.out.println(JSON.toJSONString(new BinaryTreePaths257().binaryTreePaths(TreeNode.createTree(1))));
    }

    /**
     * 执行耗时:7 ms,击败了35.98% 的Java用户
     * 内存消耗:41.6 MB,击败了20.11% 的Java用户
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        bfs(result, "", root);
        return result;
    }

    private void bfs(List<String> result, String path, TreeNode node) {
        if (node != null) {
            path += "->" + node.val;
            if (node.left != null || node.right != null) {
                bfs(result, path, node.left);
                bfs(result, path, node.right);
            } else {
                result.add(path.substring(2));
            }
        }
    }
}
