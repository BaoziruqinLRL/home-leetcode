package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 杨辉三角
 * @author: lirl
 * @date: 2021/3/9
 */
public class YangHuiGenerate {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new YangHuiGenerate().generate(5)));
    }

    /**
     * 执行耗时:1 ms,击败了46.85% 的Java用户
     * 内存消耗:36.3 MB,击败了54.64% 的Java用户
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++){
            List<Integer> lastRow = i == 0 ? null : list.get(i - 1);
            List<Integer> ele = new ArrayList<>(i+1);
            ele.add(1);
            for (int j = 1; j < i;j++){
                ele.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            if (i > 0) {
                ele.add(1);
            }
            list.add(ele);
        }
        return list;
    }
}
