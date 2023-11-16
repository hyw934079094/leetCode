package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/3 15:27
 * @Description:
 */
public class Day12 {
    public static void main(String[] args) {
        Day12 day = new Day12();
        int[] nums = {3,2,1,0,4};
        System.out.println(day.canJump(nums));
    }

    /**
     * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ��
     * ����ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
     * ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
     * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
     * ʾ��?1��
     * ���룺nums = [2,3,2]
     * �����3
     * ���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
     * ʾ�� 2��
     * ���룺nums = [1,2,3,1]
     * �����4
     * ���ͣ��������͵�� 1 �ŷ��ݣ���� = 1����Ȼ��͵�� 3 �ŷ��ݣ���� = 3����
     * ͵�Ե�����߽�� = 1 + 3 = 4 ��
     * ʾ�� 3��
     * ���룺nums = [1,2,3]
     * �����3
     * ��ʾ��
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //��һ�����Ӳ�͵�����,�Ǵӵ�2����n�����Ӷ�̬�滮
        int[] fn1 = new int[nums.length];
        fn1[0] = 0;
        fn1[1] = nums[1];
        //��һ������͵�����,�Ǵӵ�������n-1�����Ӷ�̬�滮
        int[] fn2 = new int[nums.length - 1];
        fn2[0] = nums[0];
        fn2[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            fn1[i] = Math.max(fn1[i - 1], fn1[i - 2] + nums[i]);
            if (i < nums.length - 1) {
                fn2[i] = Math.max(fn2[i - 1], fn2[i - 2] + nums[i]);
            }

        }
        int max1 = Math.max(fn1[fn1.length - 1], fn1[fn1.length - 2]);
        int max2 = Math.max(fn2[fn2.length - 1], fn2[fn2.length - 2]);
        return Math.max(max1, max2);

    }


    /**
     * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     * �ж����Ƿ��ܹ��������һ���±ꡣ
     * ʾ�� 1��
     * ���룺nums = [2,3,1,1,4]
     * �����true
     * ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ
     * ʾ�� 2��
     * ���룺nums = [3,2,1,0,4]
     * �����false
     * ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ
     * <p>
     * <p>
     * ��ʾ��
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     */
    public boolean canJump(int[] nums) {
        boolean[] fn = new boolean[nums.length];
        fn[0] = true;
        for (int i = 1; i < fn.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!fn[j]) {
                    break;
                }
                if (nums[j] >= (i - j)) {
                    fn[i] = true;
                    break;
                }
            }
        }
        return fn[nums.length - 1];
    }

}
