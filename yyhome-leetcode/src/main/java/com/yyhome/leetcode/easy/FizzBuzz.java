package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 412 Fizz Buzz
 * @author: lirl
 * @date: 2021/3/24
 */
public class FizzBuzz {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new FizzBuzz().fizzBuzz(10)));
        System.out.println(JSON.toJSONString(new FizzBuzz().fizzBuzz(15)));
    }

    /**
     * 执行耗时:3 ms,击败了42.68% 的Java用户
     * 内存消耗:39.7 MB,击败了45.07% 的Java用户
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>();
        for(Integer i=1; i<=n; i++) {
            if(i % 3 == 0 && i % 5 == 0) li.add("FizzBuzz");
            else if(i % 3 == 0) li.add("Fizz");
            else if(i % 5 == 0) li.add("Buzz");
            else li.add(i.toString());
        }
        return li;
    }
}
