package houyw.java.myself.leetcode.one;

import houyw.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/28 11:12
 * @Description:
 */
public class Day6 {
    /**
     * ����һ�� n?�����ĸ��ڵ� ?root?������ ��ڵ�ֵ�� ǰ����� ��
     * n ���� �������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵ null �ָ�����μ�ʾ������
     * ʾ�� 1��
     * ���룺root = [1,null,3,2,4,null,5,6]
     * �����[1,3,5,6,2,4]
     * ʾ�� 2��
     * ���룺root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
     * �����[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
     * ?
     * ��ʾ��
     * �ڵ������ڷ�Χ?[0, 104]��
     * 0 <= Node.val <= 104
     * n �����ĸ߶�С�ڻ���� 1000
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.val);
            List<Node> children = root.children;
            for(int i = 0;i<children.size();i++){
                List<Integer>  lst =  preorder(children.get(i)) ;
                list.addAll(lst);
            }
        }
        return list;
    }
}
