package houyw.java.myself.leetcode.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/4 11:04
 * @Description:
 */
public class Day12 {

    public static void main(String[] args) {
        Day12 day = new Day12();
        System.out.println(day.characterReplacement("ABBBB", 1));
    }

    /**
     * ���������ַ���?s?�� p���ҵ�?s?������?p?��?��λ��?���Ӵ���������Щ�Ӵ�����ʼ�����������Ǵ������˳��
     * ��λ�� ָ����ͬ��ĸ�������γɵ��ַ�����������ͬ���ַ�������
     * ʾ��?1:
     * ����: s = "cbaebabacd", p = "abc"
     * ���: [0,6]
     * ����:
     * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����λ�ʡ�
     * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����λ�ʡ�
     * ?ʾ�� 2:
     * <p>
     * ����: s = "abab", p = "ab"
     * ���: [0,1,2]
     * ����:
     * ��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
     * ��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����λ�ʡ�
     * ��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
     * ��ʾ:
     * 1 <= s.length, p.length <= 3 * 104
     * s?��?p?������Сд��ĸ
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] temp = new int[26];
        int[] window = new int[26];
        int size = 0;
        for (int i = 0; i < p.length(); i++) {
            if (temp[p.charAt(i) - 'a'] == 0) {
                size++;
            }
            temp[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c - 'a']++;
            if (temp[c - 'a'] == window[c - 'a']) {
                count++;
            }
            while (count == size) {
                if (right - left == p.length() - 1) {
                    list.add(left);
                }
                char cl = s.charAt(left);
                window[cl - 'a']--;
                if (temp[cl - 'a'] > 0 && temp[cl - 'a'] > window[cl - 'a']) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return list;
    }


    /**
     * ABBACDBBAEFAGHAIJAKLAMNAOPAQRA   3
     * ����һ���ַ��� s ��һ������ k �������ѡ���ַ����е���һ�ַ���
     * ���������Ϊ�κ�������дӢ���ַ����ò�������ִ�� k �Ρ�
     * ��ִ�����������󣬷��ذ�����ͬ��ĸ������ַ����ĳ��ȡ�
     * ʾ�� 1��
     * ���룺s = "ABAB", k = 2
     * �����4
     * ���ͣ�������'A'�滻Ϊ����'B',��֮��Ȼ��
     * ʾ�� 2��
     * ���룺s = "AABABBA", k = 1
     * �����4
     * ���ͣ�
     * ���м��һ��'A'�滻Ϊ'B',�ַ�����Ϊ "AABBBBA"��
     * �Ӵ� "BBBB" ����ظ���ĸ, ��Ϊ 4��
     * ��ʾ��
     * 1 <= s.length <= 105
     * s ���ɴ�дӢ����ĸ���
     * 0 <= k <= s.length
     */
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int m = k;
        int count = 0;
        while (start < s.length()) {
            int end = start;
            char cs = s.charAt(start);
            while (end < s.length()) {
                char ce = s.charAt(end);
                if (ce != cs) {
                    m--;
                }
                if (m < 0) {
                    break;
                }
                count++;
                end++;
            }
            if(m>0){
                count+=m;
                if(count>s.length()){
                    count = s.length();
                }
            }
            if (count > max) {
                max = count;
            }
            m = k;
            count = 0;
            start++;
        }
        return max;
    }
}
