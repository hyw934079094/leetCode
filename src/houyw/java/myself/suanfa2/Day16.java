package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/8 17:38
 * @Description:
 */
public class Day16 {
    public static void main(String[] args) {
        Day16 day = new Day16();
        int[] nums = {2, 2, 2, 2, 2};
        int i = day.findNumberOfLIS(nums);
        System.out.println(i);
    }

    /**
     * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
     * ������?���������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳��
     * ���磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
     * ʾ�� 1��
     * ���룺nums = [10,9,2,5,3,7,101,18]
     * �����4
     * ���ͣ�������������� [2,3,7,101]����˳���Ϊ 4 ��
     * ʾ�� 2��
     * ���룺nums = [0,1,0,3,2,3]
     * �����4
     * ʾ�� 3��
     * ���룺nums = [7,7,7,7,7,7,7]
     * �����1
     * ��ʾ��
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * ���ף�
     * ���ܽ��㷨��ʱ�临�ӶȽ��͵�?O(n log(n)) ��?
     */
    public int lengthOfLIS(int[] nums) {
        int[] fn = new int[nums.length];
        fn[0] = 1;
        int max = 1;
        for (int i = 1; i < fn.length; i++) {
            fn[i] = 1;

            //�ҵ���һ�����Լ�С����һ����
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    continue;
                }
                if (nums[j] == nums[i] && fn[j] > fn[i]) {
                    fn[i] = fn[j];
                }
                if (nums[j] < nums[i] && fn[j] + 1 > fn[i]) {
                    fn[i] = fn[j] + 1;
                }
            }

            if (fn[i] > max) {
                max = fn[i];
            }
        }
        return max;
    }

    /**
     * ����һ��δ�������������?nums?��?��������������еĸ���?��
     * ע��?������б����� �ϸ� �����ġ�
     * ʾ�� 1:
     * ����: [1,3,5,4,7]
     * ���: 2
     * ����: ����������������У��ֱ��� [1, 3, 4, 7] ��[1, 3, 5, 7]��
     * ʾ�� 2:
     * ����: [2,2,2,2,2]
     * ���: 5
     * ����: ����������еĳ�����1�����Ҵ���5�������еĳ���Ϊ1��������5��
     * 1 <= nums.length <= 2000
     * -106?<= nums[i] <= 106
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) count[i] = 1;

        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) result += count[i];
        }
        return result;
    }
}
