package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 82 删除排序链表中的重复元素
 * @author lirl
 * @date 2021/4/28 19:08
 */
public class DeleteDuplicates {

    public static void main(String[] args){
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,1,2,2)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,2,2,3)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,2,2)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,1)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,1,1,2,3)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,2,3,3,4,4,5)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了76.32% 的Java用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, pre = head;
        boolean skipHead = false;
        while (cur != null) {
            boolean needDel = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                needDel = true;
            }
            if (needDel) {
                if (!skipHead) {
                    pre = cur;
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                    skipHead = true;
                }
            } else {
                pre = cur;
                skipHead = true;
            }
            cur = cur.next;
        }
        return head;
    }
}
