package houyw.java.myself.suanfa;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/20 16:13
 * @Description:
 */
public class Day10 {
    public static void main(String[] args) {
        Day10 day = new Day10();
        int[] nums = {};
        ListNode getlist = ListUtils.getlist(nums);
        ListNode listNode = day.reverseList(getlist);
        ListUtils.printListNode(listNode);
    }
    /**
     * ��������������ϲ�Ϊһ���µ� ���� �������ء�
     * ��������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�?
     * ʾ�� 1��
     * ���룺l1 = [1,2,4], l2 = [1,3,4]
     * �����[1,1,2,3,4,4]
     * ʾ�� 2��
     * ���룺l1 = [], l2 = []
     * �����[]
     * ʾ�� 3��
     * ���룺l1 = [], l2 = [0]
     * �����[0]
     * ��ʾ��
     * ��������Ľڵ���Ŀ��Χ�� [0, 50]
     * -100 <= Node.val <= 100
     * l1 �� l2 ���� �ǵݼ�˳�� ����
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        while(list1!=null){
            list.add(list1);
            list1 = list1.next;
        }
        while(list2!=null){
            list.add(list2);
            list2 = list2.next;
        }
        if(list.size() == 0){
            return  list1;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);
    }

    /**
     * ���㵥�����ͷ�ڵ� head �����㷴ת���������ط�ת�������
     * ʾ�� 1��
     * ���룺head = [1,2,3,4,5]
     * �����[5,4,3,2,1]
     * ʾ�� 2��
     * ���룺head = [1,2]
     * �����[2,1]
     * ʾ�� 3��
     * ���룺head = []
     * �����[]
     * ��ʾ��
     * �����нڵ����Ŀ��Χ�� [0, 5000]
     * -5000 <= Node.val <= 5000
     * ���ף��������ѡ�õ�����ݹ鷽ʽ��ɷ�ת�����ܷ������ַ����������⣿
     */
    public ListNode reverseList(ListNode head) {
        //����
        /*if(head !=null){
            ListNode node = head.next;
            if(node == null){
                return head;
            }else{
                head.next = null;
            }
            while(node!=null){
                ListNode next = node.next;
                node.next = head;
                head = node;
                if(next!=null){
                    node = next;
                }else{
                    return  node;
                }
            }
        }
        return head;*/
        //�ݹ�
        if(head!=null){
            ListNode next = head.next;
            if(next == null){
                return head;
            }else{
                head.next = null;
            }
            ListNode listNode = reverseList(next);
            next.next = head;
            return listNode;
        }
        return head;
    }
}
