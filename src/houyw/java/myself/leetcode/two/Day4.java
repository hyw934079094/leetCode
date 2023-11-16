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
     * 给定单链表的头节点?head?，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，
     * 然后返回重新排序的列表。
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为?偶数 ，以此类推。
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * 你必须在?O(1)?的额外空间复杂度和?O(n)?的时间复杂度下解决这个问题。
     * 示例 1:
     * 输入: head = [1,2,3,4,5]
     * 输出:?[1,3,5,2,4]
     * 示例 2:
     * 输入: head = [2,1,3,5,6,4,7]
     * 输出: [2,3,6,7,1,5,4]
     * <p>
     * 提示:
     * n ==? 链表中的节点数
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
            //偶数的下一个是奇数,奇数的下一个是偶数
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
     * 给你链表的头结点?head?，请将其按 升序 排列并返回 排序后的链表 。
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * 提示：
     * 链表中节点的数目在范围?[0, 5 * 104]?内
     * -105?<= Node.val <= 105
     * 进阶：你可以在?O(n?log?n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
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
