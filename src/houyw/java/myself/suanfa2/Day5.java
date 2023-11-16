package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/7/29 10:52
 * @Description:
 */
public class Day5 {
    public static void main(String[] args) {
        Day5 day = new Day5();
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        //System.out.println(day.minSubArrayLen(11, num));
        System.out.println(day.numSubarrayProductLessThanK(nums, 8));

    }

    /**
     * 给定一个含有?n?个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组?[numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组?[4,3]?是该条件下的长度最小的子数组。
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 提示：
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * 进阶：
     * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                int num = right - left + 1;
                if (count == 0) {
                    count = num;
                }
                if (num < count) {
                    count = num;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return count;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     * 示例 1：
     * 输入：nums = [10,5,2,6], k = 100
     * 输出：8
     * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
     * 示例 2：
     * 输入：nums = [1,2,3], k = 0
     * 输出：0
     * ?
     * 提示:?
     * 1 <= nums.length <= 3 * 104
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 106
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 1;
        int count = 0;
        while (right < nums.length) {
            //当前le
            sum *= nums[right];
            //右指针停留在第一个使乘积大于k的下标或者末尾端
            while (sum >= k) {
                if (right >= left) {
                    count += right - left;
                }else{
                    break;
                }
                sum /= nums[left];
                left++;
            }
            right++;
        }
        while (left < right) {
            count+=right-left;
            left++;
        }
        return count;
    }
}
