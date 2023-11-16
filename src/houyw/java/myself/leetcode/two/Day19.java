package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/21 16:11
 * @Description:
 */
public class Day19 {
    public static void main(String[] args) {
        //1001
        //0110
        //0111
        //1011
        Day19 day = new Day19();
        int[][] arr = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
       // System.out.println(day.findCircleNum(arr));
        int[][] stores ={{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(day.removeStones(stores));

    }

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     * 返回矩阵中 省份 的数量。
     * 示例 1：
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     * 提示：
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] 为 1 或 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    findCircleNum(isConnected, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    //第几行进行查询染色
    public void findCircleNum(int[][] isConnected, int x, int y) {
        isConnected[x][y] = 2;
        for (int i = 0; i < isConnected[y].length; i++) {
            if (isConnected[y][i] == 1) {
                isConnected[y][i] = 2;
                findCircleNum(isConnected, y, i);
            }
        }
    }


    /**
     * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
     * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
     * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
     * 示例 1：
     * <p>
     * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * 输出：5
     * 解释：一种移除 5 块石头的方法如下所示：
     * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
     * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
     * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
     * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
     * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
     * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
     * 示例 2：
     * <p>
     * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
     * 输出：3
     * 解释：一种移除 3 块石头的方法如下所示：
     * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
     * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
     * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
     * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
     * 示例 3：
     * <p>
     * 输入：stones = [[0,0]]
     * 输出：0
     * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
     * ?
     * <p>
     * 提示：
     * 1 <= stones.length <= 1000
     * 0 <= xi, yi <= 104
     * 不会有两块石头放在同一个坐标点上
     */

    public int removeStones(int[][] stones) {
        //只要是同行或者同列，则视为一个集合，看有多少个集合就是最后剩余得石头数量
        if (stones.length == 1) {
            return 0;
        }
        int all = stones.length;
        int[] arr = new int[all];
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if(arr[i] == 1){
                continue;
            }
            removeStones(stones, stones[i][0], stones[i][1], arr);
            count++;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum == all) {
                return all-count;
            }
        }
        return all-count;
    }

    public void removeStones(int[][] stones, int x, int y, int[] arr) {
        for (int i = 0; i < stones.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            if (stones[i][1] == y) {
                arr[i] = 1;
                removeStones(stones, stones[i][0], y, arr);
            }
            if (stones[i][0] == x) {
                arr[i] = 1;
                removeStones(stones, x, stones[i][1], arr);
            }
        }
    }

}
