package com.yyhome.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 71 简化路径
 * @author: lirl
 * @date: 2021/4/20
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home/"));
        System.out.println(new SimplifyPath().simplifyPath("/../"));
        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
    }

    /**
     * 执行耗时:6 ms,击败了50.25% 的Java用户
     * 内存消耗:38.7 MB,击败了35.12% 的Java用户
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        List<String> res = new ArrayList<>();
        String[] pathArr = path.split("/");
        for (int i = 1; i < pathArr.length; i++) {
            nextState(res, pathArr[i]);
        }
        return res.size() > 0 ? String.join("", res) : "/";
    }

    private void nextState(List<String> res, String nextStr) {
        switch (nextStr) {
            case "/":
            case "":
            case ".":
                break;
            case "..":
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                }
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                }
                break;
            default:
                res.add("/");
                res.add(nextStr);
                break;
        }
    }
}
