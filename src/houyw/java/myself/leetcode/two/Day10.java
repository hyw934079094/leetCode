package houyw.java.myself.leetcode.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/13 17:38
 * @Description:
 */
public class Day10 {
    public static void main(String[] args) {
        Day10 day = new Day10();
        //int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] heights = {{2, 1}, {1, 2}};
        List<List<Integer>> lists = day.pacificAtlantic(heights);
        System.out.println(lists);
    }

    /**
     * �ڸ�����?m x n?����?grid?�У�ÿ����Ԫ���������������ֵ֮һ��
     * ֵ?0?����յ�Ԫ��
     * ֵ?1?�����������ӣ�
     * ֵ?2?�����õ����ӡ�
     * ÿ���ӣ����õ�����?��Χ?4 ������������ ���������Ӷ��ḯ�á�
     * ���� ֱ����Ԫ����û����������Ϊֹ�����뾭������С����������������ܣ�����?-1?��
     * ʾ�� 1��
     * ���룺grid = [[2,1,1],[1,1,0],[0,1,1]]
     * 221     222     222    222
     * 210     220     220    220
     * 011     011     021    022
     * �����4
     * ʾ�� 2��
     * ���룺grid = [[2,1,1],[0,1,1],[1,0,1]]
     * �����-1
     * ���ͣ����½ǵ����ӣ��� 2 �У� �� 0 �У���Զ���ḯ�ã���Ϊ����ֻ�ᷢ���� 4 �������ϡ�
     * ʾ�� 3��
     * ���룺grid = [[0,2]]
     * �����0
     * ���ͣ���Ϊ 0 ����ʱ�Ѿ�û�����������ˣ����Դ𰸾��� 0 ��
     * ��ʾ��
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 10
     * grid[i][j] ��Ϊ?0��1?��?2
     */
    public int orangesRotting(int[][] grid) {
        int time = 0;
        List<int[]> ints = orangesRotting(grid, new ArrayList<int[]>());
        if (ints.size() != 0) {
            while (ints.size() > 0) {
                time++;
                ints = orangesRotting(grid, ints);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public List<int[]> orangesRotting(int[][] grid, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            grid[list.get(i)[0]][list.get(i)[1]] = 2;
        }
        list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //����
                    if (i > 0 && grid[i - 1][j] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //���
                    if (j > 0 && grid[i][j - 1] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //�±�
                    if (i < grid.length - 1 && grid[i + 1][j] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                    //�ұ�
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 2) {
                        list.add(new int[]{i, j});
                        continue;
                    }
                }
            }
        }
        return list;
    }


    /**
     * ��һ�� m �� n �ľ��ε��죬�� ̫ƽ�� �� ������ ���ڡ�?
     * ��̫ƽ��?���ڴ�½����߽���ϱ߽磬�� �������� ���ڴ�½���ұ߽���±߽硣
     * ��������ָ��һ�������ɷ��ε�Ԫ����ɵ����񡣸���һ�� m x n ����������?heights?��?
     * heights[r][c]?��ʾ���� (r, c) �ϵ�Ԫ�� ���ں�ƽ��ĸ߶� ��
     * ������ˮ�϶࣬������ڵ�Ԫ��ĸ߶� С�ڻ���� ��ǰ��Ԫ��ĸ߶ȣ���ˮ����ֱ���򱱡��ϡ��������������ڵ�Ԫ��
     * ˮ���ԴӺ��󸽽����κε�Ԫ�����뺣��
     * ������������ result?�� 2D �б� ������?result[i] = [ri, ci]?��ʾ��ˮ�ӵ�Ԫ�� (ri, ci) ���� �ȿ�����̫ƽ��Ҳ����������� ��
     * ʾ�� 1��
     * ����: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
     * ���: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
     * ʾ�� 2��
     * ����: heights = [[2,1],[1,2]]
     * ���: [[0,0],[0,1],[1,0],[1,1]]
     * ��ʾ��
     * m == heights.length
     * n == heights[r].length
     * 1 <= m, n <= 200
     * 0 <= heights[r][c] <= 105
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] one = new int[heights.length][heights[0].length];
        int[][] two = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (i == 0 || j == 0) {
                    pacificAtlantic(one, i, j, heights);
                }
                if (i == heights.length - 1 || j == heights[i].length - 1) {
                    pacificAtlantic(two, i, j, heights);
                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (one[i][j] == 1 && two[i][j] == 1) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    lst.add(j);
                    list.add(lst);
                }
            }
        }
        return list;
    }

    public void pacificAtlantic(int[][] arr, int i, int j, int[][] heights) {
        arr[i][j] = 1;
        if (i > 0 && heights[i - 1][j] >= heights[i][j] && arr[i - 1][j] == 0) {
            pacificAtlantic(arr, i - 1, j, heights);
        }
        if (i < heights.length - 1 && heights[i + 1][j] >= heights[i][j] && arr[i + 1][j] == 0) {
            pacificAtlantic(arr, i + 1, j, heights);
        }

        if (j > 0 && heights[i][j - 1] >= heights[i][j] && arr[i][j - 1] == 0) {
            pacificAtlantic(arr, i, j - 1, heights);
        }
        if (j < heights[0].length - 1 && heights[i][j + 1] >= heights[i][j] && arr[i][j + 1] == 0) {
            pacificAtlantic(arr, i, j + 1, heights);
        }
    }
}
