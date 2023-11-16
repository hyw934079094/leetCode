package houyw.java.myself.leetcode.one;

/**
 * @Author: DELL
 * @Date: 2022/7/4 10:41
 * @Description:
 */
public class Day11 {
    public static void main(String[] args) {
        Day11 day = new Day11();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
       // System.out.println(day.minCostClimbingStairs(cost));
        System.out.println(day.uniquePaths(3,2));
    }

    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
     * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     * 示例 1：
     * 输入：cost = [10,15,20]
     * 输出：15
     * 解释：你将从下标为 1 的台阶开始。
     * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
     * 总花费为 15 。
     * 示例 2：
     * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
     * 输出：6
     * 解释：你将从下标为 0 的台阶开始。
     * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
     * 总花费为 6 。
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] fn = new int[cost.length];
        fn[0] = cost[0];
        fn[1] = cost[1];
        for(int i =2;i<fn.length;i++){
            fn[i] = Math.min(fn[i-1],fn[i-2])+cost[i];
        }
        return Math.min(fn[fn.length-1],fn[fn.length-2]);
    }


    /**
     *一个机器人位于一个 m x n?网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 示例 1：
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     * 输入：m = 3, n = 3
     * 输出：6
     */
    public int uniquePaths(int m, int n) {
        int[][] fn = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i==0||j==0){
                    fn[i][j] =1;
                }else{
                    fn[i][j] = fn[i-1][j] + fn[i][j-1];
                }
            }
        }
        return fn[m-1][n-1];
    }
}
