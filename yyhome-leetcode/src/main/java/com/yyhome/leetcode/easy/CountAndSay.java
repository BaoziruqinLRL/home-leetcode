package com.yyhome.leetcode.easy;

/**
 * 38 外观数列
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
    }

    /**
     * 执行耗时:2 ms,击败了77.75% 的Java用户
     * 内存消耗:36.1 MB,击败了67.37% 的Java用户
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return to("1", n, 0);
    }

    private String to(String current, int n, int index) {
        if (index == 0) {
            return to(current,n,index + 1);
        }else if (index == n){
            return current;
        } else{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < current.length();i++){
                int count = 1;
                while (i + 1 < current.length() && current.charAt(i + 1) == current.charAt(i)){
                    count++;
                    i++;
                }
                sb.append(count).append(current.charAt(i));
            }
            return to(sb.toString(), n, index + 1);
        }
    }
}
