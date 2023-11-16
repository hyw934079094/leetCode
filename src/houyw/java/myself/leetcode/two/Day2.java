package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/7 16:20
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
       // System.out.println(day.multiply("123", "456"));
        //System.out.println(day.sum("123", "199"));

        String[] arr = {"flower","","flower","flower"};
        System.out.println(day.longestCommonPrefix(arr));
    }

    /**
     * �����������ַ�����ʽ��ʾ�ķǸ�����?num1?��?num2������?num1?��?num2?�ĳ˻���
     * ���ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
     * ע�⣺����ʹ���κ����õ� BigInteger ���ֱ�ӽ�����ת��Ϊ������
     * ʾ�� 1:
     * ����: num1 = "2", num2 = "3"
     * ���: "6"
     * ʾ��?2:
     * ����: num1 = "123", num2 = "456"
     * ���: "56088"
     * ��ʾ��
     * 1 <= num1.length, num2.length <= 200
     * num1?�� num2?ֻ����������ɡ�
     * num1?�� num2?���������κ�ǰ���㣬��������0����
     * 123
     * 123
     * 369
     * 246
     * 123
     * 15129
     */
    public String multiply(String num1, String num2) {
        String allSum = "";
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int jin = 0;
            String sum = "";
            int n1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = Integer.valueOf(String.valueOf(num2.charAt(j)));
                int num = n1 * n2 + jin;
                if (num >= 10) {
                    if (j == 0) {
                        sum = String.valueOf(num) + sum;
                    } else {
                        sum = String.valueOf(num % 10) + sum;
                    }

                    jin = num / 10;
                } else {
                    sum = String.valueOf(num) + sum;
                    jin = 0;
                }
            }
            for (int k = num1.length() - 1 - i; k > 0; k--) {
                sum = sum + "0";
            }
            allSum = sum(allSum, sum);
        }
        return allSum;
    }

    public String sum(String num1, String num2) {
        String sum = "";
        int jin = 0;
        while (num1.length() > num2.length()) {
            num2 = "0" + num2;
        }
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            int n2 = Integer.valueOf(String.valueOf(num2.charAt(i)));
            int num = n1 + n2 + jin;
            if (num >= 10) {
                if (i == 0) {
                    sum = String.valueOf(num) + sum;
                } else {
                    sum = String.valueOf(num - 10) + sum;
                }
                jin = num / 10;
            } else {
                sum = String.valueOf(num) + sum;
                jin = 0;
            }

        }
        return sum;
    }

    /**
     * ��дһ�������������ַ��������е������ǰ׺��
     * ��������ڹ���ǰ׺�����ؿ��ַ���?""��
     * ʾ�� 1��
     * ���룺strs = ["flower","flow","flight"]
     * �����"fl"
     * ʾ�� 2��
     * ���룺strs = ["dog","racecar","car"]
     * �����""
     * ���ͣ����벻���ڹ���ǰ׺��
     * ��ʾ��
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] ����СдӢ����ĸ���
     */
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].equals("")) {
            return str;
        }
        int i = 0;
        while (i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (String ss : strs) {
                if (ss.length() <= i) {
                    return str;
                }
                if (ss.charAt(i) != c) {
                    return str;
                }
            }
            str += c;
            i++;
        }
        return str;
    }
}
