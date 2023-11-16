package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/8 10:35
 * @Description:
 */
public class Day15 {
    public static void main(String[] args) {
        Day15 day = new Day15();
        //String[] direct = {"leet", "code"};
        List<String> direct = new ArrayList<>();
        direct.add("leet");
        direct.add("code");
        System.out.println(day.wordBreak("leetcode",direct));

    }

    /**
     * һ��������ĸ?A-Z ����Ϣͨ������ӳ������� ���� ��
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * Ҫ ���� �ѱ������Ϣ���������ֱ����������ӳ��ķ���������ӳ�����ĸ�������ж��ַ����������磬"11106" ����ӳ��Ϊ��
     * "AAJF" ������Ϣ����Ϊ (1 1 10 6)
     * "KJF" ������Ϣ����Ϊ (11 10 6)
     * ע�⣬��Ϣ���ܷ���Ϊ? (1 11 06) ����Ϊ "06" ����ӳ��Ϊ "F" ���������� "6" �� "06" ��ӳ���в����ȼۡ�
     * ����һ��ֻ�����ֵ� �ǿ� �ַ��� s ������㲢���� ���� ������ ���� ��
     * ��Ŀ���ݱ�֤�𰸿϶���һ�� 32 λ ��������
     * ʾ�� 1��
     * <p>
     * ���룺s = "12"
     * �����2
     * ���ͣ������Խ���Ϊ "AB"��1 2������ "L"��12����
     * ʾ�� 2��
     * <p>
     * ���룺s = "226"
     * �����3
     * ���ͣ������Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��
     * ʾ�� 3��
     * <p>
     * ���룺s = "0"
     * �����0
     * ���ͣ�û���ַ�ӳ�䵽�� 0 ��ͷ�����֡�
     * ���� 0 ����Чӳ���� 'J' -> "10" �� 'T'-> "20" ��
     * ����û���ַ������û����Ч�ķ����Դ˽��н��룬��Ϊ�������ֶ���Ҫӳ�䡣
     * ��ʾ��
     * 1 <= s.length <= 100
     * s ֻ�������֣����ҿ��ܰ���ǰ���㡣
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] fn = new int[s.length()];
        fn[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                if (i > 1) {
                    fn[i] = fn[i - 2];
                } else {
                    fn[i] = 1;
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    fn[i] = fn[i - 1];
                } else {
                    int num = Integer.valueOf(s.substring(i - 1, i + 1));
                    if (num <= 26) {
                        if (i > 1) {
                            fn[i] = fn[i - 1] + fn[i - 2];
                        } else {
                            fn[i] = fn[i - 1] + 1;
                        }
                    } else {
                        fn[i] = fn[i - 1];
                    }
                }
            }


        }
        return fn[fn.length - 1];
    }

    /**
     * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣�����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��
     * ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�
     * ʾ�� 1��
     * ����: s = "leetcode", wordDict = ["leet", "code"]
     * ���: true
     * ����: ���� true ��Ϊ "leetcode" ������ "leet" �� "code" ƴ�ӳɡ�
     * ʾ�� 2��
     * ����: s = "applepenapple", wordDict = ["apple", "pen"]
     * ���: true
     * ����: ���� true ��Ϊ "applepenapple" ������ "apple" "pen" "apple" ƴ�ӳɡ�
     * ?    ע�⣬������ظ�ʹ���ֵ��еĵ��ʡ�
     * ʾ�� 3��
     *
     * ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * ���: false
     * ?
     *
     * ��ʾ��
     *
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s �� wordDict[i] ����СдӢ����ĸ���
     * wordDict �е������ַ��� ������ͬ
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode.cn/problems/word-break
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0){
            return true;
        }
        boolean[] dp = new  boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(String word:wordDict){
                if(word.length()>i){
                    continue;
                }
                if(s.substring(i-word.length(),i ).equals(word)&&dp[i-word.length()]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
