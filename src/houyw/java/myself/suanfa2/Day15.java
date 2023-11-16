package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/8 10:35
 * @Description:
 */
public class Day15 {
    public static void main(String[] args) {
        Day15 day = new Day15();
        //String[] direct = {"leet", "code"};
        List<String> direct = new ArrayList<>();
        direct.add("leet");
        direct.add("code");
        System.out.println(day.wordBreak("leetcode",direct));

    }

    /**
     * 一条包含字母?A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为? (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * 示例 1：
     * <p>
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2：
     * <p>
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 示例 3：
     * <p>
     * 输入：s = "0"
     * 输出：0
     * 解释：没有字符映射到以 0 开头的数字。
     * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
     * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
     * 提示：
     * 1 <= s.length <= 100
     * s 只包含数字，并且可能包含前导零。
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] fn = new int[s.length()];
        fn[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                if (i > 1) {
                    fn[i] = fn[i - 2];
                } else {
                    fn[i] = 1;
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    fn[i] = fn[i - 1];
                } else {
                    int num = Integer.valueOf(s.substring(i - 1, i + 1));
                    if (num <= 26) {
                        if (i > 1) {
                            fn[i] = fn[i - 1] + fn[i - 2];
                        } else {
                            fn[i] = fn[i - 1] + 1;
                        }
                    } else {
                        fn[i] = fn[i - 1];
                    }
                }
            }


        }
        return fn[fn.length - 1];
    }

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * 示例 1：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     * ?    注意，你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * ?
     *
     * 提示：
     *
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅有小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/word-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return true;
        }
        boolean[] dp = new  boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(String word:wordDict){
                if(word.length()>i){
                    continue;
                }
                if(s.substring(i-word.length(),i ).equals(word)&&dp[i-word.length()]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
