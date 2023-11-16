package houyw.java.myself;

import houyw.common.TreeNode;
import houyw.common.utils.TransferUtils;
import houyw.common.utils.TreeUtils;

import javax.sound.midi.Sequence;
import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/8/21 10:32
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        //1,1,2,3,4,4,5
        Test2 test = new Test2();
        /*PriorityQueue<Integer> que = new PriorityQueue();
        que.add(3);
        que.add(2);
        que.add(1);
        System.out.println(que.poll());*/

        int[] nums = {1, 1, 2, 3};
        System.out.println(minSum(nums));


    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int count = 0;
        int all = 0;
        for (int i = 0; i < energy.length; i++) {
            all += energy[i];
        }
        if (all >= initialEnergy) {
            count = all - initialEnergy + 1;
        }
        for (int i = 0; i < experience.length; i++) {
            if (initialExperience <= experience[i]) {
                count = count + experience[i] - initialExperience + 1;
                initialExperience = experience[i] * 2 + 1;
            } else {
                initialExperience = initialExperience + experience[i];
            }
        }

        return count;
    }

    /**
     * 给你一个仅由数字（0 - 9）组成的字符串 num 。
     * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
     * 注意：
     * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
     * 示例 1：
     * 输入：num = "444947137"
     * 输出："7449447"
     * 解释：
     * 从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
     * 可以证明 "7449447" 是能够形成的最大回文整数。
     * 示例 2：
     * 输入：num = "00009"
     * 输出："9"
     * 解释：
     * 可以证明 "9" 能够形成的最大回文整数。
     * 注意返回的整数不应含前导零。
     * 提示：
     * 1 <= num.length <= 105
     * num 由数字（0 - 9）组成
     */
    public String largestPalindromic(String num) {
        if (num.equals("0")) {
            return "0";
        }
        int max = 0;
        long[] nums = new long[10];
        for (int i = 0; i < num.length(); i++) {
            nums[num.charAt(i) - '0']++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1 && nums[i] > 2) {
                nums[i]--;
                if (i > max) {
                    max = i;
                }
            }
        }
        String ss = "";
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] != 0) {
                count2 += nums[i];
            } else {
                if (nums[i] > 0 && i > max) {
                    max = i;
                }
            }
        }
        //可多用的
        if (nums[0] == count2) {
            return String.valueOf(max);
        } else {
            if (!(max == 0 && nums[0] == 0)) {
                ss = String.valueOf(max);
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    while (nums[i] > 0) {
                        ss = String.valueOf(i) + ss + String.valueOf(i);
                        nums[i] = nums[i] - 2;
                    }
                }
            }
        }
        return ss;
    }

    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        Map<TreeNode, Integer> counts = new HashMap<>();
        TreeNode first = null;
        int all = 0;
        while (que.size() > 0) {
            int size = que.size();
            all += size;
            while (size-- > 0) {
                TreeNode cur = que.poll();
                if (cur.val == start) {
                    first = cur;
                }
                if (cur.left != null) {
                    mp.put(cur.left, cur);
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    mp.put(cur.right, cur);
                    que.add(cur.right);
                }
            }
        }
        counts.put(first, 0);
        que.add(first);
        int count = 0;
        while (all-- > 0) {
            while (que.size() > 0) {
                int size = que.size();
                while (size-- > 0) {
                    TreeNode cur = que.poll();
                    if (cur.left != null && counts.get(cur.left) == null) {
                        counts.put(cur.left, counts.get(cur) + 1);
                        que.add(cur.left);
                    }
                    if (cur.right != null && counts.get(cur.right) == null) {
                        counts.put(cur.right, counts.get(cur) + 1);
                        que.add(cur.right);
                    }
                    if (mp.get(cur) != null && counts.get(mp.get(cur)) == null) {
                        counts.put(mp.get(cur), 1);
                        que.add(mp.get(cur));
                    }

                }
                count++;
            }

        }
        return count - 1;
    }

    /**
     * 给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
     * 数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
     * 返回数组的 第 k 大和 。
     * 子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
     * 注意：空子序列的和视作 0 。
     * 示例 1：
     * 输入：nums = [2,4,-2], k = 5
     * 输出：2
     * 解释：所有可能获得的子序列和列出如下，按递减顺序排列：
     * - 6、4、4、2、2、0、0、-2
     * 数组的第 5 大和是 2 。
     * 示例 2：
     * 输入：nums = [1,-2,3,4,-10,12], k = 16
     * 输出：10
     * 解释：数组的第 16 大和是 10 。
     * 提示：
     * n == nums.length
     * 1 <= n <= 105
     * -109 <= nums[i] <= 109
     * 1 <= k <= min(2000, 2n)
     */
    public long kSum(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> indexs = new ArrayList<>();
        //所有得总和
        long sum = 0;
        //一个数得序列
        List<Integer> l1 = new ArrayList<>();
        List<Integer> i1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            l1.add(nums[i]);
            i1.add(i);
            sum += nums[i];
        }
        //i+1个数得组合
        for (int i = 1; i < nums.length / 2; i++) {
            List<Integer> li = new ArrayList<>();
            List<Integer> index = indexs.get(i - 1);
            //前一个列表所有得和
            List<Integer> l = list.get(i - 1);
            //前一个列表所有得坐标
            List<Integer> idx = indexs.get(i - 1);
            for (int j = 0; j < nums.length; j++) {
                if (idx.contains(i)) {
                    continue;
                }
            }


        }
        return 0;
    }


    public long kSum1(int[] nums, int k) {
        //最大值子序列和，所有的序列和都可以用最大值减去任意一个或多个元素的绝对值来得到
        long maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxVal += nums[i];
            }
            //所有的值都取正值
            nums[i] = Math.abs(nums[i]);
        }
        if (k == 1) {
            return maxVal;
        }
        //从小到大排序
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        //用最优先队列
        PriorityQueue<long[]> que = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        //代表当前的最小序列和该序列最后一位的坐标
        que.add(new long[]{nums[0], 0});
        while (!que.isEmpty()) {
            long[] cur = que.poll();
            int index = (int) cur[1];
            list.add(cur[0]);
            //当有足够的值之后就不再计算后面的了
            if (list.size() >= k - 1) {
                break;
            }
            if (index + 1 < nums.length) {
                que.add(new long[]{cur[0] + nums[index + 1], index + 1});
                que.add(new long[]{cur[0] - nums[index] + nums[index + 1], index + 1});
            }
        }
        return maxVal - list.get(k - 2);
    }

    public static List<Long> minSum(int[] nums) {
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        //用最优先队列
        PriorityQueue<long[]> que = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        que.add(new long[]{nums[0], 0});
        while (!que.isEmpty()) {
            long[] cur = que.poll();
            int index = (int) cur[1];
            list.add(cur[0]);
            if (index + 1 < nums.length) {
                long next = cur[0] + nums[index + 1];
                que.add(new long[]{next, index + 1});
                que.add(new long[]{next - nums[index], index + 1});
            }
        }
        return list;
    }

    /**
     * 【堆】
     * 数组规模最大为：10^5
     * k 不超过 2000，不超过 2^n
     * <p>
     * nums 中所有正数元素的和 maxSum 为最大的子序列和。
     * 所有子序列都能由这个 maxSum 对应的子序列出发，通过移除部分正数、添加部分非正数得到。
     * 因此，2^n 个子序列和都可以由 maxSum 减去部分正数元素值或加上部分负数元素值得到。
     * 我们可以将原数组中的正数和负数统一一下，全部取为正数，那么在 maxSum 上加上负数值就相当于是减去它的绝对值。
     * <p>
     * 有了上面的转化，目标就转化为：从一个由非负元素构成的数组中求出【第 k 小的子序列和】。
     * 如果一一枚举需要 O(2^n) 的时间复杂度，我们肯定不能这样做，我们需要想出一个 O(nlogn) 的方法。
     * <p>
     * 我们使用优先队列（小根堆）来维护当前遍历的所有子序列和。
     * 我们可以对这个非负数组做排序，并从子序列 {a[0]} 出发（它一定具有最小的【非空】子序列和），将其放入堆中，
     * 每次从堆中抛出堆顶元素（当前的最小子序列和），并在该子序列的两个「邻居节点」放入堆中。
     * 不断重复这个过程，直到抛出 k - 1 个最小子序列和即完成。
     * <p>
     * 我们能够保证这样的做法能确保所有子序列和不被遗漏，同时一定是【sum 较小】的子序列先放入堆，【sum 较大】的子序列后放入堆。
     */
    public static List<Integer> getTopMapNum(int[] arr, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue();
        List<Integer> topKList = new ArrayList<>();
        if (arr == null || k > arr.length || k <= 0) {
            return topKList;
        }
        for (int i : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(i);
            } else {
                if (priorityQueue.peek() < i) {
                    priorityQueue.poll();
                    priorityQueue.add(i);
                }
            }
        }

        while (k-- > 0) {
            topKList.add(priorityQueue.poll());
        }
        return topKList;
    }


    /**
     * 给定?pushed?和?popped?两个序列，每个序列中的 值都不重复，只
     * 有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false?。
     * 示例 1：
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * 示例 2：
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     * 提示：
     * 1 <= pushed.length <= 1000
     * 0 <= pushed[i] <= 1000
     * pushed 的所有元素 互不相同
     * popped.length == pushed.length
     * popped 是 pushed 的一个排列
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            while (stack.size() > 0 && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
            stack.push(pushed[i]);
        }
        while (stack.size() > 0 && stack.peek() == popped[index]) {
            stack.pop();
            index++;
        }
        if(stack.size() == 0 && index ==popped.length){
            return true;
        }
        return false;
    }
}
