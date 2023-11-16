package houyw.java.myself.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DELL
 * @Date: 2022/6/23 21:42
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        boolean isomorphic = day.isSubsequence("aaaaaa", "abbbaaaa");
        System.out.println(isomorphic);
    }

    /**
     * 给定两个字符串?s?和?t?，判断它们是否是同构的。
     * 如果?s?中的字符可以按某种映射关系替换得到?t?，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，
     * 同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     * 示例 2：
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * 示例 3：
     * 输入：s = "paper", t = "title"
     * 输出：true
     */
    public boolean isIsomorphic(String s, String t) {
        int[] indexs = new int[256];
        int[] indext = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if (indexs[sc] == 0) {
                indexs[sc] = i + 1;
            } else {
                if (indexs[sc] != indext[st]) {
                    return false;
                }
            }
            if (indext[st] == 0) {
                indext[st] = i + 1;
            } else {
                if (indext[st] != indexs[sc]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 进阶：
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
     * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * 致谢：
     * 特别感谢 @pbrother?添加此问题并且创建所有测试用例。
     * 示例 1：
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     * 提示：
     * 0 <= s.length <= 100
     * 0 <= t.length <= 10^4
     * 两个字符串都只由小写字符组成。
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
