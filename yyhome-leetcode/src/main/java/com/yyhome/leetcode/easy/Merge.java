package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import lombok.var;

/**
 * 合并有序序列 MS 10.01
 * @author miluo
 * @date 2020-03-03
 */
public class Merge {

    public static void main(String[] args){
        var a = new int[]{1,2,3,0,0,0};
        merge(a,3,new int[]{2,5,6},3);
        System.out.println(JSON.toJSONString(a));
        a = new int[]{-1,0,0,3,3,3,0,0,0};
        merge(a,6,new int[]{1,2,2},3);
        System.out.println(JSON.toJSONString(a));
        a = new int[]{0};
        merge(a,0,new int[]{1},1);
        System.out.println(JSON.toJSONString(a));
        a = new int[]{-12,0,0,0,0,0};
        merge(a,1,new int[]{-90,-88,-11,0,12},5);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 思路：
     * 初始化A数组索引index = 0，对B数据循环搜索，当
     * 1.A[index]小于当前B数组元素  且 A[index] >= A[index - 1] (这一步
     * 目的是为了排除掉A中已经超出m范围的索引导致的0值计算异常，因为A数组实际
     * 长度为m，后面的0值都是为了留足空间而赋的）且 index小于A的实际长度，则
     * 表明A当前元素无需移位，直接把index后移一位计算下一位
     * 2.除1外的情况，则表示B当前元素比A[index]大，要将A[index]及之后的元素
     * 后移一位，然后A[index]塞入B当前元素，并把B索引和A索引都往前移一位
     * @param A
     * @param m
     * @param B
     * @param n
     */
    private static void merge(int[] A, int m, int[] B, int n) {
        if (m == 0){
            System.arraycopy(B,0,A,0,n);
        }else {
            int aIndex = 0;
            int mTemp = m;
            for (int bIndex = 0; bIndex < n; ) {
                if (A[aIndex] < B[bIndex] && (aIndex == 0 || A[aIndex] >= A[aIndex - 1]) && aIndex < mTemp) {
                    aIndex++;
                } else {
                    System.arraycopy(A, aIndex, A, aIndex + 1, m + n - aIndex - 1);
                    mTemp++;
                    A[aIndex] = B[bIndex++];
                    aIndex = (aIndex + 1 >= m + n) ? m + n - 1 : aIndex + 1;
                }
            }
        }
    }
}
