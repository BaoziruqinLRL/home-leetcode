package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 杨辉三角2
 * @author: lirl
 * @date: 2021/3/9
 */
public class YangHuiGenerate2 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new YangHuiGenerate2().getRow(3)));
        System.out.println(JSON.toJSONString(new YangHuiGenerate2().getRow(4)));
        System.out.println(JSON.toJSONString(new YangHuiGenerate2().getRow(5)));
    }

    /**
     * 执行耗时:2 ms,击败了31.02% 的Java用户
     * 内存消耗:35.9 MB,击败了96.33% 的Java用户
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            int preEle = 1;
            for (int j = 0; j <= i; j++){
                if (j == i){
                    preRow.add(1);
                }else if (j > 0) {
                    int tempEle = preEle;
                    preEle = preRow.get(j);
                    preRow.set(j, tempEle + preRow.get(j));
                }
            }
        }
        return preRow;
    }
}
