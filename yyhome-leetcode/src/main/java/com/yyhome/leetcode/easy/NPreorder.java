package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 589 N叉树的前序遍历
 * @author: lirl
 * @date: 2021/4/6
 */
public class NPreorder {

    public static void main(String[] args){
        System.out.println(new NPreorder().preorder(Node.createTree(1,null,3,2,4,null,5,6)));
        System.out.println(new NPreorder().preorder(Node.createTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12, null,13,null,null,14)));
    }

    /**
     * 执行耗时:4 ms,击败了26.96% 的Java用户
     * 内存消耗:39.2 MB,击败了64.55% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node n = stack.pop();
            if (n.children != null){
                for (int i = n.children.size() - 1; i >= 0; i--){
                    stack.push(n.children.get(i));
                }
            }
            res.add(n.val);
        }
        return res;
    }
}
