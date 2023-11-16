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
     * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
     * ��Ч �����������������£�
     * �ڵ��������ֻ���� С�� ��ǰ�ڵ������
     * �ڵ��������ֻ���� ���� ��ǰ�ڵ������
     * �������������������������Ҳ�Ƕ�����������
     * ʾ�� 1��
     * ���룺root = [2,1,3]
     * �����true
     * ʾ�� 2��
     * ���룺root = [5,1,4,null,null,3,6]
     * �����false
     * ���ͣ����ڵ��ֵ�� 5 ���������ӽڵ��ֵ�� 4 ��
     * ��ʾ��
     * ���нڵ���Ŀ��Χ��[1, 104] ��
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
