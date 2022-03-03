package com.yyhome.leetcode;

import com.alibaba.fastjson.JSON;
import lombok.var;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * @author miluo
 * @date 2020-03-20
 */
public class TestLambda {

    public static void main(String[] args){
        new TestLambda().tt();
//        String name = "AAAAA";
//        System.out.println(name);
//        test1();
//        System.out.println(isMoreThenTimeLimit("02:32:18","24:00:00"));
//        System.out.println(JSON.toJSONString(convertBinaryToList(127L)));
    }

    private ThreadLocal<String> st = new ThreadLocal<>();
    private ThreadLocal<Integer> it = new ThreadLocal<>();

    private void tt(){
        st.set("AAAA");
        st.set("BBBB");
        st.set("CCCC");
        it.set(1);
        it.set(2);
        it.set(3);
        System.out.println(st.get());
        System.out.println(it.get());
    }
    // threadMap 674
    // tab 685
    private static void test1(){

       int price = 1332;
       int maxHundred = price / 100;
       int maxHundredResult = 0;
       int max12Result = 0;
       for (int i = maxHundred; i > 0; i--){
           if ((price - i * 100) % 12 == 0){
               maxHundredResult = i;
               max12Result = (price - i * 100) / 12;
               break;
           }
       }
        System.out.println(maxHundredResult);
    }

    private static boolean isMoreThenTimeLimit(String waitTime, String limit){
        var date = new Date();
        String startDate;
        if (date == null) {
            startDate = null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            startDate =  dateFormat.format(date);
        }
        var startS = startDate +" 00:00:00";
        System.out.println(startS);
        String endDate;
        if (date == null) {
            endDate = null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            endDate =  dateFormat.format(date);
        }
        var endS = endDate +" 23:59:59";
        System.out.println(endS);
        return true;
    }

    private static final int MAX_NUM = 63;
//
//    private static List<Long> BINARY_VALUE = new ArrayList<>(64);
//
//    static {
//        var initDecimal = BigDecimal.valueOf(2);
//        IntStream.range(0, MAX_NUM)
//                .forEach(n -> BINARY_VALUE.add(n, initDecimal.pow(n).longValue()));
//    }

    private static List<Integer> convertBinaryToList(Long binaryValue) {
        List<Long> BINARY_VALUE = new ArrayList<>(64);
        var initDecimal = BigDecimal.valueOf(2);
        IntStream.range(0, MAX_NUM)
                .forEach(n -> BINARY_VALUE.add(n, initDecimal.pow(n).longValue()));
        int index = 0;
        int head = 0;
        int end = MAX_NUM;
        boolean notFinish = true;
        // 二分查找法查找binaryValue应该所在的索引
        while (notFinish) {
            int middle = (head + end) / 2;
            if (BINARY_VALUE.get(middle) <= binaryValue && binaryValue < BINARY_VALUE.get(middle + 1)) {
                // 找到索引位置
                index = middle;
                notFinish = false;
            } else {
                if (binaryValue < BINARY_VALUE.get(middle)) {
                    end = middle;
                } else if (BINARY_VALUE.get(middle) < binaryValue) {
                    head = middle;
                }
            }
        }
        // 转换二进制位数
        var res = new ArrayList<Integer>(index + 1);
        while (index > 0) {
            if (binaryValue >= BINARY_VALUE.get(index)) {
                res.add(index);
                binaryValue -= BINARY_VALUE.get(index);
            }
            index--;
        }
        return res;
    }

    private static Base singleBase;

    private static Base testDateFormat(){
        if (singleBase == null){
            synchronized (TestLambda.class){
                if (singleBase == null){
                    singleBase = new Base();
                }
            }
        }
        return singleBase;
    }

    private <T extends Today> T hello(T param){
        return param;
    }

    private static class Base{

    }

    private class Today extends Base{

    }

    private class Tomorrow extends Today{

    }

    private class Month {

    }
}

