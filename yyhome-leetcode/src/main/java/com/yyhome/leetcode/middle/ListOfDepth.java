package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;
import com.yyhome.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题 04.03 特定深度节点链表
 * @author: lirl
 * @date: 2021/4/13
 */
public class ListOfDepth {

    public static void main(String[] args) {
        ListNode[] res = new ListOfDepth().listOfDepth(TreeNode.createTree(1,2,3,4,5,null,7,8));
        for (ListNode n : res) {
            ListNode.print(n);
        }
    }

    /**
     * 执行耗时:1 ms,击败了96.52% 的Java用户
     * 内存消耗:37 MB,击败了22.45% 的Java用户
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()){
            List<TreeNode> li = new ArrayList<>();
            while (!stack.isEmpty()){
                li.add(stack.pop());
            }
            if (!li.isEmpty()) {
                ListNode head = new ListNode(li.get(li.size() - 1).val);
                if (li.get(li.size() - 1).left != null) {
                    stack.push(li.get(li.size() - 1).left);
                }
                if (li.get(li.size() - 1).right != null) {
                    stack.push(li.get(li.size() - 1).right);
                }
                res.add(head);
                ListNode cur = head;
                // 创建链表
                for (int i = li.size() - 2; i >= 0; i--) {
                    if (li.get(i).left != null) {
                        stack.push(li.get(i).left);
                    }
                    if (li.get(i).right != null) {
                        stack.push(li.get(i).right);
                    }
                    cur.next = new ListNode(li.get(i).val);
                    cur = cur.next;
                }
            }
        }

        return res.toArray(new ListNode[res.size()]);
    }
}
