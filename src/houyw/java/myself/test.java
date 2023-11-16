package houyw.java.myself;

import houyw.common.TreeNode;
import houyw.common.utils.ArrayUtils;
import houyw.common.utils.TreeUtils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/6/16 17:23
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        //int[] nums = {9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
        // int[] nums = {1, 0, 2, 0, 3, 0, 4, 0, 0, 5};
        ;
        test t = new test();
        Integer[] arr = {1, 4, 5, 4, 4, 5};
        TreeNode treeNode = TreeUtils.transferToTreeNode(arr);
        int i = t.longestUnivaluePath(treeNode);
        System.out.println(i);
    }

    /**
     * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
     * 另有一个二维索引数组?indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其
     * 中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
     * ri 行上的所有单元格，加 1 。
     * ci 列上的所有单元格，加 1 。
     * 给你 m、n 和 indices 。请你在执行完所有?indices?指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
     * 示例 1：
     * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
     * 输出：6
     * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
     * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
     * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
     * 示例 2：
     * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
     * 输出：0
     * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
     * 提示：
     * 1 <= m, n <= 50
     * 1 <= indices.length <= 100
     * 0 <= ri < m
     * 0 <= ci < n
     * 进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？
     */
    public static int oddCells1(int m, int n, int[][] indices) {
        int[] xx = new int[m];
        int[] yy = new int[n];
        for (int i = 0; i < indices.length; i++) {
            if (xx[indices[i][0]] == 0) {
                xx[indices[i][0]]++;
            } else {
                xx[indices[i][0]]--;
            }

            if (yy[indices[i][1]] == 0) {
                yy[indices[i][1]]++;
            } else {
                yy[indices[i][1]]--;
            }
        }
        int count = 0;
        int t = 0;
        int k = 0;
        for (int i = 0; i < xx.length; i++) {
            if (xx[i] > 0) {
                count += n;
                t++;
            }
        }
        for (int i = 0; i < yy.length; i++) {
            if (yy[i] > 0) {
                count += m;
                k++;
            }
        }
        return count - t * k * 2;
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            int x = indices[i][0];
            int y = indices[i][1];
            for (int j = 0; j < arr[x].length; j++) {
                arr[x][j]++;
            }
            for (int k = 0; k < arr.length; k++) {
                arr[k][y]++;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int minCostToMoveChips(int[] position) {
        //奇数放一起，偶数放一起,取小得 1 2 2 2 2
        int a = 0;
        int b = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                a++;
            } else {
                b++;
            }
        }
        return Math.min(a, b);
    }

    /**
     * 在英语中，我们有一个叫做?词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为?
     * 继承词(successor)。例如，词根an，跟随着单词?other(其他)，可以形成新的单词?another(另一个)。
     * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
     * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * 你需要输出替换之后的句子。
     * <p>
     * ?
     * <p>
     * 示例 1：
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     * 示例 2：
     * <p>
     * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
     * 输出："a a b c"
     * ?
     * <p>
     * 提示：
     * <p>
     * 1 <= dictionary.length?<= 1000
     * 1 <= dictionary[i].length <= 100
     * dictionary[i]?仅由小写字母组成。
     * 1 <= sentence.length <= 10^6
     * sentence?仅由小写字母和空格组成。
     * sentence 中单词的总量在范围 [1, 1000] 内。
     * sentence 中每个单词的长度在范围 [1, 1000] 内。
     * sentence 中单词之间由一个空格隔开。
     * sentence?没有前导或尾随空格。
     */

    public static String replaceWords(List<String> dictionary, String sentence) {
        String ret = "";
        String[] split = sentence.split(" ");
        for (String str : split) {
            String replace = "";
            int length = str.length();
            for (String ss : dictionary) {
                if (str.startsWith(ss) && ss.length() < length) {
                    length = ss.length();
                    replace = ss;
                }
            }
            if (replace != "") {
                ret += replace;
            } else {
                ret += str;
            }

            ret += " ";
        }
        return ret.substring(0, ret.length() - 1);
    }

    public static int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        while (k > 0) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < relation.length; i++) {
                if (lst.contains(relation[i][0])) {
                    l.add(relation[i][1]);
                }
            }
            lst = l;
            k--;
        }
        int count = 0;
        if (lst.contains(n - 1)) {
            for (int a : lst) {
                if (a == n - 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] % 2 == 0) {
                count += coins[i] / 2;
            } else {
                count += (coins[i] + 1) / 2;
            }
        }
        return count;
    }

    /**
     * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。
     * 小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
     * U: 向y轴正方向移动一格
     * R: 向x轴正方向移动一格。
     * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
     * <p>
     * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
     * 示例 1：
     * 输入：command = "URR", obstacles = [], x = 3, y = 2
     * 输出：true
     * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
     * 示例 2：
     * <p>
     * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
     * 输出：false
     * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
     * 示例 3：
     * <p>
     * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
     * 输出：true
     * 解释：到达终点后，再碰到障碍物也不影响返回结果。
     * 限制：
     * 2 <= command的长度 <= 1000
     * command由U，R构成，且至少有一个U，至少有一个R
     * 0 <= x <= 1e9, 0 <= y <= 1e9
     * 0 <= obstacles的长度 <= 1000
     * obstacles[i]不为原点或者终点
     */

    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        int numsU = 0;
        int numsR = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                numsU++;
            } else {
                numsR++;
            }
        }
        if (!isTo(numsU, numsR, x, y, command)) {
            return false;
        }
        for (int i = 0; i < obstacles.length; i++) {
            int a = obstacles[i][0], b = obstacles[i][1];
            if (a >= x && b >= y) {
                continue;
            }
            if (isTo(numsU, numsR, obstacles[i][0], obstacles[i][1], command)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTo(int numsU, int numsR, int x, int y, String command) {
        int a = Math.min(x / numsR, y / numsU);
        int numsX = a * numsR;
        int numsY = a * numsU;
        if (numsX == x && numsY == y) {
            return true;
        }
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                numsY++;
            } else {
                numsX++;
            }
            if (numsX == x && numsY == y) {
                return true;
            }
            if (numsX > x || numsY > y) {
                return false;
            }
        }
        return false;
    }

    //1020304
    //1002003
    public static void zeroDouble(int[] nums) {
        int index = 0;
        int zero = 0;
        //最后一个是0但不复制
        boolean lastZero = false;
        while (index + zero < nums.length - 1) {
            if (nums[index] == 0) {
                zero++;
            }
            if (index + zero >= nums.length - 1) {
                //最后一个是0且复制
                lastZero = true;
                break;
            }
            index++;
        }

        while (zero > 0) {
            nums[index + zero] = nums[index];
            if (nums[index + zero] == 0) {
                if (index + zero == nums.length - 1 && !lastZero) {
                    //最后一位且不复制
                    index--;
                    continue;
                }
                zero--;
                nums[index + zero] = 0;
            }
            index--;
        }
    }


    /**
     * 给你一个包含若干星号 * 的字符串 s 。
     * 在一步操作中，你可以：
     * 选中 s 中的一个星号。
     * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
     * 返回移除 所有 星号之后的字符串。
     * 注意：
     * 生成的输入保证总是可以执行题面中描述的操作。
     * 可以证明结果字符串是唯一的。
     * 示例 1：
     * 输入：s = "leet**cod*e"
     * 输出："lecoe"
     * 解释：从左到右执行移除操作：
     * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
     * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
     * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
     * 不存在其他星号，返回 "lecoe" 。
     * 示例 2：
     * 输入：s = "erase*****"
     * 输出：""
     * 解释：整个字符串都会被移除，所以返回空字符串。
     * 提示：
     * 1 <= s.length <= 105
     * s 由小写英文字母和星号 * 组成
     * s 可以执行上述操作
     */
    public String removeStars(String s) {
        Stack<Character> que = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (que.size() > 0) {
                    que.pop();
                }
            } else {
                que.add(c);
            }
        }
        String ret = "";
        while (que.size() > 0) {
            ret = que.pop() + ret;
        }
        return ret;
    }

    /**
     * 给你一个下标从 0?开始的字符串数组?garbage?，其中?garbage[i]?表示第 i?个房子的垃圾集合。
     * garbage[i]?只包含字符?'M'?，'P' 和?'G'?，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。
     * 垃圾车收拾 一?单位的任何一种垃圾都需要花费?1?分钟。
     * 同时给你一个下标从 0?开始的整数数组?travel?，其中?travel[i]?是垃圾车从房子 i?行驶到房子 i + 1?需要的分钟数。
     * 城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0?出发，按顺序?到达每一栋房子。
     * 但它们 不是必须?到达所有的房子。
     * 任何时刻只有 一辆?垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能?做任何事情。
     * 请你返回收拾完所有垃圾需要花费的 最少?总分钟数。
     * 示例 1：
     * 输入：garbage = ["G","P","GP","GG"], travel = [2,4,3]
     * 输出：21
     * 解释：
     * 收拾纸的垃圾车：
     * 1. 从房子 0 行驶到房子 1
     * 2. 收拾房子 1 的纸垃圾
     * 3. 从房子 1 行驶到房子 2
     * 4. 收拾房子 2 的纸垃圾
     * 收拾纸的垃圾车总共花费 8 分钟收拾完所有的纸垃圾。
     * 收拾玻璃的垃圾车：
     * 1. 收拾房子 0 的玻璃垃圾
     * 2. 从房子 0 行驶到房子 1
     * 3. 从房子 1 行驶到房子 2
     * 4. 收拾房子 2 的玻璃垃圾
     * 5. 从房子 2 行驶到房子 3
     * 6. 收拾房子 3 的玻璃垃圾
     * 收拾玻璃的垃圾车总共花费 13 分钟收拾完所有的玻璃垃圾。
     * 由于没有金属垃圾，收拾金属的垃圾车不需要花费任何时间。
     * 所以总共花费 8 + 13 = 21 分钟收拾完所有垃圾。
     * 示例 2：
     * 输入：garbage = ["MMM","PGM","GP"], travel = [3,10]
     * 输出：37
     * 解释：
     * 收拾金属的垃圾车花费 7 分钟收拾完所有的金属垃圾。
     * 收拾纸的垃圾车花费 15 分钟收拾完所有的纸垃圾。
     * 收拾玻璃的垃圾车花费 15 分钟收拾完所有的玻璃垃圾。
     * 总共花费 7 + 15 + 15 = 37 分钟收拾完所有的垃圾。
     * 提示：
     * 2 <= garbage.length <= 105
     * garbage[i] 只包含字母?'M'?，'P'?和?'G'?。
     * 1 <= garbage[i].length <= 10
     * travel.length == garbage.length - 1
     * 1 <= travel[i] <= 100
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int way = 0;
        int way1 = 0;
        int way2 = 0;
        int way3 = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    count1++;
                } else if (garbage[i].charAt(j) == 'P') {
                    count2++;
                } else {
                    count3++;
                }
            }
            if (i > 0) {
                way += travel[i - 1];
            }
            if (garbage[i].contains("M")) {
                way1 = way;
            }
            if (garbage[i].contains("P")) {
                way2 = way;
            }
            if (garbage[i].contains("G")) {
                way3 = way;
            }
        }
        return count1 + count2 + count3 + way1 + way2 + way3;
    }

    /**
     * 给你一个 正?整数?k?，同时给你：
     * 一个大小为 n?的二维整数数组?rowConditions?，其中?rowConditions[i] = [abovei, belowi]?和
     * 一个大小为 m?的二维整数数组?colConditions?，其中?colConditions[i] = [lefti, righti]?。
     * 两个数组里的整数都是?1?到?k?之间的数字。
     * 你需要构造一个?k x k?的矩阵，1?到?k?每个数字需要?恰好出现一次?。剩余的数字都是?0?。
     * 矩阵还需要满足以下条件：
     * 对于所有 0?到?n - 1?之间的下标?i?，数字?abovei?所在的 行?必须在数字?belowi?所在行的上面。
     * 对于所有 0?到 m - 1?之间的下标?i?，数字?lefti?所在的 列?必须在数字?righti?所在列的左边。
     * 返回满足上述要求的 任意?矩阵。如果不存在答案，返回一个空的矩阵。
     * 示例 1：
     * 输入：k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
     * 输出：[[3,0,0],[0,0,1],[0,2,0]]
     * 解释：上图为一个符合所有条件的矩阵。
     * 行要求如下：
     * - 数字 1 在第 1 行，数字 2 在第 2?行，1 在 2 的上面。
     * - 数字 3 在第 0?行，数字 2 在第 2?行，3 在 2 的上面。
     * 列要求如下：
     * - 数字 2 在第 1?列，数字 1 在第 2?列，2 在 1 的左边。
     * - 数字 3 在第 0?列，数字 2 在第 1?列，3 在 2 的左边。
     * 注意，可能有多种正确的答案。
     * 示例 2：
     * 输入：k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
     * 输出：[]
     * 解释：由前两个条件可以得到 3 在 1 的下面，但第三个条件是 3 在 1 的上面。
     * 没有符合条件的矩阵存在，所以我们返回空矩阵。
     * 提示：
     * 2 <= k <= 400
     * 1 <= rowConditions.length, colConditions.length <= 104
     * rowConditions[i].length == colConditions[i].length == 2
     * 1 <= abovei, belowi, lefti, righti <= k
     * abovei != belowi
     * lefti != righti
     */
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        return null;
    }


    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.indexOf(searchWord) == -1) {
            return -1;
        }
        String[] strs = sentence.split(" ");
        int index = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord)) {
                index = i + 1;
                break;
            }
        }
        return index;
    }

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例?2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * 来源：力扣（LeetCode）
     */
    public String largestNumber(int[] nums) {
        //首位最大的放前面，首位相同的看次位
        PriorityQueue<String> que = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Long.valueOf(o1 + o2) > Long.valueOf(o2 + o1)) {
                    return 1;
                }
                return -1;
            }
        });
        for (int num : nums) {
            que.add(String.valueOf(num));
        }
        String str = "";
        while (que.size() > 0) {
            String poll = que.poll();
            if (str.equals("") && Integer.valueOf(poll) == 0) {
                continue;
            }
            str += poll;
        }
        if (str.equals("")) {
            return "0";
        }
        return str;
    }

    /**
     * 给定两个整数，被除数?dividend?和除数?divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数?dividend?除以除数?divisor?得到的商。
     * 整数除法的结果应当截去（truncate）其小数部分，
     * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 示例?1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例?2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     * 提示：
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为?0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,? 231?? 1]。本题中，如果除法结果溢出，则返回 231?? 1。
     */
    public int divide(int dividend, int divisor) {
        boolean flag = false;
        int m = dividend ^ divisor;
        if (m == 0) {
            return 1;
        }
        if (m < 0) {
            flag = true;
        }
        long a = Math.abs(dividend);
        if (a == Integer.MIN_VALUE) {
            a = 0 - a;
        }
        long b = Math.abs(divisor);
        if (b == Integer.MIN_VALUE) {
            b = 0 - b;
        }
        long count = 0;
        if (b == 1) {
            count = a;
        } else {
            while (a >= b) {
                a = a - b;
                count++;
            }
        }

        //负数
        if (flag) {
            if (count > Integer.MAX_VALUE && 0 - count < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                count = 0 - count;
            }

        } else {
            if (count >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) count;
    }

    /**
     * 给你一个数组?prices?，其中?prices[i]?是商店里第?i?件商品的价格。
     * 商店里正在进行促销活动，如果你要买第?i?件商品，那么你可以得到与 prices[j] 相等的折扣，
     * 其中?j?是满足?j > i?且?prices[j] <= prices[i]?的?最小下标?，如果没有满足条件的?j?，你将没有任何折扣。
     * 请你返回一个数组，数组中第?i?个元素是折扣后你购买商品 i?最终需要支付的价格。
     * 示例 1：
     * 输入：prices = [8,4,6,2,3]
     * 输出：[4,2,4,2,3]
     * 解释：
     * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
     * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
     * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
     * 商品 3 和 4 都没有折扣。
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：[1,2,3,4,5]
     * 解释：在这个例子中，所有商品都没有折扣。
     * 示例 3：
     * 输入：prices = [10,1,1,6]
     * 输出：[9,0,1,6]
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public int getLengthOfWaterfallFlow(int num, int[] block) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < block.length; i++) {
            if (que.size() < num) {
                que.add(block[i]);
                continue;
            }
            int min = que.poll();
            que.add(min + block[i]);
        }
        while (que.size() > 1) {
            que.poll();
        }
        return que.peek();
    }


    public double[] honeyQuotes(int[][] handle) {
        List<Double> list = new ArrayList<>();
        double sum = 0;
        List<Double> ret = new ArrayList<>();
        for (int i = 0; i < handle.length; i++) {

            if (handle[i].length == 1) {
                if (list.size() == 0) {
                    ret.add(-1d);
                    continue;
                }
                //计算
                if (handle[i][0] == 3) {
                    ret.add(sum / list.size());
                } else {
                    double avg = sum / list.size();
                    double all = 0;
                    for (int j = 0; j < list.size(); j++) {
                        all += (list.get(j) - avg) * (list.get(j) - avg);
                    }
                    ret.add(all / list.size());
                }
            } else {
                //操作
                if (handle[i][0] == 1) {
                    list.add(Double.valueOf(handle[i][1]));
                    sum += handle[i][1];
                } else {
                    list.remove(Double.valueOf(handle[i][1]));
                    sum -= handle[i][1];
                }
            }
        }
        double[] result = new double[ret.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ret.get(i);
        }
        return result;
    }

    /**
     * 航空公司向经常乘坐飞机的乘客们提供了一些商务套票，tickets[i] = [duration_i, price_i]，
     * 表示第 i 种套票的有效天数和价格。
     * 例如：乘客购买了有效天数为 n 的套票，则该套票在第 date ~ date+n-1 天期间都可以使用。
     * 现有一名乘客将在未来的几天中出行，days[i] 表示他第 i 次出行的时间，如果他选择购买商务套票，
     * 请返回他将花费的最少金额。
     * 注意：
     * 输入不存在多个有效天数相同的套票。
     * 示例 1：
     * 输入：
     * days = [1,2,3,4]
     * tickets = [[1,3],[2,5],[3,7]]
     * 输出: 10
     * 解释：可以买一张一天有效期的票和一张三天有效期的票；或买两张两天有效期的票；总票价均为10
     * 示例 2：
     * 输入：
     * days = [1,4,5]
     * tickets = [[1,4],[5,6],[2,5]]
     * 输出: 6
     * 解释：买一张 5 天有效期的票；总票价为6
     * 提示：
     * 1 <= days.length <= 10^5
     * 1 <= days[i] < days[i+1] <= 10^9
     * 1 <= tickets.length <= 20
     * 1 <= tickets[i][0] <= 10^5
     * 1 <= tickets[i][1] <= 10^9
     */
    public long minCostToTravelOnDays(int[] days, int[][] tickets) {
        return 0L;
    }

    /**
     * 给定一个二叉树的?root?，返回?最长的路径的长度 ，这个路径中的?每个节点具有相同值?。
     * 这条路径可以经过也可以不经过根节点。
     * 两个节点之间的路径长度?由它们之间的边数表示。
     * 示例 1:
     * 输入：root = [5,4,5,1,1,5]
     * 输出：2
     * 示例 2:
     * 输入：root = [1,4,5,4,4,5]
     * 输出：2
     * 提示:
     * 树的节点数的范围是?[0, 104]?
     * -1000 <= Node.val <= 1000
     * 树的深度将不超过 1000?
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null & root.right == null)) {
            return 0;
        }
        int count1 = longestUnivalue1(root.left);
        int count2 = longestUnivalue1(root.right);
        int count = 0;
        if (root.left != null && root.left.val == root.val) {
            count += count1 + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            count += count2 + 1;
        }
        int leftCount = longestUnivaluePath(root.left);
        int rightCount = longestUnivaluePath(root.right);
        if (leftCount > rightCount) {
            return Math.max(count, leftCount);
        } else {
            return Math.max(count, rightCount);
        }
    }

    public int longestUnivalue1(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root == null || root.left == null || root.left.val != root.val) {
            left = 0;
        } else {
            left = longestUnivalue1(root.left) + 1;
        }
        if (root == null || root.right == null || root.right.val != root.val) {
            right = 0;
        } else {
            right = longestUnivalue1(root.right) + 1;
        }
        return Math.max(left, right);
    }

    class MyLinkedList {
        private List<Integer> list;

        public MyLinkedList() {
            list = new LinkedList<Integer>();
        }

        public int get(int index) {
            if (index >= list.size() || index < 0) {
                return -1;
            } else {
                return list.get(index);
            }
        }

        public void addAtHead(int val) {
            list.add(0, val);
        }

        public void addAtTail(int val) {
            list.add(val);
        }

        public void addAtIndex(int index, int val) {

        }

        public void deleteAtIndex(int index) {

        }
    }
}
