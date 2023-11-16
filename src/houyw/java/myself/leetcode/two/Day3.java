package houyw.java.myself.leetcode.two;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/7 21:40
 * @Description:
 */
public class Day3 {
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
     * 如果是，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：false
     * 提示：
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     * 进阶：你能否用?O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        for(int i = 0;i<list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }
    //进阶
    public boolean isPalindrome1(ListNode head) {
        while(head!=null){

            head = head.next;
        }
        return true;
    }

}
