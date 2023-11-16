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
     * 给定一个已排序的链表的头?head ，?删除原始链表中所有重复数字的节点，
     * 只留下不同的数字?。返回 已排序的链表?。
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * 提示：
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序 排列
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

    //在本体操作
    public ListNode deleteDuplicates(ListNode head) {
        //先确认火车头
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
     * 给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，
     * 使得?a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * -4 -1,-1 0 1 2
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     * 通过次数1,063,028提交次数2,
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
