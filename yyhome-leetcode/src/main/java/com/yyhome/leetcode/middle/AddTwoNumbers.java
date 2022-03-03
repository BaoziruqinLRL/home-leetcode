package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 2 两数相加
 * @author miluo
 * @date 2020-03-17
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        // 342 + 465 = 807
        ListNode.print(addTwoNumbers(ListNode.createLink(3,4,2),ListNode.createLink(4,6,5)));
        // 3416
        ListNode.print(addTwoNumbers(ListNode.createLink(1,0,9,5),ListNode.createLink(2,3,2,1)));
        // 10
        ListNode.print(addTwoNumbers(ListNode.createLink(5),ListNode.createLink(5)));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        int carry = 0;
        ListNode headNode = null;
        ListNode currentNode = null;
        while (l1 != null || l2 != null){
            ListNode node = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry);
            if (node.val > 9){
                carry = 1;
                node.val -= 10;
            }else{
                carry = 0;
            }
            headNode = headNode == null ? node : headNode;
            if (currentNode == null){
                currentNode = node;
            }else{
                currentNode.next = node;
                currentNode = node;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1){
            currentNode.next = new ListNode(1);
        }
        return headNode;
    }
 }
