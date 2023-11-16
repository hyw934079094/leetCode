package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/9 16:11
 * @Description:
 */
public class Day17 {
    /**
     * 给定两个字符串?text1 和?text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的?子序列?是指这样一个新的字符串：
     * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * 示例 1：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     * 提示：
     * 1 <= text1.length, text2.length <= 1000
     * text1 和?text2 仅由小写英文字符组成。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //fn[i][j]代表text1前i+1位和text2前j+1位得最长公共子串长度
        int[][] fn = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)) {
            fn[0][0] = 1;
        } else {
            fn[0][0] = 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                fn[i][0] = 1;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }
        for (int j = 1; j < text2.length(); j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                fn[0][j] = 1;
            } else {
                fn[0][j] = fn[0][j - 1];
            }
        }
        if (text1.charAt(0) == text2.charAt(0)) {
            fn[0][0] = 1;
        } else {
            fn[0][0] = 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    fn[i][j] = fn[i - 1][j - 1] + 1;
                } else {
                    fn[i][j] = Math.max(fn[i - 1][j], fn[i][j - 1]);
                }
            }
        }
        return fn[text1.length() - 1][text2.length() - 1];
    }

    /**
     * 给定两个单词?word1?和?word2?，返回使得?word1?和??word2?相同所需的最小步数。
     * 每步?可以删除任意一个字符串中的一个字符。
     * 示例 1：
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     * 示例 ?2:
     * 输入：word1 = "leetcode", word2 = "etco"
     * 输出：4
     * 提示：
     * 1 <= word1.length, word2.length <= 500
     * word1?和?word2?只包含小写英文字母
     */
    public int minDistance(String word1, String word2) {
        //fn[i][j]表示word1前i+1位变成word2前j+1位需要得步数
        int[][] fn = new int[word1.length()][word2.length()];
        if (word1.charAt(0) == word2.charAt(0)) {
            fn[0][0] = 0;
        } else {
            fn[0][0] = 2;
        }
        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                fn[i][0] = i;
            } else {
                fn[i][0] = 1 + fn[i - 1][0];
            }
        }
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt(0) == word2.charAt(j)) {
                fn[0][j] = j;
            } else {
                fn[0][j] = 1 + fn[0][j - 1];
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    fn[i][j] = fn[i - 1][j - 1];
                } else {
                    fn[i][j] = Math.min(fn[i - 1][j], fn[i][j - 1]) + 1;
                }
            }
        }

        return fn[word1.length()-1][word2.length()-1];
    }
}
