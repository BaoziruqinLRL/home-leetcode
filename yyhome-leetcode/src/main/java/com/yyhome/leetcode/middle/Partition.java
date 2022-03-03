package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 86 分隔链表
 * @author: lirl
 * @date: 2021/5/6
 */
public class Partition {

    public static void main(String[] args) {
        ListNode.print(new Partition().partition(ListNode.createLink(1,1), 2));
        ListNode.print(new Partition().partition(ListNode.createLink(1,1), 0));
        ListNode.print(new Partition().partition(ListNode.createLink(1,4,3,2,5,2), 3));
        ListNode.print(new Partition().partition(ListNode.createLink(2,1), 2));
        ListNode.print(new Partition().partition(ListNode.createLink(1), 0));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.4 MB,击败了97.42% 的Java用户
     * 双指针
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head.val < x ? head : null, right = left == null ? head : null,
                firstRight = right, firstLeft = left,
                e = head.next;
        while (e != null) {
            if (e.val < x) {
                if (right != null) {
                    right.next = e.next;
                    if (left == null) {
                        left = e;
                        left.next = firstRight;
                    } else {
                        ListNode temp = left.next;
                        left.next = e;
                        e.next = temp;
                        left = left.next;
                    }
                    if (firstLeft == null) {
                        firstLeft = e;
                    }
                } else {
                    left = left.next;
                }
            } else {
                right = right == null ? e : right.next;
            }
            e = right == null ? left.next : right.next;
        }
        return firstLeft == null ? firstRight : firstLeft;
    }
}
