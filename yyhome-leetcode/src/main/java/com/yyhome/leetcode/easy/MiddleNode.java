package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 876 链表中间节点
 * @author miluo
 * @date 2020-03-23
 */
public class MiddleNode {

    public static void main(String[] args){
        ListNode.print(middleNode(ListNode.createLink(1,2,3,4,5)));
        ListNode.print(middleNode(ListNode.createLink(1,2,3,4,5,6)));
        ListNode.print(middleNodeQS(ListNode.createLink(1,2,3,4,5)));
        ListNode.print(middleNodeQS(ListNode.createLink(1,2,3,4,5,6)));
    }

    private static ListNode middleNode(ListNode head){
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null){
            nodeList.add(head);
            head = head.next;
        }
        return nodeList.get(nodeList.size() / 2);
    }

    /**
     * 快慢指针，慢针走一步，快针走两步
     * @param head
     * @return
     */
    private static ListNode middleNodeQS(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
