package houyw.java.myself.leetcode.two;

import houyw.common.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/7/21 15:28
 * @Description:
 */
public class Day18 {
    public static void main(String[] args) {
        Day18 day = new Day18();
        int[] arr = {8, -8};
        // int[] ints = day.asteroidCollision(arr);
        // ArrayUtils.print(ints);
        int calculate = day.calculate("0 ");
        System.out.println(calculate);
    }

    /**
     * 给定一个整数数组 asteroids，表示在同一行的行星。
     * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
     * 每一颗行星以相同的速度移动。
     * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
     * 则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     * 示例 1：
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     * 示例 2：
     * 输入：asteroids = [8,-8]
     * 输出：[]
     * 解释：8 和 -8 碰撞后，两者都发生爆炸。
     * 示例 3：
     * 输入：asteroids = [10,2,-5]
     * 输出：[10]
     * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
     * 提示：
     * 2 <= asteroids.length?<= 104
     * -1000 <= asteroids[i] <= 1000
     * asteroids[i] != 0
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int i = 1;
        while (i < asteroids.length) {
            if (stack.size() > 0 && stack.peek() > 0 && asteroids[i] < 0) {
                if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                    i++;
                    continue;
                }
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                    continue;
                }
                if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                    stack.pop();
                    i++;
                    continue;
                }
            }
            stack.push(asteroids[i]);
            i++;

        }
        if (!stack.isEmpty()) {
            int[] ret = new int[stack.size()];
            for (int j = ret.length - 1; j >= 0; j--) {
                ret[j] = stack.pop();
            }
            return ret;
        }
        return new int[0];
    }

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     * 你可以假设给定的表达式总是有效的。所有中间结果将在?[-231, 231?- 1] 的范围内。
     * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * 示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     * 示例 3：
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * s 表示一个 有效表达式
     * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
     * 题目数据保证答案是一个 32-bit 整数
     */

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int last = 0;
        List<Integer> nums = new ArrayList<>();
        //记录符号位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (last == 0) {
                    nums.add(Integer.valueOf(s.substring(0, i)));
                } else {
                    nums.add(Integer.valueOf(s.substring(last + 1, i)));
                }
                last = i;
            }
        }
        if (last == 0) {
            return Integer.valueOf(s);
        }
        nums.add(Integer.valueOf(s.substring(last + 1)));
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                index++;
            } else {
                continue;
            }
            if (c == '*') {
                nums.set(index + 1, nums.get(index) * nums.get(index + 1));
                nums.remove(index);
                index--;
            }
            if (c == '/') {
                nums.set(index + 1, nums.get(index) / nums.get(index + 1));
                nums.remove(index);
                index--;
            }
        }
        index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                index++;
            } else {
                continue;
            }
            if (c == '+') {
                nums.set(index, nums.get(index) + nums.get(index + 1));
                nums.remove(index + 1);
                index--;
            }
            if (c == '-') {
                nums.set(index, nums.get(index) - nums.get(index + 1));
                nums.remove(index + 1);
                index--;
            }
        }

        return nums.get(0);
    }
}
