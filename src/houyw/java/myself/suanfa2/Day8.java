package houyw.java.myself.suanfa2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: DELL
 * @Date: 2022/8/1 09:57
 * @Description:
 */
public class Day8 {
    public static void main(String[] args) {
        Day8 day = new Day8();
        int[][] graph =  {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(day.allPathsSourceTarget(graph));
    }

    /**
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     * 示例 1：
     * 输入：grid = [[0,1],[1,0]]
     * 输出：2
     * 示例 2：
     * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
     * 输出：4
     * 示例 3：
     * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
     * 输出：-1
     * 0 1 1 0 0 0
     * 0 1 0 1 1 0
     * 0 1 1 0 1 0
     * 0 0 0 1 1 0
     * 1 1 1 1 1 0
     * 1 1 1 1 1 0
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        grid[0][0] = 1;
        //初始路径为1
        int sum = 1;
        //用数组定义八个移动方向
        int[][] tmps = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        while (que.size() > 0) {
            //本次需要取出的点的个数
            int size = que.size();
            while (size > 0) {
                //取出当前遍历得节点
                int[] cur = que.poll();
                //取出的节点已经到终点了
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    return sum;
                }
                //遍历八个方向
                for (int[] tmp : tmps) {
                    int x = cur[0] + tmp[0];
                    int y = cur[1] + tmp[1];
                    if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        continue;
                    }
                    //加入当前节点
                    que.add(new int[]{x, y});
                    //并且标记当前节点已经走到过
                    grid[x][y] = 1;

                }
                size--;
            }
            //本次取完，开始下一层
            sum++;
        }
        return -1;
    }


    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
     * 并将这些区域里所有的?'O' 用 'X' 填充。
     * 示例 1：
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的?'O'?都不会被填充为?'X'。
     * 任何不在边界上，或不与边界上的?'O'?相连的?'O'?最终都会被填充为?'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     * 提示：
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] 为 'X' 或 'O'
     */
    public void solve(char[][] board) {
        //找到所有不被填充的点
        Queue<int[]> que = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        //定义四个方向
        int[][] tmps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //先把所有边界上的0找出来
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                que.add(new int[]{i, 0});
            }
            if (board[i][board[i].length - 1] == 'O') {
                que.add(new int[]{i, board[i].length - 1});
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                que.add(new int[]{0, i});
            }
            if (board[board.length - 1][i] == 'O') {
                que.add(new int[]{board.length - 1, i});
            }
        }
        //然后把相连的O全部加入
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int[] poll = que.poll();
                //所有进入过队列的点都加入列表中
                list.add(poll);
                board[poll[0]][poll[1]] = 'X';
                for (int[] tmp : tmps) {
                    int x = poll[0] + tmp[0];
                    int y = poll[1] + tmp[1];
                    if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1) {
                        continue;
                    }
                    if (board[x][y] == 'X') {
                        continue;
                    }
                    //加入当前点
                    que.add(new int[]{x, y});
                    //标记当前点已经走到过
                    board[x][y] = 'X';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'X';
            }
        }
        if (list.size() > 0) {
            for (int[] arr : list) {
                board[arr[0]][arr[1]] = 'O';
            }
        }
    }


    /**
     * 给你一个有?n?个节点的 有向无环图（DAG），请你找出所有从节点 0?到节点 n-1?的路径并输出（不要求按特定顺序）
     * ?graph[i]?是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点?graph[i][j]存在一条有向边）。
     * 示例 1：
     * 输入：graph = [[1,2],[3],[3],[]]
     * 输出：[[0,1,3],[0,2,3]]
     * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
     * 示例 2：
     * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
     * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
     * 提示：
     * n == graph.length
     * 2 <= n <= 15
     * 0 <= graph[i][j] < n
     * graph[i][j] != i（即不存在自环）
     * graph[i] 中的所有元素 互不相同
     * 保证输入为 有向无环图（DAG）
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        que.add(l);
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                List<Integer> poll = que.poll();
                int index = poll.get(poll.size() - 1);
                if(index ==graph.length-1){
                    list.add(poll);
                    continue;
                }
                for (int i : graph[index]) {
                    List<Integer> lst = new ArrayList<>();
                    lst.addAll(poll);
                    lst.add(i);
                    que.add(lst);
                }
            }
        }
        return list;
    }
}
