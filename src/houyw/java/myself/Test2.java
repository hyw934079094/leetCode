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
     * ����һ���������֣�0 - 9����ɵ��ַ��� num ��
     * �����ҳ��ܹ�ʹ�� num �������γɵ� ������ �����������ַ�����ʽ���ء����������� ǰ���� ��
     * ע�⣺
     * �� ���� ʹ�� num �е��������֣��������ʹ�� ���� һ�����֡�
     * ʾ�� 1��
     * ���룺num = "444947137"
     * �����"7449447"
     * ���ͣ�
     * �� "444947137" ��ѡ������ "4449477"�������γɻ������� "7449447" ��
     * ����֤�� "7449447" ���ܹ��γɵ�������������
     * ʾ�� 2��
     * ���룺num = "00009"
     * �����"9"
     * ���ͣ�
     * ����֤�� "9" �ܹ��γɵ�������������
     * ע�ⷵ�ص�������Ӧ��ǰ���㡣
     * ��ʾ��
     * 1 <= num.length <= 105
     * num �����֣�0 - 9�����
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
        //�ɶ��õ�
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
     * ����һ���������� nums ��һ�� �� ���� k �������ѡ���������һ ������ ���Ҷ���ȫ��Ԫ����͡�
     * ����� �� k ��� ����Ϊ�����Ի�õĵ� k �� ��� �����кͣ������к���������ظ���
     * ��������� �� k ��� ��
     * ��������һ����������������ɾ��ĳЩ��ɾ��Ԫ���������������飬���������̲��ı�ʣ��Ԫ�ص�˳��
     * ע�⣺�������еĺ����� 0 ��
     * ʾ�� 1��
     * ���룺nums = [2,4,-2], k = 5
     * �����2
     * ���ͣ����п��ܻ�õ������к��г����£����ݼ�˳�����У�
     * - 6��4��4��2��2��0��0��-2
     * ����ĵ� 5 ����� 2 ��
     * ʾ�� 2��
     * ���룺nums = [1,-2,3,4,-10,12], k = 16
     * �����10
     * ���ͣ�����ĵ� 16 ����� 10 ��
     * ��ʾ��
     * n == nums.length
     * 1 <= n <= 105
     * -109 <= nums[i] <= 109
     * 1 <= k <= min(2000, 2n)
     */
    public long kSum(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> indexs = new ArrayList<>();
        //���е��ܺ�
        long sum = 0;
        //һ����������
        List<Integer> l1 = new ArrayList<>();
        List<Integer> i1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            l1.add(nums[i]);
            i1.add(i);
            sum += nums[i];
        }
        //i+1���������
        for (int i = 1; i < nums.length / 2; i++) {
            List<Integer> li = new ArrayList<>();
            List<Integer> index = indexs.get(i - 1);
            //ǰһ���б����еú�
            List<Integer> l = list.get(i - 1);
            //ǰһ���б����е�����
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
        //���ֵ�����кͣ����е����кͶ����������ֵ��ȥ����һ������Ԫ�صľ���ֵ���õ�
        long maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxVal += nums[i];
            }
            //���е�ֵ��ȡ��ֵ
            nums[i] = Math.abs(nums[i]);
        }
        if (k == 1) {
            return maxVal;
        }
        //��С��������
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        //�������ȶ���
        PriorityQueue<long[]> que = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        //����ǰ����С���к͸��������һλ������
        que.add(new long[]{nums[0], 0});
        while (!que.isEmpty()) {
            long[] cur = que.poll();
            int index = (int) cur[1];
            list.add(cur[0]);
            //�����㹻��ֵ֮��Ͳ��ټ���������
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
        //�������ȶ���
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
     * ���ѡ�
     * �����ģ���Ϊ��10^5
     * k ������ 2000�������� 2^n
     * <p>
     * nums ����������Ԫ�صĺ� maxSum Ϊ���������к͡�
     * ���������ж�������� maxSum ��Ӧ�������г�����ͨ���Ƴ�������������Ӳ��ַ������õ���
     * ��ˣ�2^n �������кͶ������� maxSum ��ȥ��������Ԫ��ֵ����ϲ��ָ���Ԫ��ֵ�õ���
     * ���ǿ��Խ�ԭ�����е������͸���ͳһһ�£�ȫ��ȡΪ��������ô�� maxSum �ϼ��ϸ���ֵ���൱���Ǽ�ȥ���ľ���ֵ��
     * <p>
     * ���������ת����Ŀ���ת��Ϊ����һ���ɷǸ�Ԫ�ع��ɵ�������������� k С�������к͡���
     * ���һһö����Ҫ O(2^n) ��ʱ�临�Ӷȣ����ǿ϶�������������������Ҫ���һ�� O(nlogn) �ķ�����
     * <p>
     * ����ʹ�����ȶ��У�С���ѣ���ά����ǰ���������������к͡�
     * ���ǿ��Զ�����Ǹ����������򣬲��������� {a[0]} ��������һ��������С�ġ��ǿա������кͣ������������У�
     * ÿ�δӶ����׳��Ѷ�Ԫ�أ���ǰ����С�����кͣ������ڸ������е��������ھӽڵ㡹������С�
     * �����ظ�������̣�ֱ���׳� k - 1 ����С�����кͼ���ɡ�
     * <p>
     * �����ܹ���֤������������ȷ�����������кͲ�����©��ͬʱһ���ǡ�sum ��С�����������ȷ���ѣ���sum �ϴ󡿵������к����ѡ�
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
     * ����?pushed?��?popped?�������У�ÿ�������е� ֵ�����ظ���ֻ
     * �е����ǿ������������ջ�Ͻ��е����� push �͵��� pop �������еĽ��ʱ������ true�����򣬷��� false?��
     * ʾ�� 1��
     * ���룺pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * �����true
     * ���ͣ����ǿ��԰�����˳��ִ�У�
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * ʾ�� 2��
     * ���룺pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * �����false
     * ���ͣ�1 ������ 2 ֮ǰ������
     * ��ʾ��
     * 1 <= pushed.length <= 1000
     * 0 <= pushed[i] <= 1000
     * pushed ������Ԫ�� ������ͬ
     * popped.length == pushed.length
     * popped �� pushed ��һ������
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
