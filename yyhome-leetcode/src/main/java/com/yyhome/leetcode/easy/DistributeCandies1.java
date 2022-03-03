package com.yyhome.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575 分糖果
 * @author: lirl
 * @date: 2021/3/29
 */
public class DistributeCandies1 {

    public static void main(String[] args){
        System.out.println(new DistributeCandies1().distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(new DistributeCandies1().distributeCandies(new int[]{1,1,2,3}));
    }

    /**
     * 执行耗时:29 ms,击败了86.36% 的Java用户
     * 内存消耗:40.3 MB,击败了80.06% 的Java用户
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0, sType = 0; i < candyType.length && sType < candyType.length / 2; i++){
            if (!set.contains(candyType[i])){
                sType++;
                set.add(candyType[i]);
            }
        }
        return set.size();
    }
}
