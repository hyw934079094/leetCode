package houyw.java.myself.leetcode.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DELL
 * @Date: 2022/7/9 10:37
 * @Description:
 */
public class Day5 {

    public static void main(String[] args) {
        Day5 day = new Day5();
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[] tasks1 = {'A','A','A','B','B','B','C','C','C','D','D','E'};
        System.out.println(day.leastInterval(tasks1,2));
    }

    /**
     * ����һ���ַ�������?words?��words?��ÿ��Ԫ�ض���һ������ ����?СдӢ����ĸ�ĵ��ʡ�
     * ����� words?��ѡ��һЩԪ�ز��� ����˳��?�������ǣ����õ�һ�� �����ܳ��Ļ��Ĵ�?��ÿ��Ԫ�� ����?ֻ��ʹ��һ�Ρ�
     * ���㷵�����ܵõ�������Ĵ��� ����?�����û�취�õ��κ�һ�����Ĵ������㷵�� 0?��
     * ���Ĵ�?ָ���Ǵ�ǰ����ʹӺ���ǰ��һ�����ַ�����
     * ʾ�� 1��
     * ���룺words = ["lc","cl","gg"]
     * �����6
     * ���ͣ�һ����Ļ��Ĵ�Ϊ "lc" + "gg" + "cl" = "lcggcl" ������Ϊ 6 ��
     * "clgglc" ����һ�����Եõ�������Ĵ���
     * ʾ�� 2��
     * ���룺words = ["ab","ty","yt","lc","cl","ab"]
     * �����8
     * ���ͣ�����Ĵ��� "ty" + "lc" + "cl" + "yt" = "tylcclyt" ������Ϊ 8 ��
     * "lcyttycl" ����һ�����Եõ�������Ĵ���
     * ʾ�� 3��
     * ���룺words = ["cc","ll","xx"]
     * �����2
     * ���ͣ�����Ĵ��� "cc" ������Ϊ 2 ��
     * "ll" ����һ�����Եõ�������Ĵ���"xx" Ҳ�ǡ�
     * ��ʾ��
     * 1 <= words.length <= 105
     * words[i].length == 2
     * words[i]?������СдӢ����ĸ��
     */
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        int[] nums = new int[26];
        int count = 0;
        for (String str : words) {
            String s1 = str.substring(1, 2);
            String s2 = str.substring(0, 1);
            String st = s1 + s2;
            if (s1.equals(s2)) {
                nums[str.charAt(0) - 'a']++;
            }
            int num = mp.getOrDefault(st, 0);
            if (num > 0) {
                count += 4;
                mp.put(st, num - 1);
            } else {
                mp.put(str, mp.getOrDefault(str, 0) + 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count += 2;
                break;
            }
        }
        return count;
    }

    /**
     * ����һ�����ַ�����?tasks ��ʾ�� CPU ��Ҫִ�е������б�����ÿ����ĸ��ʾһ�ֲ�ͬ���������
     * �������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣ
     * ���κ�һ����λʱ�䣬CPU �������һ�����񣬻��ߴ��ڴ���״̬��
     * Ȼ�������� ��ͬ���� ������֮������г���Ϊ���� n ����ȴʱ�䣬
     * ������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��
     * ����Ҫ�������������������Ҫ�� ���ʱ�� ��
     * ʾ�� 1��
     * ���룺tasks = ["A","A","A","B","B","B"], n = 2
     * �����8
     * ���ͣ�A -> B -> (����) -> A -> B -> (����) -> A -> B
     * �ڱ�ʾ���У�������ͬ��������֮�����������Ϊ n = 2 ����ȴʱ�䣬
     * ��ִ��һ������ֻ��Ҫһ����λʱ�䣬�����м�����ˣ�������״̬��
     * ʾ�� 2��
     * ���룺tasks = ["A","A","A","B","B","B"], n = 0
     * �����6
     * ���ͣ�����������£��κδ�СΪ 6 �����ж���������Ҫ����Ϊ n = 0
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * �������
     * ʾ�� 3��
     * ���룺tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * �����16
     * ���ͣ�һ�ֿ��ܵĽ�������ǣ�
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (����) -> (����) -> A -> (����) -> (����) -> A
     * ��ʾ��
     * 1 <= task.length <= 104
     * tasks[i] �Ǵ�дӢ����ĸ
     * n ��ȡֵ��ΧΪ [0, 100]
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int max = 0;
        int all = tasks.length;
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
            if (arr[c - 'A'] > max) {
                max = arr[c - 'A'];
            }
        }
        int ret = 0;
        while (all > 0) {
            Arrays.sort(arr);
            int t = n+1;
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    arr[i]--;
                    t--;
                    ret++;
                    all--;
                }
                if (t == 0) {
                    break;
                }
                if (arr[i] == 0) {
                    continue;
                }
            }
            if(all == 0){
                break;
            }
            while(t>0){
                ret++;
                t--;
            }

        }
        return ret;
    }
}
