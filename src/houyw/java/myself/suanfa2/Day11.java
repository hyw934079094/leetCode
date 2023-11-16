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
     * ����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
     * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
     * ʾ�� 1��
     * ���룺digits = "23"
     * �����["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * ʾ�� 2��
     * ���룺digits = ""
     * �����[]
     * ʾ�� 3��
     * ���룺digits = "2"
     * �����["a","b","c"]?
     * ��ʾ��
     * 0 <= digits.length <= 4
     * digits[i] �Ƿ�Χ ['2', '9'] ��һ�����֡�
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
     * ����һ��?m x n ��ά�ַ�����?board ��һ���ַ�������?word �����?word �����������У����� true �����򣬷��� false ��
     * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
     * ʾ�� 1��
     * ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * �����true
     * ʾ�� 2��
     * ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * �����true
     * ʾ�� 3��
     * ���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * �����false
     * ��ʾ��
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board �� word ���ɴ�СдӢ����ĸ���
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
        //�Ѿ���鵽���һ������
        if (index == word.length() - 1) {
            return true;
        }
        //����ǰ������б�
        list.add(cur);
        for (int[] tmp : tmps) {
            int x = tmp[0] + cur[0];
            int y = tmp[1] + cur[1];
            if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1) {
                continue;
            }
            int[] next = new int[]{x, y};
            //�Ѿ��߹��ĵ㲻����
            boolean point = false;
            for (int[] arr : list) {
                if (arr[0] == x && arr[1] == y) {
                    point = true;
                }
            }
            if (point) {
                continue;
            }
            //�����һ����ƥ��
            if (word.charAt(index + 1) == board[x][y]) {
                //�ݹ���һ����
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
