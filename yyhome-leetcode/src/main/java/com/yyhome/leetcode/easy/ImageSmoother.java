package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 661 图片平滑器
 * @author: lirl
 * @date: 2021/3/31
 */
public class ImageSmoother {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ImageSmoother().imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
    }

    /**
     * 执行耗时:9 ms,击败了63.88% 的Java用户
     * 内存消耗:39.4 MB,击败了73.91% 的Java用户
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][];
        for (int r = 0; r < R; ++r)
        {
            ans[r] =new  int[C];
            for (int c = 0; c < C; ++c)
            {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                {
                    for (int nc = c-1; nc <=c+1; ++nc)
                    {
                        if (0<=nr&&nr<R&&0<=nc&&nc<C)
                        {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }

                }
                ans[r][c] /= count;
            }
        }
        return ans;
    }
}
