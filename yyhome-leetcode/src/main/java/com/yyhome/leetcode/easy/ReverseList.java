package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 206反转链表
 * @author miluo
 * @date 2020-03-02
 */
public class ReverseList {

    public static void main(String[] args){
        ListNode.print(reverseList(ListNode.createLink(1,2,3,4,5)));
        ListNode.print(reverseList(ListNode.createLink(5,4,3,2,1)));
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        head = head.next;
        for (;head != null;){
            ListNode currentNode = new ListNode(head.val);
            currentNode.next = newHead;
            newHead = currentNode;
            if (head.next != null) {
                head = head.next;
            }else{
                break;
            }
        }
        return newHead;
    }
}
