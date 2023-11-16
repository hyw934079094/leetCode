package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/7/29 10:52
 * @Description:
 */
public class Day5 {
    public static void main(String[] args) {
        Day5 day = new Day5();
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        //System.out.println(day.minSubArrayLen(11, num));
        System.out.println(day.numSubarrayProductLessThanK(nums, 8));

    }

    /**
     * ����һ������?n?���������������һ�������� target ��
     * �ҳ���������������� �� target �ĳ�����С�� ����������?[numsl, numsl+1, ..., numsr-1, numsr] ��
     * �������䳤�ȡ���������ڷ��������������飬���� 0 ��
     * ʾ�� 1��
     * ���룺target = 7, nums = [2,3,1,2,4,3]
     * �����2
     * ���ͣ�������?[4,3]?�Ǹ������µĳ�����С�������顣
     * ʾ�� 2��
     * ���룺target = 4, nums = [1,4,4]
     * �����1
     * ʾ�� 3��
     * ���룺target = 11, nums = [1,1,1,1,1,1,1,1]
     * �����0
     * ��ʾ��
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * ���ף�
     * ������Ѿ�ʵ�� O(n) ʱ�临�ӶȵĽⷨ, �볢�����һ�� O(n log(n)) ʱ�临�ӶȵĽⷨ��
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                int num = right - left + 1;
                if (count == 0) {
                    count = num;
                }
                if (num < count) {
                    count = num;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return count;
    }

    /**
     * ����һ���������� nums ��һ������ k �����㷵��������������Ԫ�صĳ˻��ϸ�С�� k ���������������Ŀ��
     * ʾ�� 1��
     * ���룺nums = [10,5,2,6], k = 100
     * �����8
     * ���ͣ�8 ���˻�С�� 100 ��������ֱ�Ϊ��[10]��[5]��[2],��[6]��[10,5]��[5,2]��[2,6]��[5,2,6]��
     * ��Ҫע����� [10,5,2] �����ǳ˻�С�� 100 �������顣
     * ʾ�� 2��
     * ���룺nums = [1,2,3], k = 0
     * �����0
     * ?
     * ��ʾ:?
     * 1 <= nums.length <= 3 * 104
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 106
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 1;
        int count = 0;
        while (right < nums.length) {
            //��ǰle
            sum *= nums[right];
            //��ָ��ͣ���ڵ�һ��ʹ�˻�����k���±����ĩβ��
            while (sum >= k) {
                if (right >= left) {
                    count += right - left;
                }else{
                    break;
                }
                sum /= nums[left];
                left++;
            }
            right++;
        }
        while (left < right) {
            count+=right-left;
            left++;
        }
        return count;
    }
}
