package houyw.java.myself.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/20 17:11
 * @Description:
 */
public class Day11 {
    public static void main(String[] args) {
        Day11 day = new Day11();
        List<List<Integer>> combine = day.combine(6, 3);
        System.out.println(combine);
    }

    /**
     * ������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�
     * ����԰� �κ�˳�� ���ش𰸡�
     * ʾ�� 1��
     * ���룺n = 4, k = 2
     * �����
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * ʾ�� 2��
     * ���룺n = 1, k = 1
     * �����[[1]]
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    public List<List<Integer>> combine(int n, int k) {
        return dfs(1,n,k);
    }

    public List<List<Integer>> dfs(int start, int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(n-start+1<k){
            return list;
        }

        if (k == 1) {
            for (int i = start; i <= n; i++) {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                list.add(lst);
            }
            return list;
        }
        for(int i = start;i<=n;i++){
            List<List<Integer>> lst = dfs(i + 1, n, k - 1 );
            if(lst !=null){
                for (List<Integer> l : lst) {
                    l.add(i);
                }
            }
            list.addAll(lst);
        }

        return list;
    }


    /**
     * ����һ���ַ���?s?��ͨ�����ַ���?s?�е�ÿ����ĸת���Сд��
     * ���ǿ��Ի��һ���µ��ַ�����
     * ���� ���п��ܵõ����ַ������� ���� ����˳�� ���������
     * ʾ�� 1��
     * ���룺s = "a1b2"
     * �����["a1b2", "a1B2", "A1b2", "A1B2"]
     * ʾ�� 2:
     * ����: s = "3z4"
     * ���: ["3z4","3Z4"]
     */


    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        return dfs(0, new StringBuilder(), S.toCharArray(), list);
    }

    public List<String> dfs(int index, StringBuilder sb, char[] arr, List<String> list) {
        // ���±곬������
        if (index >= arr.length) {
            list.add(sb.toString());
            return list;
        }
        dfs(index + 1, new StringBuilder(sb).append(arr[index]), arr, list);
        // ��ĸ
        if (arr[index] >= 'a') {
            dfs(index + 1, new StringBuilder(sb).append((char) (arr[index] - 32)), arr, list);
        } else if (arr[index] >= 'A') {
            dfs(index + 1, new StringBuilder(sb).append((char) (arr[index] + 32)), arr, list);
        }
        return list;
    }
}
