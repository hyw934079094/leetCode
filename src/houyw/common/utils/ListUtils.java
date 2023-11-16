package houyw.common.utils;

import houyw.common.ListNode;

/**
 * @Author: houyw
 * @Date: 2021/3/29 11:29
 * @Description:
 */
public class ListUtils {
   //将数组转化成链表
   public static ListNode getlist(int[] arr) {
       if(arr.length ==0){
           return null;
       }
        ListNode node = new ListNode(arr[0]);
        ListNode node1 = node;
        for (int i = 1; i < arr.length; i++) {
            node1.next = new ListNode(arr[i]);
            node1 = node1.next;
        }

        return node;
    }


    //输出链表
    public static void printListNode(ListNode listNode){
        String head = "[";
        String end ="]";
        StringBuilder content = new StringBuilder("");
        if(listNode != null) {
            content.append(listNode.val);
            while (listNode.next != null) {
                listNode = listNode.next;
                content.append(",").append(listNode.val);
            }
        }

        System.out.println(head+content+end);
    }
}
