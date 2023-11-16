package houyw.java.myself;

import houyw.java.myself.utils.MyUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DELL
 * @Date: 2022/8/14 10:32
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Timestamp dateOfNextMonthFirstDay = MyUtils.getDateOfNextMonthFirstDay(new Date());
        Timestamp dateOfNextMonthFirstDay1 = MyUtils.getDateOfNextMonthFirstDay(new Timestamp(System.currentTimeMillis()));
        System.out.println(dateOfNextMonthFirstDay);
        System.out.println(dateOfNextMonthFirstDay1);

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[i].length; j++) {
                int max = grid[i][j];
                for (int a = i; a < i + 3; a++) {
                    for (int b = j; b < j + 3; b++) {
                        if (grid[a][b] >= max) {
                            max = grid[a][b];
                        }
                    }
                }
                maxLocal[i][j] = max;
            }
        }
        return maxLocal;
    }

    public int edgeScore(int[] edges) {
        long[] nums = new long[edges.length];
        long max = 0;
        int index = 0;
        for (int i = 0; i < edges.length; i++) {
            nums[edges[i]] += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 给你下标从 0 开始、长度为 n?的字符串?pattern?，它包含两种字符，'I'?表示 上升?，'D'?表示 下降?。
     * 你需要构造一个下标从 0?开始长度为?n + 1?的字符串，且它要满足以下条件：
     * num?包含数字?'1'?到?'9'?，其中每个数字?至多?使用一次。
     * 如果?pattern[i] == 'I'?，那么?num[i] < num[i + 1]?。
     * 如果?pattern[i] == 'D'?，那么?num[i] > num[i + 1]?。
     * 请你返回满足上述条件字典序 最小?的字符串?num。
     * 示例 1：
     * 输入：pattern = "IIIDIDDD"
     * 输出："123549876"
     * 解释：
     * 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
     * 下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
     * 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
     * "123549876" 是满足条件最小的数字。
     * 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
     * 示例 2：
     * 输入：pattern = "DDD"
     * 输出："4321"
     * 解释：
     * 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
     * "4321" 是满足条件最小的数字。
     * 提示：
     * 1 <= pattern.length <= 8
     * pattern?只包含字符?'I' 和?'D' 。
     */
    public String smallestNumber(String pattern) {
        Set<Integer> set = new HashSet<>();
        int[] ret = new int[pattern.length() + 1];
        int max = 1;
        ret[0] = 1;
        set.add(ret[0]);
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                ret[i + 1] = ret[i] + 1;
                while (ret[i + 1] <= max) {
                    ret[i + 1]++;
                }
                max = ret[i + 1];
            } else {
                ret[i + 1] = ret[i] - 1;
                while (set.contains(ret[i + 1]) || ret[i + 1] <= 0) {
                    ret[i + 1]++;
                    for (int j = i + 1; j > 0; j--) {
                        if (pattern.charAt(j - 1) == 'D') {
                            set.remove(ret[j - 1]);
                            ret[j - 1]++;
                            set.add(ret[j - 1]);
                            if (ret[j - 1] > max) {
                                max = ret[j - 1];
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            set.add(ret[i + 1]);
        }
        String str = "";
        for (int i = 0; i < ret.length; i++) {
            str += ret[i];
        }
        return str;
    }

    /**
     * 如果一个正整数每一个数位都是 互不相同?的，我们称它是 特殊整数 。
     * 给你一个 正?整数?n?，请你返回区间?[1, n]?之间特殊整数的数目。
     * 示例 1：
     * 输入：n = 20
     * 输出：19
     * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     * 解释：1 到 5 所有整数都是特殊整数。
     * 示例 3：
     * 输入：n = 135
     * 输出：110
     * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
     * 不特殊的部分数字为：22 ，114 和 131 。
     * 1 <= n <= 2 * 10^9
     */
    public int countSpecialNumbers(int n) {
        if (n <= 10) {
            return n;
        }
        String sn = String.valueOf(n);
        int len = sn.length();
        //两位想通同到len位相同
        int first = Integer.valueOf(sn.substring(0, 1));
        //分两种情况，
        // 1.最高位大于等于0但是小于first ，其他位可以取0~9
        // 2.最高位是first，其他位按照当前位计算

        //第一种
        int num1 = 0;
        for (int i = 0; i < first; i++) {

        }
        return 0;
    }

    public int countSpecialNumbersTest(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String sn = String.valueOf(i);
            int len = sn.length();
            if (len == 1) {
                continue;
            }
            if (len == 2) {
                int a = i / 10;
                int b = i % 10;
                if (a == b) {
                    count++;
                }
            } else {
                int a = i / 100;
                int b = i % 100 / 10;
                int c = i % 10;
                if (a == b || a == c || b == c) {
                    count++;
                }
            }
        }

        return n - count;
    }

    public boolean isMatch(String s, String p) {
        boolean[] fn = new boolean[s.length()];
        fn[0] = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        for (int i = 1; i < s.length(); i++) {

        }
        return false;
    }
}
