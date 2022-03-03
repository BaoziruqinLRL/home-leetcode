package com.yyhome.leetcode.easy;

/**
 * 13 罗马数字转整数
 * @author miluo
 * @date 2020-07-07
 */
public class RomanToInt {

    public static void main(String[] args){
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInt().romanToInt("LVIII"));
        System.out.println(new RomanToInt().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        for (int index = 0; index < s.length();){
            if (index < arr.length - 1 && arr[index] == 'I' && (arr[index + 1] == 'V' || arr[index + 1] == 'X')){
                if (arr[index + 1] == 'V'){
                    result += 4;
                }else{
                    result += 9;
                }
                index += 2;
            }else if (index < arr.length - 1 && arr[index] == 'X' && (arr[index + 1] == 'L' || arr[index + 1] == 'C')){
                if (arr[index + 1] == 'L'){
                    result += 40;
                }else{
                    result += 90;
                }
                index += 2;
            }else if (index < arr.length - 1 && arr[index] == 'C' && (arr[index + 1] == 'D' || arr[index + 1] == 'M')){
                if (arr[index + 1] == 'D'){
                    result += 400;
                }else{
                    result += 900;
                }
                index += 2;
            }else{
                switch (arr[index]){
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
                    default:
                        break;
                }
                index++;
            }
        }
        return result;
    }
}
