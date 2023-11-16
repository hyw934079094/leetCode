package houyw.java.myself.leetcode.dtgh;

import houyw.common.utils.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: DELL
 * @Date: 2022/8/18 17:58
 * @Description:
 */
public class Single {
    public static void main(String[] args) {
        Single sg = new Single();
       int[] nums = {4,5,2,1};
       int[] queries = {3,10,21};
        int[] ints = sg.answerQueries(nums, queries);
        ArrayUtils.print(ints);
    }
    /**
     * С���� A �ں� ta ��С������洫��Ϣ��Ϸ����Ϸ�������£�
     * �� n ����ң�������ұ�ŷֱ�Ϊ 0 �� n-1������С���� A �ı��Ϊ 0
     * ÿ����Ҷ��й̶������ɸ��ɴ���Ϣ��������ң�Ҳ����û�У���
     * ����Ϣ�Ĺ�ϵ�ǵ���ģ����� A ������ B ����Ϣ���� B ������ A ����Ϣ����
     * ÿ����Ϣ������Ҫ���ݸ���һ���ˣ�����Ϣ���ظ�����ͬһ����
     * ����������� n���Լ��� [��ұ��,��Ӧ�ɴ�����ұ��] ��ϵ��ɵĶ�ά���� relation��
     * ������Ϣ��С A (��� 0 ) ���� k �ִ��ݵ����Ϊ n-1 ��С��鴦�ķ������������ܵ������ 0��
     * ʾ�� 1��
     * ���룺n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     * �����3
     * ���ͣ���Ϣ��С A ��� 0 ����ʼ���� 3 �ִ��ݣ������� 4������ 3 �ַ������ֱ��� 0->2->0->4�� 0->2->1->4�� 0->2->3->4��
     * ʾ�� 2��
     * ���룺n = 3, relation = [[0,2],[2,1]], k = 2
     * �����0
     * ���ͣ���Ϣ���ܴ�С A ������ 2 �ִ��ݵ���� 2
     * ���ƣ�
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, �� relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n �� relation[i][0] != relation[i][1]
     */
    public int numWays(int n, int[][] relation, int k) {
        Queue<Integer> que = new LinkedList();
        que.add(0);
        while (k-- > 0) {
            int size = que.size();
            while (size-- > 0) {
                int cur = que.poll();
                for (int i = 0; i < relation.length; i++) {
                    if (cur == relation[i][0]) {
                        que.add(relation[i][1]);
                    }
                }
            }

        }
        int count = 0;
        while (que.size() > 0) {
            if (que.poll() == n - 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * ����һ������Ϊ n?���������� nums ����һ������Ϊ m ���������� queries ��
     * ����һ������Ϊ m ������ answer ������ answer[i] �� nums �� Ԫ��֮��С�ڵ��� queries[i] �� ������ �� ��� ����? ��
     * ������ ����һ������ɾ��ĳЩԪ�أ�Ҳ���Բ�ɾ���������ı�ʣ��Ԫ��˳��õ���һ�����顣
     * ʾ�� 1��
     * ���룺nums = [4,5,2,1], queries = [3,10,21]
     * �����[2,3,4]
     * ���ͣ�queries ��Ӧ�� answer ���£�
     * - ������ [2,1] �ĺ�С�ڻ���� 3 ������֤��������ĿҪ��������е���󳤶��� 2 ������ answer[0] = 2 ��
     * - ������ [4,5,1] �ĺ�С�ڻ���� 10 ������֤��������ĿҪ��������е���󳤶��� 3 ������ answer[1] = 3 ��
     * - ������ [4,5,2,1] �ĺ�С�ڻ���� 21 ������֤��������ĿҪ��������е���󳤶��� 4 ������ answer[2] = 4 ��
     * ʾ�� 2��
     * ���룺nums = [2,3,4,5], queries = [1]
     * �����[0]
     * ���ͣ�����������Ψһһ������Ԫ�غ�С�ڻ���� 1 �������У����� answer[0] = 0 ��
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] + sum <= queries[i]) {
                    sum += nums[j];
                    count++;
                }else{
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
