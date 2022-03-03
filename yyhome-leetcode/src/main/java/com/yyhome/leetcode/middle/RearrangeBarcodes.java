package com.yyhome.leetcode.middle;

import java.util.*;

/**
 * 二维码相邻不相等
 * @author miluo
 * @date 2019-10-18
 */
public class RearrangeBarcodes {

    public static void main(String[] args){
        // 1 4 1 2 1 2 2
        System.out.println(Arrays.toString(rearrangeBarcodes2(new int[]{1,1,1,2,2,2,4})));
        // 1 3 1 3 1 2 1 2
        System.out.println(Arrays.toString(rearrangeBarcodes2(new int[]{1,1,1,1,2,2,3,3})));
        // 12225 15222 52122 21252
        System.out.println(Arrays.toString(rearrangeBarcodes2(new int[]{2,2,2,1,5})));
    }

    private static int[] rearrangeBarcodes2(int[] barcodes) {
        int[] result = new int[barcodes.length];
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int ba : barcodes){
            if (numberCount.containsKey(ba)){
                numberCount.put(ba,numberCount.get(ba) + 1);
            }else{
                numberCount.put(ba,1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numberCount.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        int listIndex = 0;
        Map.Entry<Integer, Integer> firstEntry = list.get(listIndex);
        for (int i = 1; i < barcodes.length; i+=2){
            // 填充奇数位
            result[i] = firstEntry.getKey();
            if (firstEntry.getValue() == 1 && listIndex < list.size() - 1) {
                firstEntry = list.get(++listIndex);
            } else {
                firstEntry.setValue(firstEntry.getValue() - 1);
            }
        }
        for (int i = 0; i < barcodes.length; i+=2){
            // 填充偶数位
            result[i] = firstEntry.getKey();
            if (firstEntry.getValue() == 1 && listIndex < list.size() - 1) {
                firstEntry = list.get(++listIndex);
            } else {
                firstEntry.setValue(firstEntry.getValue() - 1);
            }
        }
        return result;
    }
}
