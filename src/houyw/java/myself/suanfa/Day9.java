package houyw.java.myself.suanfa;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/20 16:12
 * @Description:
 */
public class Day9 {
    public static void main(String[] args) {
        Day9 day = new Day9();
        int[][] nums = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ints = day.updateMatrix(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int[] num : ints) {
            List<Integer> l = new ArrayList<>();
            for (int n : num) {
                l.add(n);
            }
            list.add(l);
        }
        System.out.println(list);
    }

    /**
     * ����һ���� 0 �� 1 ��ɵľ��� mat?�������һ����С��ͬ�ľ���
     * ����ÿһ�������� mat �ж�Ӧλ��Ԫ�ص������ 0 �ľ��롣
     * ��������Ԫ�ؼ�ľ���Ϊ 1 ��
     * ʾ�� 1��
     * ���룺mat = [[0,0,0],[0,1,0],[0,0,0]]
     * �����[[0,0,0],[0,1,0],[0,0,0]]
     * ʾ�� 2��
     * ���룺mat = [[0,0,0],[0,1,0],[1,1,1]]
     * �����[[0,0,0],[0,1,0],[1,2,1]]
     */
    public int[][] updateMatrix(int[][] matrix) {
        /*
        BFS
        ���ĳ��λ�ñ����� 0����ô�� 0 �ľ���Ϊ 0
        ���ĳ��λ���������Ҵ��� һ�����ϵ� 0����ô����Ϊ 1
        */
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] res = new int[matrix.length][matrix[0].length];
        int step = 1;
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0){
                int[] p = queue.poll();
                for(int i = 0; i < 4; i++){
                    int x = p[0] + pos[i][0];
                    int y = p[1] + pos[i][1];
                    if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1){
                        matrix[x][y] = 0;
                        res[x][y] = step;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return res;
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
     * �����4
     * ʾ�� 2��
     * ���룺grid = [[2,1,1],[0,1,1],[1,0,1]]
     * �����-1
     * ���ͣ����½ǵ����ӣ��� 2 �У� �� 0 �У���Զ���ḯ�ã���Ϊ����ֻ�ᷢ���� 4 �������ϡ�
     * ʾ�� 3��
     * ���룺grid = [[0,2]]
     * �����0
     * ���ͣ���Ϊ 0 ����ʱ�Ѿ�û�����������ˣ����Դ𰸾��� 0 ��
     */
    public int orangesRotting(int[][] grid) {
        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && true) {
                    //����
                    if (i > 0) {

                    }
                }
            }
        }
        return min;
    }
}
