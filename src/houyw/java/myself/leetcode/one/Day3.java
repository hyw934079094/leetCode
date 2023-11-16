package houyw.java.myself.leetcode.one;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/27 09:58
 * @Description:
 */
public class Day3 {
    /**
     * 142
     * ����һ�������ͷ�ڵ� ?head?����������ʼ�뻷�ĵ�һ���ڵ㡣?
     * ��������޻����򷵻�?null��
     * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ���
     * Ϊ�˱�ʾ���������еĻ�������ϵͳ�ڲ�ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ������� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
     * �������޸� ����
     * ʾ�� 1��
     * ���룺head = [3,2,0,-4], pos = 1
     * �������������Ϊ 1 ������ڵ�
     * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
     * ʾ��?2��
     * ���룺head = [1,2], pos = 0
     * �������������Ϊ 0 ������ڵ�
     * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
     * ʾ�� 3��
     * ���룺head = [1], pos = -1
     * ��������� null
     * ���ͣ�������û�л���
     * ��ʾ��
     * �����нڵ����Ŀ��Χ�ڷ�Χ [0, 104] ��
     * -105 <= Node.val <= 105
     * pos ��ֵΪ -1 ���������е�һ����Ч����
     * ���ף����Ƿ����ʹ�� O(1) �ռ������⣿
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while(head.next!=null){
            if(list.contains(head.next)){
                return head.next;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }
}
