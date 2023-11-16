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
     * 给你二叉树的根节点 root ，返回它节点值的?前序?遍历和后序遍历。
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
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     * 示例 1：
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     * 示例 2：
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
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
     * 给定一个二叉树，判断它是否是高度平衡的二叉树
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
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * 只有给定的树是单值二叉树时，才返回?true；否则返回 false。
     * 示例 1：
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
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
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
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
     * 给你两棵二叉树： root1 和 root2 。
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
     * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：
     * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
     * 否则，不为 null 的节点将直接作为新二叉树的节点。
     * 返回合并后的二叉树。
     * 注意: 合并过程必须从两个树的根节点开始。
     * 示例 1：
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     * 示例 2：
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
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
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 示例 2：
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
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
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * 示例 :
     * 给定二叉树
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回?3, 它的长度是路径 [4,2,1,3] 或者?[5,2,1,3]。
     * complete
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //经过当前节点的最大值为左指数的深度加右子数的最大深度再加1
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
     * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
     * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * 整个树 的坡度就是其所有节点的坡度之和。
     * 示例 1：
     * 输入：root = [1,2,3]
     * 输出：1
     * 解释：
     * 节点 2 的坡度：|0-0| = 0（没有子节点）
     * 节点 3 的坡度：|0-0| = 0（没有子节点）
     * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
     * 坡度总和：0 + 0 + 1 = 1
     * 示例 2：
     * 输入：root = [4,2,9,3,5,null,7]
     * 输出：15
     * 解释：
     * 节点 3 的坡度：|0-0| = 0（没有子节点）
     * 节点 5 的坡度：|0-0| = 0（没有子节点）
     * 节点 7 的坡度：|0-0| = 0（没有子节点）
     * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
     * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
     * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
     * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
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
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     * 示例 1：
     * 输入：root = [1,2,3,4], x = 4, y = 3
     * 输出：false
     * 示例 2：
     * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
     * 输出：true
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
     * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，
     * 返回构造出的字符串。
     * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系
     * 的空括号对。
     * 示例 1：
     * 输入：root = [1,2,3,4]
     * 输出："1(2(4))(3)"
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
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     * 示例 2：
     * 输入：root = [1]
     * 输出：["1"]
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
     * 给定二叉搜索树的根结点?root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     * 示例 1：
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     * 示例 2：
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * 输出：23
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
     * 给定一个非空二叉树的根节点?root?, 以数组的形式返回每一层节点的平均值。
     * 与实际答案相差?10的-5次方 以内的答案可以被接受。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[3.00000,14.50000,11.00000]
     * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
     * 因此返回 [3, 14.5, 11] 。
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
     * 给定二叉搜索树（BST）的根节点?root?和一个整数值?val。
     * 你需要在 BST 中找到节点值等于?val?的节点。
     * 返回以该节点为根的子树。 如果节点不存在，则返回?null?。
     * 示例 1:
     * 输入：root = [4,2,7,1,3], val = 2
     * 输出：[2,1,3]
     * Example 2:
     * 输入：root = [4,2,7,1,3], val = 5
     * 输出：[]
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
     * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，
     * 找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     * 如果树中有不止一个众数，可以按 任意顺序 返回。
     * 假定 BST 满足如下定义：
     * 结点左子树中所含节点的值 小于等于 当前节点的值
     * 结点右子树中所含节点的值 大于等于 当前节点的值
     * 左子树和右子树都是二叉搜索树
     * 示例 1：
     * 输入：root = [1,null,2,2]
     * 输出：[2]
     * 示例 2：
     * 输入：root = [0]
     * 输出：[0]
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
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为?2?或?0。
     * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     * 更正式地说，即?root.val = min(root.left.val, root.right.val) 总成立。
     * 给出这样的一个二叉树，你需要输出所有节点中的?第二小的值 。
     * 如果第二小的值不存在的话，输出 -1 。
     * 示例 1：
     * 输入：root = [2,2,5,null,null,5,7]
     * 输出：5
     * 解释：最小的值是 2 ，第二小的值是 5 。
     * 示例 2：
     * 输入：root = [2,2,2]
     * 输出：-1
     * 解释：最小的值是 2, 但是不存在第二小的值。
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
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * 示例 1：
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     * 示例 2：
     * 输入：root = [1,0,48,null,null,12,49]
     * 输出：1
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
     * 给出一棵二叉树，其上每个结点的值都是?0?或?1?。
     * 每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为?0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数?01101，也就是?13?。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * 示例 1：
     * 输入：root = [1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * 示例 2：
     * 输入：root = [0]
     * 输出：0
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
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     * 示例 1：
     * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
     * 输出：true
     * 示例 2：
     * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * 输出：false
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
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足
     * x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
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
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 示例 1：
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
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
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树?[1,2,2,3,4,4,3] 是对称的。
     * ? ? 1
     * ? ?/ \
     * ? 2 ? 2
     * ?/ \ / \
     * 3 ?4 4 ?3
     * 但是下面这个?[1,2,2,null,3,null,3] 则不是镜像对称的:
     * ? ? 1
     * ? ?/ \
     * ? 2 ? 2
     * ? ?\ ? \
     * ? ?3 ? ?3
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
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
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明:?叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度?3 。
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
     * 给你一棵二叉搜索树，请?按中序遍历 将其重新排列为一棵递增顺序搜索树，
     * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
     * 示例 1：
     * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     * 示例 2：
     * 输入：root = [5,1,7]
     * 输出：[1,null,5,null,7]
     * 提示：
     * 树中节点数的取值范围是 [1, 100]
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
