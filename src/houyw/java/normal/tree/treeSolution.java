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
     * ����һ�ö������ĸ��ڵ�?root �����ҳ��ö�������ÿһ������ֵ��
     * ʾ��1��
     * ����: root = [1,3,2,5,3,null,9]
     * ���: [1,3,9]
     * ʾ��2��
     * ����: root = [1,2,3]
     * ���: [1,3]
     * ��ʾ��
     * �������Ľڵ�����ķ�Χ�� [0,104]
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
     * ����������ĸ��ڵ� root ��������ڵ�ֵ�� ������� ��
     * �������أ������ҷ������нڵ㣩��
     * ʾ�� 1��
     * ���룺root = [3,9,20,null,null,15,7]
     * �����[[3],[9,20],[15,7]]
     * ʾ�� 2��
     * <p>
     * ���룺root = [1]
     * �����[[1]]
     * ʾ�� 3��
     * <p>
     * ���룺root = []
     * �����[]
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
     * ����һ���� N �����Ķ������ĸ���� root�����е�ÿ������϶���Ӧ�� node.val öӲ�ң������ܹ��� N öӲ�ҡ�
     * ��һ���ƶ��У����ǿ���ѡ���������ڵĽ�㣬Ȼ��һöӲ�Ҵ�����һ������ƶ�����һ����㡣
     * (�ƶ������ǴӸ���㵽�ӽ�㣬���ߴ��ӽ���ƶ�������㡣)��
     * ����ʹÿ�������ֻ��һöӲ��������ƶ�������
     */

    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = distributeCoins(root.left);
        int right =  distributeCoins(root.right);

        int leftBu  = duoyu(root.left);
        int rightBu  = duoyu(root.right);
        //��ǰ��������Ĳ���
        int sum = leftBu+rightBu+root.val-1;

        return Math.abs(left)+ Math.abs(right)+ Math.abs(sum);
    }
    //��ɸ���֮���������ٲ�
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
