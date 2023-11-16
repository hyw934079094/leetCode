package houyw.java.myself.leetcode.two;

import houyw.common.utils.ArrayUtils;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/7/7 11:18
 * @Description:
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day = new Day1();
        //boolean happy = day.isHappy(19);
        //[[23,18,20,26,25],[24,22,3,4,4],[15,22,2,24,29],[18,15,23,28,28]]
        int[][] arrs = {{23, 18, 20, 26, 25}, {24, 22, 3, 4, 4}, {15, 22, 2, 24, 29}, {18, 15, 23, 28, 28}};
        // int[] ball = day.findBall(arrs);
        System.out.println(day.spiralOrder(arrs));

    }

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」?定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为?1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * 示例 1：
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 示例 2：
     * 输入：n = 2
     * 输出：false
     * 提示：
     * 1 <= n <= 231 - 1
     */
    public boolean isHappy(int n) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(n, 1);
        while (sum != 1 || n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
            if (n == 0) {
                if (sum == 1) {
                    break;
                }

                n = sum;
                sum = 0;
                if (map.getOrDefault(n, 0) == 1) {
                    return false;
                } else {
                    map.put(n, 1);
                }
            }

        }
        return true;
    }

    /**
     * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
     * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
     * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
     * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
     * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。
     * 如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
     * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，
     * 如果球卡在盒子里，则返回 -1 。
     * 示例 1：
     * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
     * 输出：[1,-1,-1,-1,-1]
     * 解释：示例如图：
     * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
     * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
     * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
     * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
     * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
     * 示例 2：
     * 输入：grid = [[-1]]
     * 输出：[-1]
     * 解释：球被卡在箱子左侧边上。
     * 示例 3：
     * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
     * 输出：[0,1,2,3,4,-1]
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * grid[i][j] 为 1 或 -1
     */

    public int[] findBall(int[][] grid) {
        int[] arr = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int index = findBall(grid, 0, i);
            if (index >= 0) {
                arr[i] = index;
            } else {
                arr[i] = -1;
            }
        }
        return arr;
    }


    public int findBall(int[][] grid, int x, int y) {
        //如果是1,则需要判断右边的挡板
        if (grid[x][y] == 1) {
            //判断右边的挡板
            if (y == grid[0].length - 1) {
                //最右边的话就掉不下去了
                return -1;
            } else {
                if (grid[x][y + 1] == -1) {
                    //V字型卡住
                    return -1;
                } else {
                    //往下一层走
                    if (x == grid.length - 1) {
                        //如果是最后一层则返回对应坐标
                        return y + 1;
                    } else {
                        return findBall(grid, x + 1, y + 1);
                    }
                }
            }
        } else {
            //如果是-1,则需要判断左边的挡板
            if (y == 0) {
                //最左边
                return -1;
            } else {
                //需要判断左边得挡板
                if (grid[x][y - 1] == 1) {
                    //V字型卡住
                    return -1;
                } else {
                    //往下一层走
                    if (x == grid.length - 1) {
                        //如果是最后一层则返回对应坐标
                        return y - 1;
                    } else {
                        return findBall(grid, x + 1, y - 1);
                    }
                }
            }
        }
    }


    /**
     * 给你一个 m 行 n 列的矩阵?matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * ?
     * <p>
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * [23,18,20,26,25,4,29,28,28,23,15,18,15,24,22,3,4,24,2,22]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        int x = 0;
        int y = 0;
        //1右2下3左4上
        int act = 1;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            list.add(matrix[x][y]);
            if (act == 1) {
                setX.add(x);
                if (y == matrix[x].length - 1 || setY.contains(y + 1)) {
                    act = 2;
                    x++;
                    continue;
                } else {
                    y++;
                }
            }
            if (act == 2) {
                setY.add(y);
                if (x == matrix.length - 1 || setX.contains(x + 1)) {
                    act = 3;
                    y--;
                    continue;
                } else {
                    x++;
                }
            }
            if (act == 3) {
                setX.add(x);
                if (y == 0 || setY.contains(y - 1)) {
                    act = 4;
                    x--;
                    continue;
                } else {
                    y--;
                }
            }
            if (act == 4) {
                setY.add(y);
                if (x == 0 || setX.contains(x - 1)) {
                    act = 1;
                    y++;
                    continue;
                } else {
                    x--;
                }
            }

        }
        return list;
    }

}
