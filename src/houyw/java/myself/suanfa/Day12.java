package houyw.java.myself.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/20 19:49
 * @Description:
 */
public class Day12 {
    public static void main(String[] args) {
        Day12 day = new Day12();
        int i = day.climbStairs(45);
        // System.out.println(i);
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        //int[] nums = {2,1,1,2};
        int rob = day.rob(nums);
        System.out.println(rob);
    }

    /**
     * 假设你正在爬楼梯。需要 n?阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int bef = 1;
        int aft = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = bef + aft;
            bef = aft;
            aft = sum;
        }
        return sum;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
     * 一夜之内能够偷窃到的最高金额。
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * ?    偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * ?    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * ?
     * 提示：
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * 通过次数570,705提交次数
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 动态规划
        // dp[i]数组含义：dp[i] 代表偷取第i个房间可以偷取到的最高金额
        // 递推公式：dp[i] = max(dp[i-2], dp[i-3]) + nums[i];
        // 初始化：dp[0] = nums[0], dp[1] =nums[1];
        // 遍历顺序：从0到大遍历，遍历完之后将得到能投到的最大金额
        // 打印dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int maxValue = Math.max(dp[2], dp[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }


    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * 每一步只能移动到下一行中相邻的结点上。
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * 示例 1：
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为?11（即，2?+?3?+?5?+?1?= 11）。
     * 示例 2：
     * 输入：triangle = [[-10]]
     * 输出：-10
     * 提示：
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     * 进阶：
     * 你可以只使用 O(n)?的额外空间（n 为三角形的总行数）来解决这个问题吗？
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        //f(n)[]用来表示某列经过该点的最小的路径合数组
        //f(n)[i] = min(f(n-1)[i],f(n-1)[i-1])+triangle.get(n-1).get(i))
        //1<=n<=triangle.size(),0<+i<=triangle.get(n-1).size()
        //f(1)[0] = triangle.get(0).get(0)
        //f(2)[0] = f(1)[0]+triangle.get(1).get(0) f(2)[1] = f(1)[0]+triangle.get(1).get(1)
        List<List<Integer>> list = new ArrayList<>();
        for (int n = 0; n < triangle.size(); n++) {
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                int thisValue = triangle.get(n).get(i);
                if (n - 1 < 0) {
                    lst.add(thisValue);
                } else {
                    int bef = 0;
                    if (i - 1 < 0) {
                        bef = list.get(n - 1).get(i);
                    } else if (i == n) {
                        bef = list.get(n - 1).get(i - 1);
                    } else {
                        bef = Math.min(list.get(n - 1).get(i), list.get(n - 1).get(i - 1));
                    }
                    lst.add(thisValue + bef);
                }
            }
            list.add(lst);
        }
        List<Integer> lastList = list.get(list.size() - 1);
        Collections.sort(lastList);
        return lastList.get(0);
    }
}
