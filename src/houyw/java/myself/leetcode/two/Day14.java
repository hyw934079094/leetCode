package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/19 09:53
 * @Description:
 */
public class Day14 {
    public static void main(String[] args) {
        Day14 day = new Day14();
        //System.out.println('b' - 'A');
        System.out.println(day.minWindow("a","b"));
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     * 提示：
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     */

    public String minWindow(String s, String t) {
        int[] tmp = new int[52];
        int[] window = new int[52];
        int size = 0;
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            int index = tc - 'A';
            if (index >= 32) {
                index = index - 6;
            }
            if (tmp[index] == 0) {
                size++;
            }
            tmp[index]++;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        String str = "";
        while (right < s.length()) {
            char sc = s.charAt(right);
            int idx = sc - 'A';
            if (idx >= 32) {
                idx = idx - 6;
            }
            window[idx]++;
            if (window[idx] == tmp[idx]) {
                sum++;
            }
            while (sum == size) {
                char c = s.charAt(left);
                if(str.equals("")){
                   str = s.substring(left, right + 1);
                }else if (s.substring(left, right + 1).length() < str.length()) {
                    str = s.substring(left, right + 1);
                }
                int idx1 = c - 'A';
                if (idx1 >= 32) {
                    idx1 = idx1 - 6;
                }
                window[idx1]--;
                if (window[idx1] < tmp[idx1]) {
                    sum--;
                }
                left++;
            }
            right++;

        }
        return str;
    }


    /**
     * 给你一个长度为 n 的整数数组?nums?和 一个目标值?target。
     * 请你从 nums 中选出三个整数，使它们的和与?target?最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * 示例 1：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     * 提示：
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     */
    public int threeSumClosest(int[] nums, int target) {

        return 0;
    }
}
