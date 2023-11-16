package houyw.java.myself.suanfa;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/6/11 11:08
 * @Description:
 */
public class Day3 {
    public static void main(String[] args) {
        Day3 day = new Day3();
        int[] nums = {2,7,11,15};
        int[] ints = day.twoSum(nums, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意?，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     * 提示:
     * 1 <= nums.length <= 104
     * -231?<= nums[i] <= 231?- 1
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    public void moveZeroes(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        int start = 0;
        int end = nums.length-1;
        for(int i = 0;i<ints.length;i++){
            if(ints[i]==0){
                nums[end] = 0;
                end--;
            }else{
                nums[start] =ints[i];
                start++;
            }
        }
    }

    /**
     * 给你一个下标从 1 开始的整数数组?numbers ，该数组已按 非递减顺序排列? ，
     * 请你从数组中找出满足相加之和等于目标数?target 的两个数。
     * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
     * 则 1 <= index1 < index2 <= numbers.length 。
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * 你所设计的解决方案必须只使用常量级的额外空间。
     * ?
     * 示例 1：
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     * 示例 2：
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
     * 示例 3：
     *
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     * ?
     *
     * 提示：
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers 按 非递减顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     */
    public int[] twoSum(int[] numbers, int target) {
        /*for(int i = 0;i<numbers.length;i++){
           for(int j=i+1;j<numbers.length;j++){
               if(numbers[i]+numbers[j]==target){
                   return new int[]{i+1,j+1};
               }
           }
        }
        return null;*/
        int start = 0;
        int end  = numbers.length-1;
        while(numbers[start]+numbers[end]!=target){
            if(numbers[start]+numbers[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{start+1,end+1};
    }
}
