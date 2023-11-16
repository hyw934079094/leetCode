package houyw.java.normal.listnode;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/27 20:35
 * @Description:
 */
public class LostNodeSolution {
    /**
     * 链表交换
     * 给你一个链表，两两交换节点
     * [1,2,3,4]===>[2,1,4,3]
     * [1,2,3] ===>[2,1,3]
     * [2]===>[2]
     * []===>[]
     * complete
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = head.next.next;
        node = swapPairs(node);
        newHead.next = head;
        head.next = node;
        return newHead;
    }

    /**
     * 给你两个?非空 的链表，表示两个非负的整数。
     * 它们每位数字都是按照?逆序?的方式存储的，并且每个节点只能存储?一位?数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0?开头。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int wei = 0;
        int val1 = 0;
        int val2 = 0;
        while (l1 != null || l2 != null ||wei>0) {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }else{
                val1 = 0;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }else{
                val2 = 0;
            }
            int sum = val1 + val2 + wei;
            if (sum >= 10) {
                wei = 1;
                sum -= 10;
            } else {
                wei = 0;
            }
            node.val = sum;
            if(l1 != null || l2 != null ||wei>0){
                ListNode next = new ListNode();
                node.next = next;
                node = next;
            }
        }
        return head;
    }
    public List<String> braceExpansionII(String expression) {
        List<String> list = new ArrayList<>();

        return list;
    }
    /*public List<List<String>> braceExpansionII(String expression) {
        List<String> list = new ArrayList<>();

        return list;
    }*/



    public static void main(String[] args) {

    }
}
