package houyw.java.myself.suanfa2;

import houyw.common.utils.ArrayUtils;

/**
 * @Author: DELL
 * @Date: 2022/7/26 17:03
 * @Description:
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day = new Day1();
        int[] nums = {1,4};
        int[] ints = day.searchRange(nums, 4);
        ArrayUtils.print(ints);
    }

    /**
     * ����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target��
     * �����ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
     * ��������в�����Ŀ��ֵ target������?[-1, -1]��
     * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ?O(log n)?���㷨��������⡣
     * ʾ�� 1��
     * ���룺nums = [5,7,7,8,8,10], target = 8
     * �����[3,4]
     * ʾ��?2��
     * ���룺nums = [5,7,7,8,8,10], target = 6
     * �����[-1,-1]
     * ʾ�� 3��
     * ���룺nums = [], target = 0
     * �����[-1,-1]
     * ��ʾ��
     * 0 <= nums.length <= 105
     * -109?<= nums[i]?<= 109
     * nums?��һ���ǵݼ�����
     * -109?<= target?<= 109
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        boolean hasNum = false;
        int index = -1;
        while (index < end || index > start) {
            index = (start + end) / 2;
            if (nums[index] == target) {
                hasNum = true;
                break;
            }
            if (nums[index] < target) {
                start = index;
            }
            if (nums[index] > target) {
                end = index;
            }
            if (end - start <=1) {
                if(nums[start]==target){
                    hasNum = true;
                    index = start;
                }
                if(nums[end]==target){
                    hasNum = true;
                    index = end;
                }
                break;
            }
        }
        if (hasNum) {
            start = index;
            end = index;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }
}
