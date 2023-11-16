package houyw.java.single.array;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import java.util.*;

import static java.lang.Float.NaN;


/**
 * @Author: DELL
 * @Date: 2022/3/28 15:43
 * @Description:
 */
public class ArraySolution {
    public static void main(String[] args) {
        ArraySolution so = new ArraySolution();
        int[][] grid = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        //int i = so.countHousePlacements(10000);
        String demo = "[[3,2],[3,2],[1,3],[0,2],[3,0],[3,1],[0,3],[2,1],[3,0]]";
        JSONArray objects = JSONArray.parseArray(demo);
        int[][] nums = new int[objects.size()][];
        for(int i = 0;i<nums.length;i++){
            JSONArray objects1 = (JSONArray)objects.get(i);
            int[] arr = new int[objects1.size()];
            for(int j =0;j<objects1.size();j++){
                arr[j] = (int)objects1.get(j);
            }
            nums[i] = arr;
        }
        int[] gen = {0,2,5,4};
        int i = so.giveGem(gen, nums);
        System.out.println(i);
    }

    /**
     * ��������Ϊ2n���������� nums ����������ǽ���Щ���ֳ�?n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��
     * ʹ�ô� 1 ��?n �� min(ai, bi) �ܺ����
     * ���ظ� ����ܺ� ��
     * complete
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    /**
     * ��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ�� ������ 1 ��
     * ���ڣ�����һ���������� nums �����������п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
     * �������������һ���������������������У�������ͨ��ɾ��һЩԪ�ػ�ɾ��Ԫ�ء��Ҳ��ı�����Ԫ�ص�˳����õ���
     * complete
     */

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        //��ʼֵ
        int temp = nums[0];
        //ǰֵ
        int min = 0;
        //ǰ������
        int preCount = 0;
        //��ֵ
        int max = 0;
        //�������
        int aftCount = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp) {
                //��ֵ����
                aftCount++;
            } else {
                temp = nums[i];
                if (preCount > 0 && aftCount > 0 && max == min + 1 && aftCount + preCount > num) {
                    num = aftCount + preCount;
                }
                min = nums[i - 1];
                max = nums[i];
                preCount = aftCount;
                aftCount = 1;
            }
        }
        if (preCount > 0 && aftCount > 0 && max == min + 1 && aftCount + preCount > num) {
            num = aftCount + preCount;
        }
        return num;
    }

    /**
     * ����һ���������� nums?��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target? ����?����?���������������ǵ������±ꡣ
     * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
     * ����԰�����˳�򷵻ش𰸡�
     * complete
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(target - nums[i], -1) > 0 && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    /**
     * ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
     * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
     */
    public int firstMissingPositive(int[] nums) {
        return 0;
    }

    /**
     * ����һ������?points?������?points[i] = [xi, yi]?��ʾ X-Y ƽ���ϵ�һ���㣬
     * �����Щ�㹹��һ��?������?�򷵻�?true?��
     * ������?����Ϊһ�������㣬��Щ��?������ͬ?��?����һ��ֱ����?��
     * ʾ�� 1��
     * ���룺points = [[1,1],[2,3],[3,2]]
     * �����true
     * ʾ�� 2��
     * ���룺points = [[1,1],[2,2],[3,3]]
     * �����false
     * complete
     */
    public boolean isBoomerang(int[][] points) {
        int[] arr1 = points[0];
        int[] arr2 = points[1];
        int[] arr3 = points[2];
        if (arr1[0] == arr2[0] && arr1[1] == arr2[1]) {
            return false;
        }
        if (arr1[0] == arr3[0] && arr1[1] == arr3[1]) {
            return false;
        }
        if (arr2[0] == arr3[0] && arr2[1] == arr3[1]) {
            return false;
        }
        int y1 = arr2[1] - arr1[1];
        int x1 = arr2[0] - arr1[0];
        int y2 = arr3[1] - arr2[1];
        int x2 = arr3[0] - arr2[0];
        if (x1 == 0) {
            return x2 != 0;
        }
        if (x1 * x2 != 0) {
            return (float) y2 / (float) x2 != (float) y1 / (float) x1;
        }
        return true;
    }

    /**
     * ����һ����СΪ n ������?nums ���������еĶ���Ԫ�ء���
     * ��Ԫ����ָ�������г��ִ��� ����?? n/2 ??��Ԫ�ء�
     * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
     * ʾ��?1��
     * ���룺nums = [3,2,3]
     * �����3
     * ʾ��?2��
     * ���룺nums = [2,2,1,1,1,2,2]
     * �����2
     * complete
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int num : nums) {
            Integer n = mp.getOrDefault(num, null);
            if (n != null) {
                mp.put(num, n + 1);
            } else {
                mp.put(num, 1);
            }
        }
        Set<Integer> integers = mp.keySet();
        for (int num : integers) {
            Integer integer = mp.get(num);
            if (integer > nums.length / 2) {
                return num;
            }
        }
        return nums[0];
    }

    /**
     * ����һ���±�� 0?��ʼ��һά��������?original?����������?m?��??n?��
     * ����Ҫʹ��?original?��?����?Ԫ�ش���һ��?m?��?n?�еĶ�ά���顣
     * original?���±�� 0?�� n - 1?���� ���� ����Ԫ�ع��ɶ�ά����ĵ�һ�У�
     * �±�� n?�� 2 * n - 1?���� ����?����Ԫ�ع��ɶ�ά����ĵڶ��У��������ơ�
     * ��������������̷���һ��?m x n?�Ķ�ά���顣����޷����������Ķ�ά���飬���㷵��һ���յĶ�ά���顣
     * ʾ�� 1��
     * ���룺original = [1,2,3,4], m = 2, n = 2
     * �����[[1,2],[3,4]]
     * ���ͣ�
     * ������Ķ�ά����Ӧ�ð��� 2 �� 2 �С�
     * original �е�һ�� n=2 �Ĳ���Ϊ [1,2] �����ɶ�ά����ĵ�һ�С�
     * original �еڶ��� n=2 �Ĳ���Ϊ [3,4] �����ɶ�ά����ĵڶ��С�
     * ʾ�� 2��
     * <p>
     * ���룺original = [1,2,3], m = 1, n = 3
     * �����[[1,2,3]]
     * ���ͣ�
     * ������Ķ�ά����Ӧ�ð��� 1 �� 3 �С�
     * �� original ����������Ԫ�ط����һ���У�����Ҫ��Ķ�ά���顣
     * ʾ�� 3��
     * <p>
     * ���룺original = [1,2], m = 1, n = 1
     * �����[]
     * ���ͣ�
     * original ���� 2 ��Ԫ�ء�
     * �޷��� 2 ��Ԫ�ط��뵽һ�� 1x1 �Ķ�ά�����У����Է���һ���յĶ�ά���顣
     * ʾ�� 4��
     * <p>
     * ���룺original = [3], m = 1, n = 2
     * �����[]
     * ���ͣ�
     * original ��ֻ�� 1 ��Ԫ�ء�
     * �޷��� 1 ��Ԫ�ط���һ�� 1x2 �Ķ�ά���飬���Է���һ���յĶ�ά���顣
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] ints = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = original[index];
                index++;
            }
        }
        return ints;
    }

    /**
     * ����һ����ѡ�˱�ŵļ���?candidates?��һ��Ŀ����?target?��
     * �ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
     * candidates?�е�ÿ��������ÿ�������ֻ��ʹ��?һ��?��
     * ע�⣺�⼯���ܰ����ظ�����ϡ�?
     * ʾ��?1:
     * ����: candidates =?[10,1,2,7,6,1,5], target =?8,
     * ���:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * ʾ��?2:
     * ����: candidates =?[2,5,2,1,2], target =?5,
     * ���:
     * [
     * [1,2,2],
     * [5]
     * ]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> lists = combinationSum2(candidates, target, i);
            lst.addAll(lists);
        }
        return lst;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int index) {
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                lst.add(list);
                return lst;
            }
            if (candidates[index] < target) {
                List<List<Integer>> ls = combinationSum2(candidates, target - candidates[index], index + 1);
                if (ls.size() > 0) {
                    for (List<Integer> l : ls) {
                        l.add(candidates[index]);
                    }
                    lst.addAll(ls);
                }
            }
        }
        return lst;
    }

    /**
     * ����һ���±�� 0 ��ʼ���ϸ���� ���������� nums ��һ�������� diff �������������ȫ������������Ԫ�� (i, j, k) ����һ�� ������Ԫ�� ��
     * i < j < k ��
     * nums[j] - nums[i] == diff ��
     * nums[k] - nums[j] == diff
     * ���ز�ͬ ������Ԫ�� ����Ŀ��
     * ʾ�� 1��
     * ���룺nums = [0,1,4,6,7,10], diff = 3
     * �����2
     * ���ͣ�
     * (1, 2, 4) ��������Ԫ�飺7 - 4 == 3 �� 4 - 1 == 3 ��
     * (2, 4, 5) ��������Ԫ�飺10 - 7 == 3 �� 7 - 4 == 3 ��
     * ʾ�� 2��
     * ���룺nums = [4,5,6,7,8,9], diff = 2
     * �����2
     * ���ͣ�
     * (0, 2, 4) ��������Ԫ�飺8 - 6 == 2 �� 6 - 4 == 2 ��
     * (1, 3, 5) ��������Ԫ�飺9 - 7 == 2 �� 7 - 5 == 2 ��
     * ?
     * ��ʾ��
     * 3 <= nums.length <= 200
     * 0 <= nums[i] <= 200
     * 1 <= diff <= 50
     * nums �ϸ� ����
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean f1 = false;
            boolean f2 = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] + diff) {
                    f1 = true;
                }
                if (nums[j] > nums[i] + diff && !f1) {
                    break;
                }
                if (nums[j] == nums[i] + diff + diff) {
                    f2 = true;
                }
                if (nums[j] > nums[i] + diff + diff && !f2) {
                    break;
                }
            }
            if (f1 && f2) {
                count++;
            }
        }
        return count;
    }

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 4;
        }
        long[] fn = new long[n + 1];
        fn[0] = 1;
        fn[1] = 2;
        for (int i = 2; i <= n; i++) {
            fn[i] = fn[i - 1] % (1000000000 + 7) + fn[i - 2] % (1000000000 + 7);
        }
        long one = (int) (fn[n] % (1000000000 + 7));
        return (int) (one * one % (1000000000 + 7));
    }

    /**
     * ���������±�� 0?��ʼ����������?nums1 ��?nums2?������Ϊ?n?��
     * ����?nums1 ��?nums2?�� ��ֵƽ����?����Ϊ��������?0 <= i < n?��?(nums1[i] - nums2[i])2?֮�͡�
     * ͬʱ��������������?k1 ��?k2?��
     * ����Խ�?nums1?�е�����Ԫ��?+1 ����?-1?����?k1?�Ρ����Ƶģ�
     * ����Խ�?nums2?�е�����Ԫ��?+1 ����?-1?����?k2?�Ρ�
     * ���㷵���޸�����?nums1?����?k1?�����޸�����?nums2?���� k2?�κ����С?��ֵƽ����?��
     * ע�⣺����Խ������е�Ԫ�ر��?��?������
     * ʾ�� 1��
     * ���룺nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
     * �����579
     * ���ͣ�nums1 �� nums2 �е�Ԫ�ز����޸ģ���Ϊ k1 = 0 �� k2 = 0 ��
     * ��ֵƽ����Ϊ��(1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2?= 579 ��
     * ʾ�� 2��
     * <p>
     * ���룺nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
     * �����43
     * ���ͣ�һ�ֵõ���С��ֵƽ���͵ķ�ʽΪ��
     * - �� nums1[0] ����һ�Ρ�
     * - �� nums2[2] ����һ�Ρ�
     * ��С��ֵƽ����Ϊ��
     * (2 - 5)2 + (4 - 8)2 + (10 - 7)2 + (12 - 9)2?= 43 ��
     * ע�⣬Ҳ��������ʽ���Եõ���С��ֵƽ���ͣ���û�еõ��� 43 ��С�𰸵ķ�����
     * ��ʾ��
     * n == nums1.length == nums2.length
     * 1 <= n <= 105
     * 0 <= nums1[i], nums2[i] <= 105
     * 0 <= k1, k2 <= 109
     */
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] nums = new long[nums1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int index = nums.length - 1;
        Arrays.sort(nums);
        int all = k1 + k2;
        while (all > 0) {
            if (nums[index] == 0) {
                return 0;
            }
            //���Ĳ���Ψһ
            while (nums[index] > nums[index - 1]) {
                nums[index]--;
                all--;
                if (all == 0) {
                    return getResult(nums);
                }
            }
            //������ֵ��������
            long max = nums[index];
            for (int i = index; i >= 0; i--) {
                if (max == nums[i]) {
                    nums[i]--;
                    all--;
                } else {
                    break;
                }
                if (all == 0) {
                    break;
                }
            }
        }
        return getResult(nums);
    }

    public long getResult(long[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * nums[i];
        }
        return sum;
    }


    /**
     * ����һ�� ?���ظ�Ԫ�� ��?���� �������� nums ��
     * ���� ǡ�ø����������������� �� ��С���� ���䷶Χ�б�?��
     * Ҳ����˵��nums ��ÿ��Ԫ�ض�ǡ�ñ�ĳ�����䷶Χ�����ǣ����Ҳ���������ĳ����Χ�������� nums ������ x ��
     * �б��е�ÿ�����䷶Χ [a,b] Ӧ�ð����¸�ʽ�����
     * "a->b" ����� a != b
     * "a" ����� a == b
     * ʾ�� 1��
     * ���룺nums = [0,1,2,4,5,7]
     * �����["0->2","4->5","7"]
     * ���ͣ����䷶Χ�ǣ�
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * ʾ�� 2��
     * ���룺nums = [0,2,3,4,6,8,9]
     * �����["0","2->4","6","8->9"]
     * ���ͣ����䷶Χ�ǣ�
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     * ��ʾ��
     * 0 <= nums.length <= 20
     * -231 <= nums[i] <= 231 - 1
     * nums �е�����ֵ�� ������ͬ
     * nums ����������
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length > 0) {
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //�����������
                if (nums[i] == nums[i - 1] + 1) {
                    end = nums[i];
                } else {
                    if (start == end) {
                        list.add(start + "");
                    } else {
                        list.add(start + "->" + end);
                    }
                    //���ÿ�ͷ��β
                    start = nums[i];
                    end = nums[i];
                }
            }
            if (start == end) {
                list.add(start + "");
            } else {
                list.add(start + "->" + end);
            }
        }
        return list;
    }

    /**
     * ����һ������ [0, n]?��?n?���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����
     * ʾ�� 1��
     * ���룺nums = [3,0,1]
     * �����2
     * ���ͣ�n = 3����Ϊ�� 3 �����֣��������е����ֶ��ڷ�Χ [0,3] �ڡ�2 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�
     * ʾ�� 2��
     * ���룺nums = [0,1]
     * �����2
     * ���ͣ�n = 2����Ϊ�� 2 �����֣��������е����ֶ��ڷ�Χ [0,2] �ڡ�2 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�
     * ʾ�� 3��
     * ���룺nums = [9,6,4,2,3,5,7,0,1]
     * �����8
     * ���ͣ�n = 9����Ϊ�� 9 �����֣��������е����ֶ��ڷ�Χ [0,9] �ڡ�8 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�
     * ʾ�� 4��
     * ���룺nums = [0]
     * �����1
     * ���ͣ�n = 1����Ϊ�� 1 �����֣��������е����ֶ��ڷ�Χ [0,1] �ڡ�1 �Ƕ�ʧ�����֣���Ϊ��û�г����� nums �С�
     * ��ʾ��
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * nums �е��������ֶ� ��һ�޶�
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }


    public void wiggleSort(int[] nums) {
        int[] newarr = nums.clone();
        Arrays.sort(newarr);
        int index1 = 0;
        int index2 = newarr.length / 2;
        if (newarr.length % 2 == 1) {
            index2++;
        }
        boolean flag = true;
        for (int i = 0; i < newarr.length; i++) {
            if (flag) {
                nums[i] = newarr[index1];
                index1++;
                flag = false;
            } else {
                nums[i] = newarr[index2];
                index2++;
                flag = true;
            }
        }
        System.out.println(1);
    }


    public int deleteGreatestValue(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        for (int i = grid[0].length-1; i >=0; i--) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (j == 0) {
                    max = grid[j][i];
                } else {
                    max = Math.max(grid[j][i], max);
                }
            }
            sum += max;
        }
        return sum;
    }

    public int giveGem(int[] gem, int[][] operations) {

        for(int i = 0;i<operations.length;i++){
            int x = operations[i][0];
            int y = operations[i][1];
            gem[y] = gem[y] +gem[x]/2;
            gem[x] = gem[x]-gem[x]/2;
        }
        Arrays.sort(gem);
        return gem[gem.length-1]-gem[0];
    }

}
