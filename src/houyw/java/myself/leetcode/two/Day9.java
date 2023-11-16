package houyw.java.myself.leetcode.two;

import houyw.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/13 16:07
 * @Description:
 */
public class Day9 {


    /**
     * ����һ�������������ĸ��ڵ� root ����һ������ k ���������һ���㷨�������е�?k?����СԪ�أ��� 1 ��ʼ��������
     * ʾ�� 1��
     * ���룺root = [3,1,4,null,2], k = 1
     * �����1
     * ʾ�� 2��
     * ���룺root = [5,3,6,2,4,null,null,1], k = 3
     * �����3
     * ��ʾ��
     * ���еĽڵ���Ϊ n ��
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     * ���ף���������������������޸ģ�����/ɾ����������������ҪƵ���ز��ҵ� k С��ֵ���㽫����Ż��㷨��
     */
    //����ⷨ
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> lst = new ArrayList<>();
        lst.add(root);
        while (lst.size() != 0) {
            List<TreeNode> l = new ArrayList<>();
            for (TreeNode node : lst) {
                list.add(node.val);
                if (node.left != null) {
                    l.add(node.left);
                }
                if (node.right != null) {
                    l.add(node.right);
                }
            }
            lst = l;
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    //���׽ⷨ
    public int kthSmallest1(TreeNode root, int k) {
        List<TreeNode> lst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while(root.left!=null){
            lst.add(root);
            root = root.left;
        }
        list.add(root.val);
        while(root.right!=null){

        }
        return 0;
    }



    /**
     * ʵ��һ��������������������BSTIterator ����ʾһ�����������������������BST���ĵ�������
     * BSTIterator(TreeNode root) ��ʼ�� BSTIterator ���һ������BST �ĸ��ڵ� root ����Ϊ���캯����һ���ָ�����
     * ָ��Ӧ��ʼ��Ϊһ���������� BST �е����֣��Ҹ�����С�� BST �е��κ�Ԫ�ء�
     * boolean hasNext() �����ָ���Ҳ�����������֣��򷵻� true �����򷵻� false ��
     * int next()��ָ�������ƶ���Ȼ�󷵻�ָ�봦�����֡�
     * ע�⣬ָ���ʼ��Ϊһ���������� BST �е����֣����Զ� next() ���״ε��ý����� BST �е���СԪ�ء�
     * ����Լ���?next()?����������Ч�ģ�Ҳ����˵�������� next()?ʱ��BST ��������������ٴ���һ����һ�����֡�
     * ʾ����
     * ����
     * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
     * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
     * ���
     * [null, 3, 7, true, 9, true, 15, true, 20, false]
     * ����
     * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
     * bSTIterator.next();    // ���� 3
     * bSTIterator.next();    // ���� 7
     * bSTIterator.hasNext(); // ���� True
     * bSTIterator.next();    // ���� 9
     * bSTIterator.hasNext(); // ���� True
     * bSTIterator.next();    // ���� 15
     * bSTIterator.hasNext(); // ���� True
     * bSTIterator.next();    // ���� 20
     * bSTIterator.hasNext(); // ���� False
     * ��ʾ��
     * ���нڵ����Ŀ�ڷ�Χ [1, 105] ��
     * 0 <= Node.val <= 106
     * ������ 105 �� hasNext �� next ����
     * ���ף�
     * ��������һ���������������Ľ��������next() �� hasNext() ������̯ʱ�临�Ӷ�Ϊ O(1) ��
     * ��ʹ�� O(h) �ڴ档���� h �����ĸ߶ȡ�
     */
    class BSTIterator {
        public List<Integer> list;
        public int index;

        public BSTIterator(TreeNode root) {
            index = 0;
            list = new ArrayList<>();
            List<TreeNode> lst = new ArrayList<>();
            lst.add(root);
            while (lst.size() != 0) {
                List<TreeNode> l = new ArrayList<>();
                for (TreeNode node : lst) {
                    list.add(node.val);
                    if (node.left != null) {
                        l.add(node.left);
                    }
                    if (node.right != null) {
                        l.add(node.right);
                    }
                }
                lst = l;
            }
            Collections.sort(list);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            if (index < list.size()) {
                return true;
            }
            return false;
        }
    }
}
