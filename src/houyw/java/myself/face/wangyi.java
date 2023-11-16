package houyw.java.myself.face;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: DELL
 * @Date: 2022/8/7 21:31
 * @Description:
 */
public class wangyi {
    public static void main(String[] args) {
        wangyi wy = new wangyi();
        int[] prices = {1, 2, 3, 1, 0};
        int i = wy.candy(prices);
        System.out.println(i);
    }

    /**
     * ����һ������ prices �����ĵ�?i ��Ԫ��?prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
     * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ��
     * ���һ���㷨�����������ܻ�ȡ���������
     * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
     * ʾ�� 1��
     * ���룺[7,1,5,3,6,4]
     * �����5
     * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     * ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
     * ʾ�� 2��
     * ���룺prices = [7,6,4,3,1]
     * �����0
     * ���ͣ������������, û�н������, �����������Ϊ 0��
     * ?
     * ��ʾ��
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */

    public int maxProfit(int[] prices) {
        int[][] fn = new int[prices.length][2];
        fn[0][0] = prices[0];
        fn[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            fn[i][1] = fn[i - 1][1];
            if (prices[i] > fn[i - 1][0]) {
                fn[i][0] = fn[i - 1][0];
                if (prices[i] - fn[i - 1][0] > fn[i - 1][1]) {
                    fn[i][1] = prices[i] - fn[i - 1][0];
                }
            } else {
                fn[i][0] = prices[i];
            }
        }
        return fn[fn.length - 1][1];
    }

    class Solution {
        List<ListNode> list;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
        }

        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i).val;
        }
    }

    /**
     * �������������� n �� k���������ַ���  Sn ���γɹ������£�
     * S1 = "0"
     * �� i > 1 ʱ��Si = Si-1 + "1" + reverse(invert(Si-1))
     * ���� + ��ʾ����������reverse(x) ���ط�ת x ��õ����ַ������� invert(x) ��ᷭת x �е�ÿһλ��0 ��Ϊ 1���� 1 ��Ϊ 0����
     * ���磬�����������������е�ǰ 4 ���ַ��������ǣ�
     * S1 = "0"
     * S2 = "011"
     * S3 = "0111001"
     * S4 = "011100110110001"
     * ���㷵��  Sn �� �� k λ�ַ� ����Ŀ���ݱ�֤ k һ���� Sn ���ȷ�Χ���ڡ�
     * ʾ�� 1��
     * ���룺n = 3, k = 1
     * �����"0"
     * ���ͣ�S3 Ϊ "0111001"����� 1 λΪ "0" ��
     * ʾ�� 2��
     * ���룺n = 4, k = 11
     * �����"1"
     * ���ͣ�S4 Ϊ "011100110110001"����� 11 λΪ "1" ��
     * ʾ�� 3��
     * <p>
     * ���룺n = 1, k = 1
     * �����"0"
     * ʾ�� 4��
     * <p>
     * ���룺n = 2, k = 3
     * �����"1"
     * ��ʾ��
     * 1 <= n <= 20
     * 1 <= k <= 2n - 1
     */
    public char findKthBit(int n, int k) {
        return getStr(n).charAt(k - 1);
    }

    public String getStr(int n) {
        if (n == 1) {
            return "0";
        }
        String s = getStr(n - 1);
        StringBuilder ss = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ss.append('0');
            } else {
                ss.append('1');
            }
        }
        return s + "1" + ss.toString();
    }

    /**
     * n ������վ��һ�š�����һ���������� ratings ��ʾÿ�����ӵ����֡�
     * ����Ҫ��������Ҫ�󣬸���Щ���ӷַ��ǹ���
     * ÿ���������ٷ��䵽 1 ���ǹ���
     * ���������������ָ��ߵĺ��ӻ��ø�����ǹ���
     * �����ÿ�����ӷַ��ǹ������㲢������Ҫ׼���� �����ǹ���Ŀ ��
     * ʾ��?1��
     * ���룺ratings = [1,0,2]
     * �����5
     * ���ͣ�����Էֱ����һ�����ڶ��������������ӷַ� 2��1��2 ���ǹ���
     * ʾ��?2��
     * ���룺ratings = [1,2,2]
     * �����4
     * ���ͣ�����Էֱ����һ�����ڶ��������������ӷַ� 1��2��1 ���ǹ���
     * ����������ֻ�õ� 1 ���ǹ��������������е�����������
     * ��ʾ��
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     * ͨ������162,751�ύ����329,380
     */
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        int res = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                //���ָߣ���ǰһ��Ҫ��һ��ƻ��
                nums[i] = nums[i - 1] + 1;
                res += nums[i];
            } else {
                nums[i] = 1;
                res += 1;
                //��ǰ�ĺ������ֱ�ǰһ������С
                //���ƻ������һ������ǰһ������Ҫ���һ�������ҵ��ø���ǰ�ĺ�����������
                if (nums[i] == nums[i - 1] && ratings[i] < ratings[i - 1]) {
                    for (int j = i - 1; j >= 0; j--) {
                        nums[j]++;
                        res++;
                        if (j > 0) {
                            //�������֮��ǰ��Ľṹ�����ƻ�������ѭ������
                            if (ratings[j - 1] <= ratings[j]) {
                                break;
                            } else {
                                if (nums[j - 1] > nums[j]) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
