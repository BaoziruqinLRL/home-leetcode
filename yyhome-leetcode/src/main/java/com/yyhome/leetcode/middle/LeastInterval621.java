package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: liriling
 * @Date: 2025/3/18 10:11
 */
public class LeastInterval621 {

    public static void main(String[] args) {
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','C','D'}, 1));
    }

    /**
     * 执行耗时:2 ms,击败了80.96% 的Java用户
     * 内存消耗:45 MB,击败了39.82% 的Java用户
     *
     * 先排序，从数量最多的进行排，以'A','A','A','B','C','D'  1为例，先处理A得
     * A blank A blank A
     * 之后按照由大到小数量在blank中进行填充，如填B得
     * A B A blank A
     * 再填C
     * A B A C A
     * 最后blank没有了之后，剩下的所有任务都可以在A A中间寻到位置插入
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int blank = (count[25] - 1) * n;
        int max = count[25] + blank;
        for (int i = 24; i >= 0; i--) {
            if (blank <= 0) {
                // blank使用完之后，所有的任务都可以正常插入到间隔中
                max += count[i];
            } else {
                // 每次插入最多使用最大值-1个间隔，因为已经对任务数量进行严格排序，任务数量最多比间隔数大1，多的这一个插入在队列尾部
                int maxUse = Math.min(count[25] - 1, blank);
                int use = Math.min(count[i], maxUse);
                max += Math.max(0, count[i] - maxUse);
                blank -= use;
            }
        }
        return max;
    }
}
