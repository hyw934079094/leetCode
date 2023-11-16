package houyw.java.myself.leetcode.dtgh;

/**
 * @Author: DELL
 * @Date: 2022/8/24 11:26
 * @Description:
 */
public class Hard {
    public static void main(String[] args) {
        Hard hard = new Hard();
        String ss = "(()";
        int i1 = hard.longestValidParentheses(ss);
        System.out.println(i1);
    }

    /**
     * 32. 最长有效括号
     * 给你一个只包含 '('?和 ')'?的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 示例 1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * 输入：s = ""
     * 输出：0
     * ?
     * 提示：
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     */

    public int longestValidParentheses(String s) {
        int i = s.indexOf(')');
        char[] chars = s.toCharArray();
        while (i >= 0) {
            int index = i - 1;
            //当前右括号是否可以闭合
            boolean flag = false;
            //已经闭合的直接跳过
            while (index > 0 && chars[index] == '1') {
                index--;
            }
            //找到可闭合的左括号后都替换成1
            if (index >= 0 && chars[index] == '(') {
                chars[index] = '1';
                chars[i] = '1';
                flag = true;
            }
            if (!flag) {
                //无法闭关的右括号替换成0
                chars[i] = '0';
            }
            //替换后的首个右括号下标
            i = String.valueOf(chars).indexOf(')');

        }
        int count = 0;
        int max = 0;
        //如果包含闭合括号
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] =='1') {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }
}
