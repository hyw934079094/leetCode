package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/8 09:47
 * @Description:
 */
public class Day14 {
    /**
     * ���һ������ ����������Ԫ�� ������������������Ԫ��֮����ͬ����Ƹ�����Ϊ�Ȳ����С�
     * ���磬[1,3,5,7,9]��[7,7,7,7] �� [3,-1,-5,-9] ���ǵȲ����С�
     * ����һ���������� nums ���������� nums ������Ϊ�Ȳ������ ������ ������
     * ������ �������е�һ���������С�
     * ʾ�� 1��
     * ���룺nums = [1,2,3,4]
     * �����3
     * ���ͣ�nums ���������ӵȲ����飺[1, 2, 3]��[2, 3, 4] �� [1,2,3,4] ����
     * ʾ�� 2��
     * ���룺nums = [1]
     * �����0
     * ��ʾ��
     * 1 <= nums.length <= 5000
     * -1000 <= nums[i] <= 1000
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] fn = new int[nums.length];
        fn[0] = 0;
        fn[1] = 0;
        int add = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                add++;
                fn[i] = fn[i - 1] + add;
            } else {
                fn[i] = fn[i - 1];
                add = 0;
            }
        }
        return fn[fn.length - 1];
    }
}
