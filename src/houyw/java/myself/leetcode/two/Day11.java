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
     * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
     * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
     * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
     * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
     * 示例 1：
     * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
     * 输出：2
     * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
     * 示例 2：
     * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
     * 输出：-1
     * 提示：
     * 1 <= routes.length <= 500.
     * 1 <= routes[i].length <= 105
     * routes[i] 中的所有值 互不相同
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
        // 思想就是保存站点所能经过的路线；可达同一站点的路线之间相连，且距离是1；
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
                // 取出一个路线
                int st = que.poll();
                for (int j = 0; j < routes[st].length; j++) {
                    // 当前路线上所有站
                    if (routes[st][j] == target) {
                        // 找到结果就返回
                        return res;
                    }
                    // 扩展：将当前路线上的站可达的其他路线加入到队列，勿重复加入一个路线到队列。
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
     * 现在你总共有 numCourses 门课需要选，记为?0?到?numCourses - 1。给你一个数组?prerequisites ，
     * 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修?bi 。
     * 例如，想要学习课程 0 ，你需要先完成课程?1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
     * 如果不可能完成所有课程，返回 一个空数组 。
     * 示例 1：
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：[0,1]
     * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * 示例 2：
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：[0,2,1,3]
     * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是?[0,1,2,3] 。另一个正确的排序是?[0,2,1,3] 。
     * 示例 3：
     * 输入：numCourses = 1, prerequisites = []
     * 输出：[0]
     * ?
     * 提示：
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * 所有[ai, bi] 互不相同
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
