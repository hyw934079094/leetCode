package houyw.java.myself.suanfa;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/6/10 15:20
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        int[] nums = {1};
        int[] ints = day.sortedSquares(nums);

        day.rotate(nums, 4);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(ints[i] + ",");
        }


    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，
     * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 示例 1：
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * 提示：
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        boolean flag = true;
        if(nums.length%2 ==0){
            flag = false;
        }
        while(i<j){
            nums[i] = nums[i]*nums[i];
            nums[j] = nums[j]*nums[j];
            i++;
            j--;
        }
        if(flag){
            nums[i] = nums[i]*nums[i];
        }
        /*for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        */
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 给你一个数组，将数组中的元素向右轮转 k?个位置，其中?k?是非负数。
     * 示例 1:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例?2:
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     * 提示：
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     * 进阶：
     * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为?O(1) 的?原地?算法解决这个问题吗？
     */
    public void rotate(int[] nums, int k) {
        //原数组上处理   空间复杂度o(1)

    }

    public void rotate1(int[] nums, int k) {
        //原数组上处理   但是需要求最大公约数
        if (k == 0) {
            return;
        }
        int m = maxGYS(nums.length,k );
        for (int j = 0; j < m; j++) {
            int firstIndex = j;
            int index = firstIndex;
            int temp = nums[j];
            int x;
            for (int i = 0; i < nums.length; i++) {
                index = index + k;
                while (index > nums.length - 1) {
                    index = index - nums.length;
                }
                x = nums[index];
                nums[index] = temp;
                temp = x;
                if (index == firstIndex) {
                    break;
                }
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        //使用一个新数组 complete
        int[] newarr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < newarr.length; i++) {
            int index = i + k;
            while (index > nums.length - 1) {
                index = index - nums.length;
            }
            nums[index] = newarr[i];
        }
    }

    public int maxGYS(int a, int b) {
        int max = a;
        int min = b;
        if (a > b) {
            max = b;
            min = a;
        }

        while (max % min != 0) {
            int k = max % min;
            max = min;
            min = k;
        }
        return min;
    }
}
