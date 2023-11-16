package houyw.java.myself.suanfa;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/15 17:16
 * @Description:
 */
public class Day5 {
    public static void main(String[] args) {
        Day5 day = new Day5();
        int[] arr = new int[]{1,2,3,4,5,6};
        ListNode head = ListUtils.getlist(arr);
        //ListUtils.printListNode(day.middleNode(head));


        ListUtils.printListNode(day.removeNthFromEnd(head,1));
    }

    /**
     * ����һ��ͷ���Ϊ head?�ķǿյ���������������м��㡣
     * ����������м��㣬�򷵻صڶ����м��㡣
     * ʾ�� 1��
     * ���룺[1,2,3,4,5]
     * ��������б��еĽ�� 3 (���л���ʽ��[3,4,5])
     * ���صĽ��ֵΪ 3 �� (����ϵͳ�Ըý�����л������� [3,4,5])��
     * ע�⣬���Ƿ�����һ�� ListNode ���͵Ķ��� ans��������
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, �Լ� ans.next.next.next = NULL.
     * ʾ��?2��
     *
     * ���룺[1,2,3,4,5,6]
     * ��������б��еĽ�� 4 (���л���ʽ��[4,5,6])
     * ���ڸ��б��������м��㣬ֵ�ֱ�Ϊ 3 �� 4�����Ƿ��صڶ�����㡣
     * ��ʾ��
     * ��������Ľ��������?1?��?100?֮�䡣
     */
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode node = head;
        while(node.next!=null){
            node = node.next;
            list.add(node);
        }
        int index = list.size()/2;
        return list.get(index);
    }

    /**
     * ����һ������ɾ������ĵ�����?n?����㣬���ҷ��������ͷ��㡣
     * ʾ�� 1��
     * ���룺head = [1,2,3,4,5], n = 2
     * �����[1,2,3,5]
     * ʾ�� 2��
     * ���룺head = [1], n = 1
     * �����[]
     * ʾ�� 3��
     * ���룺head = [1,2], n = 1
     * �����[1]
     * ��ʾ��
     * �����н�����ĿΪ sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode node = head;
        while(node.next!=null){
            node = node.next;
            list.add(node);
        }
        int index = list.size()-n;
        if(index ==0){
            return head.next;
        }else{
            list.get(index-1).next = list.get(index).next;
        }
        return head;
    }
}
