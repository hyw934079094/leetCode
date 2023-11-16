package houyw.java.myself.leetcode.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/4 11:04
 * @Description:
 */
public class Day12 {

    public static void main(String[] args) {
        Day12 day = new Day12();
        System.out.println(day.characterReplacement("ABBBB", 1));
    }

    /**
     * 给定两个字符串?s?和 p，找到?s?中所有?p?的?异位词?的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * 示例?1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * ?示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * 提示:
     * 1 <= s.length, p.length <= 3 * 104
     * s?和?p?仅包含小写字母
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] temp = new int[26];
        int[] window = new int[26];
        int size = 0;
        for (int i = 0; i < p.length(); i++) {
            if (temp[p.charAt(i) - 'a'] == 0) {
                size++;
            }
            temp[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c - 'a']++;
            if (temp[c - 'a'] == window[c - 'a']) {
                count++;
            }
            while (count == size) {
                if (right - left == p.length() - 1) {
                    list.add(left);
                }
                char cl = s.charAt(left);
                window[cl - 'a']--;
                if (temp[cl - 'a'] > 0 && temp[cl - 'a'] > window[cl - 'a']) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return list;
    }


    /**
     * ABBACDBBAEFAGHAIJAKLAMNAOPAQRA   3
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，
     * 并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     * 示例 1：
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     * 提示：
     * 1 <= s.length <= 105
     * s 仅由大写英文字母组成
     * 0 <= k <= s.length
     */
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int m = k;
        int count = 0;
        while (start < s.length()) {
            int end = start;
            char cs = s.charAt(start);
            while (end < s.length()) {
                char ce = s.charAt(end);
                if (ce != cs) {
                    m--;
                }
                if (m < 0) {
                    break;
                }
                count++;
                end++;
            }
            if(m>0){
                count+=m;
                if(count>s.length()){
                    count = s.length();
                }
            }
            if (count > max) {
                max = count;
            }
            m = k;
            count = 0;
            start++;
        }
        return max;
    }
}
