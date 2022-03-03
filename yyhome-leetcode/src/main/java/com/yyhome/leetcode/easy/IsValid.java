package com.yyhome.leetcode.easy;

/**
 * 20 有效的括号
 * @author miluo
 * @date 2020-07-07
 */
public class IsValid {
    public static void main(String[] args){
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        char[] strArr = s.toCharArray();
        char[] arr = new char[s.length()];
        int arrIndex = -1;
        for (int index = 0;index < s.length();index++){
            if (strArr[index] == ')' && arrIndex >= 0){
                if (arr[arrIndex] == '('){
                    arrIndex--;
                }else{
                    arr[++arrIndex] = strArr[index];
                }
            }else if (strArr[index] == ']' && arrIndex >= 0){
                if (arr[arrIndex] == '['){
                    arrIndex--;
                }else{
                    arr[++arrIndex] = strArr[index];
                }
            }else if (strArr[index] == '}' && arrIndex >= 0){
                if (arr[arrIndex] == '{'){
                    arrIndex--;
                }else{
                    arr[++arrIndex] = strArr[index];
                }
            }else{
                arr[++arrIndex] = strArr[index];
            }
        }
        return arrIndex < 0;
    }
}
