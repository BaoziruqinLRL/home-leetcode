package com.yyhome.leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 蛇梯棋 909
 * @author miluo
 * @date 2019-10-14
 */
public class SnakeAndLadders {

    public static void main(String[] args){
        System.out.println(snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));
    }

    /**
     * BFS算法
     * @param board
     * @return
     */
    private static int snakesAndLadders(int[][] board) {
        int length = board.length;
        // 初始化首节点数据
        Map<Integer, Integer> stepMap = new HashMap<>();
        stepMap.put(1,0);
        Queue<Integer> nodeQue = new LinkedBlockingQueue<>();
        nodeQue.add(1);
        while (!nodeQue.isEmpty()){
            int currentNode = nodeQue.poll();
            for (int pathNode = currentNode + 1; pathNode <= currentNode + 6 && pathNode <= length*length; pathNode++){
                int[] position = getPosition(pathNode,length);
                int actuallyNode = board[position[0]][position[1]] == -1 ? pathNode : board[position[0]][position[1]];
                if (!stepMap.containsKey(actuallyNode)){
                    // 从currentNode 走到 actuallyNode 步数+1
                    stepMap.put(actuallyNode, stepMap.get(currentNode) + 1);
                    if (actuallyNode == length*length){
                        // finish
                        nodeQue.clear();
                        break;
                    }
                    // 讲actuallyNode入队
                    nodeQue.add(actuallyNode);
                }
            }
        }
        if (stepMap.containsKey(length*length)){
            return stepMap.get(length*length);
        }
        return -1;
    }

    private static int[] getPosition(int num, int length){
        int[] result = new int[2];
        result[0] = length - (num - 1) / length - 1;
        // 偶数行正序, 奇数行倒序
        result[1] = (((num - 1) / length) % 2 == 0) ? ((num - 1) % length) : (length - (num - 1) % length - 1);
        return result;
    }

    private static int getNum(int x, int y, int length){
        int result = 0;
        result = length * (length - x - 1) + (((length - x - 1) % 2 == 0) ? (y + 1) : (length - y));
        return result;
    }
}
