package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 673 二叉树的层平均值
 * @author: lirl
 * @date: 2021/3/31
 */
public class AverageOfLevels {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new AverageOfLevels().averageOfLevels(TreeNode.createTree(3,9,20,null,null,15,7))));
    }

    List<Double> res = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();

    /**
     * 执行耗时:2 ms,击败了99.08% 的Java用户
     * 内存消耗:40.4 MB,击败了53.41% 的Java用户
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        res.add((double) root.val);
        nums.add(1);
        cycle(root, 0);
        for (int i = 0; i < res.size(); i++){
            res.set(i, res.get(i) / nums.get(i));
        }
        return res;
    }

    public void cycle(TreeNode node, int level){
        if (node == null){
            return;
        }
        if (res.size() < level + 1){
            res.add((double) node.val);
            nums.add(1);
        } else {
            res.set(level, res.get(level) + (double) node.val);
            nums.set(level, nums.get(level) + 1);
        }
        cycle(node.left, level + 1);
        cycle(node.right, level + 1);
    }
}
