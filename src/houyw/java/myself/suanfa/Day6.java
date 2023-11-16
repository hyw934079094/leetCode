package houyw.java.myself.suanfa;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/15 17:40
 * @Description:
 */
public class Day6 {
    public static void main(String[] args) {
        Day6 day = new Day6();
        String s = "bbbab";
        //System.out.println(day.lengthOfLongestSubstring(s));

        //day.checkInclusion("bd","acbdacbdacbac" );
        boolean b = day.betterSolution("bad", "acbdcacbdacbac");
        System.out.println(b);
    }

    /**
     * ����һ���ַ��� s �������ҳ����в������ظ��ַ���?��Ӵ�?�ĳ��ȡ�
     * ʾ��?1:
     * ����: s = "abcabcbb"
     * ���: 3
     * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
     * ʾ�� 2:
     * ����: s = "bbbbb"
     * ���: 1
     * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
     * ʾ�� 3:
     * ����: s = "pwwkew"
     * ���: 3
     * ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
     * ?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
     * ��ʾ��
     * 0 <= s.length <= 5 * 104
     * s?��Ӣ����ĸ�����֡����źͿո����
     */

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }


    /**
     * ���������ַ���?s1?��?s2 ��дһ���������ж� s2 �Ƿ���� s1?�����С�
     * ����ǣ����� true �����򣬷��� false ��
     * ���仰˵��s1 ������֮һ�� s2 �� �Ӵ� ��
     * ʾ�� 1��
     * ���룺s1 = "ab" s2 = "eidbaooo"
     * �����true
     * ���ͣ�s2 ���� s1 ������֮һ ("ba").
     * ʾ�� 2��
     * ���룺s1= "ab" s2 = "eidboaoo"
     * �����false
     * ��ʾ��
     * 1 <= s1.length, s2.length <= 104
     * s1 �� s2 ������Сд��ĸ
     */
    public boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> m1 = new HashMap();
        for (int i = 0; i < s1.length(); i++) {
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int j = 0; j < s2.length(); j++) {
            int count = 0;
            for (int k = j; k < s2.length(); k++) {
                if (s1.contains(String.valueOf(s2.charAt(k)))) {
                    count++;
                } else {
                    j = k + 1;
                    count = 0;
                }
                if (count == s1.length()) {
                    list.add(s2.substring(j, j + count));
                }
                if (count > s1.length()) {
                    count--;
                    j++;
                    list.add(s2.substring(j, j + count));
                }
                if (k == s2.length() - 1) {
                    j = k;
                }
            }
        }
        if (list.size() > 0) {
            char[] chars = s1.toCharArray();
            Arrays.sort(chars);
            for (String ss : list) {
                char[] chars1 = ss.toCharArray();
                Arrays.sort(chars1);
                if (String.valueOf(chars).equals(String.valueOf(chars1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean betterSolution(String s1, String s2) {
        //�±��λ�ô�����ĸ����Ӧ�����ִ������ĸ�ĸ���
        int[] temp = new int[26];
        //s1����ĸ�ĸ���
        int num = 0;
        for (char c : s1.toCharArray()) {
            if(temp[c - 'a'] ==0){
                num++;
            }
            temp[c - 'a']++;
        }
        //ɸѡ����
        int[] window = new int[26];
        //�����������Եȵ���ĸ��
        int count = 0;
        //��ʼ�±�
        int start = 0;
        //�����±�
        int end = 0;
        while(end<s2.length()){
            char c = s2.charAt(end);
            window[c-'a']++;
            //ÿһ����ĸ������Ӧ�ϣ�������1
            if(temp[c-'a']== window[c-'a']){
                count++;
            }
            //����Ѿ���ȫ��Ӧ���ˣ���ʼ��鴰��
            while(count == num){
                //������ڿ��������s1������ȣ��򷵻�true
                if(end-start+1 ==s1.length()){
                    return true;
                }
                //���ڿ�ȿ϶��Ǵ��ڵ���s1�ĳ��ȵ�,���������С����
                //�Ƴ���ʼ�±���ַ�
                char c1 = s2.charAt(start);
                window[c1-'a']--;
                //����Ƴ�����ַ�������Ӧ�����ˣ���Ҫ�ı��Ӧ�ļ���ֵ
                if(window[c1-'a']<temp[c1-'a']){
                    count--;
                }
                start++;
            }
            end ++;
        }

        return false;
    }
}
