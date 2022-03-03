package com.yyhome.leetcode.easy;

/**
 * 205 同构字符串
 * @author: lirl
 * @date: 2021/3/11
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("badc", "baba"));
        System.out.println(new IsIsomorphic().isIsomorphic("egg","add"));
        System.out.println(new IsIsomorphic().isIsomorphic("foo","bar"));
        System.out.println(new IsIsomorphic().isIsomorphic("paper", "title"));
    }

    /**
     * 执行耗时:5 ms,击败了87.54% 的Java用户
     * 内存消耗:38.7 MB,击败了12.69% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] stot = new int[128];
        int[] ttos = new int[128];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++){
            int index = sa[i];
            int tIndex = ta[i];
            if ((stot[index] != 0 && ttos[tIndex] != 0 && (stot[index] != ta[i] || ttos[tIndex] != sa[i])) ||
                    (stot[index] == 0 && ttos[tIndex] != 0) ||
                    (stot[index] != 0 && ttos[tIndex] == 0)){
                return false;
            }
            stot[index] = ta[i];
            ttos[tIndex] = sa[i];
        }
        return true;
    }
}
