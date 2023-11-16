package houyw.java.myself.leetcode.one;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: DELL
 * @Date: 2022/7/1 10:56
 * @Description:
 */
public class Day14 {


    public static void main(String[] args) {
        Day14 day = new Day14();
        System.out.println(day.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，
     * 如果两者相等，返回 true 。# 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * 示例 1：
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：s 和 t 都会变成 "ac"。
     * 示例 2：
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 ""。
     * 示例 3：
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 "c"，但 t 仍然是 "b"。
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 200
     * s 和 t 只含有小写字母以及字符 '#'
     */
    public boolean backspaceCompare(String s, String t) {
        while (s.indexOf("#") >= 0) {
            if (s.indexOf("#") > 0) {
                String str = s.charAt(s.indexOf("#") - 1) + "#";
                s = s.replace(str, "");
            } else {
                s = s.replaceFirst("#", "");
            }
        }

        while (t.indexOf("#") >= 0) {
            if (t.indexOf("#") > 0) {
                String str = t.charAt(t.indexOf("#") - 1) + "#";
                t = t.replace(str, "");
            } else {
                t = t.replaceFirst("#", "");
            }
        }
        return s.equals(t);
    }

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像?3a?或?2[4]?的输入。
     * 示例 1：
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     * 提示：
     * 1 <= s.length <= 30
     * s?由小写英文字母、数字和方括号?'[]' 组成
     * s?保证是一个?有效?的输入。
     * s?中所有整数的取值范围为?[1, 300]?
     */

    public String decodeString(String s) {
        while (s.indexOf(']') > 0) {
            int end = s.indexOf(']');
            int start = s.substring(0, end).lastIndexOf('[');
            String counts = "";
            int countStart = 0;
            String str = s.substring(start + 1, end);
            for (int i = start - 1; i >= 0; i--) {
                if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                    counts = s.charAt(i) + counts;
                } else {
                    countStart = i + 1;
                    break;
                }
            }
            String s1 = str;
            for (int j = 1; j < Integer.valueOf(counts); j++) {
                str += s1;
            }
            s = s.replace(s.substring(countStart, end + 1), str);
        }
        return s;
    }

    public String decodeString1(String s) {
        int end = s.indexOf(']');
        int start = s.substring(0, end).lastIndexOf('[');
        String counts = "";
        int countStart = 0;
        for (int i = start - 1; i >= 0; i--) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                counts = s.charAt(i) + counts;
            } else {
                countStart = i + 1;
                break;
            }
        }
        StringBuilder str = new StringBuilder(s.substring(start + 1, end));
        String s1 = str.toString();
        for (int j = 1; j < Integer.valueOf(counts); j++) {
            str.append(s1);
        }
        s = s.replace(s.substring(countStart, end + 1), str);
        return decodeString1(s);
    }

}
