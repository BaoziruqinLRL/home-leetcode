package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 92 反转链表Ⅱ
 * @author: lirl
 * @date: 2021/5/7
 */
public class ReverseBetween {

    public static void main(String[] args){
        ListNode.print(new ReverseBetween().reverseBetween(ListNode.createLink(1,2,3,4,5,6,7,8,9,10), 1, 10));
        ListNode.print(new ReverseBetween().reverseBetween(ListNode.createLink(1,2,3,4,5,6,7,8,9,10), 1, 9));
        ListNode.print(new ReverseBetween().reverseBetween(ListNode.createLink(1,2,3,4,5,6,7,8,9,10), 2, 9));
        ListNode.print(new ReverseBetween().reverseBetween(ListNode.createLink(1,2,3,4,5), 2, 4));
        ListNode.print(new ReverseBetween().reverseBetween(ListNode.createLink(5), 1, 1));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.9 MB,击败了80.66% 的Java用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftStart = head, pre = null;
        int fixLeft = 1;
        while (fixLeft++ < left) {
            pre = leftStart;
            leftStart = leftStart.next;
        }
        ListNode leftNode = leftStart.next, leftPre = leftStart;
        while (fixLeft++ <= right) {
            ListNode tempNext = leftNode.next;
            leftNode.next = leftStart;
            leftPre.next = tempNext;
            leftStart = leftNode;
            leftNode = tempNext;
        }
        if (pre != null) {
            pre.next = leftStart;
            return head;
        } else {
            return leftStart;
        }
    }
}
