package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.ListNode;

/**
 * 19 删除链表的倒数第N个结点
 * @author: lirl
 * @date: 2021/4/9
 */
public class RemoveNthFromEnd {

    public static void main(String[] args){
        ListNode.print(new RemoveNthFromEnd().removeNthFromEnd(ListNode.createLink(1,2,3,4,5), 2));
        ListNode.print(new RemoveNthFromEnd().removeNthFromEnd(ListNode.createLink(1), 1));
        ListNode.print(new RemoveNthFromEnd().removeNthFromEnd(ListNode.createLink(1,2), 1));
        ListNode.print(new RemoveNthFromEnd().removeNthFromEnd(ListNode.createLink(1,2), 2));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.4 MB,击败了62.96% 的Java用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int level = cycle(head,n);
        if (level == n){
            head = head.next;
        }
        return head;
    }

    public int cycle(ListNode node, int n){
        if (node == null) {
            return 0;
        }
        int num = cycle(node.next, n) + 1;
        if (num == n + 1){
            node.next = node.next.next;
        }
        return num;
    }
}
