package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/30 17:26
 * @Description:
 */
public class Day13 {
    public static void main(String[] args) {
        Day13 day = new Day13();
        int[] nums = {2,3,0,1,4};
        System.out.println(day.jump(nums));
    }

    /**
     * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
     * ʾ�� 1��
     * ���룺s = "babad"
     * �����"bab"
     * ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
     * ʾ�� 2��
     * ���룺s = "cbbd"
     * �����"bb"
     * ��ʾ��
     * 1 <= s.length <= 1000
     * s �������ֺ�Ӣ����ĸ���
     */
    public String longestPalindrome(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i--) {
            dp[i][i] = 1;

        }


        return "";
    }

    /**
     * ����һ���Ǹ���������?nums �������λ������ĵ�һ��λ�á�
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
     * ���������ǿ��Ե�����������һ��λ�á�
     * ʾ�� 1:
     * ����: nums = [2,3,1,1,4]
     * ���: 2
     * ����: �������һ��λ�õ���С��Ծ���� 2��
     * ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã���?1?����Ȼ����?3?��������������һ��λ�á�
     * ʾ�� 2:
     * ����: nums = [2,3,0,1,4]
     * ���: 2
     * ��ʾ:
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     */
    public int jump(int[] nums) {
        int[] fn = new int[nums.length];
        fn[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (fn[j] == 0) {
                    fn[j] = fn[i] + 1;
                } else {
                    if (fn[j] > fn[i] + 1) {
                        fn[j] = fn[i] + 1;
                    }
                }
            }
        }
        return fn[nums.length - 1];
    }
}
