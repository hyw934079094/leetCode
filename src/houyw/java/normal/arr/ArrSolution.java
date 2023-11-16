package houyw.java.normal.arr;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/25 11:22
 * @Description:
 */
public class ArrSolution {
    public static void main(String[] args) {
        ArrSolution so = new ArrSolution();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(so.findClosestElements(arr, 4, -1));
    }

    /**
     * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、
     * 蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
     * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
     * 每个房子粉刷成不同颜色的花费是以一个?n x 3?的正整数矩阵 costs 来表示的。
     * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]?表示第 1 号房子粉刷成绿色的花费，以此类推。
     * 请计算出粉刷完所有房子最少的花费成本。
     * 示例 1：
     * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
     * 输出: 10
     * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
     * ?    最少花费: 2 + 5 + 3 = 10。
     * 示例 2：
     * 输入: costs = [[7,6,2]]
     * 输出: 2
     * 提示:
     * costs.length == n
     * costs[i].length == 3
     * 1 <= n <= 100
     * 1 <= costs[i][j] <= 20
     */
    public int minCost(int[][] costs) {
        //如果当前房子刷成红色的最少金额:
        int cost0 = minCost(costs, 0, 0);
        //如果当前房子刷成绿色的最少金额:
        int cost1 = minCost(costs, 0, 1);
        //如果当前房子刷成蓝色的最少金额:
        int cost2 = minCost(costs, 0, 2);
        int min = cost0;
        if (cost1 < min) {
            min = cost1;
        }
        if (cost2 < min) {
            min = cost2;
        }
        return min;
    }


    public int minCost(int[][] costs, int index, int color) {
        if (index == costs.length - 1) {
            return costs[index][color];
        }
        int[][] nums = {{1, 2}, {0, 2}, {0, 1}};
        int cost1 = minCost(costs, index + 1, nums[color][0]);
        int cost2 = minCost(costs, index + 1, nums[color][1]);

        if (cost1 < cost2) {
            return cost1 + costs[index][color];
        }
        return cost2 + costs[index][color];
    }

    public int minCost1(int[][] costs) {
        //记录下标为n的房子刷某种颜色的最低花费
        int[][] dos = new int[costs.length][3];

        //dos[x][y]第一个房子刷y颜色的最小花费
        dos[0][0] = costs[0][0];
        dos[0][1] = costs[0][1];
        dos[0][2] = costs[0][2];
        //dos[1][0] = min(dos[0][1],dos[0][2]) +costs[1][0]
        //dos[1][1] = min(dos[0][0],dos[0][2]) +costs[1][1]
        //dos[1][2] = min(dos[0][0],dos[0][1]) +costs[1][2]

        //dos[i][0] = min(dos[i-1][1],dos[i-1][2])+costs[i-1][0]
        //dos[i][1] = min(dos[i-1][0],dos[i-1][2])+costs[i-1][1]
        //dos[i][2] = min(dos[i-1][0],dos[i-1][1])+costs[i-1][2]
        for (int i = 1; i < costs.length; i++) {
            dos[i][0] = Math.min(dos[i - 1][1], dos[i - 1][2]) + costs[i][0];
            dos[i][1] = Math.min(dos[i - 1][0], dos[i - 1][2]) + costs[i][1];
            dos[i][2] = Math.min(dos[i - 1][0], dos[i - 1][1]) + costs[i][2];
        }
        int min = dos[dos.length - 1][0];
        if (dos[dos.length - 1][1] < min) {
            min = dos[dos.length - 1][1];
        }
        if (dos[dos.length - 1][2] < min) {
            min = dos[dos.length - 1][2];
        }
        return min;
    }

