package houyw.java.myself.leetcode.dtgh;

import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/8/16 21:06
 * @Description:
 */
public class Normal {
    public static void main(String[] args) {
        Normal no = new Normal();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = no.isInterleave(s1, s2, s3);
        System.out.println(interleave);

    }

    /**
     * 一个机器人位于一个?m x n?网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 示例 1：
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     * 提示：
     * m ==?obstacleGrid.length
     * n ==?obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] fn = new int[obstacleGrid.length][obstacleGrid[0].length];
        fn[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                fn[i][0] = 0;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                fn[0][i] = 0;
            } else {
                fn[0][i] = fn[0][i - 1];
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    fn[i][j] = 0;
                } else {
                    fn[i][j] = fn[i][j - 1] + fn[i - 1][j];
                }
            }
        }
        return fn[fn.length - 1][fn[0].length - 1];
    }


    /**
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * 丑数 就是只包含质因数?2、3 和/或?5?的正整数。
     * 示例 1：
     * 输入：n = 10
     * 输出：12
     * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     * 示例 2：
     * 输入：n = 1
     * 输出：1
     * 解释：1 通常被视为丑数。
     * 提示：
     * 1 <= n <= 1690
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] tmps = {2, 3, 5};
        List<Long> list = new ArrayList<>();
        long[] fn = new long[n];
        fn[0] = 1;
        for (int i = 1; i < n; i++) {
            if (list.size() > 0) {
                for (int num : tmps) {
                    if (!list.contains(fn[i - 1] * num)) {
                        for (int j = list.size() - 1; j >= 0; j--) {
                            if (list.get(j) <= fn[i - 1] * num) {
                                list.add(j + 1, fn[i - 1] * num);
                                break;
                            }
                        }
                    }
                }
            } else {
                for (int num : tmps) {
                    list.add(fn[i - 1] * num);
                }
            }
            fn[i] = list.get(0);
            list.remove(0);
        }
        return (int) fn[n - 1];
    }

    /**
     * 给定一个包含非负整数的 m?x?n?网格?grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * 示例 1：
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     */
    public int minPathSum(int[][] grid) {
        int[][] fn = new int[grid.length][grid[0].length];
        fn[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j > 0) {
                    fn[i][j] = fn[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    fn[i][j] = fn[i - 1][j] + grid[i][j];
                } else {
                    fn[i][j] = Math.min(fn[i - 1][j], fn[i][j - 1]) + grid[i][j];
                }
            }
        }
        return fn[fn.length - 1][fn[0].length - 1];
    }

    /**
     * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
     * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
     * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
     * 示例 1：
     * 输入：n = 12, primes = [2,7,13,19]
     * 输出：32
     * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
     * 示例 2：
     * 输入：n = 1, primes = [2,3,5]
     * 输出：1
     * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
     * 提示：
     * 1 <= n <= 105
     * 1 <= primes.length <= 100
     * 2 <= primes[i] <= 1000
     * 题目数据 保证 primes[i] 是一个质数
     * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        int m = primes.length;
        int[] pointers = new int[m];
        long[] nums = new long[m];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            long minNum = Arrays.stream(nums).min().getAsLong();
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return (int) dp[n];
    }

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值
     * 从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * 示例 1：
     * 输入：n = 3
     * 输出：5
     * 示例 2：
     * 输入：n = 1
     * 输出：1
     */
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        //fn[i]表示由N个节点组成的 二叉搜搜索树的数量
        int[] fn = new int[n + 1];
        fn[0] = 1;
        fn[1] = 1;
        fn[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                fn[i] += fn[j - 1] * fn[i - j];
            }
        }
        return fn[n];
    }

    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * 示例 1：
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：4
     * 示例 2：
     * 输入：matrix = [["0","1"],["1","0"]]
     * 输出：1
     * 示例 3：
     * 输入：matrix = [["0"]]
     * 输出：0
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     */
    //DFS
    public int maximalSquare(char[][] matrix) {
        Queue<int[]> que = new LinkedList();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    que.add(new int[]{i, j});
                }
            }
        }
        if (que.size() == 0) {
            return max;
        }
        while (que.size() > 0) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            while (x < matrix.length - 1 && y < matrix[x].length - 1) {
                if (matrix[x + 1][y + 1] == '1') {
                    boolean flag = true;
                    for (int a = x + 1; a >= cur[0]; a--) {
                        if (matrix[a][y + 1] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int a = y + 1; a >= cur[1]; a--) {
                            if (matrix[x + 1][a] == '0') {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        x++;
                        y++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int m = x - cur[0] + 1;
            int n = y - cur[1] + 1;
            if (m * n > max) {
                max = m * n;
            }

        }
        return max;
    }

    //动态规划
    public int maximalSquare1(char[][] matrix) {
        int[][] fn = new int[matrix.length][matrix[0].length];
        fn[0][0] = matrix[0][0] == '1' ? 1 : 0;
        //for(int i = ){}
        return 0;
    }


    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
     * 可以按 任意顺序 返回答案。
     * 示例 1：
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * 示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     * 提示：
     * 1 <= n <= 8
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        for (int i = start; i <= end; i++) {
            if (i == start) {
                List<TreeNode> lr = generateTrees(start + 1, end);
                for (int j = 0; j < lr.size(); j++) {
                    TreeNode node = new TreeNode(start);
                    node.right = lr.get(j);
                    list.add(node);
                }
            } else if (i == end) {
                List<TreeNode> ll = generateTrees(start, end - 1);
                for (int j = 0; j < ll.size(); j++) {
                    TreeNode node = new TreeNode(end);
                    node.left = ll.get(j);
                    list.add(node);
                }
            } else {
                List<TreeNode> ll = generateTrees(start, i - 1);
                List<TreeNode> lr = generateTrees(i + 1, end);
                for (int j = 0; j < ll.size(); j++) {
                    for (int k = 0; k < lr.size(); k++) {
                        TreeNode node = new TreeNode(i);
                        node.left = ll.get(j);
                        node.right = lr.get(k);
                        list.add(node);
                    }
                }
            }

        }
        return list;
    }

    /**
     * 给定一个不重复的整数数组?nums 。?最大二叉树?可以用下面的算法从?nums 递归地构建:
     * 创建一个根节点，其值为?nums 中的最大值。
     * 递归地在最大值?左边?的?子数组前缀上?构建左子树。
     * 递归地在最大值 右边 的?子数组后缀上?构建右子树。
     * 返回?nums 构建的 最大二叉树 。
     * 示例 1：
     * 输入：nums = [3,2,1,6,0,5]
     * 输出：[6,3,5,null,2,0,null,null,1]
     * 解释：递归调用如下所示：
     * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
     * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
     * - 空数组，无子节点。
     * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
     * - 空数组，无子节点。
     * - 只有一个元素，所以子节点是一个值为 1 的节点。
     * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
     * - 只有一个元素，所以子节点是一个值为 0 的节点。
     * - 空数组，无子节点。
     * 示例 2：
     * 输入：nums = [3,2,1]
     * 输出：[3,null,2,null,1]
     * 提示：
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     * nums 中的所有整数 互不相同
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode head = new TreeNode(max);
        int[] lefts = new int[index];
        int[] rights = new int[nums.length - index - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < index) {
                lefts[i] = nums[i];
            }
            if (i > index) {
                rights[i - index - 1] = nums[i];
            }
        }
        head.left = constructMaximumBinaryTree(lefts);
        head.right = constructMaximumBinaryTree(rights);
        return head;
    }

    /**
     * 给你最大树的根节点 root 和一个整数 val 。
     * 就像 之前的问题 那样，给定的树是利用 Construct(a)?例程从列表?a（root = Construct(a)）递归地构建的：
     * 如果 a 为空，返回?null 。
     * 否则，令?a[i] 作为 a 的最大元素。创建一个值为?a[i]?的根节点 root 。
     * root?的左子树将被构建为?Construct([a[0], a[1], ..., a[i - 1]]) 。
     * root?的右子树将被构建为?Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
     * 返回?root 。
     * 请注意，题目没有直接给出 a ，只是给出一个根节点?root = Construct(a) 。
     * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
     * 返回?Construct(b) 。
     * 示例 1：
     * 输入：root = [4,1,3,null,null,2], val = 5
     * 输出：[5,4,null,1,3,null,null,2]
     * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
     * 示例 2：
     * 输入：root = [5,2,4,null,1], val = 3
     * 输出：[5,2,4,null,1,null,3]
     * 解释：a = [2,1,5,4], b = [2,1,5,4,3]
     * 示例 3：
     * 输入：root = [5,2,3,null,1], val = 4
     * 输出：[5,2,4,null,1,3]
     * 解释：a = [2,1,5,3], b = [2,1,5,3,4]
     * 提示：
     * 树中节点数目在范围 [1, 100] 内
     * 1 <= Node.val <= 100
     * 树中的所有值 互不相同
     * 1 <= val <= 100
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (root.right == null) {
            TreeNode node = new TreeNode(val);
            root.right = node;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }

    /**
     * 给定三个字符串?s1、s2、s3，请你帮忙验证?s3?是否是由?s1?和?s2 交错 组成的。
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     * 示例 1：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * 示例 2：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     * 示例 3：
     * 输入：s1 = "", s2 = "", s3 = ""
     * 输出：true
     * 0 <= s1.length, s2.length <= 100
     * 0 <= s3.length <= 200
     * s1、s2、和 s3 都由小写英文字母组成
     * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
     */

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }
        int[][] fn = new int[s1.length() + 1][s2.length() + 1];
        fn[0][0] = 1;
        for (int i = 1; i <= fn.length; i++) {
            if (s1.substring(0, i - 1).equals(s3.substring(0, i - 1))) {
                fn[i - 1][0] = 1;
            }
        }
        for (int i = 1; i <= fn[0].length; i++) {
            if (s2.substring(0, i - 1).equals(s3.substring(0, i - 1))) {
                fn[0][i - 1] = 1;
            }
        }
        for (int i = 1; i < fn.length; i++) {
            for (int j = 1; j < fn[i].length; j++) {
                if (fn[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    fn[i][j] = 1;
                }
                if (fn[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    fn[i][j] = 1;
                }
            }
        }
        if (fn[s1.length()][s2.length()] == 1) {
            return true;
        }
        return false;
    }

    /**
     * 给你一个整数数组 prices ，其中?prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候?最多?
     * 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润?。
     * 示例 1：
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     * ?    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     * 总利润为 4 + 3 = 7 。
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     * ?    总利润为 4 。
     * 示例?3：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     * 提示：
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int[][] fn = new int[prices.length][prices.length];
        for (int i = 0; i < fn.length; i++) {
            for (int j = 0; j < fn[i].length; j++) {
                if (i >= j) {
                    continue;
                }

            }
        }
        return max;
    }
}
