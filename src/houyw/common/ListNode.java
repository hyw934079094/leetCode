package houyw.common;

/**
 * @Author: houyw
 * @Date: 2021/3/29 09:15
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
