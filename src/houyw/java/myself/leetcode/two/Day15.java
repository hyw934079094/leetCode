package houyw.java.myself.leetcode.two;

import houyw.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/19 20:49
 * @Description:
 */
public class Day15 {

    /**
     * ����һ���������� ���ڵ� root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
     * ʾ�� 1:
     * ����:?[1,2,3,null,5,null,4]
     * ���:?[1,3,4]
     * ʾ�� 2:
     * ����:?[1,null,3]
     * ���:?[1,3]
     * ʾ�� 3:
     * ����:?[]
     * ���:?[]
     * ��ʾ:
     * �������Ľڵ�����ķ�Χ�� [0,100]
     * -100?<= Node.val <= 100?
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(list.size()>0){
            lst.add(list.get(list.size()-1).val);
            List<TreeNode> l = new ArrayList<>();
            for(TreeNode node: list){
                if(node.left!=null){
                    l.add(node.left);
                }
                if(node.right!=null){
                    l.add(node.right);
                }
            }
            list = l;

        }
        return lst;
    }
}
