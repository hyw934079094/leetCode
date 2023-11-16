package houyw.java.myself.leetcode.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/13 17:38
 * @Description:
 */
public class Day10 {
    public static void main(String[] args) {
        Day10 day = new Day10();
        //int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] heights = {{2, 1}, {1, 2}};
        List<List<Integer>> lists = day.pacificAtlantic(heights);
        System.out.println(lists);
    }

    /**
     * 在给定的?m x n?网格?grid?中，每个单元格可以有以下三个值之一：
     * 值?0?代表空单元格；
     * 值?1?代表新鲜橘子；
     * 值?2?代表腐烂的橘子。
     * 每分钟，腐烂的橘子?周围?4 个方向上相邻 的新鲜橘子都会腐烂。
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回?-1?。
     * 示例 1：
     * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
     * 221     222     222    222
     * 210     220     220    220
     * 011     011     021    022
     * 输出：4
     * 示例 2：
     * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * 示例 3：
     * 输入：grid = [[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 10
     * grid[i][j] 仅为?0、1?或?2
     */
    public int orangesRotting(int[][] grid) {
        int time = 0;
        List<int[]> ints = orangesRotting(grid, new ArrayList<int[]>());
        if (ints.size() != 0) {
            while (ints.size() > 0) {
                time++;
                ints = orangesRotting(grid, ints);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public List<int[]> orangesRotting(int[][] grid, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            grid[list.get(i)[0]][list.get(i)[1]] = 2;
        }
        list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //上面
                    if (i > 0 && grid[i - 1][j] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //左边
                    if (j > 0 && grid[i][j - 1] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //下边
                    if (i < grid.length - 1 && grid[i + 1][j] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //右边
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                }
            }
        }
        return list;
    }


    /**
     * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。?
     * “太平洋”?处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
     * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵?heights?，?
     * heights[r][c]?表示坐标 (r, c) 上单元格 高于海平面的高度 。
     * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。
     * 水可以从海洋附近的任何单元格流入海洋。
     * 返回网格坐标 result?的 2D 列表 ，其中?result[i] = [ri, ci]?表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
     * 示例 1：
     * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
     * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
     * 示例 2：
     * 输入: heights = [[2,1],[1,2]]
     * 输出: [[0,0],[0,1],[1,0],[1,1]]
     * 提示：
     * m == heights.length
     * n == heights[r].length
     * 1 <= m, n <= 200
     * 0 <= heights[r][c] <= 105
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] one = new int[heights.length][heights[0].length];
        int[][] two = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (i == 0 || j == 0) {
                    pacificAtlantic(one, i, j, heights);
                }
                if (i == heights.length - 1 || j == heights[i].length - 1) {
                    pacificAtlantic(two, i, j, heights);
                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (one[i][j] == 1 && two[i][j] == 1) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    lst.add(j);
                    list.add(lst);
                }
            }
        }
        return list;
    }

    public void pacificAtlantic(int[][] arr, int i, int j, int[][] heights) {
        arr[i][j] = 1;
        if (i > 0 && heights[i - 1][j] >= heights[i][j] && arr[i - 1][j] == 0) {
            pacificAtlantic(arr, i - 1, j, heights);
        }
        if (i < heights.length - 1 && heights[i + 1][j] >= heights[i][j] && arr[i + 1][j] == 0) {
            pacificAtlantic(arr, i + 1, j, heights);
        }

        if (j > 0 && heights[i][j - 1] >= heights[i][j] && arr[i][j - 1] == 0) {
            pacificAtlantic(arr, i, j - 1, heights);
        }
        if (j < heights[0].length - 1 && heights[i][j + 1] >= heights[i][j] && arr[i][j + 1] == 0) {
            pacificAtlantic(arr, i, j + 1, heights);
        }
    }
}
