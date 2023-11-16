package houyw.java.myself.leetcode.two;

import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;

/**
 * @Author: DELL
 * @Date: 2022/7/11 09:41
 * @Description:
 */
public class Day7 {
    public static void main(String[] args) {
        Day7 day = new Day7();
        Integer[] ints = {1, -2, -3, 1, 3, -2, null, -1};
        TreeNode treeNode = TreeUtils.transferToTreeNode(ints);
        System.out.println(day.pathSum(treeNode, -2));
    }

    /**
     * 1
     * -2       -3
     * 1    3    -2
     * -1
     * 给定一个二叉树的根节点 root?，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 示例 1：
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     * 示例 2：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：3
     * 提示:
     * 二叉树的节点个数的范围是 [0,1000]
     * -109?<= Node.val <= 109?
     * -1000?<= targetSum?<= 1000?
     */

    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if (root != null) {
            if (root.val == targetSum) {
                count++;
            }
            count += pathSum1(root.left, targetSum - root.val);
            count += pathSum1(root.right, targetSum - root.val);
            count += pathSum(root.left, targetSum);
            count += pathSum(root.right, targetSum);
        }
        return count;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        int count = 0;
        if (root != null) {
            if (root.val == targetSum) {
                count++;
            }
            count += pathSum1(root.left, targetSum - root.val);
            count += pathSum1(root.right, targetSum - root.val);
        }
        return count;
    }

}
