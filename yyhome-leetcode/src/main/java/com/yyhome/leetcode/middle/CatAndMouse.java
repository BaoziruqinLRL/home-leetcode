package com.yyhome.leetcode.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 猫和老鼠 TODO
 * @author miluo
 * @date 2019-10-17
 */
public class CatAndMouse {

    public static void main(String[] args){
        /**
         * 4---3---1
         * |   |
         * 2---5
         *  \ /
         *   0
         */
        System.out.println(catMouseGame(new int[][]{{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}}));
    }

    private static int catMouseGame(int[][] graph) {
        int catSite = 2;
        int mouseSite = 1;
        // 记录猫和老鼠走过的路径, key是老鼠走过的坐标, value是老鼠在该坐标时猫曾处在的位置
        Map<Integer, Set<Integer>> stepPath = new HashMap<>(graph.length);
        Set<Integer> catSet = new HashSet<>();
        catSet.add(2);
        stepPath.put(1,catSet);
        // 记录老鼠走过的路径
        Map<Integer, Set<Integer>> mousePath = new HashMap<>(graph.length);
        int result;
        while ((result = -1) < 0){

        }
        return 1;
    }

    /**
     * 找下一步,满足以下三个条件即可走
     * 1.没有往猫身上撞
     * 2.这步仍未走过
     * 3.没有走到猫旁边
     * 且如果有终点则直接返回
     * @return 下一步, 若是-1表示无路可走, 0表示赢了
     */
    private int nextMouseStep(int catSite, int mouseSite, int[][] graph, Set<Integer> mousePathPoint){
        int next = -1;
        for (int p : graph[mouseSite]){
            if (p == 0){
                next = 0;
                break;
            }
            // 1.没有往猫身上撞 2.这步仍未走过
            if (p != catSite && !mousePathPoint.contains(p)){
                boolean notCloseCat = false;
                for (int p2 : graph[catSite]){
                    if (p2 != p){
                        notCloseCat = true;
                    }
                }
                // 3.没有走到猫旁边
                if (notCloseCat){
                    next = p;
                    break;
                }
            }
        }
        return next;
    }
}
