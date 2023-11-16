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
     * 将两个升序链表合并为一个新的 升序 链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。?
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
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
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * 提示：
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     */
    public ListNode reverseList(ListNode head) {
        //迭代
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
        //递归
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
