package houyw.java.normal.tree;

import houyw.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/24 15:26
 * @Description:
 */
public class treeSolution {
    /**
     * 给定一棵二叉树的根节点?root ，请找出该二叉树中每一层的最大值。
     * 示例1：
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     * 示例2：
     * 输入: root = [1,2,3]
     * 输出: [1,3]
     * 提示：
     * 二叉树的节点个数的范围是 [0,104]
     * -231?<= Node.val <= 231?- 1
     * complete
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            boolean flag = true;
            while (flag) {
                List<TreeNode> l = new ArrayList<>();
                int max = list.get(0).val;
                for (TreeNode node : list) {
                    if (node != null) {
                        if (node.left != null) {
                            l.add(node.left);
                        }
                        if (node.right != null) {
                            l.add(node.right);
                        }
                        if (node.val > max) {
                            max = node.val;
                        }
                    }
                }
                lst.add(max);
                if (l.size() == 0) {
                    flag = false;
                } else {
                    list = l;
                }
            }
        }
        return lst;
    }

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
     * （即逐层地，从左到右访问所有节点）。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            List<TreeNode> lst = new ArrayList<>();
            lst.add(root);
            while (lst.size() > 0) {
                List<Integer> l = new ArrayList<>();
                List<TreeNode> newlst = new ArrayList<>();
                for (TreeNode node : lst) {
                    l.add(node.val);
                    if (node.left != null) {
                        newlst.add(node.left);
                    }
                    if (node.right != null) {
                        newlst.add(node.right);
                    }
                }
                list.add(l);
                lst = newlst;
            }
        }
        return list;
    }


    /**
     * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
     * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
     * 返回使每个结点上只有一枚硬币所需的移动次数。
     */

    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = distributeCoins(root.left);
        int right =  distributeCoins(root.right);

        int leftBu  = duoyu(root.left);
        int rightBu  = duoyu(root.right);
        //当前树多出来的步数
        int sum = leftBu+rightBu+root.val-1;

        return Math.abs(left)+ Math.abs(right)+ Math.abs(sum);
    }
    //完成该树之后多出来多少步
    public int duoyu(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = duoyu(root.left);
        int right = duoyu(root.right);
        int val = root.val+left+right;
        return val-1;
    }
}
