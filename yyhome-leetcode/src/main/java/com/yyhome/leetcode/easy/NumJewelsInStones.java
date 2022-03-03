package com.yyhome.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771 宝石与石头
 * @author: lirl
 * @date: 2021/4/6
 */
public class NumJewelsInStones {

    public static void main(String[] args){
        System.out.println(new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new NumJewelsInStones().numJewelsInStones("z", "ZZ"));
    }

    /**
     * 执行耗时:2 ms,击败了43.49% 的Java用户
     * 内存消耗:37.1 MB,击败了15.44% 的Java用户
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for (char c : stones.toCharArray()){
            if (set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
