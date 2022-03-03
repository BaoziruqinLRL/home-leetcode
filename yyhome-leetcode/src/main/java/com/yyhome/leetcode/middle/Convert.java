package com.yyhome.leetcode.middle;

/**
 * 6 Z字型变换
 * @author: lirl
 * @date: 2021/4/7
 */
public class Convert {

    public static void main(String[] args){
        System.out.println(new Convert().convert("A", 1));
        System.out.println(new Convert().convert("PAYPALISHIRING", 3));
        System.out.println(new Convert().convert("PAYPALISHIRING", 4));
    }

    /**
     * 3ms 98%
     * 38.8MB 74%
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int splitLength = 2 * numRows - 2;
        for (int r = 0; r < numRows; r++){
            int index = r;
            if (r == 0 || r == numRows - 1) {
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index = index + splitLength;
                }
            } else {
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    if (index + splitLength - 2 * r < s.length()){
                        sb.append(s.charAt(index + splitLength - 2 * r));
                    }
                    index = index + splitLength;
                }
            }
        }
        return sb.toString();
    }
}
