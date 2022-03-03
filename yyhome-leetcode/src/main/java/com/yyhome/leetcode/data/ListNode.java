package com.yyhome.leetcode.data;

import lombok.Data;
import lombok.var;

/**
 * @author miluo
 * @date 2020-03-23
 */
@Data
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public static ListNode createLink(int... values){
        if (values.length == 0){
            return null;
        }
        var count = 0;
        var node = new ListNode(values[count++]);
        var currentNode = node;
        for (;count < values.length;){
            currentNode.next = new ListNode(values[count++]);
            currentNode = currentNode.next;
        }
        return node;
    }

    public static ListNode createCycleLink(int position, int... values){
        ListNode cycleNode = null;
        var count = 0;
        var node = new ListNode(values[count]);
        if (position == count){
            cycleNode = node;
        }
        var currentNode = node;
        for (count++;count < values.length;count++){
            currentNode.next = new ListNode(values[count]);
            if (position == count){
                cycleNode = currentNode.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = cycleNode;
        return node;
    }

    public static void print(ListNode node){
        while (node != null){
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }
}
