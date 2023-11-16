package houyw.java.myself.face;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/8/10 10:25
 * @Description:
 */
public class mihayou {
    public static void main(String[] args) {
        mihayou mh = new mihayou();
        int i = mh.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))");
        System.out.println(i);
    }

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * 示例 1:
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例?2:
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     * 提示：
     * 1 <= k <= nums.length <= 105
     * -104?<= nums[i] <= 104
     */
    public int findKthLargest(int[] nums, int k) {

        return 0;
    }

    /**
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * 给你一个平衡字符串?s，请你将它分割成尽可能多的平衡字符串。
     * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * 示例 1：
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 示例 2：
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 示例 3：
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR".
     * 示例 4：
     * 输入：s = "RLRRRLLRLL"
     * 输出：2
     * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     */
    public int balancedStringSplit(String s) {
        int a = 0;
        int b = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                a++;
            }
            if (s.charAt(i) == 'L') {
                b++;
            }
            if (a == b) {
                count++;
            }
        }
        return count;
    }

    /**
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     * 现在，可以绘制一些连接两个数字 nums1[i]?和 nums2[j]?的直线，这些直线需要同时满足满足：
     * ?nums1[i] == nums2[j]
     * 且绘制的直线不与任何其他连线（非水平线）相交。
     * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     * 以这种方法绘制线条，并返回可以绘制的最大连线数。
     * 示例 1：
     * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
     * 输出：2
     * 解释：可以画出两条不交叉的线，如上图所示。
     * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
     * 示例 2：
     * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
     * 输出：3
     * 示例 3：
     * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
     * 输出：2
     * 提示：
     * 1 <= nums1.length, nums2.length <= 500
     * 1 <= nums1[i], nums2[j] <= 2000
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] fn = new int[nums1.length][nums2.length];
        if (nums1[0] == nums2[0]) {
            fn[0][0] = 1;
        }
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                fn[i][0] = 1;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }

        for (int i = 1; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                fn[0][i] = 1;
            } else {
                fn[0][i] = fn[0][i - 1];
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    fn[i][j] = fn[i - 1][j - 1] + 1;
                } else {
                    fn[i][j] = Math.max(fn[i - 1][j], fn[i][j - 1]);
                }
            }
        }
        return fn[nums1.length - 1][nums2.length - 1];
    }

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * 示例 1：
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * 提示：
     * 1 <= s.length <= 3?* 105
     * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * s 表示一个有效的表达式
     * '+' 不能用作一元运算(例如， "+1"?和 "+(2 + 3)"?无效)
     * '-' 可以用作一元运算(即 "-1"?和 "-(2 + 3)"?是有效的)
     * 输入中不存在两个连续的操作符
     * 每个数字和运行的计算将适合于一个有符号的 32位 整数
     */
    public int calculate(String s) {
        //去括号
        s = s.replaceAll(" ", "");
        while (s.indexOf(')') > 0) {
            int end = s.indexOf(')');
            for (int i = end - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    int ret = calculateEx(s.substring(i + 1, end));
                    String pre = "";
                    if (i > 0) {
                        //可能出现--的情况
                        if (ret < 0&&(s.charAt(i - 1) == '-'||s.charAt(i - 1) == '+')) {
                            if (s.charAt(i - 1) == '-') {
                                pre = s.substring(0, i - 1) + "+" + (-ret);
                            } else {
                                pre = s.substring(0, i - 1) + ret;
                            }
                        } else {
                            pre = s.substring(0, i) + ret;
                        }
                    } else {
                        pre = String.valueOf(ret);
                    }

                    if (end < s.length()) {
                        s = pre + s.substring(end + 1);
                    } else {
                        s = pre;
                    }
                    break;
                }
            }
        }
        return calculateEx(s.trim());
    }

    public int calculateEx(String s) {
        //简单表达式计算
        Queue<Integer> que = new LinkedList();
        Queue<Character> q = new LinkedList<>();
        if (s.charAt(0) == '-') {
            que.add(0);
        }
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                q.add(s.charAt(index));
                if (index > 0 && index < s.length()) {
                    que.add(Integer.valueOf(s.substring(0, index)));
                }
                s = s.substring(index + 1);
                index = 0;
            } else {
                index++;
            }

        }
        que.add(Integer.valueOf(s));
        int num1 = que.poll();
        while (q.size() > 0) {
            int num2 = que.poll();
            char poll = q.poll();
            if (poll == '+') {
                num1 += num2;
            } else {
                num1 -= num2;
            }
        }
        return num1;
    }
}
