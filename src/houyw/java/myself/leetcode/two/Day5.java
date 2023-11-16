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
     * 给你一个字符串数组?words?。words?中每个元素都是一个包含 两个?小写英文字母的单词。
     * 请你从 words?中选择一些元素并按 任意顺序?连接它们，并得到一个 尽可能长的回文串?。每个元素 至多?只能使用一次。
     * 请你返回你能得到的最长回文串的 长度?。如果没办法得到任何一个回文串，请你返回 0?。
     * 回文串?指的是从前往后和从后往前读一样的字符串。
     * 示例 1：
     * 输入：words = ["lc","cl","gg"]
     * 输出：6
     * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
     * "clgglc" 是另一个可以得到的最长回文串。
     * 示例 2：
     * 输入：words = ["ab","ty","yt","lc","cl","ab"]
     * 输出：8
     * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
     * "lcyttycl" 是另一个可以得到的最长回文串。
     * 示例 3：
     * 输入：words = ["cc","ll","xx"]
     * 输出：2
     * 解释：最长回文串是 "cc" ，长度为 2 。
     * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
     * 提示：
     * 1 <= words.length <= 105
     * words[i].length == 2
     * words[i]?仅包含小写英文字母。
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
     * 给你一个用字符数组?tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
     * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
     * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
     * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * 你需要计算完成所有任务所需要的 最短时间 。
     * 示例 1：
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，
     * 而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     * 示例 2：
     * 输入：tasks = ["A","A","A","B","B","B"], n = 0
     * 输出：6
     * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * 诸如此类
     * 示例 3：
     * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * 输出：16
     * 解释：一种可能的解决方案是：
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
     * 提示：
     * 1 <= task.length <= 104
     * tasks[i] 是大写英文字母
     * n 的取值范围为 [0, 100]
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
