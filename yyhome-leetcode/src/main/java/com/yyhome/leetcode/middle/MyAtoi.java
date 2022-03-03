package com.yyhome.leetcode.middle;

/**
 * 8. 字符串转换整数 (atoi)
 * @author miluo
 * @date 2020-04-03
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("42"));
        System.out.println(new MyAtoi().myAtoi("    -42"));
        System.out.println(new MyAtoi().myAtoi("4193 with words"));
        System.out.println(new MyAtoi().myAtoi("words and 987"));
        System.out.println(new MyAtoi().myAtoi("-91283472332"));
        System.out.println(new MyAtoi().myAtoi("0032"));
        System.out.println(new MyAtoi().myAtoi("-32"));
        System.out.println(new MyAtoi().myAtoi("+-32"));
        System.out.println(new MyAtoi().myAtoi("-0032"));
        System.out.println(new MyAtoi().myAtoi("+1"));
        System.out.println(new MyAtoi().myAtoi("000000-42aaaa"));
        System.out.println(new MyAtoi().myAtoi("20000000000000000000"));
    }

    /**
     * 有限状态机的表达数组
     *        -/+   other   空格    0~9
     * start  char   end    start  number
     * char   end    end    end    number
     * number end    end    end    number
     * end    end    end    end    end
     * 以数字来表达，start为0，char为1，number为2，end为3 得出状态机表达数组
     */
    private int[][] stateMachine = new int[][]{{1,3,0,2}, {3,3,3,2},{3,3,3,2},{3,3,3,3}};

    /**
     * 执行耗时:3 ms,击败了47.70% 的Java用户
     * 内存消耗:38.6 MB,击败了39.87% 的Java用户
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        long res = 0;
        int sign = 1;
        int state = 0;
        for (char c : s.toCharArray()){
            int index = charToInt(c);
            state = stateMachine[state][index];
            if (state == 2){
                res = res * 10 + (c - '0');
                res = Math.min(res, (long) Integer.MAX_VALUE + 1);
            }
            if (state == 1){
                sign = c == '-' ? -1 : 1;
            }
            if (state == 3){
                break;
            }
        }
        return (int) (sign == 1 ? (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res) : -res);
    }

    private int charToInt(char c){
        if (c == '-' || c == '+'){
            return 0;
        } else if (c == ' '){
            return 2;
        } else if (c >= '0' && c <= '9'){
            return 3;
        } else {
            return 1;
        }
    }
}
