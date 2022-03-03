package com.yyhome.leetcode.easy;

/**
 * @author: lirl
 * @date: 2021/3/10
 */
public class MinStack {

    public static void main(String[] args) {
        new MinStack().test(new String[]{"MinStack","push","push","push","getMin","pop","top","getMin"}, new Integer[]{null,-2,0,-3,null,null,null,null});
    }

    public void test(String[] type, Integer[] value){
        MinStack stack = null;
        for (int index = 0; index < type.length; index++){
            switch (type[index]){
                case "MinStack":
                    stack = new MinStack();
                    System.out.print("null ");
                    break;
                case "push":
                    stack.push(value[index]);
                    System.out.print("null ");
                    break;
                case "getMin":
                    System.out.print(stack.getMin() + " ");
                    break;
                case "pop":
                    stack.pop();
                    System.out.print("null ");
                    break;
                case "top":
                    System.out.print(stack.top() + " ");
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 执行耗时:8 ms,击败了27.26% 的Java用户
     * 内存消耗:40.5 MB,击败了5.13% 的Java用户
     */
    Link current = null;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (current == null){
            current = new Link(x);
        }else{
            Link node = new Link(x);
            node.preNode = current;
            current = node;
        }
        current.min = current.preNode == null ? x : Math.min(current.preNode.min, x);
    }

    public void pop() {
        current = current.preNode;
    }

    public int top() {
        return current.val;
    }

    public int getMin() {
        return current.min;
    }

    private static class Link{
        int val;
        int min;
        Link preNode;

        public Link(int val) {
            this.val = val;
        }
    }
}