    /**
     * 10
     * [[4,1],[1,3],[1,5],[0,5],[3,6],[8,4],[5,7],[6,9],[3,2]]
     * [2,7]
     * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
     * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
     * 另给你一个整数数组 restricted 表示 受限 节点。
     * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
     * 注意，节点 0 不 会标记为受限节点。
     * 示例 1：
     * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
     * 输出：4
     * 解释：上图所示正是这棵树。
     * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
     * 示例 2：
     * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
     * 输出：3
     * 解释：上图所示正是这棵树。
     * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
     * 提示：
     * 2 <= n <= 105
     * edges.length == n - 1
     * edges[i].length == 2
     * 0 <= ai, bi < n
     * ai != bi
     * edges 表示一棵有效的树
     * 1 <= restricted.length < n
     * 1 <= restricted[i] < n
     * restricted 中的所有值 互不相同
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int count = 0;
        while (que.size() > 0) {
            int size = que.size();
            count += size;
            while (size-- > 0) {
                int cur = que.poll();
                set.add(cur);
                List<Integer> next = list[cur];
                for (int i : next) {
                    if (!set.contains(i)) {
                        que.add(i);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
     * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
     * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
     * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
     * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。
     * 例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
     * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
     * 示例 1：
     * 输入：nums = [4,4,4,5,6]
     * 输出：true
     * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
     * 这是一种有效划分，所以返回 true 。
     * 示例 2：
     * 输入：nums = [1,1,1,2]
     * 输出：false
     * 解释：该数组不存在有效划分。
     * 提示：
     * 2 <= nums.length <= 105
     * 1 <= nums[i] <= 106
     */
    public boolean validPartition(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[1] - nums[0] == 1 && nums[2] - nums[1] == 1;
        }
        if (nums.length == 4) {
            return nums[1] == nums[0] && nums[3] == nums[2];
        }
        boolean[] fn = new boolean[nums.length];
        //1个数
        fn[0] = false;
        //两个数
        fn[1] = nums[1] == nums[0] ? true : false;
        if (nums[1] - nums[0] == 1 && nums[2] - nums[1] == 1) {
            fn[2] = true;
        }
        if (nums[2] == nums[1] && nums[1] == nums[0]) {
            fn[2] = true;
        }
        for (int i = 3; i < nums.length; i++) {
            //多得一个数可以和前面一个或者两个组成子数组
            //组合1
            if (nums[i] == nums[i - 1] && fn[i - 2]) {
                fn[i] = true;
            }
            //组合2
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && fn[i - 3]) {
                fn[i] = true;
            }
            //组合3
            if (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && fn[i - 3]) {
                fn[i] = true;
            }
        }
        return fn[fn.length - 1];
    }

    /**
     * 给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
     * t 是字符串 s 的一个子序列。
     * t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
     * 返回 最长 理想字符串的长度。
     * 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。
     * 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。
     * 示例 1：
     * 输入：s = "acfgbd", k = 2
     * 输出：4
     * 解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
     * 注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。
     * 示例 2：
     * 输入：s = "abcd", k = 3
     * 输出：4
     * 解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
     * 提示：
     * 1 <= s.length <= 105
     * 0 <= k <= 25
     * s 由小写英文字母组成
     */
    public int longestIdealString(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        int[] fn = new int[s.length()];
        int[] tmp = new int[26];
        fn[0] = 1;
        tmp[s.charAt(0) - 'a'] = 1;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            fn[i] = 1;
            //记录该字母的最大长度
            int start = c - 'a' - k;
            int end = c - 'a' + k;
            if (start < 0) {
                start = 0;
            }
            if (end > 25) {
                end = 25;
            }
            for (int j = start; j <= end; j++) {
                if (tmp[j] + 1 > fn[i]) {
                    fn[i] = tmp[j] + 1;
                }
            }
            if (tmp[c - 'a'] < fn[i]) {
                tmp[c - 'a'] = fn[i];
            }
            if (fn[i] > max) {
                max = fn[i];
            }
        }
        return max;
    }


    /**
     * 给定一个 排序好 的数组?arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
     * 返回的结果必须要是按升序排好的。
     * 整数 a 比整数 b 更接近 x 需要满足：
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     * 示例 1：
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * 示例 2：
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     * 提示：
     * 1 <= k <= arr.length
     * 1 <= arr.length?<= 104
     * arr?按 升序 排列
     * -104?<= arr[i], x <= 104
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> que = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            que.add(new int[]{Math.abs(arr[i] - x), arr[i]});
            if (que.size() > k) {
                que.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            int[] cur = que.poll();
            list.add(0, cur[1]);
        }
        Collections.sort(list);
        return list;
    }


    /**
     * 给你一个整数数组，返回它的某个?非空 子数组（连续元素）在执行一次可选的删除操作后，
     * 所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），
     * （删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
     * 注意，删除一个元素后，子数组 不能为空。
     * 示例 1：
     * 输入：arr = [1,-2,0,3,-1,3]
     * 输出：4
     * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
     * 示例 2：
     * 输入：arr = [1,-2,-2,3]
     * 输出：3
     * 解释：我们直接选出 [3]，这就是最大和。
     * 示例 3：
     * 输入：arr = [-1,-1,-1,-1]
     * 输出：-1
     * 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
     * 我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
     * 提示：
     * 1 <= arr.length <= 105
     * -104?<= arr[i] <= 104
     */

    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        //nums[i][0] 表示到自己为止 已经删除过一位的最大值
        //nums[i][1] 表示到自己为止 还没有删除过的最大值
        int[][] nums = new int[arr.length][2];
        nums[0][0] = arr[0];
        nums[0][1] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            nums[i][0] = Math.max(nums[i - 1][0] + arr[i], nums[i - 1][1]);
            nums[i][1] = Math.max(nums[i - 1][1] + arr[i], arr[i]);
            max = Math.max(Math.max(nums[i][0], nums[i][1]), max);
        }
        return max;
    }

    /**
     * 机器人在一个无限大小的 XY 网格平面上行走，从点?(0, 0) 处开始出发，面向北方。
     * 该机器人可以接收以下三种类型的命令 commands ：
     * -2 ：向左转?90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动?x?个单位长度
     * 在网格上有一些格子被视为障碍物?obstacles 。第 i?个障碍物位于网格点 ?obstacles[i] = (xi, yi) 。
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
     * 注意：
     * 北表示 +Y 方向。
     * 东表示 +X 方向。
     * 南表示 -Y 方向。
     * 西表示 -X 方向。
     * 示例 1：
     * 输入：commands = [4,-1,3], obstacles = []
     * 输出：25
     * 解释：
     * 机器人开始位于 (0, 0)：
     * 1. 向北移动 4 个单位，到达 (0, 4)
     * 2. 右转
     * 3. 向东移动 3 个单位，到达 (3, 4)
     * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
     * 示例?2：
     * <p>
     * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * 输出：65
     * 解释：机器人开始位于 (0, 0)：
     * 1. 向北移动 4 个单位，到达 (0, 4)
     * 2. 右转
     * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
     * 4. 左转
     * 5. 向北走 4 个单位，到达 (1, 8)
     * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
     * ?
     * <p>
     * 提示：
     * <p>
     * 1 <= commands.length <= 104
     * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
     * 0 <= obstacles.length <= 104
     * -3 * 104 <= xi, yi <= 3 * 104
     * 答案保证小于 231
     */

    public int robotSim(int[] commands, int[][] obstacles) {
        //路障map
        Map obs = new HashMap();
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            if (obs.get(x) == null) {
                Map map = new HashMap();
                map.put(y, "1");
                obs.put(x, map);
            } else {
                Map map = (Map) obs.get(x);
                map.put(y, "1");
            }
        }
        int x = 0;
        int y = 0;
        int max = 0;
        //0,1,2,3分别代表东南西北
        int fangxiang = 3;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                fangxiang = fangxiang + 1;
                if (fangxiang > 3) {
                    fangxiang -= 4;
                }
            }
            if (commands[i] == -2) {
                fangxiang = fangxiang - 1;
                if (fangxiang < 0) {
                    fangxiang += 4;
                }
            }
            if (commands[i] == -1 || commands[i] == -2) {
                continue;
            }
            if (fangxiang == 0) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x + 1) != null) {
                        Map map = (Map) obs.get(x + 1);
                        if (map.get(y) != null) {
                            break;
                        }
                    }
                    x = 1 + x;
                }
            }
            if (fangxiang == 1) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x) != null) {
                        Map map = (Map) obs.get(x);
                        if (map.get(y - 1) != null) {
                            break;
                        }
                    }
                    y = y - 1;
                }
            }
            if (fangxiang == 2) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x - 1) != null) {
                        Map map = (Map) obs.get(x - 1);
                        if (map.get(y) != null) {
                            break;
                        }
                    }
                    x = x - 1;
                }
            }
            if (fangxiang == 3) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x) != null) {
                        Map map = (Map) obs.get(x);
                        if (map.get(y + 1) != null) {
                            break;
                        }
                    }
                    y = 1 + y;
                }
            }
            if (x * x + y * y > max) {
                max = x * x + y * y;
            }
        }
        return max;
    }

    /**
     * 给定一个长度为 n 的环形整数数组?nums?，返回?nums?的非空 子数组 的最大可能和?。
     * 环形数组?意味着数组的末端将会与开头相连呈环状。形式上，
     * nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]?的前一个元素是 nums[(i - 1 + n) % n] 。
     * 子数组 最多只能包含固定缓冲区?nums?中的每个元素一次。形式上，
     * 对于子数组?nums[i], nums[i + 1], ..., nums[j]?，不存在?i <= k1, k2 <= j?其中?k1 % n == k2 % n?。
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        if (n == 1) {
            return max;
        }
        int min = nums[0];
        int sum = nums[0];
        int[] maxarr = new int[n];
        maxarr[0] = max;
        int[] minarr = new int[n];
        minarr[0] = min;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            maxarr[i] = Math.max(maxarr[i - 1] + nums[i], nums[i]);
            max = Math.max(max, maxarr[i]);
            minarr[i] = Math.min(minarr[i - 1] + nums[i], nums[i]);
            min = Math.min(min, minarr[i]);
        }
        if (sum == min) {
            return max;
        }
        return Math.max(max, sum - min);
    }


    /**
     * 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。
     * （注意，在后续操作中你可以对减半过的数继续执行操作）
     * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
     * 示例 1：
     * 输入：nums = [5,19,8,1]
     * 输出：3
     * 解释：初始 nums 的和为 5 + 19 + 8 + 1 = 33 。
     * 以下是将数组和减少至少一半的一种方法：
     * 选择数字 19 并减小为 9.5 。
     * 选择数字 9.5 并减小为 4.75 。
     * 选择数字 8 并减小为 4 。
     * 最终数组为 [5, 4.75, 4, 1] ，和为 5 + 4.75 + 4 + 1 = 14.75 。
     * nums 的和减小了 33 - 14.75 = 18.25 ，减小的部分超过了初始数组和的一半，18.25 >= 33/2 = 16.5 。
     * 我们需要 3 个操作实现题目要求，所以返回 3 。
     * 可以证明，无法通过少于 3 个操作使数组和减少至少一半。
     */

    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2 - o1 > 0 ? 1 : -1;
            }
        }
        );
        for (int i = 0; i < nums.length; i++) {
            queue.add((double) nums[i]);
            sum += nums[i];
        }

        int count = 0;
        double cut = 0;
        double target = sum / 2;
        while (cut < target) {
            double num = queue.poll() / 2;
            cut += num;
            count++;
            queue.add(num);
        }
        return count;
    }

    /**
     * n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
     * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
     * 第一个整数是 0
     * 一个整数在序列中出现 不超过一次
     * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
     * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
     * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
     * 0      1      3      2     6     7     5       4       12      14     15    13      9    11    10  8
     * 000   001    011    010   110   111   101    100     1100    1110    1111   1101  1001 1011  1010 1000
     * 0000  0001   0011   0010  0110   0111  0101   0100   1100    1101    1111    1110  1010   1011  1001  1000
     * 0     1       3      2      6       7    5     4      12
     */

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public void rotate(int[][] matrix) {
        Queue que = new ArrayDeque<Integer>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                que.add(matrix[i][j]);
            }
        }
        for(int i = matrix[0].length-1;i>=0;i--){
            for(int j = 0;j<matrix.length;j++){
                matrix[j][i] = (int)que.poll();
            }
        }
    }

    public void rotate1(int[][] matrix) {
        Queue que = new ArrayDeque<Integer>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length/2;j++){
                que.add(matrix[i][j]);
            }
        }

    }
}
