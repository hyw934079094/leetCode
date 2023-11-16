package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/15 17:50
 * @Description:
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 day = new Day13();
        //int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        //int[] nums = {1, 11, 5, 5};
        int[] nums = {-2,0,-1};
        //boolean b = day.canPartition(nums);
        System.out.println(day.maxProduct(nums));
    }

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 示例 1：
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        //arr[i] 表示数组中和为i的组合有多少种
        int[] arr = new int[sum / 2 + 1];
        //和为0得情况只有一种
        arr[0] = 1;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                //当前数到目标数中，
                arr[i] += arr[i - num];
            }
        }
        return arr[sum / 2] != 0;
    }


    /**
     * 给你一个整数数组 nums?，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 测试用例的答案是一个?32-位 整数。
     * 子数组 是数组的连续子序列。
     * 示例 1:
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释:?子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释:?结果不能为 2, 因为 [-2,-1] 不是子数组。
     * ?
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证?是一个 32-位 整数
     * 2,3,-1,0,-2,4,7,-2,-1,0,-4
     */
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                min[i] = 0;
                max[i] = 0;
            }else{
                if(nums[i-1] ==0){
                    min[i] = nums[i];
                    max[i] = nums[i];
                }else{
                    max[i] = Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]);
                    max[i] = Math.max(max[i],nums[i]);
                    min[i] = Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]);
                    min[i] = Math.min(min[i],nums[i]);
                }

            }
        }
        int num = nums[0];
        for(int i = 0;i<max.length;i++){
            if(max[i]>num){
                num = max[i];
            }
        }
        return num;
    }


}
