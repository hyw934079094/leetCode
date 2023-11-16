package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/28 20:37
 * @Description:
 */
public class Day18 {
    public static void main(String[] args) {
        Day18 day = new Day18();
        String s1 = "aaa";
        String s2 = "bbb";

        // int i = day.minDistance(s1, s2);
        int i1 = day.integerBreak(20);
        System.out.println(i1);
    }

    /**
     * 给你两个单词?word1 和?word2， 请返回将?word1?转换成?word2 所使用的最少操作数 ?。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 示例?1：
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例?2：
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     * 提示：
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     */

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] fn = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                //只需要删除i个字符
                fn[i][0] = i;
            } else {
                if (i == 0) {
                    //替换一个字符
                    fn[i][0] = 1;
                } else {
                    fn[i][0] = fn[i - 1][0] + 1;
                }
            }
        }
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt((0)) == word2.charAt(j)) {
                //只需要添加j个字符
                fn[0][j] = j;
            } else {
                fn[0][j] = fn[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    //如果当前字符相等
                    fn[i][j] = fn[i - 1][j - 1];
                } else {
                    //不相等，可以通过fn[i-1][j]变换过来，也可以根据fn[i][j-1]变换过来
                    int num = fn[i][j - 1];
                    if (fn[i - 1][j] < fn[i][j - 1]) {
                        num = fn[i - 1][j];
                    }
                    if (fn[i - 1][j - 1] < num) {
                        num = fn[i - 1][j - 1];
                    }
                    fn[i][j] = Math.min(num, Math.max(i, j)) + 1;
                }
            }
        }
        return fn[word1.length() - 1][word2.length() - 1];
    }

    /**
     * 给定一个正整数?n?，将其拆分为 k 个 正整数 的和（?k >= 2?），并使这些整数的乘积最大化。
     * 返回 你可以获得的最大乘积?。
     * 示例 1:
     * 输入: n = 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例?2:
     * 输入: n = 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 ×?3 ×?4 = 36。
     * 提示:
     * 2 <= n <= 58
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] fn = new int[n+1];
        //从2开始
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 2;
        fn[3] = 3;
        for (int i = 4; i < fn.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (fn[i - j] * fn[j] > fn[i]) {
                    fn[i] = fn[i - j] * fn[j];
                }
            }
        }
        return fn[fn.length-1];
    }
}
