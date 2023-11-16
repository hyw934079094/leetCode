package houyw.java.normal.arr;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/25 11:22
 * @Description:
 */
public class ArrSolution {
    public static void main(String[] args) {
        ArrSolution so = new ArrSolution();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(so.findClosestElements(arr, 4, -1));
    }

    /**
     * ������һ�ŷ��ӣ��� n ����ÿ�����ӿ��Ա���ˢ�ɺ�ɫ��
     * ��ɫ������ɫ��������ɫ�е�һ�֣�����Ҫ��ˢ���еķ��Ӳ���ʹ�����ڵ�����������ɫ������ͬ��
     * ��Ȼ����Ϊ�г��ϲ�ͬ��ɫ����ļ۸�ͬ�����Է��ӷ�ˢ�ɲ�ͬ��ɫ�Ļ��ѳɱ�Ҳ�ǲ�ͬ�ġ�
     * ÿ�����ӷ�ˢ�ɲ�ͬ��ɫ�Ļ�������һ��?n x 3?������������ costs ����ʾ�ġ�
     * ���磬costs[0][0] ��ʾ�� 0 �ŷ��ӷ�ˢ�ɺ�ɫ�ĳɱ����ѣ�costs[1][2]?��ʾ�� 1 �ŷ��ӷ�ˢ����ɫ�Ļ��ѣ��Դ����ơ�
     * ��������ˢ�����з������ٵĻ��ѳɱ���
     * ʾ�� 1��
     * ����: costs = [[17,2,17],[16,16,5],[14,3,19]]
     * ���: 10
     * ����: �� 0 �ŷ��ӷ�ˢ����ɫ��1 �ŷ��ӷ�ˢ����ɫ��2 �ŷ��ӷ�ˢ����ɫ��
     * ?    ���ٻ���: 2 + 5 + 3 = 10��
     * ʾ�� 2��
     * ����: costs = [[7,6,2]]
     * ���: 2
     * ��ʾ:
     * costs.length == n
     * costs[i].length == 3
     * 1 <= n <= 100
     * 1 <= costs[i][j] <= 20
     */
    public int minCost(int[][] costs) {
        //�����ǰ����ˢ�ɺ�ɫ�����ٽ��:
        int cost0 = minCost(costs, 0, 0);
        //�����ǰ����ˢ����ɫ�����ٽ��:
        int cost1 = minCost(costs, 0, 1);
        //�����ǰ����ˢ����ɫ�����ٽ��:
        int cost2 = minCost(costs, 0, 2);
        int min = cost0;
        if (cost1 < min) {
            min = cost1;
        }
        if (cost2 < min) {
            min = cost2;
        }
        return min;
    }


    public int minCost(int[][] costs, int index, int color) {
        if (index == costs.length - 1) {
            return costs[index][color];
        }
        int[][] nums = {{1, 2}, {0, 2}, {0, 1}};
        int cost1 = minCost(costs, index + 1, nums[color][0]);
        int cost2 = minCost(costs, index + 1, nums[color][1]);

        if (cost1 < cost2) {
            return cost1 + costs[index][color];
        }
        return cost2 + costs[index][color];
    }

