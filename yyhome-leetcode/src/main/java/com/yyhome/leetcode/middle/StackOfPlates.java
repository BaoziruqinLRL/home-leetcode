package com.yyhome.leetcode.middle;

import java.util.*;

/**
 * @author: lirl
 * @date: 2021/5/13
 */
public class StackOfPlates {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(new String[]{"StackOfPlates", "push", "pop", "popAt", "popAt", "popAt", "push", "push", "push", "popAt", "popAt", "push", "pop", "popAt", "push", "popAt", "popAt", "pop", "popAt", "push", "push", "pop", "push", "push", "popAt", "popAt", "popAt", "push", "popAt", "push", "pop", "push", "push", "popAt", "popAt", "push", "popAt", "push", "pop", "pop", "popAt", "push", "popAt", "pop", "popAt", "popAt", "popAt"},
                new Integer[][]{{1}, {33}, {}, {0}, {1}, {0}, {17}, {9}, {17}, {1}, {1}, {3}, {}, {1}, {37}, {0}, {0}, {}, {1}, {26}, {32}, {}, {36}, {24}, {1}, {0}, {0}, {4}, {0}, {34}, {}, {26}, {45}, {1}, {0}, {13}, {1}, {37}, {}, {}, {0}, {5}, {0}, {}, {1}, {1}, {1}})));
        System.out.println(Arrays.toString(test(new String[]{"StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"}, new Integer[][]{{2}, {1}, {2}, {3}, {0}, {0}, {0}})));
        System.out.println(Arrays.toString(test(new String[]{"StackOfPlates", "push", "push", "popAt", "pop", "pop"}, new Integer[][]{{1}, {1}, {2}, {1}, {}, {}})));
    }

    private static Integer[] test(String[] order, Integer[][] param) {
        List<Integer> res = new ArrayList<>();
        StackOfPlates sop = null;
        for (int i = 0; i < order.length; i++) {
            if (i >= 24 && i <= 26) {
                int a = 1;
            }
            switch (order[i]){
                case "StackOfPlates":
                    sop = new StackOfPlates(param[i][0]);
                    res.add(null);
                    break;
                case "push":
                    sop.push(param[i][0]);
                    res.add(null);
                    break;
                case "pop":
                    res.add(sop.pop());
                    break;
                case "popAt":
                    res.add(sop.popAt(param[i][0]));
                    break;
                default:
                    break;
            }
        }
        return res.toArray(new Integer[res.size()]);
    }

    /**
     * 执行耗时:15 ms,击败了32.54% 的Java用户
     * 内存消耗:46.1 MB,击败了59.62% 的Java用户
     */

    int cap;
    int num = 0;
    Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        if (num == 0) {
            Stack<Integer> stack = new Stack<>();
            stackMap.put(0, stack);
            stack.push(val);
            num++;
        } else {
            Stack<Integer> stack = stackMap.get(num - 1);
            if (stack.size() == cap) {
                Stack<Integer> newStack = new Stack<>();
                stackMap.put(num++, newStack);
                newStack.push(val);
            } else {
                stack.push(val);
            }
        }
    }

    public int pop() {
        if (num == 0) {
            return -1;
        }
        Stack<Integer> stack = stackMap.get(num - 1);
        int val = stack.pop();
        if (stack.size() == 0) {
            num--;
        }
        return val;
    }

    public int popAt(int index) {
        if (index < 0 || index >= num) {
            return -1;
        }
        Stack<Integer> stack = stackMap.get(index);
        int val = stack.pop();
        if (stack.size() == 0) {
            for (; index < num - 1; index++) {
                stackMap.put(index, stackMap.get(index+1));
            }
            num--;
        }
        return val;
    }
}
