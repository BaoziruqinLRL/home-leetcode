package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 237 删除链表中的节点
 * @author: lirl
 * @date: 2021/3/11
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode link = ListNode.createLink(4,5,1,9);
        new DeleteNode().deleteNode(link.next);
        ListNode.print(link);
        link = ListNode.createLink(4,5,1,9);
        new DeleteNode().deleteNode(link.next.next);
        ListNode.print(link);
    }

    /**
     * 0ms
     * 37.9MB
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
