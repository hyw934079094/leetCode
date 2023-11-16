package houyw.java.myself.think;
import houyw.common.ListNode;
import houyw.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: DELL
 * @Date: 2022/7/26 11:03
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 1;i<30;i++){
            ListNode next = new ListNode(i+1);
            node.next = next;
            node = next;
        }
        node.next = head;
        int index = 0;
        int count = 1;
        while(set.size()<14){

        }
        for(int i:set){
            System.out.print(i+" ");
        }
    }
}
