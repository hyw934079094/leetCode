package houyw.java.single.guilv;

/**
 * @Author: houyw
 * @Date: 2022/4/2 16:52
 * @Description:
 */
public class Solution {
    /**
     * 输出数字EXCEL表对应字符
     * complete
     */
    public static String convertToTitle(int columnNumber) {
        int x = columnNumber / 26;
        int y = columnNumber % 26;
        if (y == 0) {
            x--;
            y = 26;
        }
        String r = "";
        String s = String.valueOf((char) ('Z' - (26 - y)));
        if (x > 26) {
            r = convertToTitle(x);
        } else if (x > 0) {
            r = String.valueOf((char) ('Z' - (26 - x)));
            if (x == 0) {
                r = "";
            }
        }
        return r + s;
    }

    /**
     * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
     * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
     * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
     * 示例 1：
     * 输入：n = 8
     * 输出：6
     * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
     * 示例 2：
     * 输入：n = 1
     * 输出：1
     * 解释：1 是中枢整数，因为 1 = 1 。
     * 示例 3：
     * 输入：n = 4
     * 输出：-1
     * 解释：可以证明不存在满足题目要求的整数。
     * 提示：
     * 1 <= n <= 1000
     */
    public int pivotInteger(int n) {
        int x = (1 + n) / 2;
        int sum = (1 + n) * n / 2;
        int left = (1 + x) * x / 2;
        int right = sum - left + x;
        while (left < right) {
            right -= x;
            x++;
            left += x;

        }
        if (left == right) {
            return x;
        }
        return -1;
    }

    /**
     * 丑数 就是只包含质因数?2、3 和 5?的正整数。
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：n = 6
     * 输出：true
     * 解释：6 = 2 × 3
     * 示例 2：
     * 输入：n = 1
     * 输出：true
     * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
     * 示例 3：
     * 输入：n = 14
     * 输出：false
     * 解释：14 不是丑数，因为它包含了另外一个质因数?7 。
     */
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    /**
     * 给定一种规律 pattern?和一个字符串?s?，判断 s?是否遵循相同的规律。
     * 这里的?遵循?指完全匹配，例如，?pattern?里的每个字母和字符串?s?中的每个非空单词之间存在着双向连接的对应规律。
     * 示例1:
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * 输入:pattern = "abba", s = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * 输入: pattern = "aaaa", s = "dog cat cat dog"
     * 输出: false
     * 提示:
     * 1 <= pattern.length <= 300
     * pattern?只包含小写英文字母
     * 1 <= s.length <= 3000
     * s?只包含小写英文字母和?' '
     * s?不包含 任何前导或尾随对空格
     * s?中每个单词都被 单个空格 分隔
     */

    public boolean wordPattern(String pattern, String s) {
        String[] arr = new String[26];
        String[] s1 = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            if (arr[pattern.charAt(i) - 'a'] != null) {

            }
            arr[pattern.charAt(i) - 'a'] = s1[i];
        }
        return false;
    }

    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
     * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     */
    public boolean lemonadeChange(int[] bills) {
        int[] con = new int[2];
        for (int i = 0; i < bills.length; i++) {
            //如果不需要找零
            if(bills[i] == 5){
                con[0]++;
            }
            if(bills[i] == 10){
                con[0]--;
                con[1]++;
                if(con[0]<0){
                    return false;
                }
            }
            if (bills[i] == 20) {
                if(con[1]>0){
                    con[1]--;
                    con[0]--;
                }else{
                    con[0]-=3;
                }
                if(con[0]<0){
                    return false;
                }
            }
        }
        return true;
    }

}
