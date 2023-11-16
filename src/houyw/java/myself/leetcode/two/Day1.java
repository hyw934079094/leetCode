package houyw.java.myself.leetcode.two;

import houyw.common.utils.ArrayUtils;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/7/7 11:18
 * @Description:
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day = new Day1();
        //boolean happy = day.isHappy(19);
        //[[23,18,20,26,25],[24,22,3,4,4],[15,22,2,24,29],[18,15,23,28,28]]
        int[][] arrs = {{23, 18, 20, 26, 25}, {24, 22, 3, 4, 4}, {15, 22, 2, 24, 29}, {18, 15, 23, 28, 28}};
        // int[] ball = day.findBall(arrs);
        System.out.println(day.spiralOrder(arrs));

    }

    /**
     * ��дһ���㷨���ж�һ���� n �ǲ��ǿ�������
     * ����������?����Ϊ��
     * ����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���͡�
     * Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ������ ����ѭ�� ��ʼ�ձ䲻�� 1��
     * ���������� ���Ϊ?1����ô��������ǿ�������
     * ��� n �� ������ �ͷ��� true �����ǣ��򷵻� false ��
     * ʾ�� 1��
     * ���룺n = 19
     * �����true
     * ���ͣ�
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * ʾ�� 2��
     * ���룺n = 2
     * �����false
     * ��ʾ��
     * 1 <= n <= 231 - 1
     */
    public boolean isHappy(int n) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(n, 1);
        while (sum != 1 || n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
            if (n == 0) {
                if (sum == 1) {
                    break;
                }

                n = sum;
                sum = 0;
                if (map.getOrDefault(n, 0) == 1) {
                    return false;
                } else {
                    map.put(n, 1);
                }
            }

        }
        return true;
    }

    /**
     * ��һ����СΪ m x n �Ķ�ά���� grid ��ʾһ�����ӡ����� n �������ӵĶ����͵ײ����ǿ��ŵġ�
     * �����е�ÿ����Ԫ����һ���Խ��ߵ��壬�����Ԫ��������ǣ����Խ������������Ҳࡣ
     * �������Ҳ�ĵ��������ϽǺ����½ǣ����������� 1 ��ʾ��
     * ���������ĵ��������ϽǺ����½ǣ����������� -1 ��ʾ��
     * ������ÿһ�еĶ��˸���һ����ÿ���򶼿��ܿ����������ӵײ���������
     * �����ǡ�ÿ������鵲��֮��� "V" ��ͼ�������߱�һ�鵲�������ӵ�����һ����ϣ��ͻῨס��
     * ����һ����СΪ n ������ answer ������ answer[i] ������ڶ����ĵ� i �к�ӵײ�����������һ�ж�Ӧ���±꣬
     * ������ں�����򷵻� -1 ��
     * ʾ�� 1��
     * ���룺grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
     * �����[1,-1,-1,-1,-1]
     * ���ͣ�ʾ����ͼ��
     * b0 ��ʼ���ڵ� 0 ���ϣ����մ����ӵײ��� 1 �е�����
     * b1 ��ʼ���ڵ� 1 ���ϣ��Ῠ�ڵ� 2��3 �к͵� 1 ��֮��� "V" ���
     * b2 ��ʼ���ڵ� 2 ���ϣ��Ῠ�ڵ� 2��3 �к͵� 0 ��֮��� "V" ���
     * b3 ��ʼ���ڵ� 3 ���ϣ��Ῠ�ڵ� 2��3 �к͵� 0 ��֮��� "V" ���
     * b4 ��ʼ���ڵ� 4 ���ϣ��Ῠ�ڵ� 2��3 �к͵� 1 ��֮��� "V" ���
     * ʾ�� 2��
     * ���룺grid = [[-1]]
     * �����[-1]
     * ���ͣ��򱻿������������ϡ�
     * ʾ�� 3��
     * ���룺grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
     * �����[0,1,2,3,4,-1]
     * ��ʾ��
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * grid[i][j] Ϊ 1 �� -1
     */

    public int[] findBall(int[][] grid) {
        int[] arr = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int index = findBall(grid, 0, i);
            if (index >= 0) {
                arr[i] = index;
            } else {
                arr[i] = -1;
            }
        }
        return arr;
    }


    public int findBall(int[][] grid, int x, int y) {
        //�����1,����Ҫ�ж��ұߵĵ���
        if (grid[x][y] == 1) {
            //�ж��ұߵĵ���
            if (y == grid[0].length - 1) {
                //���ұߵĻ��͵�����ȥ��
                return -1;
            } else {
                if (grid[x][y + 1] == -1) {
                    //V���Ϳ�ס
                    return -1;
                } else {
                    //����һ����
                    if (x == grid.length - 1) {
                        //��������һ���򷵻ض�Ӧ����
                        return y + 1;
                    } else {
                        return findBall(grid, x + 1, y + 1);
                    }
                }
            }
        } else {
            //�����-1,����Ҫ�ж���ߵĵ���
            if (y == 0) {
                //�����
                return -1;
            } else {
                //��Ҫ�ж���ߵõ���
                if (grid[x][y - 1] == 1) {
                    //V���Ϳ�ס
                    return -1;
                } else {
                    //����һ����
                    if (x == grid.length - 1) {
                        //��������һ���򷵻ض�Ӧ����
                        return y - 1;
                    } else {
                        return findBall(grid, x + 1, y - 1);
                    }
                }
            }
        }
    }


    /**
     * ����һ�� m �� n �еľ���?matrix ���밴�� ˳ʱ������˳�� �����ؾ����е�����Ԫ�ء�
     * ʾ�� 1��
     * ���룺matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * �����[1,2,3,6,9,8,7,4,5]
     * ʾ�� 2��
     * ���룺matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * �����[1,2,3,4,8,12,11,10,9,5,6,7]
     * ?
     * <p>
     * ��ʾ��
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * [23,18,20,26,25,4,29,28,28,23,15,18,15,24,22,3,4,24,2,22]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        int x = 0;
        int y = 0;
        //1��2��3��4��
        int act = 1;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            list.add(matrix[x][y]);
            if (act == 1) {
                setX.add(x);
                if (y == matrix[x].length - 1 || setY.contains(y + 1)) {
                    act = 2;
                    x++;
                    continue;
                } else {
                    y++;
                }
            }
            if (act == 2) {
                setY.add(y);
                if (x == matrix.length - 1 || setX.contains(x + 1)) {
                    act = 3;
                    y--;
                    continue;
                } else {
                    x++;
                }
            }
            if (act == 3) {
                setX.add(x);
                if (y == 0 || setY.contains(y - 1)) {
                    act = 4;
                    x--;
                    continue;
                } else {
                    y--;
                }
            }
            if (act == 4) {
                setY.add(y);
                if (x == 0 || setX.contains(x - 1)) {
                    act = 1;
                    y++;
                    continue;
                } else {
                    x--;
                }
            }

        }
        return list;
    }

}
