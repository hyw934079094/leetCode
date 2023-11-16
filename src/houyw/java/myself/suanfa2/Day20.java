package houyw.java.myself.suanfa2;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/7/27 16:14
 * @Description:
 */
public class Day20 {
    public static void main(String[] args) {
        Day20 day = new Day20();
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        //int[][] points = {{-6, -1}, {3, 1}, {12, 3}};
        //int[][] points = {{1, 1}, {1, 2}, {1, 3}, {1, 1}, {1, 3}, {1, 4}};
        //System.out.println(day.maxPoints(points));
        int[] nums = {1,2,3};
        Solution so = new Solution(nums);
        so.shuffle();
        so.reset();
        so.shuffle();


    }

    /**
     * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。
     * 求最多有多少个点在同一条直线上。
     * 示例 1：
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：3
     * 示例 2：
     * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出：4
     * 提示：
     * 1 <= points.length <= 300
     * points[i].length == 2
     * -104 <= xi, yi <= 104
     * points 中的所有点 互不相同
     */

    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        //用来存放所有的k,长度4位 1:k/b分母  2：k分子 3：b分子
        List<List<Integer>> list = new ArrayList<>();
        //没有k的集合
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            //x = 常数的直线
            if (map.getOrDefault(points[i][0], 0) > 0) {
                map.put(points[i][0], map.getOrDefault(points[i][0], 0) + 1);
            } else {
                map.put(points[i][0], 1);
            }
            for (int j = i + 1; j < points.length; j++) {
                //两点组成的带k的直线
                if (points[j][0] - points[i][0] != 0) {
                    List<Integer> lst = new ArrayList<>();
                    //x2-x1
                    lst.add(points[j][0] - points[i][0]);
                    //y2-y1
                    lst.add(points[j][1] - points[i][1]);
                    //x2y1-x1y2
                    lst.add(points[j][0] * points[i][1] - points[i][0] * points[j][1]);
                    list.add(lst);
                }

            }
        }
        int max = 0;
        for (List<Integer> lst : list) {
            int count = 0;
            for (int[] nums : points) {
                if (lst.get(1) * nums[0] + lst.get(2) == lst.get(0) * nums[1]) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        //再来看看竖线最多点
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        return max;
    }


    /**
     * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是?等可能?的。
     * 实现 Solution class:
     * Solution(int[] nums) 使用整数数组 nums 初始化对象
     * int[] reset() 重设数组到它的初始状态并返回
     * int[] shuffle() 返回数组随机打乱后的结果
     * 示例 1：
     * 输入
     * ["Solution", "shuffle", "reset", "shuffle"]
     * [[[1, 2, 3]], [], [], []]
     * 输出
     * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
     * 解释
     * Solution solution = new Solution([1, 2, 3]);
     * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
     * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
     * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
     * 提示：
     * <p>
     * 1 <= nums.length <= 50
     * -106 <= nums[i] <= 106
     * nums 中的所有元素都是 唯一的
     * 最多可以调用 104 次 reset 和 shuffle
     */
    static class Solution {
        List<Integer> list;
        int[] arr;

        public Solution(int[] nums) {
            list = new ArrayList<>();
            arr = nums;
        }

        public int[] reset() {
            return arr;
        }

        public int[] shuffle() {
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            Random random = new Random();
            int index = 0;
            int[] shuffle = new int[list.size()];
            while (list.size() > 0) {
                int i = random.nextInt(100);
                int cur = i % list.size();
                shuffle[index] = list.get(cur);
                list.remove(cur);
                index++;
            }
            return shuffle;

        }
    }
}
