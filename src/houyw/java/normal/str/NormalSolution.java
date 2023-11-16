package houyw.java.normal.str;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/4/26 16:53
 * @Description:
 */
public class NormalSolution {


    public static void main(String[] args) {
        NormalSolution no = new NormalSolution();
        //int[] fips = {5, 4, 3, 2, 1, 6, 7, 8};
        // System.out.println(no.numTimesAllBlue(fips));
        String s = "ninmjmj";
        int[][] queries = {{6, 6, 0}, {1, 1, 1}, {2, 5, 4}, {1, 3, 1}, {5, 6, 1}};
        System.out.println(no.canMakePaliQueries(s, queries));


    }

    /**
     * 返回字符串中的最长回文子串
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     * complete
     */
    public String maxRetStr(String s) {
        List<String> lst = new ArrayList<>();
        String ret = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int start = i;
            int end = s.lastIndexOf(c);
            while (end != start) {
                int x = start;
                int y = end;
                while (y - x > 2 && s.charAt(x) == s.charAt(y)) {
                    x++;
                    y--;
                }
                if (y - x <= 2 && s.charAt(x) == s.charAt(y)) {
                    lst.add(s.substring(start, end + 1));
                    break;
                }
                end--;

                while (s.charAt(start) != s.charAt(end)) {
                    end--;
                }
            }

        }
        if (lst.size() > 0) {
            for (String str : lst) {
                if (str.length() > ret.length()) {
                    ret = str;
                }
            }
        }
        return ret;
    }

    /**
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [?231,? 231?? 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 ?231 的整数应该被固定为 ?231 ，大于 231?? 1 的整数应该被固定为 231?? 1 。
     * 返回整数作为最终结果。
     * complete
     */

    public int myAtoi(String s) {
        s = s.trim();
        int fuhao = 1;
        int start = 0;
        if (s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        if (c == '+' || c == '-') {
            start = 1;
            if (c == '-') {
                fuhao = -1;
            }
        }
        String ss = "";
        while (start < s.length() && s.charAt(start) >= 48 && s.charAt(start) <= 57) {
            ss += s.charAt(start);
            start++;
        }
        int num = 0;
        if (ss == "") {
            return 0;
        }
        try {
            num = Integer.valueOf(ss);
        } catch (NumberFormatException e) {
            if (fuhao < 0) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }


        return num * fuhao;
    }

    /**
     * 给你一个由 n 个整数组成的数组?nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组?[nums[a], nums[b], nums[c], nums[d]]?（若两个四元组元素一一对应，则认为两个四元组重复）：
     * 0 <= a, b, c, d?< n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * 示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**
     * 数字 n?代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     * complete
     */
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        Set<String> set = new HashSet();
        set.add("()");
        for (int i = 1; i <= n; i++) {
            Set<String> st = new HashSet();
            for (String s : set) {
                for (String s1 : set) {
                    st.add(s);
                    st.add("(" + s + ")");
                    if (s.length() + s1.length() <= i * 2) {
                        st.add(s + s1);
                        st.add(s1 + s);
                    }
                }
            }
            set = st;
        }
        for (String str : set) {
            if (str.length() == n * 2) {
                lst.add(str);
            }
        }
        return lst;
    }


    /**
     * 给定两个字符串?a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     * 注意：字符串 "abc"?重复叠加 0 次是 ""，重复叠加 1 次是?"abc"，重复叠加 2 次是?"abcabc"。
     * 示例 1：
     * 输入：a = "abcd", b = "cdabcdab"
     * 输出：3
     * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
     * 示例 2：
     * 输入：a = "a", b = "aa"
     * 输出：2
     * 示例 3：
     * 输入：a = "a", b = "a"
     * 输出：1
     * 示例 4：
     * 输入：a = "abc", b = "wxyz"
     * 输出：-1
     * complete
     */
    public int repeatedStringMatch(String a, String b) {
        if (b == "") {
            return 0;
        }
        if (a.indexOf(b) > -1) {
            return 1;
        }
        String ss = a + a;
        //叠加一次还没有则要么说明要么需要叠加多次要么就不可能有
        //叠加多次的情况下b中必定有a
        if (ss.indexOf(b) == -1 && b.indexOf(a) == -1) {
            return -1;
        }
        if (ss.indexOf(b) > -1) {
            return 2;
        }
        //叠加多次
        if (b.indexOf(a) > -1) {
            int count = 2;
            while (ss.length() <= b.length()) {
                ss += a;
                count++;
                if (ss.indexOf(b) > -1) {
                    return count;
                }
            }
            ss += a;
            if (ss.indexOf(b) > -1) {
                return count + 1;
            }

        }
        return -1;
    }

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * 示例 1：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     * complete
     */

    //耗时很长
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    set.add(sum);
                }
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (int n : set) {
            arr[index] = n;
            index++;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                if (i > 0) {
                    if (target - arr[i - 1] > arr[i] - target) {
                        return arr[i];
                    } else {
                        return arr[i - 1];
                    }
                } else {
                    return arr[i];
                }
            }
        }
        return arr[arr.length - 1];
    }

    //尝试优化
    public int threeSumClosest1(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * 输入：nums = [1]
     * 输出：[[1]]
     * complete
     * nice
     */
    public List<List<Integer>> permute(int[] nums) {
        //以任意一个数为最后一位的情况为基准，为前面n-个数的全排列最后加上这个数
        List<List<Integer>> retList = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> integers = new ArrayList<>();
            integers.add(nums[0]);
            retList.add(integers);
            return retList;
        }
        for (int i = 0; i < nums.length; i++) {
            //基准数
            int end = nums[i];
            //对应数组
            int[] numStart = new int[nums.length - 1];
            boolean isFand = false;
            for (int j = 0; j < numStart.length; j++) {
                if (nums[j] == end) {
                    //基准数之后，所有的数下标+1
                    isFand = true;
                }
                if (!isFand) {
                    numStart[j] = nums[j];
                } else {
                    numStart[j] = nums[j + 1];
                }
            }
            List<List<Integer>> list = permute(numStart);
            for (List<Integer> lst : list) {
                lst.add(end);
            }
            retList.addAll(list);

        }

        return retList;
    }

    /**
     * 给你一个 无重复元素 的整数数组?candidates 和一个目标整数?target?，
     * 找出?candidates?中可以使数字和为目标数?target 的 所有?不同组合 ，并以列表形式返回。
     * 你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。
     * 如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为?target 的不同组合数少于 150 个。
     * 示例?1：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例?2：
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * 输入: candidates = [2], target = 1
     * 输出: []
     * complete
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            //包含第i个数为基准的list
            int num = target - candidates[i];
            if (num < 0) {
                continue;
            }
            if (num == 0) {
                List<Integer> l = new ArrayList<>();
                l.add(target);
                retList.add(l);
            }
            List<List<Integer>> lst = combinationSum(candidates, num);
            if (lst.size() > 0) {
                for (List<Integer> list : lst) {
                    if (list.get(list.size() - 1) > candidates[i]) {
                        continue;
                    }
                    list.add(candidates[i]);
                    retList.add(list);
                }
            }
        }
        return retList;
    }

    /**
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，
     * 累计整数和，先使得累计整数和 达到或超过? 100 的玩家，即为胜者。
     * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     * 给定两个整数?maxChoosableInteger?（整数池中可选择的最大数）和?desiredTotal（累计和），
     * 若先出手的玩家是否能稳赢则返回 true?，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
     * 1 <= maxChoosableInteger <= 20
     * 0 <= desiredTotal <= 300
     * 示例 1：
     * 输入：maxChoosableInteger = 10, desiredTotal = 11
     * 输出：false
     * 解释：
     * 无论第一个玩家选择哪个整数，他都会失败。
     * 第一个玩家可以选择从 1 到 10 的整数。
     * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
     * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
     * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
     * 示例 2:
     * 输入：maxChoosableInteger = 10, desiredTotal = 0
     * 输出：true
     * 示例 3:
     * 输入：maxChoosableInteger = 10, desiredTotal = 1
     * 输出：true
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (desiredTotal - maxChoosableInteger < maxChoosableInteger) {
            return true;
        }
        int max = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (desiredTotal <= max) {
            //先出手的都会想办法保证出手后让对方不进入必胜先手局

        }
        return false;
    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 提示：
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[0]);
            lst.add(oneList);
        } else {
            List<Integer> allNums = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (allNums.contains(nums[i])) {
                    continue;
                } else {
                    allNums.add(nums[i]);
                }
                int[] newNum = new int[nums.length - 1];
                for (int j = 0; j < newNum.length; j++) {
                    if (j >= i) {
                        newNum[j] = nums[j + 1];
                    } else {
                        newNum[j] = nums[j];
                    }
                }
                List<List<Integer>> lists = permuteUnique(newNum);
                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                }
                lst.addAll(lists);
            }
        }
        return lst;
    }

    /**
     * 给定两个整数，被除数?dividend?和除数?divisor。将两数相除，要
     * 求不使用乘法、除法和 mod 运算符。
     * 返回被除数?dividend?除以除数?divisor?得到的商。
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 示例?1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例?2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     * 提示：
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为?0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,? 231?? 1]。本题中，如果除法结果溢出，则返回 231?? 1。
     * 通过次数168,553提交次数759,951
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        //用异或来计算是否符号相异
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            //找出足够大的数2^n*divisor
            if ((t >> i) >= d) {
                //将结果加上2^n
                result += 1 << i;
                //将被除数减去2^n*divisor
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }


    /**
     * 给定字符串列表?strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
     * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
     * ?s?的?子序列可以通过删去字符串?s?中的某些字符实现。
     * 例如，"abc"?是 "aebdc"?的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc"?。
     * "aebdc"的子序列还包括"aebdc"、 "aeb"?和 ""?(空字符串)。
     * 示例 1：
     * 输入: strs = ["aba","cdc","eae"]
     * 输出: 3
     * 示例 2:
     * 输入: strs = ["aaa","aaa","aa"]
     * 输出: -1
     * 提示:
     * 2 <= strs.length <= 50
     * 1 <= strs[i].length <= 10
     * strs[i]?只包含小写英文字母
     */
    public int findLUSlength(String[] strs) {
        int len = 0;
        int num = 0;
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                nums[i] = nums[i] | (1 << 'z' - c);
            }
        }
        return nums[0];
    }

    /**
     * 给你一个整数数组?nums，将它重新排列成?nums[0] < nums[1] > nums[2] < nums[3]...?的顺序。
     * 你可以假设所有输入数组都可以得到满足题目要求的结果。
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,1,1,6,4]
     * 输出：[1,6,1,5,1,4]
     * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
     * 示例 2：
     * 输入：nums = [1,3,2,2,3,1]
     * 输出：[2,3,1,3,1,2]?
     * <p>
     * 提示：
     * 1 <= nums.length <= 5 * 104
     * 0 <= nums[i] <= 5000
     * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
     */

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        int length = clone.length;
        Arrays.sort(clone);
        int middle = (length & 1) == 0 ? (length >> 1) : ((length + 1) >> 1);
        int r = middle - 1;
        int l = length - 1;
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 0) {
                nums[i] = clone[r--];
            } else {
                nums[i] = clone[l--];
            }
        }
    }

    /**
     * 罗马数字包含以下七种字符：?I，?V，?X，?L，C，D?和?M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做?II?，即为两个并列的 1。12 写做?XII?，即为?X?+?II?。
     * 27 写做??XXVII,即为?XX?+?V?+?II?。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做?IIII，而是?IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为?IX。
     * 这个特殊的规则只适用于以下六种情况：
     * I?可以放在?V?(5) 和?X?(10) 的左边，来表示 4 和 9。
     * X?可以放在?L?(50) 和?C?(100) 的左边，来表示 40 和?90。?
     * C?可以放在?D?(500) 和?M?(1000) 的左边，来表示?400 和?900。
     * 给你一个整数，将其转为罗马数字。
     * 示例?1:
     * 输入:?num = 3
     * 输出: "III"
     * 示例?2:
     * 输入:?num = 4
     * 输出: "IV"
     * 示例?3:
     * 输入:?num = 9
     * 输出: "IX"
     * 示例?4:
     * 输入:?num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例?5:
     * 输入:?num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * 1 <= num <= 3999
     * complete
     */
    public String intToRoman(int num) {
        String str = "";
        String str1 = "";
        String str2 = "";
        String str3 = "";
        int ge = num % 10;
        int shi = num % 100;
        int bai = num % 1000;
        int qian = num / 1000;
        //个位
        if (ge > 0) {
            if (ge == 9) {
                str = "IX";
            } else {
                int k = ge;
                if (ge == 4) {
                    str = "IV";
                    k = 0;
                } else if (ge > 4) {
                    str = "V";
                    k = ge - 5;
                }
                while (k > 0) {
                    str += "I";
                    k--;
                }
            }
        }
        //十位
        if (shi >= 10) {
            shi = shi - ge;
            if (shi == 90) {
                str1 = "XC";
            } else {
                int k = shi;
                if (shi == 40) {
                    str1 = "XL";
                    k = 0;
                } else if (shi > 40) {
                    str1 = "L";
                    k = shi - 50;
                }
                while (k > 0) {
                    str1 += "X";
                    k = k - 10;
                }
            }
        }
        //百位
        if (bai / 100 > 0) {
            bai = bai / 100;
            if (bai == 9) {
                str2 = "CM";
            } else {
                int k = bai;
                if (bai == 4) {
                    str2 = "CD";
                    k = 0;
                } else if (bai > 4) {
                    str2 = "D";
                    k = bai - 5;
                }
                while (k > 0) {
                    str2 += "C";
                    k = k - 1;
                }
            }
        }
        //千位
        while (qian > 0) {
            str3 += "M";
            qian--;
        }
        return str3 + str2 + str1 + str;
    }

    /**
     * 给你一个由数字和运算符组成的字符串?expression ，按不同优先级组合数字和运算符，
     * 计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
     * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
     * 示例 1：
     * 输入：expression = "2-1-1"
     * 输出：[0,2]
     * 解释：
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     * 示例 2：
     * 输入：expression = "2*3-4*5"
     * 输出：[-34,-14,-10,-10,10]
     * 解释：
     * (2*(3-(4*5))) = -34    112
     * ((2*3)-(4*5)) = -14   22
     * ((2*(3-4))*5) = -10   121
     * (2*((3-4)*5)) = -10   121
     * (((2*3)-4)*5) = 10   211
     * 提示：
     * 1 <= expression.length <= 20
     * expression 由数字和算符 '+'、'-' 和 '*' 组成。
     * 输入表达式中的所有整数值在范围 [0, 99]?
     * complete
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> inexList = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                inexList.add(i);
            }
        }
        if (inexList.size() > 0) {
            nums.add(Integer.valueOf(expression.substring(0, inexList.get(0))));
        } else {
            nums.add(Integer.valueOf(expression));
        }

        for (int i = 0; i < inexList.size(); i++) {
            if (i == inexList.size() - 1) {
                nums.add(Integer.valueOf(expression.substring(inexList.get(i) + 1)));
            } else {
                nums.add(Integer.valueOf(expression.substring(inexList.get(i) + 1, inexList.get(i + 1))));
            }
        }
        return getList(nums, inexList, expression);
    }


    private List<Integer> getList(List<Integer> nums, List<Integer> exps, String expression) {
        List<Integer> result = new ArrayList<>();
        if (exps.size() == 0) {
            return nums;
        }
        if (exps.size() == 1) {
            result.add(getResult(nums.get(0), expression.charAt(exps.get(0)), nums.get(1)));
            return result;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> leftExps = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            List<Integer> rightExps = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                left.add(nums.get(j));
                if (j < i) {
                    leftExps.add(exps.get(j));
                }
            }
            for (int j = i + 1; j < nums.size(); j++) {
                right.add(nums.get(j));
                if (j > i + 1) {
                    rightExps.add(exps.get(j - 1));
                }
            }
            List<Integer> list = getList(left, leftExps, expression);
            List<Integer> list1 = getList(right, rightExps, expression);
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list1.size(); k++) {
                    result.add(getResult(list.get(j), expression.charAt(exps.get(i)), list1.get(k)));
                }
            }
        }
        return result;
    }

    private int getResult(int left, char c, int right) {
        if (c == '+') {
            return left + right;
        } else if (c == '-') {
            return left - right;
        } else if (c == '*') {
            return left * right;
        }
        return -1;
    }

    /**
     * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。
     * 我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
     * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
     * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间?[1, i] 内的所有位都是 1 ，而其他位都是 0 。
     * 返回二进制字符串在翻转过程中 前缀一致 的次数。
     * 示例 1：
     * 输入：flips = [3,2,4,1,5]
     * 输出：2
     * 解释：二进制字符串最开始是 "00000" 。
     * 执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
     * 执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
     * 执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
     * 执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
     * 执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
     * 在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
     * 示例 2：
     * <p>
     * 输入：flips = [4,1,2,3]
     * 输出：1
     * 解释：二进制字符串最开始是 "0000" 。
     * 执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
     * 执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
     * 执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
     * 执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
     * 在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。
     */
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        //当前是否翻转一致数组
        boolean[] result = new boolean[n];
        //二进制字符串对应数字数组
        int[] nums = new int[n];
        int count = 0;
        //前n位都是1的最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            //当前下标位是1且 当前下标减1位是翻转一致，则当前下标翻转一致
            nums[flips[i] - 1] = 1;
            if (nums[max] == 1) {
                result[max] = true;
                for (int j = max + 1; j < n; j++) {
                    if (nums[j] == 1 && result[j - 1]) {
                        result[j] = true;
                        max = j;
                    } else {
                        break;
                    }
                }
            }
            if (result[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 给你一个字符串?s，请你对?s?的子串进行检测。
     * 每次检测，待检子串都可以表示为?queries[i] = [left, right, k]。
     * 我们可以 重新排列 子串?s[left], ..., s[right]，并从中选择 最多 k?项替换成任何小写英文字母。?
     * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为?true，否则结果为?false。
     * 返回答案数组?answer[]，其中?answer[i]?是第?i?个待检子串?queries[i]?的检测结果。
     * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，
     * 如果?s[left..right] = "aaa"?且?k = 2，我们只能替换其中的两个字母。
     * （另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
     * 示例：
     * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
     * 输出：[true,false,false,true,true]
     * 解释：
     * queries[0] : 子串 = "d"，回文。
     * queries[1] :?子串 = "bc"，不是回文。
     * queries[2] :?子串 = "abcd"，只替换 1 个字符是变不成回文串的。
     * queries[3] :?子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
     * queries[4] :?子串 = "abcda"，可以变成回文的 "abcba"。
     * 提示：
     * <p>
     * 1 <= s.length,?queries.length?<= 10^5
     * 0 <= queries[i][0] <= queries[i][1] <?s.length
     * 0 <= queries[i][2] <= s.length
     * s 中只有小写英文字母
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>(queries.length);
        //使用数组保存前i+1位的连续子串的二进制位置，例如： a是1 ，b是10.ab是11 aa或者bb是0 ,所以需要用异或
        //n表示字符长度,需要0~n 共n+1位，例如 0~2有两位，需要用0~0异或0~2
        int[] arr = new int[s.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ (1 << (s.charAt(i - 1) - 'a'));
        }
        for (int i = 0; i < queries.length; i++) {
            //二进制1的个数，表示落单的字符数量
            int count = 0;
            //如果是0~4 需要用0~4异或0~0
            //如果是3~4 需要用0~4异或0~2
            //表示子串对应数字
            int num = arr[queries[i][0]] ^ arr[queries[i][1] + 1];
            while (num != 0) {
                num = num & (num - 1);
                count++;
            }
            list.add(count / 2 <= queries[i][2]);
        }
        return list;

    }
}