    public int minCost1(int[][] costs) {
        //��¼�±�Ϊn�ķ���ˢĳ����ɫ����ͻ���
        int[][] dos = new int[costs.length][3];

        //dos[x][y]��һ������ˢy��ɫ����С����
        dos[0][0] = costs[0][0];
        dos[0][1] = costs[0][1];
        dos[0][2] = costs[0][2];
        //dos[1][0] = min(dos[0][1],dos[0][2]) +costs[1][0]
        //dos[1][1] = min(dos[0][0],dos[0][2]) +costs[1][1]
        //dos[1][2] = min(dos[0][0],dos[0][1]) +costs[1][2]

        //dos[i][0] = min(dos[i-1][1],dos[i-1][2])+costs[i-1][0]
        //dos[i][1] = min(dos[i-1][0],dos[i-1][2])+costs[i-1][1]
        //dos[i][2] = min(dos[i-1][0],dos[i-1][1])+costs[i-1][2]
        for (int i = 1; i < costs.length; i++) {
            dos[i][0] = Math.min(dos[i - 1][1], dos[i - 1][2]) + costs[i][0];
            dos[i][1] = Math.min(dos[i - 1][0], dos[i - 1][2]) + costs[i][1];
            dos[i][2] = Math.min(dos[i - 1][0], dos[i - 1][1]) + costs[i][2];
        }
        int min = dos[dos.length - 1][0];
        if (dos[dos.length - 1][1] < min) {
            min = dos[dos.length - 1][1];
        }
        if (dos[dos.length - 1][2] < min) {
            min = dos[dos.length - 1][2];
        }
        return min;
    }

