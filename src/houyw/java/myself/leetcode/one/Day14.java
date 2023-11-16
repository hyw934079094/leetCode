package houyw.java.myself.leetcode.one;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: DELL
 * @Date: 2022/7/1 10:56
 * @Description:
 */
public class Day14 {


    public static void main(String[] args) {
        Day14 day = new Day14();
        System.out.println(day.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

    }

    /**
     * ���� s �� t �����ַ����������Ƿֱ����뵽�հ׵��ı��༭����
     * ���������ȣ����� true ��# �����˸��ַ���
     * ע�⣺����Կ��ı������˸��ַ����ı�����Ϊ�ա�
     * ʾ�� 1��
     * ���룺s = "ab#c", t = "ad#c"
     * �����true
     * ���ͣ�s �� t ������ "ac"��
     * ʾ�� 2��
     * ���룺s = "ab##", t = "c#d#"
     * �����true
     * ���ͣ�s �� t ������ ""��
     * ʾ�� 3��
     * ���룺s = "a#c", t = "b"
     * �����false
     * ���ͣ�s ���� "c"���� t ��Ȼ�� "b"��
     * ��ʾ��
     * <p>
     * 1 <= s.length, t.length <= 200
     * s �� t ֻ����Сд��ĸ�Լ��ַ� '#'
     */
    public boolean backspaceCompare(String s, String t) {
        while (s.indexOf("#") >= 0) {
            if (s.indexOf("#") > 0) {
                String str = s.charAt(s.indexOf("#") - 1) + "#";
                s = s.replace(str, "");
            } else {
                s = s.replaceFirst("#", "");
            }
        }

        while (t.indexOf("#") >= 0) {
            if (t.indexOf("#") > 0) {
                String str = t.charAt(t.indexOf("#") - 1) + "#";
                t = t.replace(str, "");
            } else {
                t = t.replaceFirst("#", "");
            }
        }
        return s.equals(t);
    }

    /**
     * ����һ������������ַ������������������ַ�����
     * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
     * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
     * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������?3a?��?2[4]?�����롣
     * ʾ�� 1��
     * ���룺s = "3[a]2[bc]"
     * �����"aaabcbc"
     * ʾ�� 2��
     * ���룺s = "3[a2[c]]"
     * �����"accaccacc"
     * ʾ�� 3��
     * ���룺s = "2[abc]3[cd]ef"
     * �����"abcabccdcdcdef"
     * ʾ�� 4��
     * ���룺s = "abc3[cd]xyz"
     * �����"abccdcdcdxyz"
     * ��ʾ��
     * 1 <= s.length <= 30
     * s?��СдӢ����ĸ�����ֺͷ�����?'[]' ���
     * s?��֤��һ��?��Ч?�����롣
     * s?������������ȡֵ��ΧΪ?[1, 300]?
     */

    public String decodeString(String s) {
        while (s.indexOf(']') > 0) {
            int end = s.indexOf(']');
            int start = s.substring(0, end).lastIndexOf('[');
            String counts = "";
            int countStart = 0;
            String str = s.substring(start + 1, end);
            for (int i = start - 1; i >= 0; i--) {
                if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                    counts = s.charAt(i) + counts;
                } else {
                    countStart = i + 1;
                    break;
                }
            }
            String s1 = str;
            for (int j = 1; j < Integer.valueOf(counts); j++) {
                str += s1;
            }
            s = s.replace(s.substring(countStart, end + 1), str);
        }
        return s;
    }

    public String decodeString1(String s) {
        int end = s.indexOf(']');
        int start = s.substring(0, end).lastIndexOf('[');
        String counts = "";
        int countStart = 0;
        for (int i = start - 1; i >= 0; i--) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                counts = s.charAt(i) + counts;
            } else {
                countStart = i + 1;
                break;
            }
        }
        StringBuilder str = new StringBuilder(s.substring(start + 1, end));
        String s1 = str.toString();
        for (int j = 1; j < Integer.valueOf(counts); j++) {
            str.append(s1);
        }
        s = s.replace(s.substring(countStart, end + 1), str);
        return decodeString1(s);
    }

}
