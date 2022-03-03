package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 401 二进制手表
 * @author: lirl
 * @date: 2021/3/24
 */
public class ReadBinaryWatch {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new ReadBinaryWatch().readBinaryWatch(1)));
        System.out.println(JSON.toJSONString(new ReadBinaryWatch().readBinaryWatch(2)));
    }

    /**
     * 执行耗时:13 ms,击败了28.66% 的Java用户
     * 内存消耗:38.8 MB,击败了18.90% 的Java用户
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        return cycle(num, 0, 0);
    }

    public List<String> cycle(int num, int moveSize, int res){
        if ((10 - moveSize) < num){
            return null;
        }
        if (num == 0){
            String spRes = split(res);
            return spRes != null ? Collections.singletonList(spRes) : null;
        }
        List<String> li = new ArrayList<>();
        for (int i = moveSize; i < 10; i++){
            int moveRes = res | (1 << i);
            List<String> cycRes = cycle(num - 1, i + 1, moveRes);
            if (cycRes != null) {
                li.addAll(cycRes);
            }
        }
        return li;
    }

    public String split(int value){
        int second = value & 0b111111;
        if (second >= 60){
            return null;
        }
        int minute = (value >> 6) & 0b1111;
        if (minute >= 12){
            return null;
        }
        return minute + ":" + (second >= 10 ? second : "0" + second);
    }
}
