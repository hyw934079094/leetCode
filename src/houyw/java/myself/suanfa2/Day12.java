package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/3 15:27
 * @Description:
 */
public class Day12 {
    public static void main(String[] args) {
        Day12 day = new Day12();
        int[] nums = {3,2,1,0,4};
        System.out.println(day.canJump(nums));
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * 示例?1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：3
     * 提示：
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //第一个房子不偷的情况,那从第2到第n个房子动态规划
        int[] fn1 = new int[nums.length];
        fn1[0] = 0;
        fn1[1] = nums[1];
        //第一个房子偷的情况,那从第三到第n-1个房子动态规划
        int[] fn2 = new int[nums.length - 1];
        fn2[0] = nums[0];
        fn2[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            fn1[i] = Math.max(fn1[i - 1], fn1[i - 2] + nums[i]);
            if (i < nums.length - 1) {
                fn2[i] = Math.max(fn2[i - 1], fn2[i - 2] + nums[i]);
            }

        }
        int max1 = Math.max(fn1[fn1.length - 1], fn1[fn1.length - 2]);
        int max2 = Math.max(fn2[fn2.length - 1], fn2[fn2.length - 2]);
        return Math.max(max1, max2);

    }


    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * <p>
     * 提示：
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     */
    public boolean canJump(int[] nums) {
        boolean[] fn = new boolean[nums.length];
        fn[0] = true;
        for (int i = 1; i < fn.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!fn[j]) {
                    break;
                }
                if (nums[j] >= (i - j)) {
                    fn[i] = true;
                    break;
                }
            }
        }
        return fn[nums.length - 1];
    }

}
