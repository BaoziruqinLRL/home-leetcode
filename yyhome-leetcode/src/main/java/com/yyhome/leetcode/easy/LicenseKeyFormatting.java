package com.yyhome.leetcode.easy;

/**
 * 482 密钥格式化
 * @author: lirl
 * @date: 2021/3/25
 */
public class LicenseKeyFormatting {

    public static void main(String[] args){
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("---", 3));
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
    }

    /**
     * 执行耗时:17 ms,击败了53.80% 的Java用户
     * 内存消耗:39.3 MB,击败了11.48% 的Java用户
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        if (S.length() == 0){
            return "";
        }
        int min = S.length() % K == 0 ? K : S.length() % K;
        StringBuilder sb = new StringBuilder();
        sb.append(S, 0, min);
        for (int i = min; i < S.length(); i+=K){
            sb.append("-");
            sb.append(S, i, i + K);
        }
        return sb.toString();
    }
}
