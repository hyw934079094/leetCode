package houyw.java.myself.suanfa;

/**
 * @Author: DELL
 * @Date: 2022/6/18 17:30
 * @Description:
 */
public class Day7 {
    public static void main(String[] args) {
        Day7 day = new Day7();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int i = day.maxAreaOfIsland(grid);
        System.out.println(i);
    }

    /**
     * ��һ����?m x n?�Ķ�ά���������ʾ��ͼ��?image?��
     * ����?image[i][j]?��ʾ��ͼ��������ֵ��С��
     * ��Ҳ�������������� sr ,? sc �� newColor ��
     * ��Ӧ�ô�����?image[sr][sc]?��ʼ��ͼ����� ��ɫ��� ��
     * Ϊ����� ��ɫ���� ���ӳ�ʼ���ؿ�ʼ����¼��ʼ�����
     * ���������ĸ������� ����ֵ���ʼ������ͬ���������ص㣬
     * �����ټ�¼���ĸ������Ϸ������������ص������Ƕ�Ӧ �ĸ�������
     * ����ֵ���ʼ������ͬ���������ص㣬�������ظ��ù��̡�
     * �������м�¼�����ص����ɫֵ��Ϊ?newColor?��
     * ��󷵻� ������ɫ��Ⱦ���ͼ��?��
     * ʾ�� 1:
     * ����: image = [[1,1,1],[1,1,0],[1,0,1]]��sr = 1, sc = 1, newColor = 2
     * ���: [[2,2,2],[2,2,0],[2,0,1]]
     * ����: ��ͼ������м䣬(����(sr,sc)=(1,1)),��·�������з������������ص����ɫ�������ĳ�2��
     * ע�⣬���½ǵ�����û�и���Ϊ2����Ϊ�����������������ĸ����������ʼ�����������ص㡣
     * ʾ�� 2:
     * ����: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
     * ���: [[2,2,2],[2,2,2]]
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int t = image[sr][sc];
        if (t != color) {
            image[sr][sc] = color;
            //����
            if (sr > 0 && image[sr - 1][sc] == t) {
                image = floodFill(image, sr - 1, sc, color, t);
            }
            //����
            if (sr < image.length - 1 && image[sr + 1][sc] == t) {
                image = floodFill(image, sr + 1, sc, color);
            }
            //����
            if (sc > 0 && image[sr][sc - 1] == t) {
                image = floodFill(image, sr, sc - 1, color);
            }
            //����
            if (sc < image[0].length - 1 && image[sr][sc + 1] == t) {
                image = floodFill(image, sr, sc + 1, color);
            }
        }

        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color, int t) {
        image[sr][sc] = color;
        //����
        if (sr > 0 && image[sr - 1][sc] == t) {
            image = floodFill(image, sr - 1, sc, color, t);
        }
        //����
        if (sr < image.length - 1 && image[sr + 1][sc] == t) {
            image = floodFill(image, sr + 1, sc, color, t);
        }
        //����
        if (sc > 0 && image[sr][sc - 1] == t) {
            image = floodFill(image, sr, sc - 1, color, t);
        }
        //����
        if (sc < image[0].length - 1 && image[sr][sc + 1] == t) {
            image = floodFill(image, sr, sc + 1, color, t);
        }
        return image;
    }

    /**
     * ����һ����СΪ m x n �Ķ����ƾ��� grid ��
     * ����?����һЩ���ڵ�?1?(��������) ���ɵ���ϣ�
     * ����ġ����ڡ�Ҫ������ 1 ������ ˮƽ������ֱ���ĸ������� ���ڡ�
     * ����Լ���?grid ���ĸ���Ե���� 0������ˮ����Χ�š�
     * ���������ǵ���ֵΪ 1 �ĵ�Ԫ�����Ŀ��
     * ���㲢���� grid �����ĵ�����������û�е��죬�򷵻����Ϊ 0 ��
     * ʾ�� 1��
     * ���룺grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * �����6
     * ���ͣ��𰸲�Ӧ���� 11 ����Ϊ����ֻ�ܰ���ˮƽ��ֱ���ĸ������ϵ� 1 ��
     * ʾ�� 2��
     * ���룺grid = [[0,0,0,0,0,0,0,0]]
     * �����0
     * ��ʾ��
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 50
     * grid[i][j] Ϊ 0 �� 1
     */
    public int maxAreaOfIsland(int[][] grid) {
        int x = 0;
        int max = 0;
        while (x < grid.length) {
            int y = 0;
            while (y < grid[0].length) {
                if (grid[x][y] == 1) {
                    int count = sameAreacOUNT(grid, x, y);
                    if (count > max) {
                        max = count;
                    }
                }
                y++;
            }
            x++;
        }
        return max;
    }

    private int sameAreacOUNT(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        int count = 1;
        //����
        if (x > 0 && grid[x - 1][y] == 1) {
            count += sameAreacOUNT(grid, x - 1, y);
        }
        //����
        if (x < grid.length - 1 && grid[x + 1][y] == 1) {
            count += sameAreacOUNT(grid, x + 1, y);
        }
        //����
        if (y > 0 && grid[x][y - 1] == 1) {
            count += sameAreacOUNT(grid, x, y - 1);
        }

        //����
        if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
            count += sameAreacOUNT(grid, x, y + 1);
        }
        return count;
    }
}
