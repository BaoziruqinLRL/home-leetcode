package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 141 环形链表
 * @author: lirl
 * @date: 2021/3/10
 */
public class HasCycle {

    public static void main(String[] args) {
        System.out.println(new HasCycle().hasCycle(ListNode.createCycleLink(1,3,2,0,-4)));
        System.out.println(new HasCycle().hasCycle(ListNode.createCycleLink(0,1,2)));
        System.out.println(new HasCycle().hasCycle(ListNode.createLink(1)));
    }

    /**
     * 执行耗时:1 ms,击败了25.09% 的Java用户
     * 内存消耗:39.8 MB,击败了8.74% 的Java用户
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next != null ? head.next.next : null;
        while (true){
            if (slow == fast && fast != null){
                return true;
            }else if (fast == null || slow == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
    }
}
