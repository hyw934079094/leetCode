package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/9 16:11
 * @Description:
 */
public class Day17 {
    /**
     * ���������ַ���?text1 ��?text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
     * һ���ַ�����?������?��ָ����һ���µ��ַ�����
     * ������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
     * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
     * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
     * ʾ�� 1��
     * ���룺text1 = "abcde", text2 = "ace"
     * �����3
     * ���ͣ�������������� "ace" �����ĳ���Ϊ 3 ��
     * ʾ�� 2��
     * ���룺text1 = "abc", text2 = "abc"
     * �����3
     * ���ͣ�������������� "abc" �����ĳ���Ϊ 3 ��
     * ʾ�� 3��
     * ���룺text1 = "abc", text2 = "def"
     * �����0
     * ���ͣ������ַ���û�й��������У����� 0 ��
     * ��ʾ��
     * 1 <= text1.length, text2.length <= 1000
     * text1 ��?text2 ����СдӢ���ַ���ɡ�
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //fn[i][j]����text1ǰi+1λ��text2ǰj+1λ��������Ӵ�����
        int[][] fn = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)) {
            fn[0][0] = 1;
        } else {
            fn[0][0] = 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                fn[i][0] = 1;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }
        for (int j = 1; j < text2.length(); j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                fn[0][j] = 1;
            } else {
                fn[0][j] = fn[0][j - 1];
            }
        }
        if (text1.charAt(0) == text2.charAt(0)) {
            fn[0][0] = 1;
        } else {
            fn[0][0] = 0;
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    fn[i][j] = fn[i - 1][j - 1] + 1;
                } else {
                    fn[i][j] = Math.max(fn[i - 1][j], fn[i][j - 1]);
                }
            }
        }
        return fn[text1.length() - 1][text2.length() - 1];
    }

    /**
     * ������������?word1?��?word2?������ʹ��?word1?��??word2?��ͬ�������С������
     * ÿ��?����ɾ������һ���ַ����е�һ���ַ���
     * ʾ�� 1��
     * ����: word1 = "sea", word2 = "eat"
     * ���: 2
     * ����: ��һ���� "sea" ��Ϊ "ea" ���ڶ����� "eat "��Ϊ "ea"
     * ʾ�� ?2:
     * ���룺word1 = "leetcode", word2 = "etco"
     * �����4
     * ��ʾ��
     * 1 <= word1.length, word2.length <= 500
     * word1?��?word2?ֻ����СдӢ����ĸ
     */
    public int minDistance(String word1, String word2) {
        //fn[i][j]��ʾword1ǰi+1λ���word2ǰj+1λ��Ҫ�ò���
        int[][] fn = new int[word1.length()][word2.length()];
        if (word1.charAt(0) == word2.charAt(0)) {
            fn[0][0] = 0;
        } else {
            fn[0][0] = 2;
        }
        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                fn[i][0] = i;
            } else {
                fn[i][0] = 1 + fn[i - 1][0];
            }
        }
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt(0) == word2.charAt(j)) {
                fn[0][j] = j;
            } else {
                fn[0][j] = 1 + fn[0][j - 1];
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    fn[i][j] = fn[i - 1][j - 1];
                } else {
                    fn[i][j] = Math.min(fn[i - 1][j], fn[i][j - 1]) + 1;
                }
            }
        }

        return fn[word1.length()-1][word2.length()-1];
    }
}
