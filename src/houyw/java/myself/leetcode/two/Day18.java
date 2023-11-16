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
     * ����һ���������� asteroids����ʾ��ͬһ�е����ǡ�
     * ���������е�ÿһ��Ԫ�أ������ֵ��ʾ���ǵĴ�С��������ʾ���ǵ��ƶ���������ʾ�����ƶ�������ʾ�����ƶ�����
     * ÿһ����������ͬ���ٶ��ƶ���
     * �ҳ���ײ��ʣ�µ��������ǡ���ײ�������������໥��ײ����С�����ǻᱬը������������Ǵ�С��ͬ��
     * ���������Ƕ��ᱬը�������ƶ�������ͬ�����ǣ���Զ���ᷢ����ײ��
     * ʾ�� 1��
     * ���룺asteroids = [5,10,-5]
     * �����[5,10]
     * ���ͣ�10 �� -5 ��ײ��ֻʣ�� 10 �� 5 �� 10 ��Զ���ᷢ����ײ��
     * ʾ�� 2��
     * ���룺asteroids = [8,-8]
     * �����[]
     * ���ͣ�8 �� -8 ��ײ�����߶�������ը��
     * ʾ�� 3��
     * ���룺asteroids = [10,2,-5]
     * �����[10]
     * ���ͣ�2 �� -5 ������ײ��ʣ�� -5 ��10 �� -5 ������ײ��ʣ�� 10 ��
     * ��ʾ��
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
     * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
     * ���������������������֡�
     * ����Լ�������ı��ʽ������Ч�ġ������м�������?[-231, 231?- 1] �ķ�Χ�ڡ�
     * ע�⣺������ʹ���κν��ַ�����Ϊ��ѧ���ʽ��������ú��������� eval() ��
     * ʾ�� 1��
     * ���룺s = "3+2*2"
     * �����7
     * ʾ�� 2��
     * ���룺s = " 3/2 "
     * �����1
     * ʾ�� 3��
     * ���룺s = " 3+5 / 2 "
     * �����5
     * ��ʾ��
     * 1 <= s.length <= 3 * 105
     * s ����������� ('+', '-', '*', '/') ��ɣ��м���һЩ�ո����
     * s ��ʾһ�� ��Ч���ʽ
     * ���ʽ�е������������ǷǸ����������ڷ�Χ [0, 231 - 1] ��
     * ��Ŀ���ݱ�֤����һ�� 32-bit ����
     */

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int last = 0;
        List<Integer> nums = new ArrayList<>();
        //��¼����λ��
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
