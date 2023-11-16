package houyw.java.single.treenode;

import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author: DELL
 * @Date: 2022/3/17 16:46
 * @Description:
 */
public class TreeNodeSolution {

    /**
     * ����������ĸ��ڵ� root ���������ڵ�ֵ��?ǰ��?�����ͺ��������
     * complete
     * nice+
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.add(root.val);
            lst.addAll(preorderTraversal(root.left));
            lst.addAll(preorderTraversal(root.right));
        }
        return lst;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.addAll(postorderTraversal(root.left));
            lst.addAll(postorderTraversal(root.right));
            lst.add(root.val);
        }
        return lst;
    }

    /**
     * ����һ���������� nums ������Ԫ���Ѿ��� ���� ���У����㽫��ת��Ϊһ�� �߶�ƽ�� ������������
     * �߶�ƽ�� ��������һ�����㡸ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ���Ķ�������
     * ʾ�� 1��
     * ���룺nums = [-10,-3,0,5,9]
     * �����[0,-3,9,-10,null,5]
     * ���ͣ�[0,-10,5,null,-3,null,9] Ҳ������Ϊ��ȷ�𰸣�
     * ʾ�� 2��
     * ���룺nums = [1,3]
     * �����[3,1]
     * ���ͣ�[1,null,3] �� [3,1] ���Ǹ߶�ƽ�������������
     * complete
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode();
        if (nums.length < 2) {
            if (nums.length == 1) {
                return new TreeNode(nums[0]);
            } else {
                return null;
            }
        } else {
            int root = nums.length / 2;
            head.val = nums[root];
            int[] leftNum = new int[root];
            int[] rightNum = new int[nums.length - root - 1];
            if (root > 0 && root < nums.length) {
                for (int i = 0; i < root; i++) {
                    leftNum[i] = nums[i];
                }
            }
            if (root + 1 < nums.length) {
                for (int j = root + 1; j < nums.length; j++) {
                    rightNum[j - root - 1] = nums[j];
                }
            }
            head.left = sortedArrayToBST(leftNum);
            head.right = sortedArrayToBST(rightNum);
        }
        return head;
    }

    /**
     * ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�����
     * complete
     */
    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            int left = TreeUtils.depth(root.left);
            int right = TreeUtils.depth(root.right);
            if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * ���������ÿ���ڵ㶼������ͬ��ֵ����ô�ö��������ǵ�ֵ��������
     * ֻ�и��������ǵ�ֵ������ʱ���ŷ���?true�����򷵻� false��
     * ʾ�� 1��
     * ���룺[1,1,1,1,1,null,1]
     * �����true
     * complete
     * nice
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        boolean left = true;
        boolean right = true;
        if (root.left != null) {
            left = isUnivalTree(root.left) && val == root.left.val;
        }
        if (root.right != null) {
            right = isUnivalTree(root.right) && val == root.right.val;
        }
        return left && right;
    }

    /**
     * ����һ�����������ҳ�����С��ȡ�
     * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
     * ˵����Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
     * complete
     */
    public int minDepth(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            } else if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            } else {
                int leftNum = minDepth(root.left);
                int rightNum = minDepth(root.right);
                if (leftNum > rightNum) {
                    return rightNum + 1;
                } else {
                    return leftNum + 1;
                }
            }
        }
        return 0;
    }

    /**
     * �������ö������� root1 �� root2 ��
     * ����һ�£����㽫����һ�ø��ǵ���һ��֮��ʱ���������ϵ�һЩ�ڵ㽫���ص�������һЩ���ᣩ��
     * ����Ҫ�����������ϲ���һ���¶��������ϲ��Ĺ����ǣ�
     * ��������ڵ��ص�����ô���������ڵ��ֵ�����Ϊ�ϲ���ڵ����ֵ��
     * ���򣬲�Ϊ null �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
     * ���غϲ���Ķ�������
     * ע��: �ϲ����̱�����������ĸ��ڵ㿪ʼ��
     * ʾ�� 1��
     * ���룺root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * �����[3,4,5,5,4,null,7]
     * ʾ�� 2��
     * ���룺root1 = [1], root2 = [1,2]
     * �����[2,2]
     * complete
     * perfect
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = new TreeNode();
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        node.val = root1.val + root2.val;
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    /**
     * ����һ�ö������ĸ��ڵ� root ����ת��ö�����������������ڵ㡣
     * ʾ�� 1��
     * ���룺root = [4,2,7,1,3,6,9]
     * �����[4,7,2,9,6,3,1]
     * ʾ�� 2��
     * ���룺root = [2,1,3]
     * �����[2,3,1]
     * complete
     * perfect
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
        }
        return root;
    }

    /**
     * ����һ�ö�����������Ҫ��������ֱ�����ȡ�
     * һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
     * ʾ�� :
     * ����������
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * ����?3, ���ĳ�����·�� [4,2,1,3] ����?[5,2,1,3]��
     * complete
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //������ǰ�ڵ�����ֵΪ��ָ������ȼ����������������ټ�1
        if (root != null) {
            int num = TreeUtils.depth(root.left) + TreeUtils.depth(root.right);
            int leftNum = diameterOfBinaryTree(root.left);
            int rightNum = diameterOfBinaryTree(root.right);
            int max = Math.max(leftNum, num);
            return Math.max(rightNum, max);
        }
        return 0;
    }

    /**
     * ����һ���������ĸ��ڵ� root �����㲢���� ������ ���¶� ��
     * һ������ �ڵ���¶� ���弴Ϊ���ýڵ��������Ľڵ�֮�ͺ��������ڵ�֮�͵� ��ľ���ֵ ��
     * ���û���������Ļ����������Ľڵ�֮��Ϊ 0 ��û���������Ļ�Ҳ��һ�����ս����¶��� 0 ��
     * ������ ���¶Ⱦ��������нڵ���¶�֮�͡�
     * ʾ�� 1��
     * ���룺root = [1,2,3]
     * �����1
     * ���ͣ�
     * �ڵ� 2 ���¶ȣ�|0-0| = 0��û���ӽڵ㣩
     * �ڵ� 3 ���¶ȣ�|0-0| = 0��û���ӽڵ㣩
     * �ڵ� 1 ���¶ȣ�|2-3| = 1���������������ӽڵ㣬���Ժ��� 2 ���������������ӽڵ㣬���Ժ��� 3 ��
     * �¶��ܺͣ�0 + 0 + 1 = 1
     * ʾ�� 2��
     * ���룺root = [4,2,9,3,5,null,7]
     * �����15
     * ���ͣ�
     * �ڵ� 3 ���¶ȣ�|0-0| = 0��û���ӽڵ㣩
     * �ڵ� 5 ���¶ȣ�|0-0| = 0��û���ӽڵ㣩
     * �ڵ� 7 ���¶ȣ�|0-0| = 0��û���ӽڵ㣩
     * �ڵ� 2 ���¶ȣ�|3-5| = 2���������������ӽڵ㣬���Ժ��� 3 ���������������ӽڵ㣬���Ժ��� 5 ��
     * �ڵ� 9 ���¶ȣ�|0-7| = 7��û�������������Ժ��� 0 �����������������ӽڵ㣬���Ժ��� 7 ��
     * �ڵ� 4 ���¶ȣ�|(3+5+2)-(9+7)| = |10-16| = 6��������ֵΪ 3��5 �� 2 ������ 10 ��������ֵΪ 9 �� 7 ������ 16 ��
     * �¶��ܺͣ�0 + 0 + 0 + 2 + 7 + 6 = 15
     */
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int num = Math.abs(sumVal(root.left) - sumVal(root.right));
            return num + findTilt(root.left) + findTilt(root.right);
        }
    }

    public int sumVal(TreeNode root) {
        if (root != null) {
            return root.val + sumVal(root.left) + sumVal(root.right);
        }
        return 0;
    }

    /**
     * �ڶ������У����ڵ�λ����� 0 ����ÿ�����Ϊ k �Ľڵ���ӽڵ�λ����� k+1 ����
     * ����������������ڵ������ͬ���� ���ڵ㲻ͬ ����������һ�����ֵܽڵ㡣
     * ���Ǹ����˾���Ψһֵ�Ķ������ĸ��ڵ� root ���Լ�����������ͬ�ڵ��ֵ x �� y ��
     * ֻ����ֵ x �� y ��Ӧ�Ľڵ������ֵܽڵ�ʱ���ŷ��� true �����򣬷��� false��
     * ʾ�� 1��
     * ���룺root = [1,2,3,4], x = 4, y = 3
     * �����false
     * ʾ�� 2��
     * ���룺root = [1,2,3,null,4,null,5], x = 5, y = 4
     * �����true
     * complete
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean flag = true;
        while (flag) {
            List<Integer> lst = new ArrayList<>();
            List<TreeNode> newList = new ArrayList<>();
            int count = 0;
            for (TreeNode node : list) {
                if (node != null) {
                    if (node.left == null && node.right == null) {
                        continue;
                    }
                    newList.add(node.left);
                    newList.add(node.right);
                    count++;
                    if (node.left != null && node.right != null) {
                        if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                            return false;
                        }
                    }
                    if (node.left != null) {
                        lst.add(node.left.val);
                    }
                    if (node.right != null) {
                        lst.add(node.right.val);
                    }

                }
            }
            if (lst.contains(x) || lst.contains(y)) {
                if (lst.contains(x) && lst.contains(y)) {
                    return true;
                } else {
                    return false;
                }
            }


            list = newList;
            if (count == 0) {
                flag = false;
            }
        }
        return false;
    }

    /**
     * ����������ĸ��ڵ� root ���������ǰ������ķ�ʽ����������ת��Ϊһ�������ź�������ɵ��ַ�����
     * ���ع�������ַ�����
     * �սڵ�ʹ��һ�Կ����Ŷ� "()" ��ʾ��ת������Ҫʡ�����в�Ӱ���ַ�����ԭʼ������֮���һ��һӳ���ϵ
     * �Ŀ����Ŷԡ�
     * ʾ�� 1��
     * ���룺root = [1,2,3,4]
     * �����"1(2(4))(3)"
     * complete
     */
    public String tree2str(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return root.val + "";
            }
            if (root.left == null && root.right != null) {
                return root.val + "()(" + tree2str(root.right) + ")";
            }
            if (root.left != null && root.right == null) {
                return root.val + "(" + tree2str(root.left) + ")";
            }
            return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        }
        return "()";
    }

    /**
     * ����һ���������ĸ��ڵ� root ���� ����˳�� ���������дӸ��ڵ㵽Ҷ�ӽڵ��·����
     * Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣
     * ʾ�� 1��
     * ���룺root = [1,2,3,null,5]
     * �����["1->2->5","1->3"]
     * ʾ�� 2��
     * ���룺root = [1]
     * �����["1"]
     * complete
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                lst.add(root.val + "");
                return lst;
            }
            List<String> lefts = binaryTreePaths(root.left);
            if (lefts != null && lefts.size() > 0) {
                for (String str : lefts) {
                    lst.add(root.val + "->" + str);
                }
            }
            List<String> rights = binaryTreePaths(root.right);
            if (rights != null && rights.size() > 0) {
                for (String str : rights) {
                    lst.add(root.val + "->" + str);
                }
            }
        }
        return lst;
    }

    /**
     * ���������������ĸ����?root������ֵλ�ڷ�Χ [low, high] ֮������н���ֵ�ĺ͡�
     * ʾ�� 1��
     * ���룺root = [10,5,15,3,7,null,18], low = 7, high = 15
     * �����32
     * ʾ�� 2��
     * ���룺root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * �����23
     * complete
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    /**
     * ����һ���ǿն������ĸ��ڵ�?root?, ���������ʽ����ÿһ��ڵ��ƽ��ֵ��
     * ��ʵ�ʴ����?10��-5�η� ���ڵĴ𰸿��Ա����ܡ�
     * ʾ�� 1��
     * ���룺root = [3,9,20,null,null,15,7]
     * �����[3.00000,14.50000,11.00000]
     * ���ͣ��� 0 ���ƽ��ֵΪ 3,�� 1 ���ƽ��ֵΪ 14.5,�� 2 ���ƽ��ֵΪ 11 ��
     * ��˷��� [3, 14.5, 11] ��
     * complete
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retList = new ArrayList<>();
        List<TreeNode> lst = new ArrayList<>();
        lst.add(root);
        boolean flag = true;
        while (flag) {
            List<TreeNode> lstNew = new ArrayList<>();
            if (lst.size() > 0) {
                long sum = 0;
                for (TreeNode node : lst) {
                    sum += node.val;
                    if (node.left != null) {
                        lstNew.add(node.left);
                    }
                    if (node.right != null) {
                        lstNew.add(node.right);
                    }
                }
                double dsum = sum;
                retList.add(dsum / lst.size());
            } else {
                flag = false;
            }
            lst = lstNew;
        }
        return retList;
    }

    /**
     * ����������������BST���ĸ��ڵ�?root?��һ������ֵ?val��
     * ����Ҫ�� BST ���ҵ��ڵ�ֵ����?val?�Ľڵ㡣
     * �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻�?null?��
     * ʾ�� 1:
     * ���룺root = [4,2,7,1,3], val = 2
     * �����[2,1,3]
     * Example 2:
     * ���룺root = [4,2,7,1,3], val = 5
     * �����[]
     * complete
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = null;
        if (root != null) {
            if (root.val == val) {
                node = root;
            } else {
                node = searchBST(root.left, val);
                if (node != null && node.val == val) {
                    return node;
                } else {
                    node = searchBST(root.right, val);
                    if (node != null && node.val == val) {
                        return node;
                    }
                }
            }
        }
        return node;
    }

    /**
     * ����һ�����ظ�ֵ�Ķ�����������BST���ĸ��ڵ� root ��
     * �ҳ������� BST �е����� ��������������Ƶ����ߵ�Ԫ�أ���
     * ��������в�ֹһ�����������԰� ����˳�� ���ء�
     * �ٶ� BST �������¶��壺
     * ����������������ڵ��ֵ С�ڵ��� ��ǰ�ڵ��ֵ
     * ����������������ڵ��ֵ ���ڵ��� ��ǰ�ڵ��ֵ
     * �����������������Ƕ���������
     * ʾ�� 1��
     * ���룺root = [1,null,2,2]
     * �����[2]
     * ʾ�� 2��
     * ���룺root = [0]
     * �����[0]
     * complete
     */
    public int[] findMode(TreeNode root) {
        List<Integer> allList = getAllElementVal(root);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < allList.size(); i++) {
            int num = allList.get(i);
            if (mp.getOrDefault(num, 0) != 0) {
                mp.put(num, mp.get(num) + 1);
            } else {
                mp.put(num, 1);
            }
        }
        int num = 0;
        Set<Integer> keys = mp.keySet();
        for (int key : keys) {
            if (mp.get(key) > num) {
                num = mp.get(key);
            }
        }
        List<Integer> rets = new ArrayList<>();
        for (int key : keys) {
            if (mp.get(key) == num) {
                rets.add(key);
            }
        }
        int[] retNum = new int[rets.size()];
        for (int i = 0; i < retNum.length; i++) {
            retNum[i] = rets.get(i);
        }
        return retNum;
    }

    public List<Integer> getAllElementVal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.add(root.val);
            List<Integer> leftVal = getAllElementVal(root.left);
            if (leftVal != null && leftVal.size() > 0) {
                lst.addAll(leftVal);
            }
            List<Integer> rightVal = getAllElementVal(root.right);
            if (rightVal != null && rightVal.size() > 0) {
                lst.addAll(rightVal);
            }
        }
        return lst;
    }

    /**
     * ����һ���ǿ�����Ķ�������ÿ���ڵ㶼������������ÿ���ڵ���ӽڵ�����ֻ��Ϊ?2?��?0��
     * ���һ���ڵ��������ӽڵ�Ļ�����ô�ýڵ��ֵ���������ӽڵ��н�С��һ����
     * ����ʽ��˵����?root.val = min(root.left.val, root.right.val) �ܳ�����
     * ����������һ��������������Ҫ������нڵ��е�?�ڶ�С��ֵ ��
     * ����ڶ�С��ֵ�����ڵĻ������ -1 ��
     * ʾ�� 1��
     * ���룺root = [2,2,5,null,null,5,7]
     * �����5
     * ���ͣ���С��ֵ�� 2 ���ڶ�С��ֵ�� 5 ��
     * ʾ�� 2��
     * ���룺root = [2,2,2]
     * �����-1
     * ���ͣ���С��ֵ�� 2, ���ǲ����ڵڶ�С��ֵ��
     */
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> allElementVal = getAllElementValOnly(root);

        if (allElementVal != null && allElementVal.size() > 0) {
            if (allElementVal.size() > 1) {
                int[] arrs = new int[allElementVal.size()];
                int index = 0;
                for (int num : allElementVal) {
                    arrs[index] = num;
                    index++;
                }
                Arrays.sort(arrs);
                return arrs[1];
            }
        }
        return -1;
    }

    public Set<Integer> getAllElementValOnly(TreeNode root) {
        Set<Integer> lst = new HashSet<Integer>();
        if (root != null) {
            lst.add(root.val);
            Set<Integer> leftVal = getAllElementValOnly(root.left);
            if (leftVal != null && leftVal.size() > 0) {
                lst.addAll(leftVal);
            }
            Set<Integer> rightVal = getAllElementValOnly(root.right);
            if (rightVal != null && rightVal.size() > 0) {
                lst.addAll(rightVal);
            }
        }
        return lst;
    }

    /**
     * ����һ�������������ĸ��ڵ� root ������ ������������ͬ�ڵ�ֵ֮�����С��ֵ ��
     * ��ֵ��һ������������ֵ������ֵ֮��ľ���ֵ��
     * ʾ�� 1��
     * ���룺root = [4,2,6,1,3]
     * �����1
     * ʾ�� 2��
     * ���룺root = [1,0,48,null,null,12,49]
     * �����1
     * complete
     */
    public int getMinimumDifference(TreeNode root) {
        Set<Integer> allElementVal = getAllElementValOnly(root);
        int[] arrs = new int[allElementVal.size()];
        int index = 0;
        for (int num : allElementVal) {
            arrs[index] = num;
            index++;
        }
        Arrays.sort(arrs);
        int num = arrs[1] - arrs[0];
        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i] - arrs[i - 1] < num) {
                num = arrs[i] - arrs[i - 1];
            }
        }
        return num;
    }

    /**
     * ����һ�ö�����������ÿ������ֵ����?0?��?1?��
     * ÿһ���Ӹ���Ҷ��·��������һ���������Чλ��ʼ�Ķ���������
     * ���磬���·��Ϊ?0 -> 1 -> 1 -> 0 -> 1����ô����ʾ��������?01101��Ҳ����?13?��
     * �����ϵ�ÿһƬҶ�ӣ����Ƕ�Ҫ�ҳ��Ӹ�����Ҷ�ӵ�·������ʾ�����֡�
     * ������Щ����֮�͡���Ŀ���ݱ�֤����һ�� 32 λ ������
     * ʾ�� 1��
     * ���룺root = [1,0,1,0,1,0,1]
     * �����22
     * ���ͣ�(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * ʾ�� 2��
     * ���룺root = [0]
     * �����0
     * complete
     */
    public int sumRootToLeaf(TreeNode root) {
        List<String> binary = binary(root);
        int num = 0;
        for (String ss : binary) {
            if (ss.contains("1")) {
                for (int i = ss.length() - 1; i >= 0; i--) {
                    int n = Integer.valueOf(String.valueOf(ss.charAt(i)));
                    if (n == 1) {
                        num = num + (int) Math.pow(2, ss.length() - 1 - i);
                    }
                }
            }
        }
        return num;
    }

    public List<String> binary(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                lst.add(root.val + "");
                return lst;
            }
            List<String> lefts = binary(root.left);
            if (lefts != null && lefts.size() > 0) {
                for (String str : lefts) {
                    lst.add(root.val + str);
                }
            }
            List<String> rights = binary(root.right);
            if (rights != null && rights.size() > 0) {
                for (String str : rights) {
                    lst.add(root.val + str);
                }
            }
        }
        return lst;
    }

    /**
     * �������ö����� root �� subRoot ������ root ���Ƿ������ subRoot ������ͬ�ṹ�ͽڵ�ֵ��������
     * ������ڣ����� true �����򣬷��� false ��
     * ������ tree ��һ���������� tree ��ĳ���ڵ������ڵ�����к���ڵ㡣tree Ҳ���Կ����������һ��������
     * ʾ�� 1��
     * ���룺root = [3,4,5,1,2], subRoot = [4,1,2]
     * �����true
     * ʾ�� 2��
     * ���룺root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * �����false
     * complete
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                if (isSametree(root, subRoot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }
        return false;
    }

    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
            }
        }
        return false;
    }

    /**
     * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
     * �����и��� T ��������� p��q������������ȱ�ʾΪһ����� x������
     * x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�
     * ���磬�������¶���������:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * ʾ�� 1:
     * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * ���: 6
     * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
     * ʾ�� 2:
     * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * ���: 2
     * ����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
     * complete
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    public List<Integer> getAllNode(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.addAll(getAllNode(root.left));
            lst.addAll(getAllNode(root.right));
            lst.add(root.val);
        }
        return lst;
    }

    /**
     * �����һ������������һ�����������ú���������ľ���
     * ʾ�� 1��
     * <p>
     * ���룺root = [4,2,7,1,3,6,9]
     * �����[4,7,2,9,6,3,1]
     * complete
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }

    /**
     * ��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
     * ���磬������?[1,2,2,3,4,4,3] �ǶԳƵġ�
     * ? ? 1
     * ? ?/ \
     * ? 2 ? 2
     * ?/ \ / \
     * 3 ?4 4 ?3
     * �����������?[1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
     * ? ? 1
     * ? ?/ \
     * ? 2 ? 2
     * ? ?\ ? \
     * ? ?3 ? ?3
     * ʾ�� 1��
     * ���룺root = [1,2,2,3,4,4,3]
     * �����true
     * ʾ�� 2��
     * ���룺root = [1,2,2,null,3,null,3]
     * �����false
     * complete
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val == right.val) {
                return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
            }
        }
        if (left == null && right == null) {
            return true;
        }
        return false;
    }
    /**
     * ����һ�����������ҳ��������ȡ�
     * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
     * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
     * ʾ����
     * ���������� [3,9,20,null,null,15,7]��
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * ��������������?3 ��
     * complete
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
    /**
     * ����һ�ö�������������?��������� ������������Ϊһ�õ���˳����������
     * ʹ��������ߵĽڵ��Ϊ���ĸ��ڵ㣬����ÿ���ڵ�û�����ӽڵ㣬ֻ��һ�����ӽڵ㡣
     * ʾ�� 1��
     * ���룺root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * �����[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     * ʾ�� 2��
     * ���룺root = [5,1,7]
     * �����[1,null,5,null,7]
     * ��ʾ��
     * ���нڵ�����ȡֵ��Χ�� [1, 100]
     * 0 <= Node.val <= 1000
     * complete
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> allNode = getAllNode(root);
        Collections.sort(allNode);
        TreeNode head = new TreeNode(allNode.get(0));
        TreeNode node = head;
        for(int i = 1 ;i< allNode.size();i++){
            TreeNode next = new TreeNode(allNode.get(i));
            node.right = next;
            node = next;
        }
        return head;
    }


}
