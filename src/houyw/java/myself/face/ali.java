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
     * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
     * <p>
     * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
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
     * ����һ���������飬ÿ�������Ѿ����������С�
     * ���㽫��������ϲ���һ�����������У����غϲ��������
     * ʾ�� 1��
     * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
     * �����[1,1,2,3,4,4,5,6]
     * ���ͣ������������£�
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * �����Ǻϲ���һ�����������еõ���
     * 1->1->2->3->4->4->5->6
     * ʾ�� 2��
     * ���룺lists = []
     * �����[]
     * ʾ�� 3��
     * ���룺lists = [[]]
     * �����[]
     * ��ʾ��
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] �� ���� ����
     * lists[i].length ���ܺͲ����� 10^4
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
     * Alice �� Bob �������԰��� n ��ֲ�ｽˮ��ֲ���ų�һ�У������ҽ��б�ǣ���Ŵ� 0 �� n - 1 ��
     * ���У��� i ��ֲ���λ���� x = i ��
     * ÿһ��ֲ�ﶼ��Ҫ���ض�����ˮ��Alice �� Bob ÿ����һ��ˮ�ޣ���������� �����ǰ����������ķ�ʽ��ɽ�ˮ��
     * ?Alice �� ������ ��˳���ֲ�ｽˮ����ֲ�� 0 ��ʼ��Bob �� ���ҵ��� ��˳���ֲ�ｽˮ����ֲ�� n - 1 ��ʼ��
     * ���� ͬʱ ��ֲ�ｽˮ��
     * ���û���㹻��ˮ ��ȫ ������һ��ֲ��� / �����������¹�����ˮ�ޡ�
     * ����ֲ����Ҫ����ˮ����ˮ���ķѵ�ʱ�䶼��һ���ġ�
     * ���� ��ǰ���¹���ˮ�ޡ�
     * ÿ��ֲ�ﶼ������ Alice ���� Bob ����ˮ��
     * ��� Alice �� Bob ����ͬһ��ֲ���ô��ǰˮ����ˮ������˻������ֲ�ｽˮ���������ˮ����ͬ����ô Alice �������ֲ�ｽˮ��
     * ����һ���±�� 0 ��ʼ���������� plants �������� n ��������ɡ����У�plants[i] Ϊ�� i ��ֲ����Ҫ��ˮ���������������� capacityA ��?capacityB �ֱ��ʾ Alice �� Bob ˮ�޵��������������˽�������ֲ����������¹���ˮ�޵� ���� ��
     * ʾ�� 1��
     * ���룺plants = [2,2,3,3], capacityA = 5, capacityB = 5
     * �����1
     * ���ͣ�
     * - �����Alice �� Bob ��ˮ���и��� 5 ��Ԫˮ��
     * - Alice ��ֲ�� 0 ��ˮ��Bob ��ֲ�� 3 ��ˮ��
     * - Alice �� Bob ���ڷֱ�ʣ�� 3 ��Ԫ�� 2 ��Ԫˮ��
     * - Alice ���㹻��ˮ��ֲ�� 1 ��������ֱ�ӽ�ˮ��Bob ��ˮ������ֲ�� 2 ��������������װ��ˮ���ٽ�ˮ��
     * ���ԣ����˽�������ֲ����������¹���ˮ�޵Ĵ��� = 0 + 0 + 1 + 0 = 1 ��
     * ʾ�� 2��
     * ���룺plants = [2,2,3,3], capacityA = 3, capacityB = 4
     * �����2
     * ���ͣ�
     * - �����Alice ��ˮ������ 3 ��Ԫˮ��Bob ��ˮ������ 4 ��Ԫˮ��
     * - Alice ��ֲ�� 0 ��ˮ��Bob ��ֲ�� 3 ��ˮ��
     * - Alice �� Bob ���ڶ�ֻ�� 1 ��Ԫˮ�����ֱ���Ҫ��ֲ�� 1 ��ֲ�� 2 ��ˮ��
     * - �������ǵ�ˮ���������Խ�ˮ�������������¹���ˮ���ٽ��н�ˮ��
     * ���ԣ����˽�������ֲ����������¹���ˮ�޵Ĵ��� = 0 + 1 + 1 + 0 = 2 ��
     * ʾ�� 3��
     * ���룺plants = [5], capacityA = 10, capacityB = 8
     * �����0
     * ���ͣ�
     * - ֻ��һ��ֲ��
     * - Alice ��ˮ���� 10 ��Ԫˮ��Bob ��ˮ���� 8 ��Ԫˮ����� Alice ��ˮ����ˮ���࣬���������ֲ�ｽˮ��
     * ���ԣ����˽�������ֲ����������¹���ˮ�޵Ĵ��� = 0 ��
     * ��ʾ��
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
