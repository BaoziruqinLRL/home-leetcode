package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 24 两两交换链表中的节点
 * @author: lirl
 * @date: 2021/4/12
 */
public class SwapPairs {

    public static void main(String[] args){
        ListNode.print(new SwapPairs().swapPairs(ListNode.createLink(1,2,3,4)));
        ListNode.print(new SwapPairs().swapPairs(ListNode.createLink()));
        ListNode.print(new SwapPairs().swapPairs(ListNode.createLink(1)));
        ListNode.print(new SwapPairs().swapPairs(ListNode.createLink(1,2,3)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.2 MB,击败了27.38% 的Java用户
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode current = head;
        while (true) {
            ListNode next = current.next;
            if (next != null) {
                ListNode nextCur = next.next;
                current.next = nextCur == null ? null : nextCur.next;
                next.next = current;
                if (current == head) {
                    head = next;
                }
                if (current.next == null){
                    current.next = nextCur;
                    break;
                }
                current = nextCur;
            } else {
                break;
            }
        }
        return head;
    }
}
