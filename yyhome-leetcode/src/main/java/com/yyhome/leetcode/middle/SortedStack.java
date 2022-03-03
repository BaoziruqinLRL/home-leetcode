package com.yyhome.leetcode.middle;

import java.util.Arrays;
import java.util.Stack;

/**
 * 面试题 03.05 栈排序
 * @author: lirl
 * @date: 2021/4/13
 */
public class SortedStack {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(action(new String[]{"SortedStack", "push", "push", "peek", "pop", "peek"}, new Integer[]{null, 1, 2, null, null, null})));
        System.out.println(Arrays.toString(action(new String[]{"SortedStack", "pop", "pop", "push", "pop", "isEmpty"}, new Integer[]{null, null, null, 1, null, null})));
    }

    private static Object[] action(String[] acs, Integer[] nums) {
        Object[] obj = new Object[nums.length];
        SortedStack ss = new SortedStack();
        for (int i = 0; i < acs.length; i++) {
            switch (acs[i]){
                case "SortedStack":
                    ss = new SortedStack();
                    obj[i] = null;
                    break;
                case "push":
                    ss.push(nums[i]);
                    obj[i] = null;
                    break;
                case "peek":
                    obj[i] = ss.peek();
                    break;
                case "pop":
                    ss.pop();
                    obj[i] = null;
                    break;
                case "isEmpty":
                    obj[i] = ss.isEmpty();
                    break;
                default:
                    break;
            }
        }
        return obj;
    }

    Stack<Integer> stack = new Stack<>();

    /**
     * 执行耗时:282 ms,击败了5.05% 的Java用户
     * 内存消耗:39.8 MB,击败了21.41% 的Java用户
     */
    public SortedStack() {

    }

    public void push(int val) {
        Stack<Integer> temp = new Stack<>();
        while (!isEmpty() && peek() < val) {
            temp.push(peek());
            pop();
        }
        stack.push(val);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
