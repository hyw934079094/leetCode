package houyw.java.myself.leetcode.two;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/8 09:49
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        int[] arr = {1, 2,3};
        ListNode getlist = ListUtils.getlist(arr);
        Day4 day = new Day4();
        ListNode listNode = day.oddEvenList(getlist);
        ListUtils.printListNode(listNode);

    }

    /**
     * �����������ͷ�ڵ�?head?������������Ϊ�����Ľڵ������Ϊż���Ľڵ�ֱ������һ��
     * Ȼ�󷵻�����������б�
     * ��һ���ڵ����������Ϊ�� ���� �� �ڶ����ڵ������Ϊ?ż�� ���Դ����ơ�
     * ��ע�⣬ż������������ڲ������˳��Ӧ��������ʱ����һ�¡�
     * �������?O(1)?�Ķ���ռ临�ӶȺ�?O(n)?��ʱ�临�Ӷ��½��������⡣
     * ʾ�� 1:
     * ����: head = [1,2,3,4,5]
     * ���:?[1,3,5,2,4]
     * ʾ�� 2:
     * ����: head = [2,1,3,5,6,4,7]
     * ���: [2,3,6,7,1,5,4]
     * <p>
     * ��ʾ:
     * n ==? �����еĽڵ���
     * 0 <= n <= 104
     * -106?<= Node.val <= 106
     */


    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode head1 = head;
        ListNode node1 = head.next;
        ListNode node = head.next;
        while (head1 != null && node != null) {
            //ż������һ��������,��������һ����ż��
            head1.next = node.next;
            if (head1.next == null) {
                break;
            }
            head1 = head1.next;
            node.next = head1.next;
            node = node.next;
        }
        head1.next = node1;
        return head;
    }

    /**
     * ���������ͷ���?head?���뽫�䰴 ���� ���в����� ���������� ��
     * ʾ�� 1��
     * ���룺head = [4,2,1,3]
     * �����[1,2,3,4]
     * ʾ�� 2��
     * ���룺head = [-1,5,3,4,0]
     * �����[-1,0,3,4,5]
     * ʾ�� 3��
     * ���룺head = []
     * �����[]
     * ��ʾ��
     * �����нڵ����Ŀ�ڷ�Χ?[0, 5 * 104]?��
     * -105?<= Node.val <= 105
     * ���ף��������?O(n?log?n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£����������������
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
