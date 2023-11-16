package houyw.java.myself.leetcode.one;

import houyw.common.utils.ArrayUtils;

/**
 * @Author: DELL
 * @Date: 2022/6/23 20:11
 * @Description:
 */
public class Day1 {
    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：
     * runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * 示例 2：
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     * 示例 3：
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     */
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        return arr;
    }

    /**
     * 给你一个整数数组?nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
     * 这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。
     * 如果数组不存在中心下标，返回 -1 。
     * 示例 1：
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * 示例 2：
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * 示例 3：
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     */
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for(int i = 0;i<nums.length;i++){
            int left = 0;
            int right = 0;
            for(int j = 0;j<i;j++){
                left+=nums[j];
            }
            for(int k = i+1;k<nums.length;k++){
                right+=nums[k];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }
    //双下标优化
    public int pivotIndexBetter(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        right[0] = 0;
        for(int j = 1;j<right.length;j++){
            right[j] = nums[right.length-j]+right[j-1];
        }
        for(int i =0;i<left.length;i++){
            if(i>0){
                left[i] = nums[i-1]+left[i-1];
            }else{
                left[i] = 0;
            }
            if(left[i] == right[right.length-i-1]){
                return i;
            }
        }

        return -1;
    }
}
