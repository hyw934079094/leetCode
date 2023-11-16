package houyw.java.myself.leetcode.one;

import houyw.common.utils.ArrayUtils;

/**
 * @Author: DELL
 * @Date: 2022/6/23 20:11
 * @Description:
 */
public class Day1 {
    /**
     * ����һ������ nums �����顸��̬�͡��ļ��㹫ʽΪ��
     * runningSum[i] = sum(nums[0]��nums[i]) ��
     * �뷵�� nums �Ķ�̬�͡�
     * ʾ�� 1��
     * ���룺nums = [1,2,3,4]
     * �����[1,3,6,10]
     * ���ͣ���̬�ͼ������Ϊ [1, 1+2, 1+2+3, 1+2+3+4] ��
     * ʾ�� 2��
     * ���룺nums = [1,1,1,1,1]
     * �����[1,2,3,4,5]
     * ���ͣ���̬�ͼ������Ϊ [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] ��
     * ʾ�� 3��
     * ���룺nums = [3,1,2,10,1]
     * �����[3,4,6,16,17]
     */
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        return arr;
    }

    /**
     * ����һ����������?nums ������������ �����±� ��
     * ���� �����±� �������һ���±꣬���������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
     * ��������±�λ����������ˣ���ô�����֮����Ϊ 0 ����Ϊ���±����಻����Ԫ�ء�
     * ��һ����������±�λ���������Ҷ�ͬ�����á�
     * ��������ж�������±꣬Ӧ�÷��� ������ ����һ����
     * ������鲻���������±꣬���� -1 ��
     * ʾ�� 1��
     * ���룺nums = [1, 7, 3, 6, 5, 6]
     * �����3
     * ���ͣ�
     * �����±��� 3 ��
     * �����֮�� sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ��
     * �Ҳ���֮�� sum = nums[4] + nums[5] = 5 + 6 = 11 ��������ȡ�
     * ʾ�� 2��
     * ���룺nums = [1, 2, 3]
     * �����-1
     * ���ͣ�
     * �����в���������������������±ꡣ
     * ʾ�� 3��
     * ���룺nums = [2, 1, -1]
     * �����0
     * ���ͣ�
     * �����±��� 0 ��
     * �����֮�� sum = 0 �����±� 0 ��಻����Ԫ�أ���
     * �Ҳ���֮�� sum = nums[1] + nums[2] = 1 + -1 = 0 ��
     */
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for(int i = 0;i<nums.length;i++){
            int left = 0;
            int right = 0;
            for(int j = 0;j<i;j++){
                left+=nums[j];
            }
            for(int k = i+1;k<nums.length;k++){
                right+=nums[k];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }
    //˫�±��Ż�
    public int pivotIndexBetter(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        right[0] = 0;
        for(int j = 1;j<right.length;j++){
            right[j] = nums[right.length-j]+right[j-1];
        }
        for(int i =0;i<left.length;i++){
            if(i>0){
                left[i] = nums[i-1]+left[i-1];
            }else{
                left[i] = 0;
            }
            if(left[i] == right[right.length-i-1]){
                return i;
            }
        }

        return -1;
    }
}
