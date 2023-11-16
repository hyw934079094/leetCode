package houyw.java.myself.suanfa2;

import houyw.common.TNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/30 14:38
 * @Description:
 */
public class Day6 {
    /**
     * ����һ��������
     * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
     * ��ʼ״̬�£�����?next ָ�붼������Ϊ NULL��
     * ���ף�
     * ��ֻ��ʹ�ó���������ռ䡣
     * ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�
     * ʾ����
     * ���룺root = [1,2,3,4,5,null,7]
     * �����[1,#,2,3,#,4,5,7,#]
     * ���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ�����л�������������˳���� next ָ�����ӣ���'#' ��ʾÿ���ĩβ��
     * ��ʾ��
     * ���еĽڵ���С�� 6000
     * -100?<= node.val <= 100
     */

    public TNode connect(TNode root) {
        if(root == null){
            return root;
        }
        List<TNode> list = new ArrayList<>();
        List<TNode> lst = new ArrayList<>();
        list.add(root);
        while(list.size()>0){
            lst.clear();
            for (TNode node : list) {
                if(node.left!=null){
                    lst.add(node.left);
                }
                if(node.right!=null){
                    lst.add(node.right);
                }
                for(int i = 1;i<lst.size();i++){
                    lst.get(i-1).next = lst.get(i);
                }
            }
            list = lst;
        }
        return root;
    }
    //����
    public TNode connectBetter(TNode root) {
        return  null;
    }
}
