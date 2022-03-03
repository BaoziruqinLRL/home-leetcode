package com.yyhome.leetcode.easy;

/**
 * 67 二进制求和
 * @author miluo
 * @date 2020-07-09
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary2("11","1"));
        System.out.println(new AddBinary().addBinary2("1010","1011"));
        System.out.println(new AddBinary().addBinary2("1111","1111"));
        System.out.println(new AddBinary().addBinary2("0","0"));
    }

    /**
     * 执行耗时:3 ms,击败了59.77% 的Java用户
     * 内存消耗:39.8 MB,击败了7.69% 的Java用户
     * 真辣鸡。。。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] aAr = a.toCharArray();
        char[] bAr = b.toCharArray();
        int aIn = aAr.length - 1;
        int bIn = bAr.length - 1;
        char[] res = aAr.length > bAr.length ? aAr : bAr;
        int resIn = aAr.length > bAr.length ? aAr.length - 1 : bAr.length - 1;
        int move = 0;
        while (aIn >= 0 || bIn >= 0){
            int plusRes = (aIn >= 0 ? Integer.valueOf(String.valueOf(aAr[aIn])) : 0) + (bIn >= 0 ? Integer.valueOf(String.valueOf(bAr[bIn])) : 0) + move;
            res[resIn--] = plusRes % 2 == 0 ? '0' : '1';
            move = plusRes > 1 ? 1 : 0;
            aIn--;
            bIn--;
        }
        if (move == 1){
            char[] newRes = new char[res.length + 1];
            newRes[0] = '1';
            System.arraycopy(res,0,newRes,1,res.length);
            return String.valueOf(newRes);
        }
        return String.valueOf(res);
    }

    /**
     * 执行耗时:2 ms,击败了98.61% 的Java用户
     * 内存消耗:38.5 MB,击败了7.69% 的Java用户
     * 稍微好一点了吧。。
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a,String b){
        StringBuilder sb = new StringBuilder();
        int move = 0;
        int aIn = a.length() - 1;
        int bIn = b.length() - 1;
        while (aIn >= 0 || bIn >= 0){
            int plusRes = (aIn >= 0 ? a.charAt(aIn) - '0' : 0) + (bIn >= 0 ? b.charAt(bIn) - '0' : 0) + move;
            sb.append(plusRes % 2);
            move = plusRes / 2;
            aIn--;
            bIn--;
        }
        if (move == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
