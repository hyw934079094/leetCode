package houyw.java.myself.leetcode.one;

/**
 * @Author: DELL
 * @Date: 2022/7/1 10:14
 * @Description:
 */
public class Day8 {
    public static void main(String[] args) {
        Day8 day = new Day8();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(day.numIslands(grid));
    }

    /**
     * 给你一个由?'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * 示例 1：
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    public int numIslands(char[][] grid) {
        char max = '2';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands(grid, i, j, max);
                    max++;
                }
            }
        }
        return max-50;
    }

    public void numIslands(char[][] grid, int x, int y, char target) {
        grid[x][y] = target;
        //向上
        if (x > 0 && grid[x - 1][y] == '1') {
            numIslands(grid, x - 1, y, target);
        }
        //向下
        if (x < grid.length-1 && grid[x + 1][y] == '1') {
            numIslands(grid, x + 1, y, target);
        }
        //向左
        if (y > 0 && grid[x][y - 1] == '1') {
            numIslands(grid, x, y - 1, target);
        }
        //向右
        if (y < grid[0].length-1 && grid[x][y + 1] == '1') {
            numIslands(grid, x, y + 1, target);
        }
    }
}
