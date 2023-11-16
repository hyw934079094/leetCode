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
     * ����һ�� m x n �ľ����ʼ��ʱ��ÿ����Ԫ���е�ֵ���� 0��
     * ����һ����ά��������?indices��indices[i] = [ri, ci] ָ������е�ĳ��λ�ã���
     * �� ri �� ci �ֱ��ʾָ�����к��У��� 0 ��ʼ��ţ���
     * �� indices[i] ��ָ���ÿ��λ�ã�Ӧͬʱִ����������������
     * ri ���ϵ����е�Ԫ�񣬼� 1 ��
     * ci ���ϵ����е�Ԫ�񣬼� 1 ��
     * ���� m��n �� indices ��������ִ��������?indices?ָ�������������󣬷��ؾ����� ����ֵ��Ԫ�� ����Ŀ��
     * ʾ�� 1��
     * ���룺m = 2, n = 3, indices = [[0,1],[1,1]]
     * �����6
     * ���ͣ��ʼ�ľ����� [[0,0,0],[0,0,0]]��
     * ��һ������������õ� [[1,2,1],[0,1,0]]��
     * ���ľ����� [[1,3,1],[1,3,1]]�������� 6 ��������
     * ʾ�� 2��
     * ���룺m = 2, n = 2, indices = [[1,1],[0,0]]
     * �����0
     * ���ͣ����ľ����� [[2,2],[2,2]]������û��������
     * ��ʾ��
     * 1 <= m, n <= 50
     * 1 <= indices.length <= 100
     * 0 <= ri < m
     * 0 <= ci < n
     * ���ף���������һ��ʱ�临�Ӷ�Ϊ O(n + m + indices.length) �ҽ��� O(n + m) ����ռ���㷨�������������
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
        //������һ��ż����һ��,ȡС�� 1 2 2 2 2
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
     * ��Ӣ���У�������һ������?�ʸ�(root) �ĸ�����Դʸ������������һЩ�������һ���ϳ��ĵ��ʡ������ǳ������Ϊ?
     * �̳д�(successor)�����磬�ʸ�an�������ŵ���?other(����)�������γ��µĵ���?another(��һ��)��
     * ���ڣ�����һ�������ʸ���ɵĴʵ� dictionary ��һ���ÿո�ָ������γɵľ��� sentence��
     * ����Ҫ�������е����м̳д��ôʸ��滻��������̳д����������γ����Ĵʸ���������̵Ĵʸ��滻����
     * ����Ҫ����滻֮��ľ��ӡ�
     * <p>
     * ?
     * <p>
     * ʾ�� 1��
     * ���룺dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * �����"the cat was rat by the bat"
     * ʾ�� 2��
     * <p>
     * ���룺dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
     * �����"a a b c"
     * ?
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= dictionary.length?<= 1000
     * 1 <= dictionary[i].length <= 100
     * dictionary[i]?����Сд��ĸ��ɡ�
     * 1 <= sentence.length <= 10^6
     * sentence?����Сд��ĸ�Ϳո���ɡ�
     * sentence �е��ʵ������ڷ�Χ [1, 1000] �ڡ�
     * sentence ��ÿ�����ʵĳ����ڷ�Χ [1, 1000] �ڡ�
     * sentence �е���֮����һ���ո������
     * sentence?û��ǰ����β��ո�
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
     * �����Ŷ�����һ���ɱ�̻����ˣ������˳�ʼλ����ԭ��(0, 0)��
     * С������ȸ�����������һ��ָ��command�������˾ͻ�����ѭ������ָ��Ĳ�������ƶ���ָ�������֣�
     * U: ��y���������ƶ�һ��
     * R: ��x���������ƶ�һ��
     * ���ҵ��ǣ��� xy ƽ���ϻ���һЩ�ϰ�����ǵ�������obstacles��ʾ��������һ�������ϰ���ͻᱻ��١�
     * <p>
     * �����յ�����(x, y)�����ػ������ܷ���õص����յ㡣����ܣ�����true�����򷵻�false��
     * ʾ�� 1��
     * ���룺command = "URR", obstacles = [], x = 3, y = 2
     * �����true
     * ���ͣ�U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)��
     * ʾ�� 2��
     * <p>
     * ���룺command = "URR", obstacles = [[2, 2]], x = 3, y = 2
     * �����false
     * ���ͣ��������ڵ����յ�ǰ������(2, 2)���ϰ��
     * ʾ�� 3��
     * <p>
     * ���룺command = "URR", obstacles = [[4, 2]], x = 3, y = 2
     * �����true
     * ���ͣ������յ���������ϰ���Ҳ��Ӱ�췵�ؽ����
     * ���ƣ�
     * 2 <= command�ĳ��� <= 1000
     * command��U��R���ɣ���������һ��U��������һ��R
     * 0 <= x <= 1e9, 0 <= y <= 1e9
     * 0 <= obstacles�ĳ��� <= 1000
     * obstacles[i]��Ϊԭ������յ�
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
        //���һ����0��������
        boolean lastZero = false;
        while (index + zero < nums.length - 1) {
            if (nums[index] == 0) {
                zero++;
            }
            if (index + zero >= nums.length - 1) {
                //���һ����0�Ҹ���
                lastZero = true;
                break;
            }
            index++;
        }

        while (zero > 0) {
            nums[index + zero] = nums[index];
            if (nums[index + zero] == 0) {
                if (index + zero == nums.length - 1 && !lastZero) {
                    //���һλ�Ҳ�����
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
     * ����һ�����������Ǻ� * ���ַ��� s ��
     * ��һ�������У�����ԣ�
     * ѡ�� s �е�һ���Ǻš�
     * �Ƴ��Ǻ� ��� ������Ǹ� ���Ǻ� �ַ������Ƴ����Ǻ�����
     * �����Ƴ� ���� �Ǻ�֮����ַ�����
     * ע�⣺
     * ���ɵ����뱣֤���ǿ���ִ�������������Ĳ�����
     * ����֤������ַ�����Ψһ�ġ�
     * ʾ�� 1��
     * ���룺s = "leet**cod*e"
     * �����"lecoe"
     * ���ͣ�������ִ���Ƴ�������
     * - ����� 1 ���Ǻ�������ַ��� "leet**cod*e" �е� 't' ��s ��Ϊ "lee*cod*e" ��
     * - ����� 2 ���Ǻ�������ַ��� "lee*cod*e" �е� 'e' ��s ��Ϊ "lecod*e" ��
     * - ����� 3 ���Ǻ�������ַ��� "lecod*e" �е� 'd' ��s ��Ϊ "lecoe" ��
     * �����������Ǻţ����� "lecoe" ��
     * ʾ�� 2��
     * ���룺s = "erase*****"
     * �����""
     * ���ͣ������ַ������ᱻ�Ƴ������Է��ؿ��ַ�����
     * ��ʾ��
     * 1 <= s.length <= 105
     * s ��СдӢ����ĸ���Ǻ� * ���
     * s ����ִ����������
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
     * ����һ���±�� 0?��ʼ���ַ�������?garbage?������?garbage[i]?��ʾ�� i?�����ӵ��������ϡ�
     * garbage[i]?ֻ�����ַ�?'M'?��'P' ��?'G'?�������ܰ��������ͬ�ַ���ÿ���ַ��ֱ��ʾһ��λ�Ľ�����ֽ�Ͳ�����
     * ��������ʰ һ?��λ���κ�һ����������Ҫ����?1?���ӡ�
     * ͬʱ����һ���±�� 0?��ʼ����������?travel?������?travel[i]?���������ӷ��� i?��ʻ������ i + 1?��Ҫ�ķ�������
     * �������ܹ����������������ֱ���ʰ����������ÿ�����������ӷ��� 0?��������˳��?����ÿһ�����ӡ�
     * ������ ���Ǳ���?�������еķ��ӡ�
     * �κ�ʱ��ֻ�� һ��?����������ʹ��״̬����һ������������ʻ������ʰ������ʱ������������ ����?���κ����顣
     * ���㷵����ʰ������������Ҫ���ѵ� ����?�ܷ�������
     * ʾ�� 1��
     * ���룺garbage = ["G","P","GP","GG"], travel = [2,4,3]
     * �����21
     * ���ͣ�
     * ��ʰֽ����������
     * 1. �ӷ��� 0 ��ʻ������ 1
     * 2. ��ʰ���� 1 ��ֽ����
     * 3. �ӷ��� 1 ��ʻ������ 2
     * 4. ��ʰ���� 2 ��ֽ����
     * ��ʰֽ���������ܹ����� 8 ������ʰ�����е�ֽ������
     * ��ʰ��������������
     * 1. ��ʰ���� 0 �Ĳ�������
     * 2. �ӷ��� 0 ��ʻ������ 1
     * 3. �ӷ��� 1 ��ʻ������ 2
     * 4. ��ʰ���� 2 �Ĳ�������
     * 5. �ӷ��� 2 ��ʻ������ 3
     * 6. ��ʰ���� 3 �Ĳ�������
     * ��ʰ�������������ܹ����� 13 ������ʰ�����еĲ���������
     * ����û�н�����������ʰ����������������Ҫ�����κ�ʱ�䡣
     * �����ܹ����� 8 + 13 = 21 ������ʰ������������
     * ʾ�� 2��
     * ���룺garbage = ["MMM","PGM","GP"], travel = [3,10]
     * �����37
     * ���ͣ�
     * ��ʰ���������������� 7 ������ʰ�����еĽ���������
     * ��ʰֽ������������ 15 ������ʰ�����е�ֽ������
     * ��ʰ���������������� 15 ������ʰ�����еĲ���������
     * �ܹ����� 7 + 15 + 15 = 37 ������ʰ�����е�������
     * ��ʾ��
     * 2 <= garbage.length <= 105
     * garbage[i] ֻ������ĸ?'M'?��'P'?��?'G'?��
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
     * ����һ�� ��?����?k?��ͬʱ���㣺
     * һ����СΪ n?�Ķ�ά��������?rowConditions?������?rowConditions[i] = [abovei, belowi]?��
     * һ����СΪ m?�Ķ�ά��������?colConditions?������?colConditions[i] = [lefti, righti]?��
     * �������������������?1?��?k?֮������֡�
     * ����Ҫ����һ��?k x k?�ľ���1?��?k?ÿ��������Ҫ?ǡ�ó���һ��?��ʣ������ֶ���?0?��
     * ������Ҫ��������������
     * �������� 0?��?n - 1?֮����±�?i?������?abovei?���ڵ� ��?����������?belowi?�����е����档
     * �������� 0?�� m - 1?֮����±�?i?������?lefti?���ڵ� ��?����������?righti?�����е���ߡ�
     * ������������Ҫ��� ����?������������ڴ𰸣�����һ���յľ���
     * ʾ�� 1��
     * ���룺k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
     * �����[[3,0,0],[0,0,1],[0,2,0]]
     * ���ͣ���ͼΪһ���������������ľ���
     * ��Ҫ�����£�
     * - ���� 1 �ڵ� 1 �У����� 2 �ڵ� 2?�У�1 �� 2 �����档
     * - ���� 3 �ڵ� 0?�У����� 2 �ڵ� 2?�У�3 �� 2 �����档
     * ��Ҫ�����£�
     * - ���� 2 �ڵ� 1?�У����� 1 �ڵ� 2?�У�2 �� 1 ����ߡ�
     * - ���� 3 �ڵ� 0?�У����� 2 �ڵ� 1?�У�3 �� 2 ����ߡ�
     * ע�⣬�����ж�����ȷ�Ĵ𰸡�
     * ʾ�� 2��
     * ���룺k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
     * �����[]
     * ���ͣ���ǰ�����������Եõ� 3 �� 1 �����棬�������������� 3 �� 1 �����档
     * û�з��������ľ�����ڣ��������Ƿ��ؿվ���
     * ��ʾ��
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
     * ����һ��Ǹ����� nums����������ÿ������˳��ÿ�������ɲ�֣�ʹ֮���һ������������
     * ע�⣺���������ܷǳ�����������Ҫ����һ���ַ���������������
     * ʾ�� 1��
     * ���룺nums = [10,2]
     * �����"210"
     * ʾ��?2��
     * ���룺nums = [3,30,34,5,9]
     * �����"9534330"
     * ��Դ�����ۣ�LeetCode��
     */
    public String largestNumber(int[] nums) {
        //��λ���ķ�ǰ�棬��λ��ͬ�Ŀ���λ
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
     * ��������������������?dividend?�ͳ���?divisor�������������Ҫ��ʹ�ó˷��������� mod �������
     * ���ر�����?dividend?���Գ���?divisor?�õ����̡�
     * ���������Ľ��Ӧ����ȥ��truncate����С�����֣�
     * ���磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2
     * ʾ��?1:
     * ����: dividend = 10, divisor = 3
     * ���: 3
     * ����: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * ʾ��?2:
     * ����: dividend = 7, divisor = -3
     * ���: -2
     * ����: 7/-3 = truncate(-2.33333..) = -2
     * ��ʾ��
     * �������ͳ�����Ϊ 32 λ�з���������
     * ������Ϊ?0��
     * �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,? 231?? 1]�������У�����������������򷵻� 231?? 1��
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

        //����
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
     * ����һ������?prices?������?prices[i]?���̵����?i?����Ʒ�ļ۸�
     * �̵������ڽ��д�����������Ҫ���?i?����Ʒ����ô����Եõ��� prices[j] ��ȵ��ۿۣ�
     * ����?j?������?j > i?��?prices[j] <= prices[i]?��?��С�±�?�����û������������?j?���㽫û���κ��ۿۡ�
     * ���㷵��һ�����飬�����е�?i?��Ԫ�����ۿۺ��㹺����Ʒ i?������Ҫ֧���ļ۸�
     * ʾ�� 1��
     * ���룺prices = [8,4,6,2,3]
     * �����[4,2,4,2,3]
     * ���ͣ�
     * ��Ʒ 0 �ļ۸�Ϊ price[0]=8 ���㽫�õ� prices[1]=4 ���ۿۣ��������ռ۸�Ϊ 8 - 4 = 4 ��
     * ��Ʒ 1 �ļ۸�Ϊ price[1]=4 ���㽫�õ� prices[3]=2 ���ۿۣ��������ռ۸�Ϊ 4 - 2 = 2 ��
     * ��Ʒ 2 �ļ۸�Ϊ price[2]=6 ���㽫�õ� prices[3]=2 ���ۿۣ��������ռ۸�Ϊ 6 - 2 = 4 ��
     * ��Ʒ 3 �� 4 ��û���ۿۡ�
     * ʾ�� 2��
     * ���룺prices = [1,2,3,4,5]
     * �����[1,2,3,4,5]
     * ���ͣ�����������У�������Ʒ��û���ۿۡ�
     * ʾ�� 3��
     * ���룺prices = [10,1,1,6]
     * �����[9,0,1,6]
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
                //����
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
                //����
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
     * ���չ�˾�򾭳������ɻ��ĳ˿����ṩ��һЩ������Ʊ��tickets[i] = [duration_i, price_i]��
     * ��ʾ�� i ����Ʊ����Ч�����ͼ۸�
     * ���磺�˿͹�������Ч����Ϊ n ����Ʊ�������Ʊ�ڵ� date ~ date+n-1 ���ڼ䶼����ʹ�á�
     * ����һ���˿ͽ���δ���ļ����г��У�days[i] ��ʾ���� i �γ��е�ʱ�䣬�����ѡ����������Ʊ��
     * �뷵���������ѵ����ٽ�
     * ע�⣺
     * ���벻���ڶ����Ч������ͬ����Ʊ��
     * ʾ�� 1��
     * ���룺
     * days = [1,2,3,4]
     * tickets = [[1,3],[2,5],[3,7]]
     * ���: 10
     * ���ͣ�������һ��һ����Ч�ڵ�Ʊ��һ��������Ч�ڵ�Ʊ����������������Ч�ڵ�Ʊ����Ʊ�۾�Ϊ10
     * ʾ�� 2��
     * ���룺
     * days = [1,4,5]
     * tickets = [[1,4],[5,6],[2,5]]
     * ���: 6
     * ���ͣ���һ�� 5 ����Ч�ڵ�Ʊ����Ʊ��Ϊ6
     * ��ʾ��
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
     * ����һ����������?root?������?���·���ĳ��� �����·���е�?ÿ���ڵ������ֵͬ?��
     * ����·�����Ծ���Ҳ���Բ��������ڵ㡣
     * �����ڵ�֮���·������?������֮��ı�����ʾ��
     * ʾ�� 1:
     * ���룺root = [5,4,5,1,1,5]
     * �����2
     * ʾ�� 2:
     * ���룺root = [1,4,5,4,4,5]
     * �����2
     * ��ʾ:
     * ���Ľڵ����ķ�Χ��?[0, 104]?
     * -1000 <= Node.val <= 1000
     * ������Ƚ������� 1000?
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
