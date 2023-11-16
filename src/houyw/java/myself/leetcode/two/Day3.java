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
     * ����һ���������ͷ�ڵ� head �������жϸ������Ƿ�Ϊ��������
     * ����ǣ����� true �����򣬷��� false ��
     * ʾ�� 1��
     * ���룺head = [1,2,2,1]
     * �����true
     * ʾ�� 2��
     * ���룺head = [1,2]
     * �����false
     * ��ʾ��
     * �����нڵ���Ŀ�ڷ�Χ[1, 105] ��
     * 0 <= Node.val <= 9
     * ���ף����ܷ���?O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
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
    //����
    public boolean isPalindrome1(ListNode head) {
        while(head!=null){

            head = head.next;
        }
        return true;
    }

}
