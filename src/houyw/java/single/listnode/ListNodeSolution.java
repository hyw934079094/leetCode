package houyw.java.single.listnode;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/3/17 16:46
 * @Description:
 */
public class ListNodeSolution {
    /**
     * ����һ�������ͷ�ڵ� head ��һ������ val ��
     * ����ɾ���������������� Node.val == val �Ľڵ㣬������ �µ�ͷ�ڵ� ��
     * complete
     * nice++
     */
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val == val){
            head = head.next;
        }
        if(head!=null){

            ListNode node = head.next;
            ListNode beforeNode = head;
            while(node!=null){
                if(node.val == val){
                    beforeNode.next = node.next;
                }else{
                    beforeNode = node;
                }
                node = node.next;
            }
        }
        return head;
    }

    /**
     * ���������������ͷ�ڵ�?headA �� headB �������ҳ������������������ཻ����ʼ�ڵ㡣����������������ཻ�ڵ㣬���� null ��
     * ͼʾ���������ڽڵ� c1 ��ʼ�ཻ��
     * ��Ŀ���� ��֤ ������ʽ�ṹ�в����ڻ���
     * ע�⣬�������ؽ����������� ������ԭʼ�ṹ ��
     * �Զ������⣺
     * intersectVal - �ཻ����ʼ�ڵ��ֵ������������ཻ�ڵ㣬��һֵΪ 0
     * listA - ��һ������
     * listB - �ڶ�������
     * skipA - �� listA �У���ͷ�ڵ㿪ʼ����������ڵ�Ľڵ���
     * skipB - �� listB �У���ͷ�ڵ㿪ʼ����������ڵ�Ľڵ���
     * ����ϵͳ��������Щ���봴����ʽ���ݽṹ����������ͷ�ڵ� headA �� headB ���ݸ���ĳ���
     * ��������ܹ���ȷ�����ཻ�ڵ㣬��ô��Ľ���������� ������ȷ�� ��
     * ʾ�� 1��
     * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * �����Intersected at '8'
     * ���ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬������������ཻ����Ϊ 0����
     * �Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,6,1,8,4,5]��
     * �� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
     * �� ��ע���ཻ�ڵ��ֵ��Ϊ 1����Ϊ������ A ������ B ֮��ֵΪ 1 �Ľڵ� (A �еڶ����ڵ�� B �е������ڵ�) �ǲ�ͬ�Ľڵ㡣���仰˵���������ڴ���ָ��������ͬ��λ�ã������� A ������ B ��ֵΪ 8 �Ľڵ� (A �е������ڵ㣬B �е��ĸ��ڵ�) ���ڴ���ָ����ͬ��λ�á�
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> list = new ArrayList<>();
        while(headA!=null){
            list.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(list.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
