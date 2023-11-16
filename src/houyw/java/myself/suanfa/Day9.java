package houyw.java.myself.suanfa;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/20 16:12
 * @Description:
 */
public class Day9 {
    public static void main(String[] args) {
        Day9 day = new Day9();
        int[][] nums = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ints = day.updateMatrix(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int[] num : ints) {
            List<Integer> l = new ArrayList<>();
            for (int n : num) {
                l.add(n);
            }
            list.add(l);
        }
        System.out.println(list);
    }

    /**
     * 给定一个由 0 和 1 组成的矩阵 mat?，请输出一个大小相同的矩阵，
     * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     * 示例 1：
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     * 示例 2：
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     */
    public int[][] updateMatrix(int[][] matrix) {
        /*
        BFS
        如果某个位置本身是 0，那么到 0 的距离为 0
        如果某个位置上下左右存在 一个以上的 0，那么距离为 1
        */
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] res = new int[matrix.length][matrix[0].length];
        int step = 1;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0){
                int[] p = queue.poll();
                for(int i = 0; i < 4; i++){
                    int x = p[0] + pos[i][0];
                    int y = p[1] + pos[i][1];
                    if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1){
                        matrix[x][y] = 0;
                        res[x][y] = step;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return res;
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
     * 输出：4
     * 示例 2：
     * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * 示例 3：
     * 输入：grid = [[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     */
    public int orangesRotting(int[][] grid) {
        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && true) {
                    //向上
                    if (i > 0) {

                    }
                }
            }
        }
        return min;
    }
}
