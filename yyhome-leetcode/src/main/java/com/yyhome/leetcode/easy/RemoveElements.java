package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 203 移除链表元素
 * @author: lirl
 * @date: 2021/3/11
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode.print(new RemoveElements().removeElements(ListNode.createLink(1,2,6,3,4,5,6),6));
        ListNode.print(new RemoveElements().removeElements(ListNode.createLink(),1));
        ListNode.print(new RemoveElements().removeElements(ListNode.createLink(7,7,7,7),7));
        ListNode.print(new RemoveElements().removeElements(ListNode.createLink(1,2,2,1),2));
    }

    /**
     * 执行耗时:1 ms,击败了99.70% 的Java用户
     * 内存消耗:39.4 MB,击败了59.82% 的Java用户
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode current = head;
        ListNode pre = null;
        while (current != null){
            if (current.val == val){
                if (pre == null){
                    head = current.next;
                }else{
                    pre.next = current.next;
                }
            }else{
                pre = current;
            }
            current = current.next;
        }
        return head;
    }
}
