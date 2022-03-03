package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * @author: lirl
 * @date: 2021/3/11
 */
public class IsPalindromeLink {

    public static void main(String[] args){
        System.out.println(new IsPalindromeLink().isPalindrome(ListNode.createLink(1,2)));
        System.out.println(new IsPalindromeLink().isPalindrome(ListNode.createLink(1,2,2,1)));
    }

    ListNode compare;

    /**
     * 执行耗时:23 ms,击败了5.42% 的Java用户
     * 内存消耗:55.3 MB,击败了5.01% 的Java用户
     * 递归
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        if (head.next == null){
            return true;
        }
        compare = head;
        return judge(head.next);
    }


    public boolean judge(ListNode current){
        if (current == null){
            return true;
        }
        boolean res = judge(current.next) && compare.val == current.val;
        compare = compare.next;
        return res;
    }
}
