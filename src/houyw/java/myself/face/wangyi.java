package houyw.java.myself.face;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: DELL
 * @Date: 2022/8/7 21:31
 * @Description:
 */
public class wangyi {
    public static void main(String[] args) {
        wangyi wy = new wangyi();
        int[] prices = {1, 2, 3, 1, 0};
        int i = wy.candy(prices);
        System.out.println(i);
    }

    /**
     * 给定一个数组 prices ，它的第?i 个元素?prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * ?
     * 提示：
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */

    public int maxProfit(int[] prices) {
        int[][] fn = new int[prices.length][2];
        fn[0][0] = prices[0];
        fn[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            fn[i][1] = fn[i - 1][1];
            if (prices[i] > fn[i - 1][0]) {
                fn[i][0] = fn[i - 1][0];
                if (prices[i] - fn[i - 1][0] > fn[i - 1][1]) {
                    fn[i][1] = prices[i] - fn[i - 1][0];
                }
            } else {
                fn[i][0] = prices[i];
            }
        }
        return fn[fn.length - 1][1];
    }

    class Solution {
        List<ListNode> list;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
        }

        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i).val;
        }
    }

    /**
     * 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
     * S1 = "0"
     * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
     * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
     * 例如，符合上述描述的序列的前 4 个字符串依次是：
     * S1 = "0"
     * S2 = "011"
     * S3 = "0111001"
     * S4 = "011100110110001"
     * 请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
     * 示例 1：
     * 输入：n = 3, k = 1
     * 输出："0"
     * 解释：S3 为 "0111001"，其第 1 位为 "0" 。
     * 示例 2：
     * 输入：n = 4, k = 11
     * 输出："1"
     * 解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
     * 示例 3：
     * <p>
     * 输入：n = 1, k = 1
     * 输出："0"
     * 示例 4：
     * <p>
     * 输入：n = 2, k = 3
     * 输出："1"
     * 提示：
     * 1 <= n <= 20
     * 1 <= k <= 2n - 1
     */
    public char findKthBit(int n, int k) {
        return getStr(n).charAt(k - 1);
    }

    public String getStr(int n) {
        if (n == 1) {
            return "0";
        }
        String s = getStr(n - 1);
        StringBuilder ss = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ss.append('0');
            } else {
                ss.append('1');
            }
        }
        return s + "1" + ss.toString();
    }

    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * 你需要按照以下要求，给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * 示例?1：
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例?2：
     * 输入：ratings = [1,2,2]
     * 输出：4
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     * 提示：
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     * 通过次数162,751提交次数329,380
     */
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        int res = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                //评分高，比前一个要多一个苹果
                nums[i] = nums[i - 1] + 1;
                res += nums[i];
            } else {
                nums[i] = 1;
                res += 1;
                //当前的孩子评分比前一个孩子小
                //如果苹果数量一样，则前一个孩子要多给一个，并且得让更往前的孩子满足条件
                if (nums[i] == nums[i - 1] && ratings[i] < ratings[i - 1]) {
                    for (int j = i - 1; j >= 0; j--) {
                        nums[j]++;
                        res++;
                        if (j > 0) {
                            //如果加完之后前面的结构不被破坏，则不用循环加了
                            if (ratings[j - 1] <= ratings[j]) {
                                break;
                            } else {
                                if (nums[j - 1] > nums[j]) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
