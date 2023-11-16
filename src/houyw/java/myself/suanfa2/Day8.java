package houyw.java.myself.suanfa2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: DELL
 * @Date: 2022/8/1 09:57
 * @Description:
 */
public class Day8 {
    public static void main(String[] args) {
        Day8 day = new Day8();
        int[][] graph =  {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(day.allPathsSourceTarget(graph));
    }

    /**
     * ����һ�� n x n �Ķ����ƾ��� grid �У����ؾ�������� ��ͨ·�� �ĳ��ȡ����������������·�������� -1 ��
     * �����ƾ����е� ��ͨ·�� ��һ���� ���Ͻ� ��Ԫ�񣨼���(0, 0)���� ���½� ��Ԫ�񣨼���(n - 1, n - 1)����·������·��ͬʱ��������Ҫ��
     * ·��;�������е�Ԫ�񶼵�ֵ���� 0 ��
     * ·�����������ڵĵ�Ԫ��Ӧ���� 8 ������֮һ ����ͨ��������������Ԫ֮��˴˲�ͬ�ҹ���һ���߻���һ���ǣ���
     * ��ͨ·���ĳ��� �Ǹ�·��;���ĵ�Ԫ��������
     * ʾ�� 1��
     * ���룺grid = [[0,1],[1,0]]
     * �����2
     * ʾ�� 2��
     * ���룺grid = [[0,0,0],[1,1,0],[1,1,0]]
     * �����4
     * ʾ�� 3��
     * ���룺grid = [[1,0,0],[1,1,0],[1,1,0]]
     * �����-1
     * 0 1 1 0 0 0
     * 0 1 0 1 1 0
     * 0 1 1 0 1 0
     * 0 0 0 1 1 0
     * 1 1 1 1 1 0
     * 1 1 1 1 1 0
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        grid[0][0] = 1;
        //��ʼ·��Ϊ1
        int sum = 1;
        //�����鶨��˸��ƶ�����
        int[][] tmps = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        while (que.size() > 0) {
            //������Ҫȡ���ĵ�ĸ���
            int size = que.size();
            while (size > 0) {
                //ȡ����ǰ�����ýڵ�
                int[] cur = que.poll();
                //ȡ���Ľڵ��Ѿ����յ���
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    return sum;
                }
                //�����˸�����
                for (int[] tmp : tmps) {
                    int x = cur[0] + tmp[0];
                    int y = cur[1] + tmp[1];
                    if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        continue;
                    }
                    //���뵱ǰ�ڵ�
                    que.add(new int[]{x, y});
                    //���ұ�ǵ�ǰ�ڵ��Ѿ��ߵ���
                    grid[x][y] = 1;

                }
                size--;
            }
            //����ȡ�꣬��ʼ��һ��
            sum++;
        }
        return -1;
    }


    /**
     * ����һ�� m x n �ľ��� board ���������ַ� 'X' �� 'O' ���ҵ����б� 'X' Χ�Ƶ�����
     * ������Щ���������е�?'O' �� 'X' ��䡣
     * ʾ�� 1��
     * ���룺board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * �����[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * ���ͣ���Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ�?'O'?�����ᱻ���Ϊ?'X'��
     * �κβ��ڱ߽��ϣ�����߽��ϵ�?'O'?������?'O'?���ն��ᱻ���Ϊ?'X'��
     * �������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
     * ʾ�� 2��
     * ���룺board = [["X"]]
     * �����[["X"]]
     * ��ʾ��
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] Ϊ 'X' �� 'O'
     */
    public void solve(char[][] board) {
        //�ҵ����в������ĵ�
        Queue<int[]> que = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        //�����ĸ�����
        int[][] tmps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //�Ȱ����б߽��ϵ�0�ҳ���
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                que.add(new int[]{i, 0});
            }
            if (board[i][board[i].length - 1] == 'O') {
                que.add(new int[]{i, board[i].length - 1});
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                que.add(new int[]{0, i});
            }
            if (board[board.length - 1][i] == 'O') {
                que.add(new int[]{board.length - 1, i});
            }
        }
        //Ȼ���������Oȫ������
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int[] poll = que.poll();
                //���н�������еĵ㶼�����б���
                list.add(poll);
                board[poll[0]][poll[1]] = 'X';
                for (int[] tmp : tmps) {
                    int x = poll[0] + tmp[0];
                    int y = poll[1] + tmp[1];
                    if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1) {
                        continue;
                    }
                    if (board[x][y] == 'X') {
                        continue;
                    }
                    //���뵱ǰ��
                    que.add(new int[]{x, y});
                    //��ǵ�ǰ���Ѿ��ߵ���
                    board[x][y] = 'X';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'X';
            }
        }
        if (list.size() > 0) {
            for (int[] arr : list) {
                board[arr[0]][arr[1]] = 'O';
            }
        }
    }


    /**
     * ����һ����?n?���ڵ�� �����޻�ͼ��DAG���������ҳ����дӽڵ� 0?���ڵ� n-1?��·�����������Ҫ���ض�˳��
     * ?graph[i]?��һ���ӽڵ� i ���Է��ʵ����нڵ���б����ӽڵ� i ���ڵ�?graph[i][j]����һ������ߣ���
     * ʾ�� 1��
     * ���룺graph = [[1,2],[3],[3],[]]
     * �����[[0,1,3],[0,2,3]]
     * ���ͣ�������·�� 0 -> 1 -> 3 �� 0 -> 2 -> 3
     * ʾ�� 2��
     * ���룺graph = [[4,3,1],[3,2,4],[3],[4],[]]
     * �����[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
     * ��ʾ��
     * n == graph.length
     * 2 <= n <= 15
     * 0 <= graph[i][j] < n
     * graph[i][j] != i�����������Ի���
     * graph[i] �е�����Ԫ�� ������ͬ
     * ��֤����Ϊ �����޻�ͼ��DAG��
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        que.add(l);
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                List<Integer> poll = que.poll();
                int index = poll.get(poll.size() - 1);
                if(index ==graph.length-1){
                    list.add(poll);
                    continue;
                }
                for (int i : graph[index]) {
                    List<Integer> lst = new ArrayList<>();
                    lst.addAll(poll);
                    lst.add(i);
                    que.add(lst);
                }
            }
        }
        return list;
    }
}
