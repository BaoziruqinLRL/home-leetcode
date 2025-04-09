package com.yyhome.leetcode.hard;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liriling
 * @Date: 2025/4/8 16:00
 */
public class AddOperators282 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("2147483648", -2147483648)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("105", 5)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("12034", 69)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("12034", 154)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("12034", 46)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("123", 6)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("232", 8)));
        System.out.println(JSON.toJSONString(new AddOperators282().addOperators("3456237490", 9191)));
    }

    /**
     * 执行耗时:138 ms,击败了22.45% 的Java用户
     * 内存消耗:44.9 MB,击败了6.12% 的Java用户
     * @param num
     * @param target
     * @return
     */
    public List<String> addOperators(String num, int target) {
        if (num.length() == 1 && num.charAt(0) == target + '0') {
            return new ArrayList<String>() {{
                add(num);
            }};
        }
        List<String> res = new ArrayList<>();
        // 数组记录前面数值 0=累加数 1=后置符号[正或负] 2=乘法乘数 3=乘法被乘数[被乘数会因为不选择符号而不断累加成为大数]
        cycle(res, "", num, target, new long[]{0, 1, 1, 0}, 0);
        return res;
    }

    public void cycle(List<String> res, String sb, String num, int target, long[] calArray, int index) {
        if (index == num.length()) {
            if (calArray[0] + calArray[1] * calArray[2] * calArray[3] == target) {
                res.add(sb);
            }
            return;
        }
        long o0 = calArray[0], o1 = calArray[1], o2 = calArray[2], o3 = calArray[3];
        int current = num.charAt(index) - '0';
        if (index == num.length() - 1) {
            calArray[3] = calArray[3] * 10 + current;
            sb += num.charAt(index);
            cycle(res, sb, num, target, calArray, index + 1);
        } else {
            sb += num.charAt(index);
            // +. 把之前的累加数和乘法进行计算，最终归到累加数中，并重置乘数和被乘数
            calArray[0] = o0 + o1 * o2 * (o3 * 10 + current);
            calArray[1] = 1;
            calArray[2] = 1;
            calArray[3] = 0;
            cycle(res, sb + '+', num, target, calArray, index + 1);
            // - 把之前的累加数和乘法进行计算，最终归到累加数中，并重置乘数和被乘数
            calArray[0] = o0 + o1 * o2 * (o3 * 10 + current);
            calArray[1] = -1;
            calArray[2] = 1;
            calArray[3] = 0;
            cycle(res, sb + "-", num, target, calArray, index + 1);
            // * 仅把乘数和被乘数进行计算并归到乘数上，并重置被乘数
            calArray[0] = o0;
            calArray[1] = o1;
            calArray[2] = o2 * (o3 * 10 + current);
            calArray[3] = 0;
            cycle(res, sb + '*', num, target, calArray, index + 1);
            if (current != 0 || o3 != 0) {
                // 不取 只累加被乘数，其他不变
                calArray[0] = o0;
                calArray[1] = o1;
                calArray[2] = o2;
                calArray[3] = o3 * 10 + current;
                cycle(res, sb, num, target, calArray, index + 1);
            }
        }
    }
}
