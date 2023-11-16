package houyw.java.myself.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/20 15:22
 * @Description:
 */
public class Day8 {

    /**
     * ����һ��?����������?��������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣�������������£�
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
     * ��ʼ״̬�£�����?next ָ�붼������Ϊ NULL��
     * ʾ�� 1��
     * ���룺root = [1,2,3,4,5,6,7]
     * �����[1,#,2,3,#,4,5,6,7,#]
     * ���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ�����л������������������У�ͬһ��ڵ��� next ָ�����ӣ�'#' ��־��ÿһ��Ľ�����
     * ʾ�� 2:
     * ���룺root = []
     * �����[]
     * ��ʾ��
     * ���нڵ��������?[0, 212?- 1]?��Χ��
     * -1000 <= node.val <= 1000
     * ���ף�
     * ��ֻ��ʹ�ó���������ռ䡣
     * ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�
     */

    public Node connect(Node root) {
        if(root!=null){
            if(root.left!=null){
                root.left.next = root.right;
                if(root.left.left!=null){
                    root.left.right.next = root.right.left;
                }
                connect(root.left);
                connect(root.right);
            }
        }
        /*if (root != null) {
            List<Node> list = new ArrayList<>();
            list.add(root);
            while (list.get(0).left != null) {
                List<Node> list2 = new ArrayList<>();
                for (Node node : list) {
                    list2.add(node.left);
                    list2.add(node.right);
                }
                for (int i = 0; i < list2.size() - 1; i++) {
                    list2.get(i).next = list2.get(i + 1);
                }
                list = list2;
            }
        }*/
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
