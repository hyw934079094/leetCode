package houyw.java.myself.face;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/8/11 09:46
 * @Description:
 */
public class pindd {
    public static void main(String[] args) {
        pindd pdd = new pindd();
        System.out.println("abababab".replaceAll("ab", ""));
    }

    //实现pow(x,y)
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (n >= 0) {
            double ret = 1;
            while (n-- > 0) {
                ret *= x;
            }
            return ret;
        } else {
            return Math.sqrt(n);
        }
    }

    /**
     * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * <p>
     * ?
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：6
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：24
     * 示例 3：
     * <p>
     * 输入：nums = [-1,-2,-3]
     * 输出：-6
     * ?
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <=?104
     * -1000 <= nums[i] <= 1000
     */
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int len = nums.length;
        //返回正数得情况
        int max = Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
        return max;
    }

    /**
     * 给定一个非空的字符串?s?，检查是否可以通过由它的一个子串重复多次构成。
     * <p>
     * ?
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * 示例 2:
     * <p>
     * 输入: s = "aba"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     * ?
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s?由小写英文字母组成
     * <p>
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() > 1) {
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (c != s.charAt(i)) {
                    continue;
                }
                if (i < s.length() && s.replace(s.substring(0, i), "").length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i?个火柴棒的长度。
     * 你要用 所有的火柴棍?拼成一个正方形。
     * 你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
     * 如果你能使这个正方形，则返回 true ，否则返回 false 。
     * 示例?1:
     * 输入: matchsticks = [1,1,2,2,2]
     * 输出: true
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     * 示例?2:
     * 输入: matchsticks = [3,3,3,3,4]
     * 输出: false
     * 解释: 不能用所有火柴拼成一个正方形。
     * 提示:
     * 1 <= matchsticks.length <= 15
     * 1 <= matchsticks[i] <= 108
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int zhouchang = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            zhouchang += matchsticks[i];
        }
        if (zhouchang % 4 > 0) {
            return false;
        }
        int bian = zhouchang/4;

        return false;
    }

}
