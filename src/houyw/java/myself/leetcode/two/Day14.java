package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/19 09:53
 * @Description:
 */
public class Day14 {
    public static void main(String[] args) {
        Day14 day = new Day14();
        //System.out.println('b' - 'A');
        System.out.println(day.minWindow("a","b"));
    }

    /**
     * ����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ������ s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
     * ע�⣺
     * ���� t ���ظ��ַ�������Ѱ�ҵ����ַ����и��ַ��������벻���� t �и��ַ�������
     * ��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
     * ʾ�� 1��
     * ���룺s = "ADOBECODEBANC", t = "ABC"
     * �����"BANC"
     * ʾ�� 2��
     * ���룺s = "a", t = "a"
     * �����"a"
     * ʾ�� 3:
     * ����: s = "a", t = "aa"
     * ���: ""
     * ����: t �������ַ� 'a' ��Ӧ������ s ���Ӵ��У�
     * ���û�з������������ַ��������ؿ��ַ�����
     * ��ʾ��
     * 1 <= s.length, t.length <= 105
     * s �� t ��Ӣ����ĸ���
     * ���ף��������һ���� o(n) ʱ���ڽ����������㷨��
     */

    public String minWindow(String s, String t) {
        int[] tmp = new int[52];
        int[] window = new int[52];
        int size = 0;
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            int index = tc - 'A';
            if (index >= 32) {
                index = index - 6;
            }
            if (tmp[index] == 0) {
                size++;
            }
            tmp[index]++;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        String str = "";
        while (right < s.length()) {
            char sc = s.charAt(right);
            int idx = sc - 'A';
            if (idx >= 32) {
                idx = idx - 6;
            }
            window[idx]++;
            if (window[idx] == tmp[idx]) {
                sum++;
            }
            while (sum == size) {
                char c = s.charAt(left);
                if(str.equals("")){
                   str = s.substring(left, right + 1);
                }else if (s.substring(left, right + 1).length() < str.length()) {
                    str = s.substring(left, right + 1);
                }
                int idx1 = c - 'A';
                if (idx1 >= 32) {
                    idx1 = idx1 - 6;
                }
                window[idx1]--;
                if (window[idx1] < tmp[idx1]) {
                    sum--;
                }
                left++;
            }
            right++;

        }
        return str;
    }


    /**
     * ����һ������Ϊ n ����������?nums?�� һ��Ŀ��ֵ?target��
     * ����� nums ��ѡ������������ʹ���ǵĺ���?target?��ӽ���
     * �������������ĺ͡�
     * �ٶ�ÿ������ֻ����ǡ��һ���⡣
     * ʾ�� 1��
     * ���룺nums = [-1,2,1,-4], target = 1
     * �����2
     * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
     * ʾ�� 2��
     * ���룺nums = [0,0,0], target = 1
     * �����0
     * ��ʾ��
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     */
    public int threeSumClosest(int[] nums, int target) {

        return 0;
    }
}
