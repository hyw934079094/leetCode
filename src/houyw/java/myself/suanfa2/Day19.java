package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/3 14:38
 * @Description:
 */
public class Day19 {
    public static void main(String[] args) {
        Day19 day = new Day19();
        int i = day.rangeBitwiseAnd(2147483646, 2147483647);
        System.out.println(i);

    }

    /**
     * ������������ left �� right ����ʾ���� [left, right] �����ش��������������� ��λ�� �Ľ�������� left ��right �˵㣩��
     * ʾ�� 1��
     * ���룺left = 5, right = 7
     * �����4
     * ʾ�� 2��
     * ���룺left = 0, right = 0
     * �����0
     * ʾ�� 3��
     * ���룺left = 1, right = 2147483647
     * �����0
     * ��ʾ��
     * 0 <= left <= right <= 231 - 1
     */
    public int rangeBitwiseAnd(int left, int right) {
        int sum = 0;
        int i = left;
        while (i <= right && i > 0) {
            if (i == left) {
                sum = i;
            } else {
                sum = sum & i;
            }
            if (sum == 0) {
                return 0;
            }
            i++;
        }

        return sum;
    }
}
