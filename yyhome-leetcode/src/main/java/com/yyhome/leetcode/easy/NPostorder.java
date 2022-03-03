package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 590 N叉树的后序遍历
 * @author: lirl
 * @date: 2021/4/6
 */
public class NPostorder {

    public static void main(String[] args){
        System.out.println(new NPostorder().postorder(Node.createTree(1,null,3,2,4,null,5,6)));
        System.out.println(new NPostorder().postorder(Node.createTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12, null,13,null,null,14)));
    }

    /**
     * 执行耗时:4 ms,击败了40.16% 的Java用户
     * 内存消耗:39.4 MB,击败了45.46% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null){
            return Collections.emptyList();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            Node n = stack.pop();
            res.add(n.val);
            if (n.children != null){
                for (Node c : n.children){
                    stack.push(c);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}
