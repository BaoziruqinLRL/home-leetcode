package com.yyhome.leetcode.other;

/**
 * 回型数字三角形，输入5，返回
 * 1 0 0 0 0
 * 2 12 0 0 0
 * 3 13 11 0 0
 * 4 14 15 10 0
 * 5 6 7 8 9
 */
public class Unknown {

    public static void main(String[] args){
       print(new Unknown().exec(5));
        print(new Unknown().exec(6));
    }

    private int[][] exec(int num){
        int[][] result = new int[num][num];
        int i = -1,j = 0;
        int currentNum = 1;
        // 0竖边，1横边，2斜边
        int cycle = 0;
        int currentCycleLength = num;
        while (currentCycleLength > 0){
            for (int count = 0; count < currentCycleLength; count++){
                if (cycle == 0) {
                    result[++i][j] = currentNum++;
                }else if (cycle == 1){
                    result[i][++j] = currentNum++;
                }else{
                    result[--i][--j] = currentNum++;
                }
            }
            // 换边
            cycle = (cycle + 1) % 3;
            // 换轮
            currentCycleLength--;
        }

        return result;
    }

    private static void print(int[][] arr){
        for (int[] i : arr){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}
