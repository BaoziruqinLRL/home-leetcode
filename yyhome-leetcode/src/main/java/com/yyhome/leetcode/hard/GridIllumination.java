package com.yyhome.leetcode.hard;

import java.util.*;

/**
 * 网格照明,  gridIllumination3是最优解 1001
 * @author miluo
 * @date 2019-10-15
 */
public class GridIllumination {

    public static void main(String[] args) {
        /**
         * 1 1 1 1 1
         * 1 1 0 0 1
         * 1 0 1 0 1
         * 1 0 0 1 1
         * 1 1 1 1 1
         *
         * 1 0 0 0 1
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 1 0 0 0 1
         *
         *
         * 1 2 3 4 5
         * 6 7 8 9 10
         * 11 12 13 14 15
         * 16 17 18 19 20
         * 21 22 23 24 25
         *
         * [0,0] [0,1] [0,2] [0,3] [0,4]
         * [1,0] [1,1] [1,2] [1,3] [1,4]
         * [2,0] [2,1] [2,2] [2,3] [2,4]
         * [3,0] [3,1] [3,2] [3,3] [3,4]
         * [4,0] [4,1] [4,2] [4,3] [4,4]
         */
//        System.out.println(Arrays.toString(gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1,4}})));
        System.out.println(Arrays.toString(gridIllumination3(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}, {1,4}})));
//        System.out.println(Arrays.toString(gridIllumination(100,new int[][]{{7,55},{53,61},{2,82},{67,85},{81,75},{38,91},{68,0},{60,43},{40,19},{12,75},{26,2},{24,89},{42,81},{60,58},{77,72},{33,24},{19,93},{7,16},{58,54},{78,57},{97,49},{65,16},{42,75},{90,50},{89,34},{76,97},{58,23},{62,47},{94,28},{88,65},{3,87},{81,10},{12,81},{44,81},{54,92},{90,54},{17,54},{27,82},{48,15},{8,46},{4,99},{15,13},{90,77},{2,87},{18,33},{52,90},{4,95},{57,61},{31,22},{32,8},{49,26},{24,65},{88,55},{88,38},{64,76},{94,76},{59,12},{41,46},{80,28},{38,36},{65,67},{75,37},{56,97},{83,57},{2,4},{44,43},{71,90},{62,40},{79,94},{81,11},{96,34},{38,11},{22,3},{54,96},{78,33},{54,54},{79,98},{1,28},{0,32},{37,11}},
//                new int[][]{{24,84},{95,68},{80,35},{31,53},{69,45},{85,29},{87,25},{42,47},{7,59},{99,3},{31,70},{64,62},{44,91},{55,25},{15,52},{95,33},{21,29},{61,34},{93,34},{79,27},{30,86},{52,0},{18,10},{5,1},{40,21},{11,48},{55,94},{22,42},{81,0},{39,43},{5,25},{43,29},{45,47},{83,93},{77,70},{22,63},{30,73},{18,48},{39,88},{91,47}})));
        System.out.println(Arrays.toString(gridIllumination3(100,new int[][]{{7,55},{53,61},{2,82},{67,85},{81,75},{38,91},{68,0},{60,43},{40,19},{12,75},{26,2},{24,89},{42,81},{60,58},{77,72},{33,24},{19,93},{7,16},{58,54},{78,57},{97,49},{65,16},{42,75},{90,50},{89,34},{76,97},{58,23},{62,47},{94,28},{88,65},{3,87},{81,10},{12,81},{44,81},{54,92},{90,54},{17,54},{27,82},{48,15},{8,46},{4,99},{15,13},{90,77},{2,87},{18,33},{52,90},{4,95},{57,61},{31,22},{32,8},{49,26},{24,65},{88,55},{88,38},{64,76},{94,76},{59,12},{41,46},{80,28},{38,36},{65,67},{75,37},{56,97},{83,57},{2,4},{44,43},{71,90},{62,40},{79,94},{81,11},{96,34},{38,11},{22,3},{54,96},{78,33},{54,54},{79,98},{1,28},{0,32},{37,11}},
                new int[][]{{24,84},{95,68},{80,35},{31,53},{69,45},{85,29},{87,25},{42,47},{7,59},{99,3},{31,70},{64,62},{44,91},{55,25},{15,52},{95,33},{21,29},{61,34},{93,34},{79,27},{30,86},{52,0},{18,10},{5,1},{40,21},{11,48},{55,94},{22,42},{81,0},{39,43},{5,25},{43,29},{45,47},{83,93},{77,70},{22,63},{30,73},{18,48},{39,88},{91,47}})));
        System.out.println("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1]");
