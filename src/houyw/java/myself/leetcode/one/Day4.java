package houyw.java.myself.leetcode.one;

/**
 * @Author: DELL
 * @Date: 2022/6/27 10:16
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        Day4 day = new Day4();
        String ss = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int i = day.longestPalindrome(ss);
        System.out.println(i);
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * 提示：
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int low = prices[0];
        int high = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = 0;
            }
            if (prices[i] > high) {
                high = prices[i];
            }
            if (high - low > max) {
                max = high - low;
            }
        }
        return max;
    }

    /**
     * 给定一个包含大写字母和小写字母的字符串?s?，返回?通过这些字母构造成的 最长的回文串?。
     * 在构造过程中，请注意 区分大小写 。比如?"Aa"?不能当做一个回文字符串。
     * 示例 1:
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     * 输入:s = "a"
     * 输入:1
     * 示例 3:
     * 输入:s = "bb"
     * 输入: 2
     * 提示:
     * 1 <= s.length <= 2000
     * s?只能由小写和/或大写英文字母组成
     */
    public int longestPalindrome(String s) {
        int[] nums = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 90) {
                //A~Z  0~25
                nums[c - 'A']++;
            } else {
                //a~z  26~51
                nums[c - 'A' - 6]++;
            }
        }
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (nums[i] % 2 == 1) {
                count--;
                max = 1;
            }
        }
        return count + max;
    }
}
