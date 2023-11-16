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
     * 给定一个包含红色、白色和蓝色、共?n 个元素的数组?nums?，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、?1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库的sort函数的情况下解决这个问题。
     * 示例 1：
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 提示：
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     * 001111201222
     * 进阶：
     * 你可以不使用代码库中的排序函数来解决这道题吗？
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */
    //常规
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
                //交换
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[right] ^ nums[left];
                nums[left] = nums[left] ^ nums[right];
            }
            left++;
            right--;
        }
    }

    /**
     * 给你链表的头节点 head ，每?k?个节点一组进行翻转，请你返回修改后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是?k?的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
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
