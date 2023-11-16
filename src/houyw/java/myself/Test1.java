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
     * �����±�� 0 ��ʼ������Ϊ n?���ַ���?pattern?�������������ַ���'I'?��ʾ ����?��'D'?��ʾ �½�?��
     * ����Ҫ����һ���±�� 0?��ʼ����Ϊ?n + 1?���ַ���������Ҫ��������������
     * num?��������?'1'?��?'9'?������ÿ������?����?ʹ��һ�Ρ�
     * ���?pattern[i] == 'I'?����ô?num[i] < num[i + 1]?��
     * ���?pattern[i] == 'D'?����ô?num[i] > num[i + 1]?��
     * ���㷵���������������ֵ��� ��С?���ַ���?num��
     * ʾ�� 1��
     * ���룺pattern = "IIIDIDDD"
     * �����"123549876"
     * ���ͣ�
     * �±� 0 ��1 ��2 �� 4 ����������Ҫʹ num[i] < num[i+1] ��
     * �±� 3 ��5 ��6 �� 7 ����������Ҫʹ num[i] > num[i+1] ��
     * һЩ���ܵ� num ��ֵΪ "245639871" ��"135749862" �� "123849765" ��
     * "123549876" ������������С�����֡�
     * ע�⣬"123414321" ���ǿ��н���Ϊ���� '1' ʹ�ô������� 1 �Ρ�
     * ʾ�� 2��
     * ���룺pattern = "DDD"
     * �����"4321"
     * ���ͣ�
     * һЩ���ܵ� num ��ֵΪ "9876" ��"7321" �� "8742" ��
     * "4321" ������������С�����֡�
     * ��ʾ��
     * 1 <= pattern.length <= 8
     * pattern?ֻ�����ַ�?'I' ��?'D' ��
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
     * ���һ��������ÿһ����λ���� ������ͬ?�ģ����ǳ����� �������� ��
     * ����һ�� ��?����?n?�����㷵������?[1, n]?֮��������������Ŀ��
     * ʾ�� 1��
     * ���룺n = 20
     * �����19
     * ���ͣ�1 �� 20 ֮�������������� 11 ���ⶼ�����������������ܹ��� 19 ������������
     * ʾ�� 2��
     * ���룺n = 5
     * �����5
     * ���ͣ�1 �� 5 ����������������������
     * ʾ�� 3��
     * ���룺n = 135
     * �����110
     * ���ͣ��� 1 �� 135 �ܹ��� 110 ������������������
     * ������Ĳ�������Ϊ��22 ��114 �� 131 ��
     * 1 <= n <= 2 * 10^9
     */
    public int countSpecialNumbers(int n) {
        if (n <= 10) {
            return n;
        }
        String sn = String.valueOf(n);
        int len = sn.length();
        //��λ��ͨͬ��lenλ��ͬ
        int first = Integer.valueOf(sn.substring(0, 1));
        //�����������
        // 1.���λ���ڵ���0����С��first ������λ����ȡ0~9
        // 2.���λ��first������λ���յ�ǰλ����

        //��һ��
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
