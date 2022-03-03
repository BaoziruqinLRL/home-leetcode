package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 面试题 02.08 环路检测
 * @author: lirl
 * @date: 2021/4/13
 */
public class DetectCycle {

    public static void main(String[] args){
        System.out.println(new DetectCycle().detectCycle(ListNode.createCycleLink(2, 3,5,2,0,-4)).val);
        System.out.println(new DetectCycle().detectCycle(ListNode.createCycleLink(0, 1,2)).val);
        System.out.println(new DetectCycle().detectCycle(ListNode.createCycleLink(-1, 1)).val);
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了55.17% 的Java用户
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow == null ? null : slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
