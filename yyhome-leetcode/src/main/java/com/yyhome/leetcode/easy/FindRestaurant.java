package com.yyhome.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 599 两个列表的最小索引总和
 * @author: lirl
 * @date: 2021/3/30
 */
public class FindRestaurant {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(new FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
    }

    /**
     * 21ms
     * 39.3mb
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(Math.max(list1.length, list2.length));
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i],-(i + 1));
        }
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])) {
                map.put(list2[i], -map.get(list2[i]) + 1 + i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String,Integer> e : map.entrySet()){
            if (e.getValue() >= 0) {
                if (e.getValue().equals(min)) {
                    sb.append(e.getKey()).append(",");
                } else if (e.getValue() < min) {
                    sb = new StringBuilder();
                    sb.append(e.getKey()).append(",");
                    min = e.getValue();
                }
            }
        }
        return sb.replace(sb.length() - 1, sb.length(), "").toString().split(",");
    }
}
