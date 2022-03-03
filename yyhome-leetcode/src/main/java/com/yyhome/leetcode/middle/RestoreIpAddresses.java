package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 复原IP地址
 * @author: lirl
 * @date: 2021/5/8
 */
public class RestoreIpAddresses {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new RestoreIpAddresses().restoreIpAddresses("25525511135")));
        System.out.println(JSON.toJSONString(new RestoreIpAddresses().restoreIpAddresses("0000")));
        System.out.println(JSON.toJSONString(new RestoreIpAddresses().restoreIpAddresses("1111")));
        System.out.println(JSON.toJSONString(new RestoreIpAddresses().restoreIpAddresses("010010")));
        System.out.println(JSON.toJSONString(new RestoreIpAddresses().restoreIpAddresses("101023")));
    }

    /**
     * 执行耗时:1 ms,击败了99.93% 的Java用户
     * 内存消耗:38.3 MB,击败了75.65% 的Java用户
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        back(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private void back(List<String> res, StringBuilder sb, String s, int index, int size) {
        if (size == 4 && index == s.length()) {
            res.add(sb.substring(1));
        } else if (size < 4) {
            for (int j = 1; j <= 3 && index + j <= s.length(); j++) {
                String v = s.substring(index, index+j);
                if (s.length() - index - j <= (3 - size) * 3 && isValid(v)){
                    sb.append('.').append(v);
                    back(res, sb, s, index+j, size+1);
                    sb.delete(sb.length() - v.length(), sb.length());
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        } else if (s.length() == 3 &&
                (s.charAt(0) > '2' ||
                        (s.charAt(0) == '2' && (s.charAt(1) > '5' || (s.charAt(1) == '5' && s.charAt(2) >'5'))))) {
            return false;
        }
        return true;
    }
}
