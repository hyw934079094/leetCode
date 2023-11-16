package houyw.java.myself.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DELL
 * @Date: 2022/6/23 21:42
 * @Description:
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day = new Day2();
        boolean isomorphic = day.isSubsequence("aaaaaa", "abbbaaaa");
        System.out.println(isomorphic);
    }

    /**
     * ���������ַ���?s?��?t?���ж������Ƿ���ͬ���ġ�
     * ���?s?�е��ַ����԰�ĳ��ӳ���ϵ�滻�õ�?t?����ô�������ַ�����ͬ���ġ�
     * ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���
     * ͬʱ���ı��ַ���˳�򡣲�ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
     * ʾ�� 1:
     * ���룺s = "egg", t = "add"
     * �����true
     * ʾ�� 2��
     * ���룺s = "foo", t = "bar"
     * �����false
     * ʾ�� 3��
     * ���룺s = "paper", t = "title"
     * �����true
     */
    public boolean isIsomorphic(String s, String t) {
        int[] indexs = new int[256];
        int[] indext = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if (indexs[sc] == 0) {
                indexs[sc] = i + 1;
            } else {
                if (indexs[sc] != indext[st]) {
                    return false;
                }
            }
            if (indext[st] == 0) {
                indext[st] = i + 1;
            } else {
                if (indext[st] != indexs[sc]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
     * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ�����
     * �����磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
     * ���ף�
     * ����д�������� S������ S1, S2, ... , Sk ���� k >= 10�ڣ�
     * ����Ҫ���μ�������Ƿ�Ϊ T �������С�����������£���������ı���룿
     * ��л��
     * �ر��л @pbrother?��Ӵ����Ⲣ�Ҵ������в���������
     * ʾ�� 1��
     * ���룺s = "abc", t = "ahbgdc"
     * �����true
     * ʾ�� 2��
     * ���룺s = "axc", t = "ahbgdc"
     * �����false
     * ��ʾ��
     * 0 <= s.length <= 100
     * 0 <= t.length <= 10^4
     * �����ַ�����ֻ��Сд�ַ���ɡ�
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
