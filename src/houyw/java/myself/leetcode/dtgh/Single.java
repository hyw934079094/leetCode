package houyw.java.myself.leetcode.dtgh;

import houyw.common.utils.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: DELL
 * @Date: 2022/8/18 17:58
 * @Description:
 */
public class Single {
    public static void main(String[] args) {
        Single sg = new Single();
       int[] nums = {4,5,2,1};
       int[] queries = {3,10,21};
        int[] ints = sg.answerQueries(nums, queries);
        ArrayUtils.print(ints);
    }
    /**
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。
     * 传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
     * 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     * 示例 1：
     * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     * 输出：3
     * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
     * 示例 2：
     * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
     * 输出：0
     * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
     * 限制：
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
     */
    public int numWays(int n, int[][] relation, int k) {
        Queue<Integer> que = new LinkedList();
        que.add(0);
        while (k-- > 0) {
            int size = que.size();
            while (size-- > 0) {
                int cur = que.poll();
                for (int i = 0; i < relation.length; i++) {
                    if (cur == relation[i][0]) {
                        que.add(relation[i][1]);
                    }
                }
            }

        }
        int count = 0;
        while (que.size() > 0) {
            if (que.poll() == n - 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 给你一个长度为 n?的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
     * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度? 。
     * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
     * 示例 1：
     * 输入：nums = [4,5,2,1], queries = [3,10,21]
     * 输出：[2,3,4]
     * 解释：queries 对应的 answer 如下：
     * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
     * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
     * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
     * 示例 2：
     * 输入：nums = [2,3,4,5], queries = [1]
     * 输出：[0]
     * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] + sum <= queries[i]) {
                    sum += nums[j];
                    count++;
                }else{
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
