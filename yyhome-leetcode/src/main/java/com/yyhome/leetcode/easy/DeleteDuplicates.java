package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 83 删除排序链表中的重复元素
 * @author miluo
 * @date 2020-07-10
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,1,2)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates(ListNode.createLink(1,1,2,3,3)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates2(ListNode.createLink(1,1,2)));
        ListNode.print(new DeleteDuplicates().deleteDuplicates2(ListNode.createLink(1,1,2,3,3)));
    }

    /**
     * 执行耗时:1 ms,击败了72.18% 的Java用户
     * 内存消耗:39.5 MB,击败了5.97% 的Java用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode last = head;
        int current = head.val;
        while (temp != null){
            if (temp.val == current){
                last.next = temp.next;
                temp = temp.next;
            }else{
                last = temp;
                current = temp.val;
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了5.97% 的用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            head = head.next;
        }
        return head;
    }
}
