package com.yyhome.leetcode.easy;

/**
 * 415 字符串相加
 * @author: lirl
 * @date: 2021/3/24
 */
public class AddStrings {

    public static void main(String[] args){
        System.out.println(new AddStrings().addStrings("2345", "78901234"));
        System.out.println(new AddStrings().addStrings("1", "2"));
        System.out.println(new AddStrings().addStrings("10000", "90000"));
    }

    /**
     * 执行耗时:10 ms,击败了8.71% 的Java用户
     * 内存消耗:39 MB,击败了6.09% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        if (num1.length() < num2.length()){
            int size = num2.length() - num1.length();
            for (int i = 0; i < size; i++){
                num1 = "0" + num1;
            }
        }else if (num2.length() < num1.length()){
            int size = num1.length() - num2.length();
            for (int i = 0; i < size; i++){
                num2 = "0" + num2;
            }
        }
        int plus = 0;
        for (int i = 0; i < num1.length(); i++){
            int plusRes = num1.charAt(num1.length() - i - 1) - '0' + num2.charAt(num2.length() - i - 1) - '0' + plus;
            sb.insert(0, plusRes >= 10 ? (char) (plusRes - 10 + '0') : (char) (plusRes + '0'));
            plus = plusRes >= 10 ? 1 : 0;
        }
        if (plus == 1){
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
