package houyw.java.myself.leetcode.dtgh;

/**
 * @Author: DELL
 * @Date: 2022/8/24 11:26
 * @Description:
 */
public class Hard {
    public static void main(String[] args) {
        Hard hard = new Hard();
        String ss = "(()";
        int i1 = hard.longestValidParentheses(ss);
        System.out.println(i1);
    }

    /**
     * 32. ���Ч����
     * ����һ��ֻ���� '('?�� ')'?���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
     * ʾ�� 1��
     * ���룺s = "(()"
     * �����2
     * ���ͣ����Ч�����Ӵ��� "()"
     * ʾ�� 2��
     * ���룺s = ")()())"
     * �����4
     * ���ͣ����Ч�����Ӵ��� "()()"
     * ʾ�� 3��
     * ���룺s = ""
     * �����0
     * ?
     * ��ʾ��
     * 0 <= s.length <= 3 * 104
     * s[i] Ϊ '(' �� ')'
     */

    public int longestValidParentheses(String s) {
        int i = s.indexOf(')');
        char[] chars = s.toCharArray();
        while (i >= 0) {
            int index = i - 1;
            //��ǰ�������Ƿ���Ապ�
            boolean flag = false;
            //�Ѿ��պϵ�ֱ������
            while (index > 0 && chars[index] == '1') {
                index--;
            }
            //�ҵ��ɱպϵ������ź��滻��1
            if (index >= 0 && chars[index] == '(') {
                chars[index] = '1';
                chars[i] = '1';
                flag = true;
            }
            if (!flag) {
                //�޷��չص��������滻��0
                chars[i] = '0';
            }
            //�滻����׸��������±�
            i = String.valueOf(chars).indexOf(')');

        }
        int count = 0;
        int max = 0;
        //��������պ�����
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] =='1') {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }
}
