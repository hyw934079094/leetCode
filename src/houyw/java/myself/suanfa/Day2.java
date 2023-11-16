package houyw.java.myself.suanfa;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/6/10 15:20
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        int[] nums = {1};
        int[] ints = day.sortedSquares(nums);

        day.rotate(nums, 4);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(ints[i] + ",");
        }


    }

    /**
     * ����һ���� �ǵݼ�˳�� ������������� nums��
     * ���� ÿ�����ֵ�ƽ�� ��ɵ������飬Ҫ��Ҳ�� �ǵݼ�˳�� ����
     * ʾ�� 1��
     * ���룺nums = [-4,-1,0,3,10]
     * �����[0,1,9,16,100]
     * ���ͣ�ƽ���������Ϊ [16,1,0,9,100]
     * ����������Ϊ [0,1,9,16,100]
     * ʾ�� 2��
     * ���룺nums = [-7,-3,2,3,11]
     * �����[4,9,9,49,121]
     * ��ʾ��
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums �Ѱ� �ǵݼ�˳�� ����
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        boolean flag = true;
        if(nums.length%2 ==0){
            flag = false;
        }
        while(i<j){
            nums[i] = nums[i]*nums[i];
            nums[j] = nums[j]*nums[j];
            i++;
            j--;
        }
        if(flag){
            nums[i] = nums[i]*nums[i];
        }
        /*for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        */
        Arrays.sort(nums);
        return nums;
    }

    /**
     * ����һ�����飬�������е�Ԫ��������ת k?��λ�ã�����?k?�ǷǸ�����
     * ʾ�� 1:
     * ����: nums = [1,2,3,4,5,6,7], k = 3
     * ���: [5,6,7,1,2,3,4]
     * ����:
     * ������ת 1 ��: [7,1,2,3,4,5,6]
     * ������ת 2 ��: [6,7,1,2,3,4,5]
     * ������ת 3 ��: [5,6,7,1,2,3,4]
     * ʾ��?2:
     * ���룺nums = [-1,-100,3,99], k = 2
     * �����[3,99,-1,-100]
     * ����:
     * ������ת 1 ��: [99,-1,-100,3]
     * ������ת 2 ��: [3,99,-1,-100]
     * ��ʾ��
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     * ���ף�
     * �������������Ľ�������������� ���� ��ͬ�ķ������Խ��������⡣
     * �����ʹ�ÿռ临�Ӷ�Ϊ?O(1) ��?ԭ��?�㷨������������
     */
    public void rotate(int[] nums, int k) {
        //ԭ�����ϴ���   �ռ临�Ӷ�o(1)

    }

    public void rotate1(int[] nums, int k) {
        //ԭ�����ϴ���   ������Ҫ�����Լ��
        if (k == 0) {
            return;
        }
        int m = maxGYS(nums.length,k );
        for (int j = 0; j < m; j++) {
            int firstIndex = j;
            int index = firstIndex;
            int temp = nums[j];
            int x;
            for (int i = 0; i < nums.length; i++) {
                index = index + k;
                while (index > nums.length - 1) {
                    index = index - nums.length;
                }
                x = nums[index];
                nums[index] = temp;
                temp = x;
                if (index == firstIndex) {
                    break;
                }
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        //ʹ��һ�������� complete
        int[] newarr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < newarr.length; i++) {
            int index = i + k;
            while (index > nums.length - 1) {
                index = index - nums.length;
            }
            nums[index] = newarr[i];
        }
    }

    public int maxGYS(int a, int b) {
        int max = a;
        int min = b;
        if (a > b) {
            max = b;
            min = a;
        }

        while (max % min != 0) {
            int k = max % min;
            max = min;
            min = k;
        }
        return min;
    }
}
