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
     * ����һ���������ĸ��ڵ� root?����һ������ targetSum ����ö�������ڵ�ֵ֮�͵��� targetSum �� ·�� ����Ŀ��
     * ·�� ����Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
     * ʾ�� 1��
     * ���룺root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * �����3
     * ���ͣ��͵��� 8 ��·���� 3 ������ͼ��ʾ��
     * ʾ�� 2��
     * ���룺root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * �����3
     * ��ʾ:
     * �������Ľڵ�����ķ�Χ�� [0,1000]
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
