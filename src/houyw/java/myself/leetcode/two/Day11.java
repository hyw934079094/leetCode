package houyw.java.myself.leetcode.two;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/7/8 11:27
 * @Description:
 */
public class Day11 {
    public static void main(String[] args) {
        Day11 day = new Day11();
        int[][] routes = {{1, 7}, {3, 6, 5}};
        // int[][] routes1 = {{1, 2, 3}, {2, 5, 8}, {3, 6, 9}, {5, 6, 10}, {6, 7}};
        int[][] prerequisites = {{0, 1}, {1, 0}};

        System.out.println(day.findOrder(2, prerequisites));
    }

    /**
     * 1(2,3)   2 (5,8)    5 (6,10)      6 (7)    7
     * 1(2,3)   3 (6,9)    6 (7)         7
     * ����һ������ routes ����ʾһϵ�й�����·������ÿ�� routes[i] ��ʾһ��������·���� i ������������������ѭ����ʻ��
     * ���磬·�� routes[0] = [1, 5, 7] ��ʾ�� 0 ����������һֱ������ 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... �����ĳ�վ·����ʻ��
     * ���ڴ� source ��վ��������ʼʱ���ڹ������ϣ���Ҫǰ�� target ��վ�� �ڼ���ɳ�����������
     * ��� ���ٳ����Ĺ��������� ����������ܵ����յ㳵վ������ -1 ��
     * ʾ�� 1��
     * ���룺routes = [[1,2,7],[3,6,7]], source = 1, target = 6
     * �����2
     * ���ͣ����Ų������ȳ�����һ�����������ﳵվ 7 , Ȼ�󻻳˵ڶ�������������վ 6 ��
     * ʾ�� 2��
     * ���룺routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
     * �����-1
     * ��ʾ��
     * 1 <= routes.length <= 500.
     * 1 <= routes[i].length <= 105
     * routes[i] �е�����ֵ ������ͬ
     * sum(routes[i].length) <= 105
     * 0 <= routes[i][j] < 106
     * 0 <= source, target < 106
     */

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> que = new LinkedList<>();
        boolean[] mark = new boolean[505];
        // ˼����Ǳ���վ�����ܾ�����·�ߣ��ɴ�ͬһվ���·��֮���������Ҿ�����1��
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new LinkedList<Integer>());
                }
                List<Integer> list = map.get(routes[i][j]);
                list.add(i);
            }
        }

        List<Integer> list = map.get(source);
        for (int k = 0; k < list.size(); k++) {
            que.add(list.get(k));
            mark[list.get(k)] = true;
        }
        int res = 0;
        while (!que.isEmpty()) {
            res++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                // ȡ��һ��·��
                int st = que.poll();
                for (int j = 0; j < routes[st].length; j++) {
                    // ��ǰ·��������վ
                    if (routes[st][j] == target) {
                        // �ҵ�����ͷ���
                        return res;
                    }
                    // ��չ������ǰ·���ϵ�վ�ɴ������·�߼��뵽���У����ظ�����һ��·�ߵ����С�
                    List<Integer> temp = map.get(routes[st][j]);
                    for (int k = 0; k < temp.size(); k++) {
                        if (!mark[temp.get(k)]) {
                            que.add(temp.get(k));
                            mark[temp.get(k)] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * �������ܹ��� numCourses �ſ���Ҫѡ����Ϊ?0?��?numCourses - 1������һ������?prerequisites ��
     * ���� prerequisites[i] = [ai, bi] ����ʾ��ѡ�޿γ� ai ǰ ���� ��ѡ��?bi ��
     * ���磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ�?1 ��������һ��ƥ������ʾ��[0,1] ��
     * ������Ϊ��ѧ�����пγ������ŵ�ѧϰ˳�򡣿��ܻ��ж����ȷ��˳����ֻҪ���� ����һ�� �Ϳ����ˡ�
     * ���������������пγ̣����� һ�������� ��
     * ʾ�� 1��
     * ���룺numCourses = 2, prerequisites = [[1,0]]
     * �����[0,1]
     * ���ͣ��ܹ��� 2 �ſγ̡�Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0����ˣ���ȷ�Ŀγ�˳��Ϊ [0,1] ��
     * ʾ�� 2��
     * ���룺numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * �����[0,2,1,3]
     * ���ͣ��ܹ��� 4 �ſγ̡�Ҫѧϰ�γ� 3����Ӧ������ɿγ� 1 �Ϳγ� 2�����ҿγ� 1 �Ϳγ� 2 ��Ӧ�����ڿγ� 0 ֮��
     * ��ˣ�һ����ȷ�Ŀγ�˳����?[0,1,2,3] ����һ����ȷ��������?[0,2,1,3] ��
     * ʾ�� 3��
     * ���룺numCourses = 1, prerequisites = []
     * �����[0]
     * ?
     * ��ʾ��
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * ����[ai, bi] ������ͬ
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        List<Integer> wait = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!list.contains(i)) {
                List<Integer> order = findOrder(prerequisites, list, i, wait);
                if (order == null) {
                    return new int[0];
                }
            }

        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public List<Integer> findOrder(int[][] prerequisites, List<Integer> list, int course, List<Integer> wait) {

        wait.add(course);
        for (int i = 0; i < prerequisites.length; i++) {
            if (course == prerequisites[i][0]) {
                if (wait.contains(prerequisites[i][1])) {
                    return null;
                }
                if (list.contains(prerequisites[i][1])) {
                    continue;
                }

                List<Integer> order = findOrder(prerequisites, list, prerequisites[i][1], wait);
                if (order == null) {
                    return null;
                }
            }
        }
        list.add(course);
        if (wait.size() > 0) {
            wait.remove(wait.size() - 1);
        }
        return list;
    }
}
