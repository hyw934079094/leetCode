package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/7 16:20
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
       // System.out.println(day.multiply("123", "456"));
        //System.out.println(day.sum("123", "199"));

        String[] arr = {"flower","","flower","flower"};
        System.out.println(day.longestCommonPrefix(arr));
    }

    /**
     * 给定两个以字符串形式表示的非负整数?num1?和?num2，返回?num1?和?num2?的乘积，
     * 它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例?2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 提示：
     * 1 <= num1.length, num2.length <= 200
     * num1?和 num2?只能由数字组成。
     * num1?和 num2?都不包含任何前导零，除了数字0本身。
     * 123
     * 123
     * 369
     * 246
     * 123
     * 15129
     */
    public String multiply(String num1, String num2) {
        String allSum = "";
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int jin = 0;
            String sum = "";
            int n1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = Integer.valueOf(String.valueOf(num2.charAt(j)));
                int num = n1 * n2 + jin;
                if (num >= 10) {
                    if (j == 0) {
                        sum = String.valueOf(num) + sum;
                    } else {
                        sum = String.valueOf(num % 10) + sum;
                    }

                    jin = num / 10;
                } else {
                    sum = String.valueOf(num) + sum;
                    jin = 0;
                }
            }
            for (int k = num1.length() - 1 - i; k > 0; k--) {
                sum = sum + "0";
            }
            allSum = sum(allSum, sum);
        }
        return allSum;
    }

    public String sum(String num1, String num2) {
        String sum = "";
        int jin = 0;
        while (num1.length() > num2.length()) {
            num2 = "0" + num2;
        }
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            int n2 = Integer.valueOf(String.valueOf(num2.charAt(i)));
            int num = n1 + n2 + jin;
            if (num >= 10) {
                if (i == 0) {
                    sum = String.valueOf(num) + sum;
                } else {
                    sum = String.valueOf(num - 10) + sum;
                }
                jin = num / 10;
            } else {
                sum = String.valueOf(num) + sum;
                jin = 0;
            }

        }
        return sum;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串?""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 提示：
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].equals("")) {
            return str;
        }
        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (String ss : strs) {
                if (ss.length() <= i) {
                    return str;
                }
                if (ss.charAt(i) != c) {
                    return str;
                }
            }
            str += c;
            i++;
        }
        return str;
    }
}
