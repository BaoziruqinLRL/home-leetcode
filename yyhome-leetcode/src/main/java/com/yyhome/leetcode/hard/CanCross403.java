package com.yyhome.leetcode.hard;

/**
 * @Author: liriling
 * @Date: 2025/5/16 9:06
 */
public class CanCross403 {

    public static void main(String[] args) {
        System.out.println(new CanCross403().canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(new CanCross403().canCross(new int[]{0,1,2,3,4,8,9,11}));
    }

    /**
     * 执行耗时:11 ms,击败了96.71% 的Java用户
     * 内存消耗:58.8 MB,击败了19.75% 的Java用户
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        // dp[i][j]表示从第i块石头跳到第j块石头，最后是否能到达终点
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        return cycle(dp, stones, 1, 1);
    }

    private boolean cycle(Boolean[][] dp, int[] stones, int currentStep, int currentIndex) {
        if (currentIndex == stones.length - 1) {
            return true;
        }
        for (int plus = -1; plus <= 1; plus++) {
            int willStep = currentStep + plus;
            if (willStep > 0) {
                for (int j = currentIndex + 1; j < stones.length; j++) {
                    if (stones[currentIndex] + willStep < stones[j]) {
                        break;
                    }
                    if (stones[currentIndex] + willStep == stones[j]) {
                        if (dp[currentIndex][j] == null) {
                            boolean result = cycle(dp, stones, willStep, j);
                            if (result) {
                                return true;
                            } else {
                                dp[currentIndex][j] = false;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
}
