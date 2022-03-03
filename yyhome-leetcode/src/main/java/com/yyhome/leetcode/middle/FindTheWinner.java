package com.yyhome.leetcode.middle;

/**
 * 1823 找出游戏的获胜者
 * @author: lirl
 * @date: 2021/5/31
 */
public class FindTheWinner {

    public static void main(String[] args){
        System.out.println(new FindTheWinner().findTheWinner(5, 2));
        System.out.println(new FindTheWinner().findTheWinner(6, 5));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了81.32% 的Java用户
     * 约瑟夫环
     * https://blog.csdn.net/u011500062/article/details/72855826
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++){
            p = (p + k) % i;
        }
        return p+1;
    }
}
