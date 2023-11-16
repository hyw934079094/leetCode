package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/30 17:26
 * @Description:
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 day = new Day13();
        int[] nums = {2,3,0,1,4};
        System.out.println(day.jump(nums));
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    public String longestPalindrome(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i--) {
            dp[i][i] = 1;

        }


        return "";
    }

    /**
     * 给你一个非负整数数组?nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳?1?步，然后跳?3?步到达数组的最后一个位置。
     * 示例 2:
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     * 提示:
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     */
    public int jump(int[] nums) {
        int[] fn = new int[nums.length];
        fn[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (fn[j] == 0) {
                    fn[j] = fn[i] + 1;
                } else {
                    if (fn[j] > fn[i] + 1) {
                        fn[j] = fn[i] + 1;
                    }
                }
            }
        }
        return fn[nums.length - 1];
    }
}
