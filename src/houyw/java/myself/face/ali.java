package houyw.java.myself.face;

import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/9 20:29
 * @Description:
 */
public class ali {
    public static void main(String[] args) {
        ali al = new ali();
        System.out.println(al.isPalindrome(1123211));

    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = merge2Lists(list, lists[i]);
        }
        return list;
    }

    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2);
            list2 = list2.next;
        }
        if (list.size() == 0) {
            return list1;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

    /**
     * Alice 和 Bob 打算给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。
     * 其中，第 i 株植物的位置是 x = i 。
     * 每一株植物都需要浇特定量的水。Alice 和 Bob 每人有一个水罐，最初是满的 。他们按下面描述的方式完成浇水：
     * ?Alice 按 从左到右 的顺序给植物浇水，从植物 0 开始。Bob 按 从右到左 的顺序给植物浇水，从植物 n - 1 开始。
     * 他们 同时 给植物浇水。
     * 如果没有足够的水 完全 浇灌下一株植物，他 / 她会立即重新灌满浇水罐。
     * 不管植物需要多少水，浇水所耗费的时间都是一样的。
     * 不能 提前重新灌满水罐。
     * 每株植物都可以由 Alice 或者 Bob 来浇水。
     * 如果 Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水。如果他俩水量相同，那么 Alice 会给这株植物浇水。
     * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有两个整数 capacityA 和?capacityB 分别表示 Alice 和 Bob 水罐的容量。返回两人浇灌所有植物过程中重新灌满水罐的 次数 。
     * 示例 1：
     * 输入：plants = [2,2,3,3], capacityA = 5, capacityB = 5
     * 输出：1
     * 解释：
     * - 最初，Alice 和 Bob 的水罐中各有 5 单元水。
     * - Alice 给植物 0 浇水，Bob 给植物 3 浇水。
     * - Alice 和 Bob 现在分别剩下 3 单元和 2 单元水。
     * - Alice 有足够的水给植物 1 ，所以她直接浇水。Bob 的水不够给植物 2 ，所以他先重新装满水，再浇水。
     * 所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 0 + 1 + 0 = 1 。
     * 示例 2：
     * 输入：plants = [2,2,3,3], capacityA = 3, capacityB = 4
     * 输出：2
     * 解释：
     * - 最初，Alice 的水罐中有 3 单元水，Bob 的水罐中有 4 单元水。
     * - Alice 给植物 0 浇水，Bob 给植物 3 浇水。
     * - Alice 和 Bob 现在都只有 1 单元水，并分别需要给植物 1 和植物 2 浇水。
     * - 由于他们的水量均不足以浇水，所以他们重新灌满水罐再进行浇水。
     * 所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 1 + 1 + 0 = 2 。
     * 示例 3：
     * 输入：plants = [5], capacityA = 10, capacityB = 8
     * 输出：0
     * 解释：
     * - 只有一株植物
     * - Alice 的水罐有 10 单元水，Bob 的水罐有 8 单元水。因此 Alice 的水罐中水更多，她会给这株植物浇水。
     * 所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 。
     * 提示：
     * n == plants.length
     * 1 <= n <= 105
     * 1 <= plants[i] <= 106
     * max(plants[i]) <= capacityA, capacityB <= 109
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;
        int time = 0;
        int alice = capacityA;
        int bob = capacityB;
        while (left < right) {
            if (alice >= plants[left]) {
                alice = alice - plants[left];
            } else {
                time++;
                alice = capacityA - plants[left];
            }
            if (bob >= plants[right]) {
                bob = bob - plants[right];
            } else {
                time++;
                bob = capacityB - plants[right];
            }
            left++;
            right--;
        }
        if (left == right) {
            if (alice >= bob) {
                if (alice < plants[left]) {
                    time++;
                }
            } else {
                if (bob < plants[right]) {
                    time++;
                }
            }
        }
        return time;
    }
}
