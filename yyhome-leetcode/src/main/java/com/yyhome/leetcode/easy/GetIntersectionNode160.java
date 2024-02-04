package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 相交链表 160
 * @Author: lrl
 * @Date: 2024/2/4 9:10:38
 */
public class GetIntersectionNode160 {

    /**
     * 执行耗时:1 ms,击败了99.41% 的Java用户
     * 内存消耗:47.5 MB,击败了15.35% 的Java用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aTemp = headA;
        while (aTemp != null) {
            aTemp.val = aTemp.val + 100000;
            aTemp = aTemp.next;
        }
        ListNode bTemp = headB;
        while (bTemp != null) {
            if (bTemp.val > 100000) {
                break;
            }
            bTemp = bTemp.next;
        }
        aTemp = headA;
        while (aTemp != null) {
            aTemp.val -= 100000;
            aTemp = aTemp.next;
        }
        return bTemp;
    }
}
