package houyw.java.myself.face;

import java.util.Arrays;

/**
 * @Author: DELL
 * @Date: 2022/8/11 09:46
 * @Description:
 */
public class pindd {
    public static void main(String[] args) {
        pindd pdd = new pindd();
        System.out.println("abababab".replaceAll("ab", ""));
    }

    //ʵ��pow(x,y)
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (n >= 0) {
            double ret = 1;
            while (n-- > 0) {
                ret *= x;
            }
            return ret;
        } else {
            return Math.sqrt(n);
        }
    }

    /**
     * ����һ���������� nums �����������ҳ�����������ɵ����˻������������˻���
     * <p>
     * ?
     * <p>
     * ʾ�� 1��
     * <p>
     * ���룺nums = [1,2,3]
     * �����6
     * ʾ�� 2��
     * <p>
     * ���룺nums = [1,2,3,4]
     * �����24
     * ʾ�� 3��
     * <p>
     * ���룺nums = [-1,-2,-3]
     * �����-6
     * ?
     * <p>
     * ��ʾ��
     * <p>
     * 3 <= nums.length <=?104
     * -1000 <= nums[i] <= 1000
     */
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int len = nums.length;
        //�������������
        int max = Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
        return max;
    }

    /**
     * ����һ���ǿյ��ַ���?s?������Ƿ����ͨ��������һ���Ӵ��ظ���ι��ɡ�
     * <p>
     * ?
     * <p>
     * ʾ�� 1:
     * <p>
     * ����: s = "abab"
     * ���: true
     * ����: �����Ӵ� "ab" �ظ����ι��ɡ�
     * ʾ�� 2:
     * <p>
     * ����: s = "aba"
     * ���: false
     * ʾ�� 3:
     * <p>
     * ����: s = "abcabcabcabc"
     * ���: true
     * ����: �����Ӵ� "abc" �ظ��Ĵι��ɡ� (���Ӵ� "abcabc" �ظ����ι��ɡ�)
     * ?
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= s.length <= 104
     * s?��СдӢ����ĸ���
     * <p>
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() > 1) {
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (c != s.charAt(i)) {
                    continue;
                }
                if (i < s.length() && s.replace(s.substring(0, i), "").length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * �㽫�õ�һ���������� matchsticks ������ matchsticks[i] �ǵ� i?�������ĳ��ȡ�
     * ��Ҫ�� ���еĻ���?ƴ��һ�������Ρ�
     * �� �����۶� �κ�һ��������������԰���������һ�𣬶���ÿ���������� ʹ��һ�� ��
     * �������ʹ��������Σ��򷵻� true �����򷵻� false ��
     * ʾ��?1:
     * ����: matchsticks = [1,1,2,2,2]
     * ���: true
     * ����: ��ƴ��һ���߳�Ϊ2�������Σ�ÿ���������
     * ʾ��?2:
     * ����: matchsticks = [3,3,3,3,4]
     * ���: false
     * ����: ���������л��ƴ��һ�������Ρ�
     * ��ʾ:
     * 1 <= matchsticks.length <= 15
     * 1 <= matchsticks[i] <= 108
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int zhouchang = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            zhouchang += matchsticks[i];
        }
        if (zhouchang % 4 > 0) {
            return false;
        }
        int bian = zhouchang/4;

        return false;
    }

}
