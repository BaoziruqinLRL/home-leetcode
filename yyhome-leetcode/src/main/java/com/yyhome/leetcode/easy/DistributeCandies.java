package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 * 分糖果2 1103
 * @author miluo
 * @date 2020-03-05
 */
public class DistributeCandies {

    public static void main(String[] args){
        // 1 2 3 1  1*1+(1-1)*4
        System.out.println(JSON.toJSONString(distributeCandiesLoop(7,4)));
        System.out.println(JSON.toJSONString(distributeCandiesDirectCal(7,4)));
        // 6 4 3 4
        // 2*1+(2-1)*4=6  2*2+(2-1)*4=8  2*3+(2-1)*4=10  2*4+(2-1)*4=12
        // totalCirNum =（10+0*4）= 10
        // add = （2-1）*4 = 4
        // add+2*1=6   remain = 17-6-totalCirNum+(2-1)*1=2
        // add+2*2=8   （2-1）*2 + remain > add ? add : reamin = 4  remain = remain > add ? remain - add : 0;
        // add+2*3=10   （2-1）*3 + 0 = 3
        // add+2*4=12
        System.out.println(JSON.toJSONString(distributeCandiesLoop(17,4)));
        System.out.println(JSON.toJSONString(distributeCandiesDirectCal(17,4)));
        // 10 8 10 12
        // totalCirNum = (10+0*4*4) + (10+1*4*4) = 36
        // add = (3-2)*4 = 4
        // lastAdd = (3-1)*4 = 8
        // 1. candis - totalCirNum = 4 < lastAdd + 1 ? add + (3-1)*1 + candis - totalCirNum : add + (3-1)*1 + lastAdd + 1
        // 2.
        System.out.println(JSON.toJSONString(distributeCandiesLoop(40,4)));
        System.out.println(JSON.toJSONString(distributeCandiesDirectCal(40,4)));
    }

    private static int[] distributeCandiesLoop(int candies, int num_people) {
        int[] result = new int[num_people];
        for (int count = 0; candies > 0; count++){
            int currentCount = count % num_people;
            result[currentCount] = result[currentCount] + ((count + 1) > candies ? candies : count + 1);
            candies -= (count + 1);
        }
        return result;
    }

    private static int[] distributeCandiesDirectCal(int candies, int num_people) {
        int[] result = new int[num_people];
        // 第一轮消耗糖果数
        int oneTurnTotal = 0;
        for (int i = 0; i < num_people; i++){
            oneTurnTotal += i + 1;
        }
        // 总轮数
        int turnNum = candies / oneTurnTotal + 1;
        // 除最后一轮外的总消耗数
        int totalCirNumExceptLast = 0;
        // 除最后一轮外总的累加数
        int totalAdd = 0;
        for (int i = 0; i < turnNum - 1;i++){
            if (totalCirNumExceptLast + oneTurnTotal + i * num_people * num_people > candies){
                turnNum = i + 1;
                break;
            }
            totalCirNumExceptLast += oneTurnTotal + i * num_people * num_people;
            totalAdd += i * num_people;
        }
        // 最后一轮累加数
        int lastAdd = (turnNum - 1) * num_people;
        // 剩余糖果数
        int remain = 0;
        // 计算最后一轮的第一个
        result[0] = candies - totalCirNumExceptLast < lastAdd + 1 ? totalAdd + (turnNum - 1) * 1 + candies - totalCirNumExceptLast : totalAdd + (turnNum - 1) * 1 + lastAdd + 1;
        remain = candies - totalCirNumExceptLast - lastAdd - 1;
        for (int i = 1; i < num_people; i++){
            result[i] = remain > lastAdd + (i + 1) ? totalAdd + (turnNum - 1) * (i + 1) + lastAdd + (i + 1) : totalAdd + (turnNum - 1) * (i + 1) + (remain > 0 ? remain : 0);
            remain -= lastAdd + (i + 1);
        }
        return result;
    }
}
