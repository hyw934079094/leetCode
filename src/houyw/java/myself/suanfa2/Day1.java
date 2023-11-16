package houyw.java.myself.suanfa2;

import houyw.common.utils.ArrayUtils;

/**
 * @Author: DELL
 * @Date: 2022/7/26 17:03
 * @Description:
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day = new Day1();
        int[] nums = {1,4};
        int[] ints = day.searchRange(nums, 4);
        ArrayUtils.print(ints);
    }

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
     * 请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回?[-1, -1]。
     * 你必须设计并实现时间复杂度为?O(log n)?的算法解决此问题。
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例?2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * 提示：
     * 0 <= nums.length <= 105
     * -109?<= nums[i]?<= 109
     * nums?是一个非递减数组
     * -109?<= target?<= 109
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        boolean hasNum = false;
        int index = -1;
        while (index < end || index > start) {
            index = (start + end) / 2;
            if (nums[index] == target) {
                hasNum = true;
                break;
            }
            if (nums[index] < target) {
                start = index;
            }
            if (nums[index] > target) {
                end = index;
            }
            if (end - start <=1) {
                if(nums[start]==target){
                    hasNum = true;
                    index = start;
                }
                if(nums[end]==target){
                    hasNum = true;
                    index = end;
                }
                break;
            }
        }
        if (hasNum) {
            start = index;
            end = index;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }
}
