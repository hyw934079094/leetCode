package houyw.java.myself.suanfa;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/15 17:40
 * @Description:
 */
public class Day6 {
    public static void main(String[] args) {
        Day6 day = new Day6();
        String s = "bbbab";
        //System.out.println(day.lengthOfLongestSubstring(s));

        //day.checkInclusion("bd","acbdacbdacbac" );
        boolean b = day.betterSolution("bad", "acbdcacbdacbac");
        System.out.println(b);
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的?最长子串?的长度。
     * 示例?1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
     * ?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s?由英文字母、数字、符号和空格组成
     */

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }


    /**
     * 给你两个字符串?s1?和?s2 ，写一个函数来判断 s2 是否包含 s1?的排列。
     * 如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * 示例 1：
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * 提示：
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     */
    public boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> m1 = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int j = 0; j < s2.length(); j++) {
            int count = 0;
            for (int k = j; k < s2.length(); k++) {
                if (s1.contains(String.valueOf(s2.charAt(k)))) {
                    count++;
                } else {
                    j = k + 1;
                    count = 0;
                }
                if (count == s1.length()) {
                    list.add(s2.substring(j, j + count));
                }
                if (count > s1.length()) {
                    count--;
                    j++;
                    list.add(s2.substring(j, j + count));
                }
                if (k == s2.length() - 1) {
                    j = k;
                }
            }
        }
        if (list.size() > 0) {
            char[] chars = s1.toCharArray();
            Arrays.sort(chars);
            for (String ss : list) {
                char[] chars1 = ss.toCharArray();
                Arrays.sort(chars1);
                if (String.valueOf(chars).equals(String.valueOf(chars1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean betterSolution(String s1, String s2) {
        //下标的位置代表字母，对应的数字代表该字母的个数
        int[] temp = new int[26];
        //s1中字母的个数
        int num = 0;
        for (char c : s1.toCharArray()) {
            if(temp[c - 'a'] ==0){
                num++;
            }
            temp[c - 'a']++;
        }
        //筛选窗口
        int[] window = new int[26];
        //计数：数量对等的字母数
        int count = 0;
        //开始下标
        int start = 0;
        //结束下标
        int end = 0;
        while(end<s2.length()){
            char c = s2.charAt(end);
            window[c-'a']++;
            //每一个字母数量对应上，则技术加1
            if(temp[c-'a']== window[c-'a']){
                count++;
            }
            //如果已经完全对应上了，则开始检查窗口
            while(count == num){
                //如果窗口宽度正好与s1长度相等，则返回true
                if(end-start+1 ==s1.length()){
                    return true;
                }
                //窗口宽度肯定是大于等于s1的长度的,不相等则缩小窗口
                //移除开始下标的字符
                char c1 = s2.charAt(start);
                window[c1-'a']--;
                //如果移除后该字符数量对应不上了，则要改变对应的计数值
                if(window[c1-'a']<temp[c1-'a']){
                    count--;
                }
                start++;
            }
            end ++;
        }

        return false;
    }
}