    /**
     * 10
     * [[4,1],[1,3],[1,5],[0,5],[3,6],[8,4],[5,7],[6,9],[3,2]]
     * [2,7]
     * ����һ���� n ���ڵ���ɵ����������ڵ��Ŵ� 0 �� n - 1 ������ n - 1 ���ߡ�
     * ����һ����ά�������� edges ������Ϊ n - 1 ������ edges[i] = [ai, bi] ��ʾ���нڵ� ai �� bi ֮�����һ���ߡ�
     * �����һ���������� restricted ��ʾ ���� �ڵ㡣
     * �ڲ��������޽ڵ��ǰ���£���������Դӽڵ� 0 ����� ��� �ڵ���Ŀ��
     * ע�⣬�ڵ� 0 �� ����Ϊ���޽ڵ㡣
     * ʾ�� 1��
     * ���룺n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
     * �����4
     * ���ͣ���ͼ��ʾ�����������
     * �ڲ��������޽ڵ��ǰ���£�ֻ�нڵ� [0,1,2,3] ���Դӽڵ� 0 ���
     * ʾ�� 2��
     * ���룺n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
     * �����3
     * ���ͣ���ͼ��ʾ�����������
     * �ڲ��������޽ڵ��ǰ���£�ֻ�нڵ� [0,5,6] ���Դӽڵ� 0 ���
     * ��ʾ��
     * 2 <= n <= 105
     * edges.length == n - 1
     * edges[i].length == 2
     * 0 <= ai, bi < n
     * ai != bi
     * edges ��ʾһ����Ч����
     * 1 <= restricted.length < n
     * 1 <= restricted[i] < n
     * restricted �е�����ֵ ������ͬ
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int count = 0;
        while (que.size() > 0) {
            int size = que.size();
            count += size;
            while (size-- > 0) {
                int cur = que.poll();
                set.add(cur);
                List<Integer> next = list[cur];
                for (int i : next) {
                    if (!set.contains(i)) {
                        que.add(i);
                    }
                }
            }
        }
        return count;
    }

    /**
     * ����һ���±�� 0 ��ʼ���������� nums ������뽫���黮��Ϊһ������ ���� �����顣
     * �����õ���Щ��������ÿ������������������ ֮һ ������Գ���Ϊ�����һ�� ��Ч ���֣�
     * ������ ǡ �� 2 �����Ԫ����ɣ����磬������ [2,2] ��
     * ������ ǡ �� 3 �����Ԫ����ɣ����磬������ [4,4,4] ��
     * ������ ǡ �� 3 ����������Ԫ����ɣ���������Ԫ��֮��Ĳ�ֵΪ 1 ��
     * ���磬������ [3,4,5] ������������ [1,3,5] ������Ҫ��
     * ������� ���� ����һ����Ч���֣����� true �����򣬷��� false ��
     * ʾ�� 1��
     * ���룺nums = [4,4,4,5,6]
     * �����true
     * ���ͣ�������Ի��ֳ������� [4,4] �� [4,5,6] ��
     * ����һ����Ч���֣����Է��� true ��
     * ʾ�� 2��
     * ���룺nums = [1,1,1,2]
     * �����false
     * ���ͣ������鲻������Ч���֡�
     * ��ʾ��
     * 2 <= nums.length <= 105
     * 1 <= nums[i] <= 106
     */
    public boolean validPartition(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[1] - nums[0] == 1 && nums[2] - nums[1] == 1;
        }
        if (nums.length == 4) {
            return nums[1] == nums[0] && nums[3] == nums[2];
        }
        boolean[] fn = new boolean[nums.length];
        //1����
        fn[0] = false;
        //������
        fn[1] = nums[1] == nums[0] ? true : false;
        if (nums[1] - nums[0] == 1 && nums[2] - nums[1] == 1) {
            fn[2] = true;
        }
        if (nums[2] == nums[1] && nums[1] == nums[0]) {
            fn[2] = true;
        }
        for (int i = 3; i < nums.length; i++) {
            //���һ�������Ժ�ǰ��һ�������������������
            //���1
            if (nums[i] == nums[i - 1] && fn[i - 2]) {
                fn[i] = true;
            }
            //���2
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && fn[i - 3]) {
                fn[i] = true;
            }
            //���3
            if (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && fn[i - 3]) {
                fn[i] = true;
            }
        }
        return fn[fn.length - 1];
    }

    /**
     * ����һ����Сд��ĸ��ɵ��ַ��� s ����һ������ k �����������������������Խ��ַ��� t ������ �����ַ��� ��
     * t ���ַ��� s ��һ�������С�
     * t ��ÿ���� ���� ��ĸ����ĸ����λ�εľ��Բ�ֵС�ڻ���� k ��
     * ���� � �����ַ����ĳ��ȡ�
     * �ַ�����������ͬ����һ���ַ��������������л����㣺���Ծ��������ַ���ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���������ı�ʣ���ַ���˳��õ���
     * ע�⣺��ĸ��˳�򲻻�ѭ�������磬'a' �� 'z' ����ĸ����λ�εľ��Բ�ֵ�� 25 �������� 1 ��
     * ʾ�� 1��
     * ���룺s = "acfgbd", k = 2
     * �����4
     * ���ͣ�������ַ����� "acbd" �����ַ�������Ϊ 4 �����Է��� 4 ��
     * ע�� "acfgbd" ���������ַ�������Ϊ 'c' �� 'f' ����ĸ��λ�β�ֵΪ 3 ��
     * ʾ�� 2��
     * ���룺s = "abcd", k = 3
     * �����4
     * ���ͣ�������ַ����� "abcd" �����ַ�������Ϊ 4 �����Է��� 4 ��
     * ��ʾ��
     * 1 <= s.length <= 105
     * 0 <= k <= 25
     * s ��СдӢ����ĸ���
     */
    public int longestIdealString(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        int[] fn = new int[s.length()];
        int[] tmp = new int[26];
        fn[0] = 1;
        tmp[s.charAt(0) - 'a'] = 1;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            fn[i] = 1;
            //��¼����ĸ����󳤶�
            int start = c - 'a' - k;
            int end = c - 'a' + k;
            if (start < 0) {
                start = 0;
            }
            if (end > 25) {
                end = 25;
            }
            for (int j = start; j <= end; j++) {
                if (tmp[j] + 1 > fn[i]) {
                    fn[i] = tmp[j] + 1;
                }
            }
            if (tmp[c - 'a'] < fn[i]) {
                tmp[c - 'a'] = fn[i];
            }
            if (fn[i] > max) {
                max = fn[i];
            }
        }
        return max;
    }


    /**
     * ����һ�� ����� ������?arr ���������� k �� x �����������ҵ���� x������֮����С���� k ������
     * ���صĽ������Ҫ�ǰ������źõġ�
     * ���� a ������ b ���ӽ� x ��Ҫ���㣺
     * |a - x| < |b - x| ����
     * |a - x| == |b - x| �� a < b
     * ʾ�� 1��
     * ���룺arr = [1,2,3,4,5], k = 4, x = 3
     * �����[1,2,3,4]
     * ʾ�� 2��
     * ���룺arr = [1,2,3,4,5], k = 4, x = -1
     * �����[1,2,3,4]
     * ��ʾ��
     * 1 <= k <= arr.length
     * 1 <= arr.length?<= 104
     * arr?�� ���� ����
     * -104?<= arr[i], x <= 104
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> que = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            que.add(new int[]{Math.abs(arr[i] - x), arr[i]});
            if (que.size() > k) {
                que.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            int[] cur = que.poll();
            list.add(0, cur[1]);
        }
        Collections.sort(list);
        return list;
    }


    /**
     * ����һ���������飬��������ĳ��?�ǿ� �����飨����Ԫ�أ���ִ��һ�ο�ѡ��ɾ��������
     * ���ܵõ������Ԫ���ܺ͡����仰˵������Դ�ԭ������ѡ��һ�������飬�����Ծ���Ҫ��Ҫ����ɾ��һ��Ԫ�أ�ֻ��ɾһ��Ŷ����
     * ��ɾ����������������Ӧ����һ��Ԫ�أ�Ȼ��������飨ʣ�£���Ԫ���ܺ�������������֮�����ġ�
     * ע�⣬ɾ��һ��Ԫ�غ������� ����Ϊ�ա�
     * ʾ�� 1��
     * ���룺arr = [1,-2,0,3,-1,3]
     * �����4
     * ���ͣ����ǿ���ѡ�� [1, -2, 0, 3]��Ȼ��ɾ�� -2�������õ� [1, 0, 3]�������
     * ʾ�� 2��
     * ���룺arr = [1,-2,-2,3]
     * �����3
     * ���ͣ�����ֱ��ѡ�� [3]����������͡�
     * ʾ�� 3��
     * ���룺arr = [-1,-1,-1,-1]
     * �����-1
     * ���ͣ����õ��������鲻��Ϊ�գ��������ǲ���ѡ�� [-1] ������ɾȥ -1 ���õ� 0��
     * ����Ӧ��ֱ��ѡ�� [-1]������ѡ�� [-1, -1] �ٴ���ɾȥһ�� -1��
     * ��ʾ��
     * 1 <= arr.length <= 105
     * -104?<= arr[i] <= 104
     */

    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        //nums[i][0] ��ʾ���Լ�Ϊֹ �Ѿ�ɾ����һλ�����ֵ
        //nums[i][1] ��ʾ���Լ�Ϊֹ ��û��ɾ���������ֵ
        int[][] nums = new int[arr.length][2];
        nums[0][0] = arr[0];
        nums[0][1] = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            nums[i][0] = Math.max(nums[i - 1][0] + arr[i], nums[i - 1][1]);
            nums[i][1] = Math.max(nums[i - 1][1] + arr[i], arr[i]);
            max = Math.max(Math.max(nums[i][0], nums[i][1]), max);
        }
        return max;
    }

    /**
     * ��������һ�����޴�С�� XY ����ƽ�������ߣ��ӵ�?(0, 0) ����ʼ���������򱱷���
     * �û����˿��Խ��������������͵����� commands ��
     * -2 ������ת?90 ��
     * -1 ������ת 90 ��
     * 1 <= x <= 9 ����ǰ�ƶ�?x?����λ����
     * ����������һЩ���ӱ���Ϊ�ϰ���?obstacles ���� i?���ϰ���λ������� ?obstacles[i] = (xi, yi) ��
     * �������޷��ߵ��ϰ����ϣ�������ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ������Խ��и�·�ߵ����ಿ�֡�
     * ���ش�ԭ�㵽���������о�����·���㣨����Ϊ�����������ŷʽ�����ƽ�����������������Ϊ 5 ���򷵻� 25 ��
     * ע�⣺
     * ����ʾ +Y ����
     * ����ʾ +X ����
     * �ϱ�ʾ -Y ����
     * ����ʾ -X ����
     * ʾ�� 1��
     * ���룺commands = [4,-1,3], obstacles = []
     * �����25
     * ���ͣ�
     * �����˿�ʼλ�� (0, 0)��
     * 1. ���ƶ� 4 ����λ������ (0, 4)
     * 2. ��ת
     * 3. ���ƶ� 3 ����λ������ (3, 4)
     * ����ԭ����Զ���� (3, 4) ������Ϊ 32 + 42 = 25
     * ʾ��?2��
     * <p>
     * ���룺commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * �����65
     * ���ͣ������˿�ʼλ�� (0, 0)��
     * 1. ���ƶ� 4 ����λ������ (0, 4)
     * 2. ��ת
     * 3. ���ƶ� 1 ����λ��Ȼ��λ�� (2, 4) ���ϰ����赲��������ͣ�� (1, 4)
     * 4. ��ת
     * 5. ���� 4 ����λ������ (1, 8)
     * ����ԭ����Զ���� (1, 8) ������Ϊ 12 + 82 = 65
     * ?
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= commands.length <= 104
     * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
     * 0 <= obstacles.length <= 104
     * -3 * 104 <= xi, yi <= 3 * 104
     * �𰸱�֤С�� 231
     */

    public int robotSim(int[] commands, int[][] obstacles) {
        //·��map
        Map obs = new HashMap();
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            if (obs.get(x) == null) {
                Map map = new HashMap();
                map.put(y, "1");
                obs.put(x, map);
            } else {
                Map map = (Map) obs.get(x);
                map.put(y, "1");
            }
        }
        int x = 0;
        int y = 0;
        int max = 0;
        //0,1,2,3�ֱ����������
        int fangxiang = 3;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                fangxiang = fangxiang + 1;
                if (fangxiang > 3) {
                    fangxiang -= 4;
                }
            }
            if (commands[i] == -2) {
                fangxiang = fangxiang - 1;
                if (fangxiang < 0) {
                    fangxiang += 4;
                }
            }
            if (commands[i] == -1 || commands[i] == -2) {
                continue;
            }
            if (fangxiang == 0) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x + 1) != null) {
                        Map map = (Map) obs.get(x + 1);
                        if (map.get(y) != null) {
                            break;
                        }
                    }
                    x = 1 + x;
                }
            }
            if (fangxiang == 1) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x) != null) {
                        Map map = (Map) obs.get(x);
                        if (map.get(y - 1) != null) {
                            break;
                        }
                    }
                    y = y - 1;
                }
            }
            if (fangxiang == 2) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x - 1) != null) {
                        Map map = (Map) obs.get(x - 1);
                        if (map.get(y) != null) {
                            break;
                        }
                    }
                    x = x - 1;
                }
            }
            if (fangxiang == 3) {
                for (int j = 1; j <= commands[i]; j++) {
                    if (obs.get(x) != null) {
                        Map map = (Map) obs.get(x);
                        if (map.get(y + 1) != null) {
                            break;
                        }
                    }
                    y = 1 + y;
                }
            }
            if (x * x + y * y > max) {
                max = x * x + y * y;
            }
        }
        return max;
    }

    /**
     * ����һ������Ϊ n �Ļ�����������?nums?������?nums?�ķǿ� ������ �������ܺ�?��
     * ��������?��ζ�������ĩ�˽����뿪ͷ�����ʻ�״����ʽ�ϣ�
     * nums[i] ����һ��Ԫ���� nums[(i + 1) % n] �� nums[i]?��ǰһ��Ԫ���� nums[(i - 1 + n) % n] ��
     * ������ ���ֻ�ܰ����̶�������?nums?�е�ÿ��Ԫ��һ�Ρ���ʽ�ϣ�
     * ����������?nums[i], nums[i + 1], ..., nums[j]?��������?i <= k1, k2 <= j?����?k1 % n == k2 % n?��
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        if (n == 1) {
            return max;
        }
        int min = nums[0];
        int sum = nums[0];
        int[] maxarr = new int[n];
        maxarr[0] = max;
        int[] minarr = new int[n];
        minarr[0] = min;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            maxarr[i] = Math.max(maxarr[i - 1] + nums[i], nums[i]);
            max = Math.max(max, maxarr[i]);
            minarr[i] = Math.min(minarr[i - 1] + nums[i], nums[i]);
            min = Math.min(min, minarr[i]);
        }
        if (sum == min) {
            return max;
        }
        return Math.max(max, sum - min);
    }


    /**
     * ����һ������������ nums ��ÿһ�β����У�����Դ� nums ��ѡ�� ���� һ������������С�� ǡ�� һ�롣
     * ��ע�⣬�ں�������������ԶԼ������������ִ�в�����
     * ���㷵�ؽ� nums ����� ���� ����һ��� ���� ��������
     * ʾ�� 1��
     * ���룺nums = [5,19,8,1]
     * �����3
     * ���ͣ���ʼ nums �ĺ�Ϊ 5 + 19 + 8 + 1 = 33 ��
     * �����ǽ�����ͼ�������һ���һ�ַ�����
     * ѡ������ 19 ����СΪ 9.5 ��
     * ѡ������ 9.5 ����СΪ 4.75 ��
     * ѡ������ 8 ����СΪ 4 ��
     * ��������Ϊ [5, 4.75, 4, 1] ����Ϊ 5 + 4.75 + 4 + 1 = 14.75 ��
     * nums �ĺͼ�С�� 33 - 14.75 = 18.25 ����С�Ĳ��ֳ����˳�ʼ����͵�һ�룬18.25 >= 33/2 = 16.5 ��
     * ������Ҫ 3 ������ʵ����ĿҪ�����Է��� 3 ��
     * ����֤�����޷�ͨ������ 3 ������ʹ����ͼ�������һ�롣
     */

    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2 - o1 > 0 ? 1 : -1;
            }
        }
        );
        for (int i = 0; i < nums.length; i++) {
            queue.add((double) nums[i]);
            sum += nums[i];
        }

        int count = 0;
        double cut = 0;
        double target = sum / 2;
        while (cut < target) {
            double num = queue.poll() / 2;
            cut += num;
            count++;
            queue.add(num);
        }
        return count;
    }

    /**
     * n λ���������� ��һ���� 2^n ��������ɵ����У����У�
     * ÿ���������ڷ�Χ [0, 2^n - 1] �ڣ��� 0 �� 2^n - 1��
     * ��һ�������� 0
     * һ�������������г��� ������һ��
     * ÿ�� ���� �����Ķ����Ʊ�ʾ ǡ��һλ��ͬ ����
     * ��һ�� �� ���һ�� �����Ķ����Ʊ�ʾ ǡ��һλ��ͬ
     * ����һ������ n ��������һ��Ч�� n λ���������� ��
     * 0      1      3      2     6     7     5       4       12      14     15    13      9    11    10  8
     * 000   001    011    010   110   111   101    100     1100    1110    1111   1101  1001 1011  1010 1000
     * 0000  0001   0011   0010  0110   0111  0101   0100   1100    1101    1111    1110  1010   1011  1001  1000
     * 0     1       3      2      6       7    5     4      12
     */

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public void rotate(int[][] matrix) {
        Queue que = new ArrayDeque<Integer>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                que.add(matrix[i][j]);
            }
        }
        for(int i = matrix[0].length-1;i>=0;i--){
            for(int j = 0;j<matrix.length;j++){
                matrix[j][i] = (int)que.poll();
            }
        }
    }

    public void rotate1(int[][] matrix) {
        Queue que = new ArrayDeque<Integer>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length/2;j++){
                que.add(matrix[i][j]);
            }
        }

    }
}
