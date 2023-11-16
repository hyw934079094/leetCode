package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/15 17:50
 * @Description:
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 day = new Day13();
        //int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        //int[] nums = {1, 11, 5, 5};
        int[] nums = {-2,0,-1};
        //boolean b = day.canPartition(nums);
        System.out.println(day.maxProduct(nums));
    }

    /**
     * ����һ�� ֻ���������� �� �ǿ� ���� nums �������ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
     * ʾ�� 1��
     * ���룺nums = [1,5,11,5]
     * �����true
     * ���ͣ�������Էָ�� [1, 5, 5] �� [11] ��
     * ʾ�� 2��
     * ���룺nums = [1,2,3,5]
     * �����false
     * ���ͣ����鲻�ָܷ������Ԫ�غ���ȵ��Ӽ���
     * ��ʾ��
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        //arr[i] ��ʾ�����к�Ϊi������ж�����
        int[] arr = new int[sum / 2 + 1];
        //��Ϊ0�����ֻ��һ��
        arr[0] = 1;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                //��ǰ����Ŀ�����У�
                arr[i] += arr[i - num];
            }
        }
        return arr[sum / 2] != 0;
    }


    /**
     * ����һ���������� nums?�������ҳ������г˻����ķǿ����������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
     * ���������Ĵ���һ��?32-λ ������
     * ������ ����������������С�
     * ʾ�� 1:
     * ����: nums = [2,3,-2,4]
     * ���: 6
     * ����:?������ [2,3] �����˻� 6��
     * ʾ�� 2:
     * ����: nums = [-2,0,-1]
     * ���: 0
     * ����:?�������Ϊ 2, ��Ϊ [-2,-1] ���������顣
     * ?
     * <p>
     * ��ʾ:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums ���κ�ǰ׺���׺�ĳ˻��� ��֤?��һ�� 32-λ ����
     * 2,3,-1,0,-2,4,7,-2,-1,0,-4
     */
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                min[i] = 0;
                max[i] = 0;
            }else{
                if(nums[i-1] ==0){
                    min[i] = nums[i];
                    max[i] = nums[i];
                }else{
                    max[i] = Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]);
                    max[i] = Math.max(max[i],nums[i]);
                    min[i] = Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]);
                    min[i] = Math.min(min[i],nums[i]);
                }

            }
        }
        int num = nums[0];
        for(int i = 0;i<max.length;i++){
            if(max[i]>num){
                num = max[i];
            }
        }
        return num;
    }


}
