package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: DELL
 * @Date: 2022/8/4 10:17
 * @Description:
 */
public class Day11 {

    public static void main(String[] args) {
        Day11 day = new Day11();
        char[][] ss = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(day.exist(ss, "ABCEFSADEESE"));
        /*List<int[]> arr = new ArrayList<>();
        int[] arr1 = {1, 0};
        int[] arr2 = {1, 0};
        arr.add(arr1);
        System.out.println(arr.contains(arr1));*/
    }

    /**
     * 给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]?
     * 提示：
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    public List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<>();
        if (digits.length() > 0) {
            String str = "abcdefghijklmnopqrstuvwsyz";
            int[] nums = new int[10];
            int index = 0;
            List<List<String>> list = new ArrayList<>();
            for (int i = 2; i < nums.length; i++) {
                nums[i] = 3;
                if (i == 7 || i == 9) {
                    nums[i] = 4;
                }
                List<String> ss = new ArrayList<>();
                list.add(ss);
                for (int j = 0; j < nums[i]; j++) {
                    ss.add(String.valueOf(str.charAt(index)));
                    index++;
                }
            }

            lst.addAll(list.get(Integer.valueOf(digits.substring(0, 1)) - 2));
            for (int i = 1; i < digits.length(); i++) {
                int num = Integer.valueOf(digits.substring(i, i + 1));
                List<String> l = list.get(num - 2);
                List<String> tmp = new ArrayList<>();
                for (String s1 : lst) {
                    for (String s2 : l) {
                        tmp.add(s1 + s2);
                    }
                }
                lst = tmp;

            }
        }
        return lst;
    }

    /**
     * 给定一个?m x n 二维字符网格?board 和一个字符串单词?word 。如果?word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     * 提示：
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     */
    List<int[]> list = new ArrayList<>();
    int[][] tmps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean exist = exist(board, word, 0, new int[]{i, j});
                    if (exist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int index, int[] cur) {
        //已经检查到最后一个点了
        if (index == word.length() - 1) {
            return true;
        }
        //将当前点加入列表
        list.add(cur);
        for (int[] tmp : tmps) {
            int x = tmp[0] + cur[0];
            int y = tmp[1] + cur[1];
            if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1) {
                continue;
            }
            int[] next = new int[]{x, y};
            //已经走过的点不再走
            boolean point = false;
            for (int[] arr : list) {
                if (arr[0] == x && arr[1] == y) {
                    point = true;
                }
            }
            if (point) {
                continue;
            }
            //如果下一个点匹配
            if (word.charAt(index + 1) == board[x][y]) {
                //递归下一个点
                boolean b = exist(board, word, index + 1, next);
                if (b) {
                    return true;
                }
            }
        }
        list.remove(cur);
        return false;
    }
}
