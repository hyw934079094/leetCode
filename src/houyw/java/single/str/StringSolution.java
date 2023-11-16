package houyw.java.single.str;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/3/17 16:08
 * @Description:
 */
public class StringSolution {
    /**
     * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
     * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
     * 字符串可以写为 AB（A 与 B?字符串连接），其中 A 和 B 都是 有效括号字符串 。
     * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
     * 类似地，可以定义任何有效括号字符串?S 的 嵌套深度 depth(S)：
     * depth("") = 0
     * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
     * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
     * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
     * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
     * <p>
     * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
     * 输入：s = "(1+(2*3)+((8)/4))+1"
     * 输出：3
     * 解释：数字 8 在嵌套的 3 层括号中。
     * complete
     */
    public static int maxDepth(String s) {
        int count = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                leftCount++;
            }
            if (s.charAt(i) == ')') {
                if (leftCount > count) {
                    count = leftCount;
                }
                leftCount--;
            }

        }
        return count;
    }

    /**
     * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。
     * 如果不存在这样的子字符串，返回 -1 。
     * 子字符串 是字符串中的一个连续字符序列。
     * complete
     */
    public static int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        int max = -1;
        if (chars.length >= 2) {
            for (int i = chars.length - 1; i >= 0 && max < i; i--) {
                String str = String.valueOf(chars[i]);
                int start = s.indexOf(str);
                if (start < i) {
                    int temp = i - start - 1;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }


    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * complete
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            while (i < j && !String.valueOf(chars[i]).matches("[0-9a-z]")) {
                i++;
            }

            while (i < j && !String.valueOf(chars[j]).matches("[0-9a-z]")) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给你一个字符串?text，你需要使用 text 中的字母来拼凑尽可能多的单词?"balloon"（气球）。
     * 字符串?text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词?"balloon"。
     * complete
     */
    public static int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int n = 0;
        int o = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).equals("a")) {
                a++;
            }
            if (text.substring(i, i + 1).equals("b")) {
                b++;
            }
            if (text.substring(i, i + 1).equals("l")) {
                l++;
            }
            if (text.substring(i, i + 1).equals("n")) {
                n++;
            }
            if (text.substring(i, i + 1).equals("o")) {
                o++;
            }
        }
        if (a == 0 || b == 0 || l == 0 || n == 0 || o == 0) {
            return 0;
        }
        int x = a;
        if (b < x) {
            x = b;
        }
        if (n < x) {
            x = n;
        }
        int y = l;
        if (o < y) {
            y = o;
        }
        if (y > 2 * x) {
            return x;
        } else {
            return y / 2;
        }
    }

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
     * 如果数组中每个元素互不相同，返回 false 。
     * 示例 1：
     * 输入：nums = [1,2,3,1]
     * 输出：true
     * 示例 2：
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 示例?3：
     * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
     * 输出：true
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * complete
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给你一个整数数组?nums 和一个整数?k ，判断数组中是否存在两个 不同的索引?i?和?j ，
     * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     * 示例?1：
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * 示例 3：
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     * complete
     * nice
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.getOrDefault(nums[i], null) == null) {
                mp.put(nums[i], i);
            } else {
                if (i - mp.get(nums[i]) <= k) {
                    return true;
                }
                mp.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」?定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为?1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     * 示例 1：
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 示例 2：
     * 输入：n = 2
     * 输出：false
     */
    public boolean isHappy(int n) {
        Set set = new HashSet();
        int sum = 0;
        while (n != 1) {
            while (n / 10 > 0) {
                int num = n % 10;
                n = n / 10;
                sum += num * num;
            }
            n = n % 10;
            sum += n * n;
            if (sum == 1) {
                return true;
            } else {
                if (set.contains(sum)) {
                    return false;
                }
                set.add(sum);
            }
            n = sum;
            sum = 0;
        }
        return true;
    }

    /**
     * 给定两个字符串?s?和?t?，判断它们是否是同构的。
     * t.length == s.length
     * 如果?s?中的字符可以按某种映射关系替换得到?t?，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
     * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
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
        Map<Character, Character> mps = new HashMap();
        Map<Character, Character> mpt = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (mps.getOrDefault(sc, null) != null) {
                if (mps.get(sc) != tc) {
                    return false;
                }
            } else {
                mps.put(sc, tc);
            }

            if (mpt.getOrDefault(tc, null) != null) {
                if (mpt.get(tc) != sc) {
                    return false;
                }
            } else {
                mpt.put(tc, sc);
            }
        }
        return true;
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若?s 和 t?中每个字符出现的次数都相同，则称?s 和 t?互为字母异位词。
     * 示例?1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 提示:
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t?仅包含小写字母
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
     * 示例 1:
     * 输入: num = 38
     * 输出: 2
     * 解释: 各位相加的过程为：
     * 38 --> 3 + 8 --> 11
     * 11 --> 1 + 1 --> 2
     * 由于?2 是一位数，所以返回 2。
     * 示例 2:
     * 输入: num = 0
     * 输出: 0
     * 提示：
     * 0 <= num <= 231?- 1
     */
    public int addDigits(int num) {
        int newNum = num;
        while (newNum >= 10) {
            num = newNum;
            newNum = 0;
            while (num != 0) {
                newNum += num % 10;
                num = num / 10;
            }
        }
        return newNum;
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String str = "";
        int wei = 0;
        for (int i = 0; i < num1.length(); i++) {
            int numOne = Integer.valueOf(String.valueOf(num1.charAt(num1.length() - 1 - i)));
            int numTwo = 0;
            if (i < num2.length()) {
                numTwo = Integer.valueOf(num2.substring(num2.length() - 1 - i, num2.length() - i));
            }
            int sum = numOne + numTwo + wei;
            if (sum >= 10) {
                sum = sum - 10;
                wei = 1;
            } else {
                wei = 0;
            }
            str = sum + str;
        }
        if (wei > 0) {
            str = wei + str;
        }
        return str;
    }

    public int alternateDigitSum(int n) {
        int num1 = 0;
        int num2 = 0;
        int wei = 0;
        while (n > 0) {
            int num = n % 10;
            if (wei % 2 == 0) {
                num2 += num;
            } else {
                num1 += num;
            }
            wei++;
            n = n / 10;
        }
        if (wei % 2 == 0) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        List<String> list = new ArrayList();
        for (int i = 0; i < jewels.length(); i++) {
            list.add((String.valueOf(jewels.charAt(i))));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (list.contains(String.valueOf(stones.charAt(i)))) {
                count++;
            }
        }
        return count;
    }


    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int count = 0;
        while (left != right) {
            while (height[left] == 0 && left < right) {
                left++;
            }
            while (height[right] == 0 && left < right) {
                right--;
            }
            int x = Math.min(height[left], height[right]);
            for (int i = left; i <= right; i++) {
                height[i] = height[i] - x;
                if (height[i] < 0) {
                    count += height[i];
                    height[i] = 0;
                }
            }
        }

        return -count;
    }


    /**
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
     * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
     * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     */

    public int minFallingPathSum(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int length = result.length;
        int min  = 0;
        for (int i = 0; i < result[length - 1].length; i++) {
            result[length - 1][i] = matrix[length - 1][i];
        }
        for (int i = result.length - 2; i >= 0; i--) {
            for (int j = 0; j < result[i].length; j++) {
                int x = result[i + 1][j] + matrix[i][j];
                if (j == 0) {
                    result[i][j] = Math.min( matrix[i][j]+result[i+1][j+1],x);
                }else if(j==  result[i].length - 1){
                    result[i][j] = Math.min( matrix[i][j]+result[i+1][j-1],x);
                }else{
                    result[i][j] = Math.min(Math.min( matrix[i][j]+result[i+1][j-1],matrix[i][j]+result[i+1][j+1]),x);
                }
            }
        }
        for (int i = 0; i < result[0].length; i++) {
            if(i == 0){
                min = result[0][i];
            }else{
                min = Math.min(min,result[0][i]);
            }
        }
        return min;
    }



}
