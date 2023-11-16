package houyw.java.myself.leetcode.one;

import houyw.common.TreeNode;
import houyw.common.utils.TreeUtils;

/**
 * @Author: DELL
 * @Date: 2022/6/30 10:44
 * @Description:
 */
public class Day7 {
    public static void main(String[] args) {
        Day7 day = new Day7();
        Integer[] nums = {120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
        TreeNode treeNode = TreeUtils.transferToTreeNode(nums);
        boolean validBST = day.isValidBST(treeNode);
        System.out.println(day.minVal(treeNode.right));
        System.out.println(validBST);
    }

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1：
     * 输入：root = [2,1,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     * 提示：
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     */
    public boolean isValidBST(TreeNode root) {
        if(root.left == null &&root.right == null){
            return true;
        }
        boolean leftFlag ;
        boolean rightFlag;
        if(root.left != null){
            leftFlag = isValidBST(root.left)&& (maxVal(root.left)<root.val);
        }else{
            leftFlag = true;
        }
        if(root.right != null){
            rightFlag = isValidBST(root.right)&& (minVal(root.right)>root.val);
        }else{
            rightFlag = true;
        }
        return leftFlag && rightFlag;
    }

    public int maxVal(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            return Math.max(root.val, maxVal(root.right));
        }
        if (root.right == null) {
            return Math.max(root.val, maxVal(root.left));
        }
        return Math.max(Math.max(root.val, maxVal(root.left)), maxVal(root.right));
    }

    public int minVal(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            return Math.min(root.val, minVal(root.right));
        }
        if (root.right == null) {
            return Math.min(root.val, minVal(root.left));
        }
        return Math.min(Math.min(root.val, minVal(root.left)), minVal(root.right));
    }


}
