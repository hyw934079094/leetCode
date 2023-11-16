package houyw.java.myself.leetcode.dtgh;

import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;

import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/8/16 21:06
 * @Description:
 */
public class Normal {
    public static void main(String[] args) {
        Normal no = new Normal();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = no.isInterleave(s1, s2, s3);
        System.out.println(interleave);

    }

    /**
     * һ��������λ��һ��?m x n?��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
     * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish������
     * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
     * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
     * ʾ�� 1��
     * ���룺obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * �����2
     * ���ͣ�3x3 ��������м���һ���ϰ��
     * �����Ͻǵ����½�һ���� 2 ����ͬ��·����
     * 1. ���� -> ���� -> ���� -> ����
     * 2. ���� -> ���� -> ���� -> ����
     * ʾ�� 2��
     * ���룺obstacleGrid = [[0,1],[0,0]]
     * �����1
     * ��ʾ��
     * m ==?obstacleGrid.length
     * n ==?obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] Ϊ 0 �� 1
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] fn = new int[obstacleGrid.length][obstacleGrid[0].length];
        fn[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                fn[i][0] = 0;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                fn[0][i] = 0;
            } else {
                fn[0][i] = fn[0][i - 1];
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    fn[i][j] = 0;
                } else {
                    fn[i][j] = fn[i][j - 1] + fn[i - 1][j];
                }
            }
        }
        return fn[fn.length - 1][fn[0].length - 1];
    }


    /**
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25
     * ����һ������ n �������ҳ������ص� n �� ���� ��
     * ���� ����ֻ����������?2��3 ��/��?5?����������
     * ʾ�� 1��
     * ���룺n = 10
     * �����12
     * ���ͣ�[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] ����ǰ 10 ��������ɵ����С�
     * ʾ�� 2��
     * ���룺n = 1
     * �����1
     * ���ͣ�1 ͨ������Ϊ������
     * ��ʾ��
     * 1 <= n <= 1690
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] tmps = {2, 3, 5};
        List<Long> list = new ArrayList<>();
        long[] fn = new long[n];
        fn[0] = 1;
        for (int i = 1; i < n; i++) {
            if (list.size() > 0) {
                for (int num : tmps) {
                    if (!list.contains(fn[i - 1] * num)) {
                        for (int j = list.size() - 1; j >= 0; j--) {
                            if (list.get(j) <= fn[i - 1] * num) {
                                list.add(j + 1, fn[i - 1] * num);
                                break;
                            }
                        }
                    }
                }
            } else {
                for (int num : tmps) {
                    list.add(fn[i - 1] * num);
                }
            }
            fn[i] = list.get(0);
            list.remove(0);
        }
        return (int) fn[n - 1];
    }

    /**
     * ����һ�������Ǹ������� m?x?n?����?grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
     * ˵����ÿ��ֻ�����»��������ƶ�һ����
     * ʾ�� 1��
     * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
     * �����7
     * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
     * ʾ�� 2��
     * ���룺grid = [[1,2,3],[4,5,6]]
     * �����12
     * ��ʾ��
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     */
    public int minPathSum(int[][] grid) {
        int[][] fn = new int[grid.length][grid[0].length];
        fn[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j > 0) {
                    fn[i][j] = fn[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    fn[i][j] = fn[i - 1][j] + grid[i][j];
                } else {
                    fn[i][j] = Math.min(fn[i - 1][j], fn[i][j - 1]) + grid[i][j];
                }
            }
        }
        return fn[fn.length - 1][fn[0].length - 1];
    }

    /**
     * �������� ��һ�������������������������������������������� primes �С�
     * ����һ������ n ��һ���������� primes �����ص� n �� �������� ��
     * ��Ŀ���ݱ�֤�� n �� �������� �� 32-bit ������������Χ�ڡ�
     * ʾ�� 1��
     * ���룺n = 12, primes = [2,7,13,19]
     * �����32
     * ���ͣ���������Ϊ 4 ���������� primes = [2,7,13,19]��ǰ 12 ��������������Ϊ��[1,2,4,7,8,13,14,16,19,26,28,32] ��
     * ʾ�� 2��
     * ���룺n = 1, primes = [2,3,5]
     * �����1
     * ���ͣ�1 ����������������������������������������� primes = [2,3,5] �С�
     * ��ʾ��
     * 1 <= n <= 105
     * 1 <= primes.length <= 100
     * 2 <= primes[i] <= 1000
     * ��Ŀ���� ��֤ primes[i] ��һ������
     * primes �е�����ֵ�� ������ͬ ���Ұ� ����˳�� ����
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        int m = primes.length;
        int[] pointers = new int[m];
        long[] nums = new long[m];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            long minNum = Arrays.stream(nums).min().getAsLong();
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return (int) dp[n];
    }

    /**
     * ����һ������ n ����ǡ�� n ���ڵ�����ҽڵ�ֵ
     * �� 1 �� n ������ͬ�� ���������� �ж����֣�
     * ������������Ķ�����������������
     * ʾ�� 1��
     * ���룺n = 3
     * �����5
     * ʾ�� 2��
     * ���룺n = 1
     * �����1
     */
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        //fn[i]��ʾ��N���ڵ���ɵ� ������������������
        int[] fn = new int[n + 1];
        fn[0] = 1;
        fn[1] = 1;
        fn[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                fn[i] += fn[j - 1] * fn[i - j];
            }
        }
        return fn[n];
    }

    /**
     * ��һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
     * ʾ�� 1��
     * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * �����4
     * ʾ�� 2��
     * ���룺matrix = [["0","1"],["1","0"]]
     * �����1
     * ʾ�� 3��
     * ���룺matrix = [["0"]]
     * �����0
     * ��ʾ��
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] Ϊ '0' �� '1'
     */
    //DFS
    public int maximalSquare(char[][] matrix) {
        Queue<int[]> que = new LinkedList();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    que.add(new int[]{i, j});
                }
            }
        }
        if (que.size() == 0) {
            return max;
        }
        while (que.size() > 0) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            while (x < matrix.length - 1 && y < matrix[x].length - 1) {
                if (matrix[x + 1][y + 1] == '1') {
                    boolean flag = true;
                    for (int a = x + 1; a >= cur[0]; a--) {
                        if (matrix[a][y + 1] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int a = y + 1; a >= cur[1]; a--) {
                            if (matrix[x + 1][a] == '0') {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        x++;
                        y++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            int m = x - cur[0] + 1;
            int n = y - cur[1] + 1;
            if (m * n > max) {
                max = m * n;
            }

        }
        return max;
    }

    //��̬�滮
    public int maximalSquare1(char[][] matrix) {
        int[][] fn = new int[matrix.length][matrix[0].length];
        fn[0][0] = matrix[0][0] == '1' ? 1 : 0;
        //for(int i = ){}
        return 0;
    }


    /**
     * ����һ������ n ���������ɲ����������� n ���ڵ�����ҽڵ�ֵ�� 1 �� n ������ͬ�Ĳ�ͬ ���������� ��
     * ���԰� ����˳�� ���ش𰸡�
     * ʾ�� 1��
     * ���룺n = 3
     * �����[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * ʾ�� 2��
     * ���룺n = 1
     * �����[[1]]
     * ��ʾ��
     * 1 <= n <= 8
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        for (int i = start; i <= end; i++) {
            if (i == start) {
                List<TreeNode> lr = generateTrees(start + 1, end);
                for (int j = 0; j < lr.size(); j++) {
                    TreeNode node = new TreeNode(start);
                    node.right = lr.get(j);
                    list.add(node);
                }
            } else if (i == end) {
                List<TreeNode> ll = generateTrees(start, end - 1);
                for (int j = 0; j < ll.size(); j++) {
                    TreeNode node = new TreeNode(end);
                    node.left = ll.get(j);
                    list.add(node);
                }
            } else {
                List<TreeNode> ll = generateTrees(start, i - 1);
                List<TreeNode> lr = generateTrees(i + 1, end);
                for (int j = 0; j < ll.size(); j++) {
                    for (int k = 0; k < lr.size(); k++) {
                        TreeNode node = new TreeNode(i);
                        node.left = ll.get(j);
                        node.right = lr.get(k);
                        list.add(node);
                    }
                }
            }

        }
        return list;
    }

    /**
     * ����һ�����ظ�����������?nums ��?��������?������������㷨��?nums �ݹ�ع���:
     * ����һ�����ڵ㣬��ֵΪ?nums �е����ֵ��
     * �ݹ�������ֵ?���?��?������ǰ׺��?������������
     * �ݹ�������ֵ �ұ� ��?�������׺��?������������
     * ����?nums ������ �������� ��
     * ʾ�� 1��
     * ���룺nums = [3,2,1,6,0,5]
     * �����[6,3,5,null,2,0,null,null,1]
     * ���ͣ��ݹ����������ʾ��
     * - [3,2,1,6,0,5] �е����ֵ�� 6 ����߲����� [3,2,1] ���ұ߲����� [0,5] ��
     * - [3,2,1] �е����ֵ�� 3 ����߲����� [] ���ұ߲����� [2,1] ��
     * - �����飬���ӽڵ㡣
     * - [2,1] �е����ֵ�� 2 ����߲����� [] ���ұ߲����� [1] ��
     * - �����飬���ӽڵ㡣
     * - ֻ��һ��Ԫ�أ������ӽڵ���һ��ֵΪ 1 �Ľڵ㡣
     * - [0,5] �е����ֵ�� 5 ����߲����� [0] ���ұ߲����� [] ��
     * - ֻ��һ��Ԫ�أ������ӽڵ���һ��ֵΪ 0 �Ľڵ㡣
     * - �����飬���ӽڵ㡣
     * ʾ�� 2��
     * ���룺nums = [3,2,1]
     * �����[3,null,2,null,1]
     * ��ʾ��
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 1000
     * nums �е��������� ������ͬ
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode head = new TreeNode(max);
        int[] lefts = new int[index];
        int[] rights = new int[nums.length - index - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < index) {
                lefts[i] = nums[i];
            }
            if (i > index) {
                rights[i - index - 1] = nums[i];
            }
        }
        head.left = constructMaximumBinaryTree(lefts);
        head.right = constructMaximumBinaryTree(rights);
        return head;
    }

    /**
     * ����������ĸ��ڵ� root ��һ������ val ��
     * ���� ֮ǰ������ �������������������� Construct(a)?���̴��б�?a��root = Construct(a)���ݹ�ع����ģ�
     * ��� a Ϊ�գ�����?null ��
     * ������?a[i] ��Ϊ a �����Ԫ�ء�����һ��ֵΪ?a[i]?�ĸ��ڵ� root ��
     * root?����������������Ϊ?Construct([a[0], a[1], ..., a[i - 1]]) ��
     * root?����������������Ϊ?Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) ��
     * ����?root ��
     * ��ע�⣬��Ŀû��ֱ�Ӹ��� a ��ֻ�Ǹ���һ�����ڵ�?root = Construct(a) ��
     * ���� b �� a �ĸ���������ĩβ����ֵ val����Ŀ���ݱ�֤ b �е�ֵ������ͬ��
     * ����?Construct(b) ��
     * ʾ�� 1��
     * ���룺root = [4,1,3,null,null,2], val = 5
     * �����[5,4,null,1,3,null,null,2]
     * ���ͣ�a = [1,4,2,3], b = [1,4,2,3,5]
     * ʾ�� 2��
     * ���룺root = [5,2,4,null,1], val = 3
     * �����[5,2,4,null,1,null,3]
     * ���ͣ�a = [2,1,5,4], b = [2,1,5,4,3]
     * ʾ�� 3��
     * ���룺root = [5,2,3,null,1], val = 4
     * �����[5,2,4,null,1,3]
     * ���ͣ�a = [2,1,5,3], b = [2,1,5,3,4]
     * ��ʾ��
     * ���нڵ���Ŀ�ڷ�Χ [1, 100] ��
     * 1 <= Node.val <= 100
     * ���е�����ֵ ������ͬ
     * 1 <= val <= 100
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (root.right == null) {
            TreeNode node = new TreeNode(val);
            root.right = node;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }

    /**
     * ���������ַ���?s1��s2��s3�������æ��֤?s3?�Ƿ�����?s1?��?s2 ���� ��ɵġ�
     * �����ַ��� s �� t ���� �Ķ�����������£�����ÿ���ַ������ᱻ�ָ������ �ǿ� ���ַ�����
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * ���� �� s1 + t1 + s2 + t2 + s3 + t3 + ... ���� t1 + s1 + t2 + s2 + t3 + s3 + ...
     * ע�⣺a + b ��ζ���ַ��� a �� b ���ӡ�
     * ʾ�� 1��
     * ���룺s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * �����true
     * ʾ�� 2��
     * ���룺s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * �����false
     * ʾ�� 3��
     * ���룺s1 = "", s2 = "", s3 = ""
     * �����true
     * 0 <= s1.length, s2.length <= 100
     * 0 <= s3.length <= 200
     * s1��s2���� s3 ����СдӢ����ĸ���
     * ���ף����ܷ��ʹ�� O(s2.length) ������ڴ�ռ��������?
     */

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }
        int[][] fn = new int[s1.length() + 1][s2.length() + 1];
        fn[0][0] = 1;
        for (int i = 1; i <= fn.length; i++) {
            if (s1.substring(0, i - 1).equals(s3.substring(0, i - 1))) {
                fn[i - 1][0] = 1;
            }
        }
        for (int i = 1; i <= fn[0].length; i++) {
            if (s2.substring(0, i - 1).equals(s3.substring(0, i - 1))) {
                fn[0][i - 1] = 1;
            }
        }
        for (int i = 1; i < fn.length; i++) {
            for (int j = 1; j < fn[i].length; j++) {
                if (fn[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    fn[i][j] = 1;
                }
                if (fn[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    fn[i][j] = 1;
                }
            }
        }
        if (fn[s1.length()][s2.length()] == 1) {
            return true;
        }
        return false;
    }

    /**
     * ����һ���������� prices ������?prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
     * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ��?���?
     * ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
     * ���� ���ܻ�õ� ��� ����?��
     * ʾ�� 1��
     * ���룺prices = [7,1,5,3,6,4]
     * �����7
     * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5 - 1 = 4 ��
     * ?    ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6 - 3 = 3 ��
     * ������Ϊ 4 + 3 = 7 ��
     * ʾ�� 2��
     * ���룺prices = [1,2,3,4,5]
     * �����4
     * ���ͣ��ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5 - 1 = 4 ��
     * ?    ������Ϊ 4 ��
     * ʾ��?3��
     * ���룺prices = [7,6,4,3,1]
     * �����0
     * ���ͣ������������, �����޷�������������Բ����뽻�׿��Ի����������������Ϊ 0 ��
     * ��ʾ��
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int[][] fn = new int[prices.length][prices.length];
        for (int i = 0; i < fn.length; i++) {
            for (int j = 0; j < fn[i].length; j++) {
                if (i >= j) {
                    continue;
                }

            }
        }
        return max;
    }
}
