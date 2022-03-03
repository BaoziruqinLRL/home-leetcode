package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 61 旋转链表
 * @author: lirl
 * @date: 2021/4/19
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode.print(new RotateRight().rotateRight(ListNode.createLink(1,2,3,4,5), 2));
        ListNode.print(new RotateRight().rotateRight(ListNode.createLink(1,2), 1));
        ListNode.print(new RotateRight().rotateRight(ListNode.createLink(0,1,2), 4));
    }

    /**
     * 1ms 52%
     * 38MB 24%
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int count = 0;
        while (true) {
            count++;
            if (cur.next == null) {
                cur.next = head;
                break;
            }
            cur = cur.next;
        }
        k = k % count;
        int index = 1;
        while (index < count - k) {
            head = head.next;
            index++;
        }
        cur = head.next;
        head.next = null;
        return cur;
    }
}
