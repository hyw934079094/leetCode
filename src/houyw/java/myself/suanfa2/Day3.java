package houyw.java.myself.suanfa2;

import houyw.common.ListNode;
import houyw.common.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/27 10:34
 * @Description:
 */
public class Day3 {
    public static void main(String[] args) {
        Day3 day = new Day3();
        /*int[] arr = {1, 1, 1, 2, 3};
        ListNode getlist = ListUtils.getlist(arr);
        ListNode listNode = day.deleteDuplicates(getlist);
        ListUtils.printListNode(listNode);*/
        int[] nums = {0, 0, 0, 0};
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
        l.add(0);
        List<List<Integer>> lists = day.threeSum(nums);
        System.out.println(lists.contains(l));
        System.out.println(lists);
    }

    /**
     * ����һ��������������ͷ?head ��?ɾ��ԭʼ�����������ظ����ֵĽڵ㣬
     * ֻ���²�ͬ������?������ �����������?��
     * ʾ�� 1��
     * ���룺head = [1,2,3,3,4,4,5]
     * �����[1,2,5]
     * ʾ�� 2��
     * ���룺head = [1,1,1,2,3]
     * �����[2,3]
     * ��ʾ��
     * �����нڵ���Ŀ�ڷ�Χ [0, 300] ��
     * -100 <= Node.val <= 100
     * ��Ŀ���ݱ�֤�����Ѿ������� ����
     */
    public ListNode deleteDuplicates1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
            if (list.size() > 1) {
                if (list.get(list.size() - 1).val == list.get(list.size() - 2).val) {
                    ints.add(list.get(list.size() - 1).val);
                }
            }
        }
        int count = 0;
        ListNode node = null;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i).val;
            if (ints.contains(val)) {
                continue;
            }
            count++;
            if (count == 1) {
                head = list.get(i);
                node = head;
                node.next = null;
            } else {
                node.next = list.get(i);
                node = node.next;
                node.next = null;
            }

        }
        return head;
    }

    //�ڱ������
    public ListNode deleteDuplicates(ListNode head) {
        //��ȷ�ϻ�ͷ
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            while (head.next != null) {
                if (head.next.val != head.val) {
                    head = head.next;
                    return deleteDuplicates(head);
                }
                head = head.next;
            }
            return null;
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }


    /**
     * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��
     * ʹ��?a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
     * ע�⣺���в����԰����ظ�����Ԫ�顣
     * ʾ�� 1��
     * <p>
     * ���룺nums = [-1,0,1,2,-1,-4]
     * -4 -1,-1 0 1 2
     * �����[[-1,-1,2],[-1,0,1]]
     * ʾ�� 2��
     * <p>
     * ���룺nums = []
     * �����[]
     * ʾ�� 3��
     * <p>
     * ���룺nums = [0]
     * �����[]
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     * ͨ������1,063,028�ύ����2,
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[left]);
                    lst.add(nums[right]);
                    if (!list.contains(lst)) {
                        list.add(lst);
                    }
                }
                if (tmp + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
