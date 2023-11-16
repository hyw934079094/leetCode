package houyw.java.myself.leetcode.one;

/**
 * @Author: DELL
 * @Date: 2022/7/1 10:14
 * @Description:
 */
public class Day8 {
    public static void main(String[] args) {
        Day8 day = new Day8();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(day.numIslands(grid));
    }

    /**
     * ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
     * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
     * ���⣬����Լ��������������߾���ˮ��Χ��
     * ʾ�� 1��
     * ���룺grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * �����1
     * ʾ�� 2��
     * ���룺grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * �����3
     * ��ʾ��
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] ��ֵΪ '0' �� '1'
     */
    public int numIslands(char[][] grid) {
        char max = '2';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands(grid, i, j, max);
                    max++;
                }
            }
        }
        return max-50;
    }

    public void numIslands(char[][] grid, int x, int y, char target) {
        grid[x][y] = target;
        //����
        if (x > 0 && grid[x - 1][y] == '1') {
            numIslands(grid, x - 1, y, target);
        }
        //����
        if (x < grid.length-1 && grid[x + 1][y] == '1') {
            numIslands(grid, x + 1, y, target);
        }
        //����
        if (y > 0 && grid[x][y - 1] == '1') {
            numIslands(grid, x, y - 1, target);
        }
        //����
        if (y < grid[0].length-1 && grid[x][y + 1] == '1') {
            numIslands(grid, x, y + 1, target);
        }
    }
}
