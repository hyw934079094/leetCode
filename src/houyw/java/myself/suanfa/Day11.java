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
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * 示例 1：
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 示例 2：
     * 输入：n = 1, k = 1
     * 输出：[[1]]
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
     * 给定一个字符串?s?，通过将字符串?s?中的每个字母转变大小写，
     * 我们可以获得一个新的字符串。
     * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
     * 示例 1：
     * 输入：s = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     * 示例 2:
     * 输入: s = "3z4"
     * 输出: ["3z4","3Z4"]
     */


    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        return dfs(0, new StringBuilder(), S.toCharArray(), list);
    }

    public List<String> dfs(int index, StringBuilder sb, char[] arr, List<String> list) {
        // 若下标超出跳出
        if (index >= arr.length) {
            list.add(sb.toString());
            return list;
        }
        dfs(index + 1, new StringBuilder(sb).append(arr[index]), arr, list);
        // 字母
        if (arr[index] >= 'a') {
            dfs(index + 1, new StringBuilder(sb).append((char) (arr[index] - 32)), arr, list);
        } else if (arr[index] >= 'A') {
            dfs(index + 1, new StringBuilder(sb).append((char) (arr[index] + 32)), arr, list);
        }
        return list;
    }
}
