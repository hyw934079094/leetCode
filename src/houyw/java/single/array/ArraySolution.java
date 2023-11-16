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
     * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成?n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从 1 到?n 的 min(ai, bi) 总和最大。
     * 返回该 最大总和 。
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
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
     * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
     * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
     * complete
     */

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        //初始值
        int temp = nums[0];
        //前值
        int min = 0;
        //前计数器
        int preCount = 0;
        //后值
        int max = 0;
        //后计数器
        int aftCount = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp) {
                //后值计数
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
     * 给定一个整数数组 nums?和一个整数目标值 target，请你在该数组中找出 和为目标值 target? 的那?两个?整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
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
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     */
    public int firstMissingPositive(int[] nums) {
        return 0;
    }

    /**
     * 给定一个数组?points?，其中?points[i] = [xi, yi]?表示 X-Y 平面上的一个点，
     * 如果这些点构成一个?回旋镖?则返回?true?。
     * 回旋镖?定义为一组三个点，这些点?各不相同?且?不在一条直线上?。
     * 示例 1：
     * 输入：points = [[1,1],[2,3],[3,2]]
     * 输出：true
     * 示例 2：
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：false
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
     * 给定一个大小为 n 的数组?nums ，返回其中的多数元素。多
     * 数元素是指在数组中出现次数 大于?? n/2 ??的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例?1：
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例?2：
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
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
     * 给你一个下标从 0?开始的一维整数数组?original?和两个整数?m?和??n?。
     * 你需要使用?original?中?所有?元素创建一个?m?行?n?列的二维数组。
     * original?中下标从 0?到 n - 1?（都 包含 ）的元素构成二维数组的第一行，
     * 下标从 n?到 2 * n - 1?（都 包含?）的元素构成二维数组的第二行，依此类推。
     * 请你根据上述过程返回一个?m x n?的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
     * 示例 1：
     * 输入：original = [1,2,3,4], m = 2, n = 2
     * 输出：[[1,2],[3,4]]
     * 解释：
     * 构造出的二维数组应该包含 2 行 2 列。
     * original 中第一个 n=2 的部分为 [1,2] ，构成二维数组的第一行。
     * original 中第二个 n=2 的部分为 [3,4] ，构成二维数组的第二行。
     * 示例 2：
     * <p>
     * 输入：original = [1,2,3], m = 1, n = 3
     * 输出：[[1,2,3]]
     * 解释：
     * 构造出的二维数组应该包含 1 行 3 列。
     * 将 original 中所有三个元素放入第一行中，构成要求的二维数组。
     * 示例 3：
     * <p>
     * 输入：original = [1,2], m = 1, n = 1
     * 输出：[]
     * 解释：
     * original 中有 2 个元素。
     * 无法将 2 个元素放入到一个 1x1 的二维数组中，所以返回一个空的二维数组。
     * 示例 4：
     * <p>
     * 输入：original = [3], m = 1, n = 2
     * 输出：[]
     * 解释：
     * original 中只有 1 个元素。
     * 无法将 1 个元素放满一个 1x2 的二维数组，所以返回一个空的二维数组。
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
     * 给定一个候选人编号的集合?candidates?和一个目标数?target?，
     * 找出?candidates?中所有可以使数字和为?target?的组合。
     * candidates?中的每个数字在每个组合中只能使用?一次?。
     * 注意：解集不能包含重复的组合。?
     * 示例?1:
     * 输入: candidates =?[10,1,2,7,6,1,5], target =?8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例?2:
     * 输入: candidates =?[2,5,2,1,2], target =?5,
     * 输出:
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
     * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
     * i < j < k ，
     * nums[j] - nums[i] == diff 且
     * nums[k] - nums[j] == diff
     * 返回不同 算术三元组 的数目。
     * 示例 1：
     * 输入：nums = [0,1,4,6,7,10], diff = 3
     * 输出：2
     * 解释：
     * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
     * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
     * 示例 2：
     * 输入：nums = [4,5,6,7,8,9], diff = 2
     * 输出：2
     * 解释：
     * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
     * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
     * ?
     * 提示：
     * 3 <= nums.length <= 200
     * 0 <= nums[i] <= 200
     * 1 <= diff <= 50
     * nums 严格 递增
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
     * 给你两个下标从 0?开始的整数数组?nums1 和?nums2?，长度为?n?。
     * 数组?nums1 和?nums2?的 差值平方和?定义为所有满足?0 <= i < n?的?(nums1[i] - nums2[i])2?之和。
     * 同时给你两个正整数?k1 和?k2?。
     * 你可以将?nums1?中的任意元素?+1 或者?-1?至多?k1?次。类似的，
     * 你可以将?nums2?中的任意元素?+1 或者?-1?至多?k2?次。
     * 请你返回修改数组?nums1?至多?k1?次且修改数组?nums2?至多 k2?次后的最小?差值平方和?。
     * 注意：你可以将数组中的元素变成?负?整数。
     * 示例 1：
     * 输入：nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
     * 输出：579
     * 解释：nums1 和 nums2 中的元素不能修改，因为 k1 = 0 和 k2 = 0 。
     * 差值平方和为：(1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2?= 579 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
     * 输出：43
     * 解释：一种得到最小差值平方和的方式为：
     * - 将 nums1[0] 增加一次。
     * - 将 nums2[2] 增加一次。
     * 最小差值平方和为：
     * (2 - 5)2 + (4 - 8)2 + (10 - 7)2 + (12 - 9)2?= 43 。
     * 注意，也有其他方式可以得到最小差值平方和，但没有得到比 43 更小答案的方案。
     * 提示：
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
            //最大的不再唯一
            while (nums[index] > nums[index - 1]) {
                nums[index]--;
                all--;
                if (all == 0) {
                    return getResult(nums);
                }
            }
            //多个最大值轮流减少
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
     * 给定一个 ?无重复元素 的?有序 整数数组 nums 。
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表?。
     * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     * 示例 1：
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例 2：
     * 输入：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     * 提示：
     * 0 <= nums.length <= 20
     * -231 <= nums[i] <= 231 - 1
     * nums 中的所有值都 互不相同
     * nums 按升序排列
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length > 0) {
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //如果是连续得
                if (nums[i] == nums[i - 1] + 1) {
                    end = nums[i];
                } else {
                    if (start == end) {
                        list.add(start + "");
                    } else {
                        list.add(start + "->" + end);
                    }
                    //重置开头结尾
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
     * 给定一个包含 [0, n]?中?n?个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * 示例 1：
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 3：
     * 输入：nums = [9,6,4,2,3,5,7,0,1]
     * 输出：8
     * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 4：
     * 输入：nums = [0]
     * 输出：1
     * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
     * 提示：
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * nums 中的所有数字都 独一无二
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
