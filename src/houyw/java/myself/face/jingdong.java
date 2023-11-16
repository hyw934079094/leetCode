package houyw.java.myself.face;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/9 19:32
 * @Description:
 */
public class jingdong {
    public static void main(String[] args) {
        jingdong jd = new jingdong();
        /*int[] nums = {2, 0, 2, 1, 2, 0, 2, 1, 1, 1, 0};
        jd.sortColors(nums);
        System.out.println(1);*/
        int[] nums = {1, 2, 3, 4, 5};
        ListNode getlist = ListUtils.getlist(nums);
        ListNode listNode = jd.reverseKGroup(getlist, 3);
        ListUtils.printListNode(listNode);
    }

    /**
     * ����һ��������ɫ����ɫ����ɫ����?n ��Ԫ�ص�����?nums?��
     * ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
     * ����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
     * �����ڲ�ʹ�ÿ��sort����������½��������⡣
     * ʾ�� 1��
     * ���룺nums = [2,0,2,1,1,0]
     * �����[0,0,1,1,2,2]
     * ʾ�� 2��
     * ���룺nums = [2,0,1]
     * �����[0,1,2]
     * ��ʾ��
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] Ϊ 0��1 �� 2
     * 001111201222
     * ���ף�
     * ����Բ�ʹ�ô�����е�������������������
     * �������һ����ʹ�ó����ռ��һ��ɨ���㷨��
     */
    //����
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                a++;
            } else if (nums[i] == 2) {
                b++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
            if (i < nums.length - b && i >= nums.length - a - b) {
                nums[i] = 1;
            } else if (i >= nums.length - b) {
                nums[i] = 2;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] > nums[right]) {
                //����
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[right] ^ nums[left];
                nums[left] = nums[left] ^ nums[right];
            }
            left++;
            right--;
        }
    }

    /**
     * ���������ͷ�ڵ� head ��ÿ?k?���ڵ�һ����з�ת�����㷵���޸ĺ������
     * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
     * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
     * ʾ�� 1��
     * ���룺head = [1,2,3,4,5], k = 2
     * �����[2,1,4,3,5]
     * ʾ�� 2��
     * ���룺head = [1,2,3,4,5], k = 3
     * �����[3,2,1,4,5]
     * ��ʾ��
     * �����еĽڵ���ĿΪ n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     * ���ף���������һ��ֻ�� O(1) �����ڴ�ռ���㷨�����������
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int t = 0;
        List<ListNode> list = new ArrayList<>();
        while (t++ < k) {
            list.add(head);
            head = head.next;
            if (head == null && list.size() < k) {
                break;
            }
        }
        if (list.size() < k) {
            return list.get(0);
        }
        ListNode node = list.get(list.size() - 1);
        ListNode next = node.next;
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = reverseKGroup(next, k);
        return node;
    }
}
