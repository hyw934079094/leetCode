package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/26 17:39
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        int[] nums = {1, 2, 3, 1};
        int peakElement = day.findPeakElement(nums);
        System.out.println(peakElement);
    }


    /**
     * ��֪һ������Ϊ n �����飬Ԥ�Ȱ����������У����� 1 �� n �� ��ת ��
     * �õ��������顣���磬ԭ���� nums = [0,1,2,4,5,6,7] �ڱ仯����ܵõ���
     * ����ת 4 �Σ�����Եõ� [4,5,6,7,0,1,2]
     * ����ת 7 �Σ�����Եõ� [0,1,2,4,5,6,7]
     * ע�⣬���� [a[0], a[1], a[2], ..., a[n-1]] ��תһ�� �Ľ��Ϊ���� [a[n-1], a[0], a[1], a[2], ..., a[n-2]] ��
     * ����һ��Ԫ��ֵ ������ͬ ������ nums ����ԭ����һ���������е����飬�����������ν����˶����ת�������ҳ������������е� ��СԪ�� ��
     * ��������һ��ʱ�临�Ӷ�Ϊ?O(log n) ���㷨��������⡣
     * ʾ�� 1��
     * ���룺nums = [3,4,5,1,2]
     * �����1
     * ���ͣ�ԭ����Ϊ [1,2,3,4,5] ����ת 3 �εõ��������顣
     * ʾ�� 2��
     * ���룺nums = [4,5,6,7,0,1,2]
     * �����0
     * ���ͣ�ԭ����Ϊ [0,1,2,4,5,6,7] ����ת 4 �εõ��������顣
     * ʾ�� 3��
     * ���룺nums = [11,13,15,17]
     * �����11
     * ���ͣ�ԭ����Ϊ [11,13,15,17] ����ת 4 �εõ��������顣
     * ��ʾ��
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums �е��������� ������ͬ
     * nums ԭ����һ��������������飬�������� 1 �� n ����ת
     */

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = (start + end) / 2;
        while (start < end) {
            if (nums[index] < nums[end]) {
                end = index;
            } else {

            }

        }
        return nums[0];
    }

    /**
     * ��ֵԪ����ָ��ֵ�ϸ������������ֵ��Ԫ�ء�
     * ����һ����������?nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�
     * ����Լ���?nums[-1] = nums[n] = -�� ��
     * �����ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨����������⡣
     * ʾ�� 1��
     * ���룺nums = [1,2,3,1]
     * �����2
     * ���ͣ�3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
     * ʾ��?2��
     * ���룺nums = [1,2,1,3,5,6,4]
     * �����1 �� 5
     * ���ͣ���ĺ������Է������� 1�����ֵԪ��Ϊ 2��
     * ?    ���߷������� 5�� ���ֵԪ��Ϊ 6��
     * ��ʾ��
     * 1 <= nums.length <= 1000
     * -231 <= nums[i] <= 231 - 1
     * ����������Ч�� i ���� nums[i] != nums[i + 1]
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[1] < nums[0]) {
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i]) {
                if (nums[i + 1] < nums[i]) {
                    return i;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return -1;
    }
}
