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
     * 给定一个头结点为 head?的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例?2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * 提示：
     * 给定链表的结点数介于?1?和?100?之间。
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
     * 给你一个链表，删除链表的倒数第?n?个结点，并且返回链表的头结点。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * 提示：
     * 链表中结点的数目为 sz
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
