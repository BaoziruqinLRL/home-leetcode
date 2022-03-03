package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 螺旋矩阵
 * @author: lirl
 * @date: 2021/4/15
 */
public class SpiralOrder {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new SpiralOrder().spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}})));
        System.out.println(JSON.toJSONString(new SpiralOrder().spiralOrder(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}})));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.8 MB,击败了9.99% 的Java用户
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 0右 1下 2左 3上
        int xu = 0, xd = matrix.length - 1, yl = 0, yr = matrix[0].length - 1, x = 0, y = 0;
        while (true) {
            for (; yl <= y && y <= yr; y++){
                res.add(matrix[x][y]);
            }
            x++;
            y--;
            xu++;
            if (xu > xd || yl > yr) {
                break;
            }
            for (; xu <= x && x <= xd; x++){
                res.add(matrix[x][y]);
            }
            x--;
            y--;
            yr--;
            if (xu > xd || yl > yr) {
                break;
            }
            for (; yl <= y && y <= yr; y--) {
                res.add(matrix[x][y]);
            }
            x--;
            y++;
            xd--;
            if (xu > xd || yl > yr) {
                break;
            }
            for (; xu <= x && x <= xd; x--) {
                res.add(matrix[x][y]);
            }
            x++;
            y++;
            yl++;
            if (xu > xd || yl > yr) {
                break;
            }
        }
        return res;
    }
}
