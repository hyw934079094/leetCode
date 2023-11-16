package houyw.java.myself.suanfa2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/7/28 10:32
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        Day4 day = new Day4();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(day.maxArea(height));
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     * ?
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：s 和 t 都会变成 "ac"。
     * 示例 2：
     * <p>
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 ""。
     * 示例 3：
     * <p>
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 "c"，但 t 仍然是 "b"。
     * ?
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 200
     * s 和 t 只含有小写字母以及字符 '#'
     * ?
     */
    public boolean backspaceCompare(String s, String t) {
        Stack ss = new Stack();
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                ss.push(s.charAt(i));
            }
            if (ss.size() > 0 && s.charAt(i) == '#') {
                ss.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                st.push(t.charAt(i));
            }
            if (st.size() > 0 && t.charAt(i) == '#') {
                st.pop();
            }
        }
        if (ss.size() != st.size()) {
            return false;
        }
        while (ss.size() > 0) {
            if (ss.pop() != st.pop()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给定一个长度为 n 的整数数组?height?。有?n?条垂线，第 i 条线的两个端点是?(i, 0)?和?(i, height[i])?。
     * 找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为?49。
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     * 提示：
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     */
    public int maxArea(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int max = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] < height[i]) {
                    if ((j - i) * height[j] > max) {
                        max = (j - i) * height[j];
                    }
                    continue;
                } else {
                    if ((j - i) * height[i] > max) {
                        max = (j - i) * height[i];
                    }
                    break;
                }
            }
            if (sum < max) {
                sum = max;
            }
        }

        return sum;
    }

    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，
     * 其中 firstList[i] = [starti, endi] 而?secondList[j] = [startj, endj] 。
     * 每个区间列表都是成对 不相交 的，并且 已经排序 。
     * 返回这 两个区间列表的交集 。
     * 形式上，闭区间?[a, b]（其中?a <= b）表示实数?x?的集合，而?a <= x <= b 。
     * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     * 示例 1：
     * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * 示例 2：
     * <p>
     * 输入：firstList = [[1,3],[5,9]], secondList = []
     * 输出：[]
     * 示例 3：
     * 输入：firstList = [], secondList = [[4,8],[10,12]]
     * 输出：[]
     * 示例 4：
     * 输入：firstList = [[1,7]], secondList = [[3,10]]
     * 输出：[[3,7]]
     * 提示：
     * 0 <= firstList.length, secondList.length <= 1000
     * firstList.length + secondList.length >= 1
     * 0 <= starti < endi <= 109
     * endi < starti+1
     * 0 <= startj < endj <= 109
     * endj < startj+1
     */

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //相交---》下区间取大的，上区间取小的
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            int[] f1 = firstList[i];
            for (int j = 0; j < secondList.length; j++) {
                //找到相交点
                int[] f2 = secondList[j];
                //整个段落在都在当前前面
                if (f1[0] > f2[1]) {
                    continue;
                }
                //整段都在后面,后面的都在后面了
                if (f2[0] > f1[1]) {
                    break;
                }
                //存在相交片段的
                int[] arr = new int[2];
                if (f1[0] >= f2[0]) {
                    arr[0] = f1[0];
                } else {
                    arr[0] = f2[0];
                }
                if (f1[1] <= f2[1]) {
                    arr[1] = f1[1];
                } else {
                    arr[1] = f2[1];
                }
                list.add(arr);
            }
        }
        int[][] ret = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
