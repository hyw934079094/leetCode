package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/7/28 20:37
 * @Description:
 */
public class Day18 {
    public static void main(String[] args) {
        Day18 day = new Day18();
        String s1 = "aaa";
        String s2 = "bbb";

        // int i = day.minDistance(s1, s2);
        int i1 = day.integerBreak(20);
        System.out.println(i1);
    }

    /**
     * ������������?word1 ��?word2�� �뷵�ؽ�?word1?ת����?word2 ��ʹ�õ����ٲ����� ?��
     * ����Զ�һ�����ʽ����������ֲ�����
     * ����һ���ַ�
     * ɾ��һ���ַ�
     * �滻һ���ַ�
     * ʾ��?1��
     * ���룺word1 = "horse", word2 = "ros"
     * �����3
     * ���ͣ�
     * horse -> rorse (�� 'h' �滻Ϊ 'r')
     * rorse -> rose (ɾ�� 'r')
     * rose -> ros (ɾ�� 'e')
     * ʾ��?2��
     * ���룺word1 = "intention", word2 = "execution"
     * �����5
     * ���ͣ�
     * intention -> inention (ɾ�� 't')
     * inention -> enention (�� 'i' �滻Ϊ 'e')
     * enention -> exention (�� 'n' �滻Ϊ 'x')
     * exention -> exection (�� 'n' �滻Ϊ 'c')
     * exection -> execution (���� 'u')
     * ��ʾ��
     * 0 <= word1.length, word2.length <= 500
     * word1 �� word2 ��СдӢ����ĸ���
     */

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] fn = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                //ֻ��Ҫɾ��i���ַ�
                fn[i][0] = i;
            } else {
                if (i == 0) {
                    //�滻һ���ַ�
                    fn[i][0] = 1;
                } else {
                    fn[i][0] = fn[i - 1][0] + 1;
                }
            }
        }
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt((0)) == word2.charAt(j)) {
                //ֻ��Ҫ���j���ַ�
                fn[0][j] = j;
            } else {
                fn[0][j] = fn[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    //�����ǰ�ַ����
                    fn[i][j] = fn[i - 1][j - 1];
                } else {
                    //����ȣ�����ͨ��fn[i-1][j]�任������Ҳ���Ը���fn[i][j-1]�任����
                    int num = fn[i][j - 1];
                    if (fn[i - 1][j] < fn[i][j - 1]) {
                        num = fn[i - 1][j];
                    }
                    if (fn[i - 1][j - 1] < num) {
                        num = fn[i - 1][j - 1];
                    }
                    fn[i][j] = Math.min(num, Math.max(i, j)) + 1;
                }
            }
        }
        return fn[word1.length() - 1][word2.length() - 1];
    }

    /**
     * ����һ��������?n?��������Ϊ k �� ������ �ĺͣ�?k >= 2?������ʹ��Щ�����ĳ˻���󻯡�
     * ���� ����Ի�õ����˻�?��
     * ʾ�� 1:
     * ����: n = 2
     * ���: 1
     * ����: 2 = 1 + 1, 1 �� 1 = 1��
     * ʾ��?2:
     * ����: n = 10
     * ���: 36
     * ����: 10 = 3 + 3 + 4, 3 ��?3 ��?4 = 36��
     * ��ʾ:
     * 2 <= n <= 58
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] fn = new int[n+1];
        //��2��ʼ
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 2;
        fn[3] = 3;
        for (int i = 4; i < fn.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (fn[i - j] * fn[j] > fn[i]) {
                    fn[i] = fn[i - j] * fn[j];
                }
            }
        }
        return fn[fn.length-1];
    }
}
