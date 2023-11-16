package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/8 17:38
 * @Description:
 */
public class Day16 {
    public static void main(String[] args) {
        Day16 day = new Day16();
        int[] nums = {2, 2, 2, 2, 2};
        int i = day.findNumberOfLIS(nums);
        System.out.println(i);
    }

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列?是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * 示例 1：
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * 提示：
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * 进阶：
     * 你能将算法的时间复杂度降低到?O(n log(n)) 吗?
     */
    public int lengthOfLIS(int[] nums) {
        int[] fn = new int[nums.length];
        fn[0] = 1;
        int max = 1;
        for (int i = 1; i < fn.length; i++) {
            fn[i] = 1;

            //找到第一个比自己小或者一样的
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    continue;
                }
                if (nums[j] == nums[i] && fn[j] > fn[i]) {
                    fn[i] = fn[j];
                }
                if (nums[j] < nums[i] && fn[j] + 1 > fn[i]) {
                    fn[i] = fn[j] + 1;
                }
            }

            if (fn[i] > max) {
                max = fn[i];
            }
        }
        return max;
    }

    /**
     * 给定一个未排序的整数数组?nums?，?返回最长递增子序列的个数?。
     * 注意?这个数列必须是 严格 递增的。
     * 示例 1:
     * 输入: [1,3,5,4,7]
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * 示例 2:
     * 输入: [2,2,2,2,2]
     * 输出: 5
     * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
     * 1 <= nums.length <= 2000
     * -106?<= nums[i] <= 106
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) count[i] = 1;

        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) result += count[i];
        }
        return result;
    }
}
