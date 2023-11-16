package houyw.java.myself.suanfa;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/6/11 11:08
 * @Description:
 */
public class Day3 {
    public static void main(String[] args) {
        Day3 day = new Day3();
        int[] nums = {2,7,11,15};
        int[] ints = day.twoSum(nums, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }

    /**
     * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
     * ��ע��?�������ڲ���������������ԭ�ض�������в�����
     * ʾ�� 1:
     * ����: nums = [0,1,0,3,12]
     * ���: [1,3,12,0,0]
     * ʾ�� 2:
     * ����: nums = [0]
     * ���: [0]
     * ��ʾ:
     * 1 <= nums.length <= 104
     * -231?<= nums[i] <= 231?- 1
     * ���ף����ܾ���������ɵĲ���������
     */
    public void moveZeroes(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        int start = 0;
        int end = nums.length-1;
        for(int i = 0;i<ints.length;i++){
            if(ints[i]==0){
                nums[end] = 0;
                end--;
            }else{
                nums[start] =ints[i];
                start++;
            }
        }
    }

    /**
     * ����һ���±�� 1 ��ʼ����������?numbers ���������Ѱ� �ǵݼ�˳������? ��
     * ������������ҳ��������֮�͵���Ŀ����?target ����������
     * ��������������ֱ��� numbers[index1] �� numbers[index2] ��
     * �� 1 <= index1 < index2 <= numbers.length ��
     * �Գ���Ϊ 2 ���������� [index1, index2] ����ʽ�����������������±� index1 �� index2��
     * ����Լ���ÿ������ ֻ��ӦΨһ�Ĵ� �������� ������ �ظ�ʹ����ͬ��Ԫ�ء�
     * ������ƵĽ����������ֻʹ�ó������Ķ���ռ䡣
     * ?
     * ʾ�� 1��
     * ���룺numbers = [2,7,11,15], target = 9
     * �����[1,2]
     * ���ͣ�2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ������ [1, 2] ��
     * ʾ�� 2��
     * ���룺numbers = [2,3,4], target = 6
     * �����[1,3]
     * ���ͣ�2 �� 4 ֮�͵���Ŀ���� 6 ����� index1 = 1, index2 = 3 ������ [1, 3] ��
     * ʾ�� 3��
     *
     * ���룺numbers = [-1,0], target = -1
     * �����[1,2]
     * ���ͣ�-1 �� 0 ֮�͵���Ŀ���� -1 ����� index1 = 1, index2 = 2 ������ [1, 2] ��
     * ?
     *
     * ��ʾ��
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers �� �ǵݼ�˳�� ����
     * -1000 <= target <= 1000
     * ������һ����Ч��
     */
    public int[] twoSum(int[] numbers, int target) {
        /*for(int i = 0;i<numbers.length;i++){
           for(int j=i+1;j<numbers.length;j++){
               if(numbers[i]+numbers[j]==target){
                   return new int[]{i+1,j+1};
               }
           }
        }
        return null;*/
        int start = 0;
        int end  = numbers.length-1;
        while(numbers[start]+numbers[end]!=target){
            if(numbers[start]+numbers[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{start+1,end+1};
    }
}