//        System.out.println(Arrays.toString(gridIllumination2(5, new int[][]{{0, 0}, {4, 4},{1,1},{1,3}}, new int[][]{{0, 2}, {1,2},{2,1}, {2, 0}, {2,4}, {2,2},{4,2}})));
        System.out.println(Arrays.toString(gridIllumination3(1000000000, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}})));
    }

    private static int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];
        int resultIndex = 0, index = 0;
        int[] closeIndex = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        boolean isLighted = false;
        for (int[] point : queries) {
            for (int i = 0; i < lamps.length; i++) {
                if (lamps[i][0] == -1){
                    continue;
                }
                int[] light = lamps[i];
                if (Math.abs(point[0] - light[0]) <= 1 && Math.abs(point[1] - light[1]) <= 1) {
                    // 灯在关闭范围内
                    closeIndex[index++] = i;
                }
                if (!isLighted) {
                    // 若未被照亮, 继续搜索
                    if (point[0] == light[0] || point[1] == light[1] ||
                            (Math.abs(point[0] - light[0]) == Math.abs(point[1] - light[1]))) {
                        // 在灯照范围内, 关闭周围的灯
                        isLighted = true;
                    }
                }else{
                    // 如果被照亮了, 且关灯数达到9, 则不再搜索
                    if (index == 9){
                        break;
                    }
                }
            }
            result[resultIndex++] = isLighted ? 1 : 0;
            // 关灯且复原closeIndex
            for (int i = 0; i < closeIndex.length;i++) {
                int in = closeIndex[i];
                if (in != -1 && isLighted) {
                    lamps[in][0] = -1;
                    lamps[in][1] = -1;
                }
                closeIndex[i] = -1;
            }
            // 变量复原
            index = 0;
            isLighted = false;
        }
        return result;
    }

    private static int[] gridIllumination2(int N, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];
        int resultIndex = 0;
        // 竖路径和坐斜到顶上和右斜到顶上的路径
        int[][] lightPathRow = new int[N][3];
        // 横路径和左斜到左边的路径
        int[][] lightPathCow = new int[N][2];
        // 右斜到右边的路径
        int[] lightPathRight = new int[N];
        Set<Integer> lampsSet = new HashSet<>(lamps.length);
        for (int[] la : lamps) {
            // 计算四条路径, 横竖左斜右斜, 并从上起点开始加入路径列表
            // 竖路径
            ++lightPathRow[getNumByWay(la, N, 1)][0];
            // 横路径
            ++lightPathCow[getNumByWay(la, N, 2)][0];
            if (la[0] > la[1]){
                // 左斜到左边
                ++lightPathCow[getNumByWay(la,N,3)][1];
            }else{
                // 左斜到顶上
                ++lightPathRow[getNumByWay(la,N,3)][1];
            }
            if (la[0] + la[1] < N - 1){
                // 右斜到顶上
                ++lightPathRow[getNumByWay(la, N, 4)][2];
            }else{
                // 右斜到右边
                ++lightPathRight[getNumByWay(la, N, 4)];
            }
            lampsSet.add(getNum(la, N));
        }
        for (int[] point : queries) {
            if (lightPathRow[getNumByWay(point,N,1)][0] > 0 ||
                    lightPathCow[getNumByWay(point,N,2)][0] > 0 ||
                    (point[0] > point[1] ? lightPathCow[getNumByWay(point,N,3)][1] > 0 : lightPathRow[getNumByWay(point,N,3)][1] > 0) ||
                    (point[0] + point[1] < N - 1 ? lightPathRow[getNumByWay(point, N, 4)][2] > 0 : lightPathRight[getNumByWay(point, N, 4)] > 0)){
                // 被照亮，进行关灯
                int closeNum;
                int[] closePoint;
                for (int x = -1; x < 2;x++){
                    for (int y = -1;y < 2;y++){
                        closePoint = new int[]{point[0] + x,point[1] + y};
                        if (closePoint[0] >= 0 && closePoint[0] < N && closePoint[1] >= 0 && closePoint[1] < N) {
                            if (lampsSet.contains(closeNum = getNum(closePoint,N))){
                                // 周边某一点是灯，则关灯
                                lampsSet.remove(closeNum);
                                // 移除灯照路径
                                // 竖路径
                                --lightPathRow[getNumByWay(closePoint, N, 1)][0];
                                // 横路径
                                --lightPathCow[getNumByWay(closePoint, N, 2)][0];
                                if (closePoint[0] > closePoint[1]){
                                    // 左斜到左边
                                    --lightPathCow[getNumByWay(closePoint,N,3)][1];
                                }else{
                                    // 左斜到顶上
                                    --lightPathRow[getNumByWay(closePoint,N,3)][1];
                                }
                                if (closePoint[0] + closePoint[1] < N - 1){
                                    // 右斜到顶上
                                    --lightPathRow[getNumByWay(closePoint, N, 4)][2];
                                }else{
                                    // 右斜到右边
                                    --lightPathRight[getNumByWay(closePoint, N, 4)];
                                }
                            }
                        }
                    }
                }
                result[resultIndex++] = 1;
            }else{
                result[resultIndex++] = 0;
            }
        }
        return result;
    }

    private static int getNumByWay(int[] position, int length, int way){
        int num = 0;
        if (way == 1){
            // 竖
            num = position[1];
        }else if (way == 2){
            // 横
            num = position[0];
        }else if (way == 3){
            // 左斜
            num = Math.abs(position[0] - position[1]);
        }else if (way == 4){
            // 右斜
            boolean pointLeft = (position[0] + position[1]) < length - 1;
            num = pointLeft ? position[0] + position[1] : position[0] + position[1] - length + 1;
        }
        return num;
    }

    private static int getNum(int[] position, int length){
        return (length * position[0]) + position[1];
    }

    private static int[] gridIllumination3(int N, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        Map<Integer,Integer> rowMap = new HashMap<>(lamps.length);
        Map<Integer,Integer> cowMap = new HashMap<>(lamps.length);
        Map<Integer,Integer> leftMap = new HashMap<>(lamps.length);
        Map<Integer,Integer> rightMap = new HashMap<>(lamps.length);
        Set<Integer> sets = new HashSet<>();
        for (int[] la : lamps){
            rowMap.put(la[1],rowMap.containsKey(la[1]) ? rowMap.get(la[1]) + 1 : 1);
            cowMap.put(la[0],cowMap.containsKey(la[0]) ? cowMap.get(la[0]) + 1 : 1);
            int leftPoint = la[0] - la[1];
            leftMap.put(leftPoint,leftMap.containsKey(leftPoint) ? leftMap.get(leftPoint) + 1 : 1);
            int rightPoint = la[0] + la[1];
            rightMap.put(rightPoint,rightMap.containsKey(rightPoint) ? rightMap.get(rightPoint) + 1 : 1);
            sets.add(N * la[0] + la[1]);
        }
        for (int[] qu : queries){
            if ((rowMap.containsKey(qu[1]) && rowMap.get(qu[1]) > 0) ||
                (cowMap.containsKey(qu[0]) && cowMap.get(qu[0]) > 0) ||
                (leftMap.containsKey(qu[0] - qu[1]) && leftMap.get(qu[0] - qu[1]) > 0) ||
                (rightMap.containsKey(qu[0] + qu[1]) && rightMap.get(qu[0] + qu[1]) > 0)){
                // 灯照范围内, 关周围的灯
                for (int x = -1; x < 2; x++){
                    for (int y = -1; y < 2; y++){
                        int[] handlePoint = new int[]{qu[0] + x, qu[1] + y};
                        if (!(handlePoint[0] < 0 || handlePoint[0] >= N || handlePoint[1] < 0 || handlePoint[1] >= N)){
                            // 处在网格内
                            Integer handlePointNum = N * handlePoint[0] + handlePoint[1];
                            if (sets.contains(handlePointNum)){
                                sets.remove(handlePointNum);
                                // 如果是要关的灯,则移除其光照路径
                                rowMap.put(handlePoint[1],rowMap.get(handlePoint[1]) - 1);
                                cowMap.put(handlePoint[0],cowMap.get(handlePoint[0]) - 1);
                                leftMap.put(handlePoint[0] - handlePoint[1],leftMap.get(handlePoint[0] - handlePoint[1]) - 1);
                                rightMap.put(handlePoint[0] + handlePoint[1], rightMap.get(handlePoint[0] + handlePoint[1]) - 1);
                            }
                        }
                    }
                }
                result[index++] = 1;
            }else{
                result[index++] = 0;
            }
        }
        return result;
    }
}
