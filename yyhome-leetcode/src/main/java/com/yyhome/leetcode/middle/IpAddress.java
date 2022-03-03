package com.yyhome.leetcode.middle;

/**
 * ip地址验证 468
 * @author miluo
 * @date 2019-10-14
 */
public class IpAddress {

    public static void main(String[] args){
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIPAddress("1.1.1.1."));
        System.out.println(validIPAddress("01.01.01.01."));
        System.out.println(validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("15.16.-0.1"));
        System.out.println(validIPAddress("192.0.0.1"));
    }

    private static String validIPAddress(String IP) {
        if (IP.contains(".") && IP.lastIndexOf(".") != IP.length() - 1 && IP.indexOf(".") != 0){
            String[] ipArr = IP.split("\\.");
            if (ipArr.length != 4){
                return "Neither";
            }
            for (String ip : ipArr){
                if (!isIPv4Int(ip)){
                    return "Neither";
                }
            }
            return "IPv4";
        }else if (IP.contains(":") && IP.lastIndexOf(":") != IP.length() - 1 && IP.indexOf(":") != 0){
            String[] ipArr = IP.split(":");
            if (ipArr.length != 8){
                return "Neither";
            }
            for (String ip : ipArr){
                if (!isIPv6Part(ip)){
                    return "Neither";
                }
            }
            return "IPv6";
        }else{
            return "Neither";
        }
    }

    private static boolean isIPv4Int(String ip){
        try{
            if ((ip.charAt(0) == '0' && ip.length() > 1) || ip.charAt(0) == '-'){
                return false;
            }
            int intIp = Integer.parseInt(ip);
            if (intIp < 0 || intIp > 255){
                return false;
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private static boolean isIPv6Part(String ip){
        if (ip.length() > 4 || ip.length() < 1){
            return false;
        }
        for (char c : ip.toCharArray()){
            boolean legalC = (c >= '0' && c <= '9') || (c >= 'a' && c <='f') || (c >= 'A' && c <= 'F');
            if (!legalC){
                return false;
            }
        }
        return true;
    }
}
