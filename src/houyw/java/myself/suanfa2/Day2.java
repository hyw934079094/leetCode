package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/26 17:39
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        int[] nums = {1, 2, 3, 1};
        int peakElement = day.findPeakElement(nums);
        System.out.println(peakElement);
    }


    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，
     * 得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * 你必须设计一个时间复杂度为?O(log n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     * 示例 3：
     * 输入：nums = [11,13,15,17]
     * 输出：11
     * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
     * 提示：
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数 互不相同
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     */

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = (start + end) / 2;
        while (start < end) {
            if (nums[index] < nums[end]) {
                end = index;
            } else {

            }

        }
        return nums[0];
    }

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * 给你一个整数数组?nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 你可以假设?nums[-1] = nums[n] = -∞ 。
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * 示例 1：
     * 输入：nums = [1,2,3,1]
     * 输出：2
     * 解释：3 是峰值元素，你的函数应该返回其索引 2。
     * 示例?2：
     * 输入：nums = [1,2,1,3,5,6,4]
     * 输出：1 或 5
     * 解释：你的函数可以返回索引 1，其峰值元素为 2；
     * ?    或者返回索引 5， 其峰值元素为 6。
     * 提示：
     * 1 <= nums.length <= 1000
     * -231 <= nums[i] <= 231 - 1
     * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[1] < nums[0]) {
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i]) {
                if (nums[i + 1] < nums[i]) {
                    return i;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return -1;
    }
}
