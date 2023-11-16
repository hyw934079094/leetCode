package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/21 16:11
 * @Description:
 */
public class Day19 {
    public static void main(String[] args) {
        //1001
        //0110
        //0111
        //1011
        Day19 day = new Day19();
        int[][] arr = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
       // System.out.println(day.findCircleNum(arr));
        int[][] stores ={{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(day.removeStones(stores));

    }

    /**
     * �� n �����У�����һЩ�˴���������һЩû��������������� a ����� b ֱ��������
     * �ҳ��� b ����� c ֱ����������ô���� a ����� c ���������
     * ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�
     * ����һ�� n x n �ľ��� isConnected ������ isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ��������
     * �� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������
     * ���ؾ����� ʡ�� ��������
     * ʾ�� 1��
     * ���룺isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * �����2
     * ʾ�� 2��
     * ���룺isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * �����3
     * ��ʾ��
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] Ϊ 1 �� 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    findCircleNum(isConnected, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    //�ڼ��н��в�ѯȾɫ
    public void findCircleNum(int[][] isConnected, int x, int y) {
        isConnected[x][y] = 2;
        for (int i = 0; i < isConnected[y].length; i++) {
            if (isConnected[y][i] == 1) {
                isConnected[y][i] = 2;
                findCircleNum(isConnected, y, i);
            }
        }
    }


    /**
     * n ��ʯͷ�����ڶ�άƽ���е�һЩ����������ϡ�ÿ������������ֻ����һ��ʯͷ��
     * ���һ��ʯͷ�� ͬ�л���ͬ�� ��������ʯͷ���ڣ���ô�Ϳ����Ƴ����ʯͷ��
     * ����һ������Ϊ n ������ stones ������ stones[i] = [xi, yi] ��ʾ�� i ��ʯͷ��λ�ã����� �����Ƴ���ʯ�� �����������
     * ʾ�� 1��
     * <p>
     * ���룺stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * �����5
     * ���ͣ�һ���Ƴ� 5 ��ʯͷ�ķ���������ʾ��
     * 1. �Ƴ�ʯͷ [2,2] ����Ϊ���� [2,1] ͬ�С�
     * 2. �Ƴ�ʯͷ [2,1] ����Ϊ���� [0,1] ͬ�С�
     * 3. �Ƴ�ʯͷ [1,2] ����Ϊ���� [1,0] ͬ�С�
     * 4. �Ƴ�ʯͷ [1,0] ����Ϊ���� [0,0] ͬ�С�
     * 5. �Ƴ�ʯͷ [0,1] ����Ϊ���� [0,0] ͬ�С�
     * ʯͷ [0,0] �����Ƴ�����Ϊ��û������һ��ʯͷͬ��/�С�
     * ʾ�� 2��
     * <p>
     * ���룺stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
     * �����3
     * ���ͣ�һ���Ƴ� 3 ��ʯͷ�ķ���������ʾ��
     * 1. �Ƴ�ʯͷ [2,2] ����Ϊ���� [2,0] ͬ�С�
     * 2. �Ƴ�ʯͷ [2,0] ����Ϊ���� [0,0] ͬ�С�
     * 3. �Ƴ�ʯͷ [0,2] ����Ϊ���� [0,0] ͬ�С�
     * ʯͷ [0,0] �� [1,1] �����Ƴ�����Ϊ����û������һ��ʯͷͬ��/�С�
     * ʾ�� 3��
     * <p>
     * ���룺stones = [[0,0]]
     * �����0
     * ���ͣ�[0,0] ��ƽ����Ψһһ��ʯͷ�����Բ������Ƴ�����
     * ?
     * <p>
     * ��ʾ��
     * 1 <= stones.length <= 1000
     * 0 <= xi, yi <= 104
     * ����������ʯͷ����ͬһ���������
     */

    public int removeStones(int[][] stones) {
        //ֻҪ��ͬ�л���ͬ�У�����Ϊһ�����ϣ����ж��ٸ����Ͼ������ʣ���ʯͷ����
        if (stones.length == 1) {
            return 0;
        }
        int all = stones.length;
        int[] arr = new int[all];
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if(arr[i] == 1){
                continue;
            }
            removeStones(stones, stones[i][0], stones[i][1], arr);
            count++;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum == all) {
                return all-count;
            }
        }
        return all-count;
    }

    public void removeStones(int[][] stones, int x, int y, int[] arr) {
        for (int i = 0; i < stones.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            if (stones[i][1] == y) {
                arr[i] = 1;
                removeStones(stones, stones[i][0], y, arr);
            }
            if (stones[i][0] == x) {
                arr[i] = 1;
                removeStones(stones, x, stones[i][1], arr);
            }
        }
    }

}
