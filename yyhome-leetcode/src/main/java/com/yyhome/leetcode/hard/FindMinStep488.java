package com.yyhome.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 488祖玛游戏
 * @Author: lrl
 * @Date: 2024/1/31 11:33:03
 */
public class FindMinStep488 {

    public static void main(String[] args) {
        System.out.println(new FindMinStep488().findMinStep("G", "GGGGG"));
        System.out.println(new FindMinStep488().findMinStep("RRGGBBYYWWRRGGBB", "RGBYW"));
        System.out.println(new FindMinStep488().findMinStep("RRWWRRBBRR", "WB"));
        System.out.println(new FindMinStep488().findMinStep("WWGWGW", "GWBWR"));
        System.out.println(new FindMinStep488().findMinStep("RBYYBBRRB", "YRBGB"));
        System.out.println(new FindMinStep488().findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(new FindMinStep488().findMinStep("WRRBBW", "RB"));
    }

    /**
     * 执行耗时:626 ms,击败了18.94% 的Java用户
     * 内存消耗:145.2 MB,击败了5.30% 的Java用户
     */
    Map<String, Map<String, Integer>> memoryMap = new HashMap<>();

    public int findMinStep(String board, String hand) {
        if (board.isEmpty()) {
            return 0;
        }
        if (hand.isEmpty()) {
            return -1;
        }
        if (memoryMap.containsKey(board)) {
            Map<String, Integer> boMap = memoryMap.get(board);
            Integer i = boMap.get(hand);
            if (i != null) {
                return i;
            }
        }
        int min = -1;
        Set<Character> insertedColor = new HashSet<>();
        for (int i = 0; i < hand.length(); i++) {
            char insertChar = hand.charAt(i);
            if (insertedColor.contains(insertChar)) {
                continue;
            } else {
                insertedColor.add(insertChar);
            }
            String newHand = hand.substring(0, i) + (i < hand.length() - 1 ? hand.substring(i + 1) : "");
            for (int j = 0; j <= board.length();) {
                int times;
                String newBoard;
                if (j == board.length()) {
                    // 插入最后一个位置
                    newBoard = board.substring(0, j) + insertChar;
                    times = remove(newBoard, j, newHand);
                    j++;
                } else {
                    char jChar = board.charAt(j);
                    if (j > 0) {
                        char preChar = board.charAt(j - 1);
                        // 插入位置插入颜色和左右两边都不一样，则跳过
                        if (insertChar != jChar && insertChar != preChar && jChar != preChar) {
                            j++;
                            continue;
                        }
                    }
                    newBoard = board.substring(0, j) + insertChar + board.substring(j);
                    times = remove(newBoard, j, newHand);
                    if (insertChar == jChar) {
                        // 插入球颜色跟右边一样
                        if (j < board.length() - 1 && jChar == board.charAt(j + 1)) {
                            // 如果右边存在两个连续相同颜色，那么插入最左边之后可以跳过插入中间和右边，因为效果是一样的
                            j += 3;
                        } else {
                            // 如果插入球颜色跟右边一样，跳过一个位置，因为插入效果一样
                            j += 2;
                        }
                    } else {
                        j++;
                    }
                }
                times = times == -1 ? -1 : (times + 1);
                min = times == -1 ? min : (min == -1 ? times : Math.min(times, min));
                Map<String, Integer> orDefault = memoryMap.getOrDefault(newBoard, new HashMap<>());
                orDefault.put(newHand, times);
                memoryMap.put(newBoard, orDefault);
            }
        }
        return min;
    }

    private int remove(String board, int index, String hand) {
        if (index < 0) {
            return findMinStep(board, hand);
        }
        char insertChar = board.charAt(index);
        if (index + 1 >= board.length()) {
            // 插入位置为最后一位，不存在消除
            return findMinStep(board, hand);
        } else {
            int left = 0, right = 0;
            // 前移几位
            while (index - left - 1 >= 0) {
                if (board.charAt(index - left - 1) == insertChar) {
                    left++;
                } else {
                    break;
                }
            }
            // 后移几位
            while (index + right + 1 < board.length()) {
                if (board.charAt(index + right + 1) == insertChar) {
                    right++;
                } else {
                    break;
                }
            }
            if (left + right >= 2) {
                // 产生消除
                board = board.substring(0, index - left) + board.substring(index + right + 1);
                return remove(board, index - left - 1, hand);
            } else {
                return findMinStep(board, hand);
            }
        }
    }
}
