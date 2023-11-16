package houyw.java.single.guilv;

/**
 * @Author: houyw
 * @Date: 2022/4/2 16:52
 * @Description:
 */
public class Solution {
    /**
     * �������EXCEL���Ӧ�ַ�
     * complete
     */
    public static String convertToTitle(int columnNumber) {
        int x = columnNumber / 26;
        int y = columnNumber % 26;
        if (y == 0) {
            x--;
            y = 26;
        }
        String r = "";
        String s = String.valueOf((char) ('Z' - (26 - y)));
        if (x > 26) {
            r = convertToTitle(x);
        } else if (x > 0) {
            r = String.valueOf((char) ('Z' - (26 - x)));
            if (x == 0) {
                r = "";
            }
        }
        return r + s;
    }

    /**
     * ����һ�������� n ���ҳ��������������� �������� x ��
     * 1 �� x ֮�������Ԫ��֮�͵��� x �� n ֮������Ԫ��֮�͡�
     * ������������ x ����������������������򷵻� -1 ����Ŀ��֤���ڸ��������룬�������һ������������
     * ʾ�� 1��
     * ���룺n = 8
     * �����6
     * ���ͣ�6 ��������������Ϊ 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 ��
     * ʾ�� 2��
     * ���룺n = 1
     * �����1
     * ���ͣ�1 ��������������Ϊ 1 = 1 ��
     * ʾ�� 3��
     * ���룺n = 4
     * �����-1
     * ���ͣ�����֤��������������ĿҪ���������
     * ��ʾ��
     * 1 <= n <= 1000
     */
    public int pivotInteger(int n) {
        int x = (1 + n) / 2;
        int sum = (1 + n) * n / 2;
        int left = (1 + x) * x / 2;
        int right = sum - left + x;
        while (left < right) {
            right -= x;
            x++;
            left += x;

        }
        if (left == right) {
            return x;
        }
        return -1;
    }

    /**
     * ���� ����ֻ����������?2��3 �� 5?����������
     * ����һ������ n �������ж� n �Ƿ�Ϊ ���� ������ǣ����� true �����򣬷��� false ��
     * ʾ�� 1��
     * ���룺n = 6
     * �����true
     * ���ͣ�6 = 2 �� 3
     * ʾ�� 2��
     * ���룺n = 1
     * �����true
     * ���ͣ�1 û�����������������ȫ���������� {2, 3, 5} �Ŀռ���ϰ���Ͻ���������һ��������
     * ʾ�� 3��
     * ���룺n = 14
     * �����false
     * ���ͣ�14 ���ǳ�������Ϊ������������һ��������?7 ��
     */
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    /**
     * ����һ�ֹ��� pattern?��һ���ַ���?s?���ж� s?�Ƿ���ѭ��ͬ�Ĺ��ɡ�
     * �����?��ѭ?ָ��ȫƥ�䣬���磬?pattern?���ÿ����ĸ���ַ���?s?�е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�
     * ʾ��1:
     * ����: pattern = "abba", s = "dog cat cat dog"
     * ���: true
     * ʾ�� 2:
     * ����:pattern = "abba", s = "dog cat cat fish"
     * ���: false
     * ʾ�� 3:
     * ����: pattern = "aaaa", s = "dog cat cat dog"
     * ���: false
     * ��ʾ:
     * 1 <= pattern.length <= 300
     * pattern?ֻ����СдӢ����ĸ
     * 1 <= s.length <= 3000
     * s?ֻ����СдӢ����ĸ��?' '
     * s?������ �κ�ǰ����β��Կո�
     * s?��ÿ�����ʶ��� �����ո� �ָ�
     */

    public boolean wordPattern(String pattern, String s) {
        String[] arr = new String[26];
        String[] s1 = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            if (arr[pattern.charAt(i) - 'a'] != null) {

            }
            arr[pattern.charAt(i) - 'a'] = s1[i];
        }
        return false;
    }

    /**
     * ������ˮ̯�ϣ�ÿһ������ˮ���ۼ�Ϊ 5 ��Ԫ��
     * �˿��Ŷӹ�����Ĳ�Ʒ�������˵� bills ֧����˳��һ�ι���һ����
     * ÿλ�˿�ֻ��һ������ˮ��Ȼ�����㸶 5 ��Ԫ��10 ��Ԫ�� 20 ��Ԫ��
     * ������ÿ���˿���ȷ���㣬Ҳ����˵��������ÿλ�˿�����֧�� 5 ��Ԫ��
     * ע�⣬һ��ʼ����ͷû���κ���Ǯ��
     * ����һ���������� bills ������ bills[i] �ǵ� i λ�˿͸����ˡ�
     * ������ܸ�ÿλ�˿���ȷ���㣬���� true �����򷵻� false ��
     */
    public boolean lemonadeChange(int[] bills) {
        int[] con = new int[2];
        for (int i = 0; i < bills.length; i++) {
            //�������Ҫ����
            if(bills[i] == 5){
                con[0]++;
            }
            if(bills[i] == 10){
                con[0]--;
                con[1]++;
                if(con[0]<0){
                    return false;
                }
            }
            if (bills[i] == 20) {
                if(con[1]>0){
                    con[1]--;
                    con[0]--;
                }else{
                    con[0]-=3;
                }
                if(con[0]<0){
                    return false;
                }
            }
        }
        return true;
    }

}
