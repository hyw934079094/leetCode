package houyw.java.myself.suanfa;

/**
 * @Author: DELL
 * @Date: 2022/6/18 17:30
 * @Description:
 */
public class Day7 {
    public static void main(String[] args) {
        Day7 day = new Day7();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int i = day.maxAreaOfIsland(grid);
        System.out.println(i);
    }

    /**
     * 有一幅以?m x n?的二维整数数组表示的图画?image?，
     * 其中?image[i][j]?表示该图画的像素值大小。
     * 你也被给予三个整数 sr ,? sc 和 newColor 。
     * 你应该从像素?image[sr][sc]?开始对图像进行 上色填充 。
     * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的
     * 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上
     * 像素值与初始坐标相同的相连像素点，……，重复该过程。
     * 将所有有记录的像素点的颜色值改为?newColor?。
     * 最后返回 经过上色渲染后的图像?。
     * 示例 1:
     * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
     * 示例 2:
     * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
     * 输出: [[2,2,2],[2,2,2]]
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int t = image[sr][sc];
        if (t != color) {
            image[sr][sc] = color;
            //向上
            if (sr > 0 && image[sr - 1][sc] == t) {
                image = floodFill(image, sr - 1, sc, color, t);
            }
            //向下
            if (sr < image.length - 1 && image[sr + 1][sc] == t) {
                image = floodFill(image, sr + 1, sc, color);
            }
            //向左
            if (sc > 0 && image[sr][sc - 1] == t) {
                image = floodFill(image, sr, sc - 1, color);
            }
            //向右
            if (sc < image[0].length - 1 && image[sr][sc + 1] == t) {
                image = floodFill(image, sr, sc + 1, color);
            }
        }

        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color, int t) {
        image[sr][sc] = color;
        //向上
        if (sr > 0 && image[sr - 1][sc] == t) {
            image = floodFill(image, sr - 1, sc, color, t);
        }
        //向下
        if (sr < image.length - 1 && image[sr + 1][sc] == t) {
            image = floodFill(image, sr + 1, sc, color, t);
        }
        //向左
        if (sc > 0 && image[sr][sc - 1] == t) {
            image = floodFill(image, sr, sc - 1, color, t);
        }
        //向右
        if (sc < image[0].length - 1 && image[sr][sc + 1] == t) {
            image = floodFill(image, sr, sc + 1, color, t);
        }
        return image;
    }

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     * 岛屿?是由一些相邻的?1?(代表土地) 构成的组合，
     * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
     * 你可以假设?grid 的四个边缘都被 0（代表水）包围着。
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     * 示例 1：
     * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 输出：6
     * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
     * 示例 2：
     * 输入：grid = [[0,0,0,0,0,0,0,0]]
     * 输出：0
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 50
     * grid[i][j] 为 0 或 1
     */
    public int maxAreaOfIsland(int[][] grid) {
        int x = 0;
        int max = 0;
        while (x < grid.length) {
            int y = 0;
            while (y < grid[0].length) {
                if (grid[x][y] == 1) {
                    int count = sameAreacOUNT(grid, x, y);
                    if (count > max) {
                        max = count;
                    }
                }
                y++;
            }
            x++;
        }
        return max;
    }

    private int sameAreacOUNT(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        int count = 1;
        //向上
        if (x > 0 && grid[x - 1][y] == 1) {
            count += sameAreacOUNT(grid, x - 1, y);
        }
        //向下
        if (x < grid.length - 1 && grid[x + 1][y] == 1) {
            count += sameAreacOUNT(grid, x + 1, y);
        }
        //向左
        if (y > 0 && grid[x][y - 1] == 1) {
            count += sameAreacOUNT(grid, x, y - 1);
        }

        //向右
        if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
            count += sameAreacOUNT(grid, x, y + 1);
        }
        return count;
    }
}
