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
     * ����һ������ points ������ points[i] = [xi, yi] ��ʾ X-Y ƽ���ϵ�һ���㡣
     * ������ж��ٸ�����ͬһ��ֱ���ϡ�
     * ʾ�� 1��
     * ���룺points = [[1,1],[2,2],[3,3]]
     * �����3
     * ʾ�� 2��
     * ���룺points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * �����4
     * ��ʾ��
     * 1 <= points.length <= 300
     * points[i].length == 2
     * -104 <= xi, yi <= 104
     * points �е����е� ������ͬ
     */

    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        //����������е�k,����4λ 1:k/b��ĸ  2��k���� 3��b����
        List<List<Integer>> list = new ArrayList<>();
        //û��k�ļ���
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            //x = ������ֱ��
            if (map.getOrDefault(points[i][0], 0) > 0) {
                map.put(points[i][0], map.getOrDefault(points[i][0], 0) + 1);
            } else {
                map.put(points[i][0], 1);
            }
            for (int j = i + 1; j < points.length; j++) {
                //������ɵĴ�k��ֱ��
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
        //����������������
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        return max;
    }


    /**
     * ����һ���������� nums ������㷨������һ��û���ظ�Ԫ�ص����顣���Һ��������������Ӧ����?�ȿ���?�ġ�
     * ʵ�� Solution class:
     * Solution(int[] nums) ʹ���������� nums ��ʼ������
     * int[] reset() �������鵽���ĳ�ʼ״̬������
     * int[] shuffle() ��������������Һ�Ľ��
     * ʾ�� 1��
     * ����
     * ["Solution", "shuffle", "reset", "shuffle"]
     * [[[1, 2, 3]], [], [], []]
     * ���
     * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
     * ����
     * Solution solution = new Solution([1, 2, 3]);
     * solution.shuffle();    // �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ�����磬���� [3, 1, 2]
     * solution.reset();      // �������鵽���ĳ�ʼ״̬ [1, 2, 3] ������ [1, 2, 3]
     * solution.shuffle();    // ����������� [1, 2, 3] ���Һ�Ľ�������磬���� [1, 3, 2]
     * ��ʾ��
     * <p>
     * 1 <= nums.length <= 50
     * -106 <= nums[i] <= 106
     * nums �е�����Ԫ�ض��� Ψһ��
     * �����Ե��� 104 �� reset �� shuffle
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
