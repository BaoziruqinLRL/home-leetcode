package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * @author miluo
 * @date 2020-07-07
 */
public class MergeTwoList {

    public static void main(String[] args){
        ListNode.print(new MergeTwoList().mergeTwoLists3(ListNode.createLink(1,2,4),ListNode.createLink(1,3,4)));
        ListNode.print(new MergeTwoList().mergeTwoLists3(ListNode.createLink(5),ListNode.createLink(1,2,4)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        while (l1 != null || l2 != null){
            ListNode temp;
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }else if (l1 == null){
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (current == null){
                current = temp;
            }else {
                current.next = temp;
                current = temp;
            }
            if (head == null){
                head = current;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        while (l1 != null || l2 != null){
            ListNode temp;
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else if (l1.val > l2.val){
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                } else{
                    temp = new ListNode(l1.val);
                    if (current == null){
                        current = temp;
                    }else {
                        current.next = temp;
                        current = temp;
                    }
                    if (head == null){
                        head = current;
                    }
                    temp = new ListNode(l2.val);
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }else if (l1 == null){
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (current == null){
                current = temp;
            }else {
                current.next = temp;
                current = temp;
            }
            if (head == null){
                head = current;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }else if (l2 == null){
            return l1;
        }else if (l1 == null){
            return l2;
        }
        ListNode head = l1;
        ListNode pre1 = l1;
        while (l2 != null){
            if (l2.val > l1.val){
                while (l1 != null && l1.val < l2.val){
                    pre1 = l1;
                    l1 = l1.next;
                }
                if (l1 == null){
                    pre1.next = l2;
                    return head;
                }
            }
            ListNode next2 = l2.next;
            if (l1 == head){
                l2.next = pre1;
                head = l2;
                l1 = head;
                pre1 = head;
            }else {
                l2.next = l1;
                pre1.next = l2;
                pre1 = pre1.next;
            }
            l2 = next2;
        }
        return head;
    }
}
