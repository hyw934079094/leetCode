package houyw.java.myself.face;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import houyw.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/8/9 21:03
 * @Description:
 */
public class bilibili {
    public static void main(String[] args) {
        bilibili bl = new bilibili();
        // boolean valid = bl.isValid("()[{}]");
        int i = bl.compareVersion("7.5.2.4", "7.5.3");
        System.out.println(i);
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例?2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例?3：
     * 输入：s = "(]"
     * 输出：false
     * 示例?4：
     * 输入：s = "([)]"
     * 输出：false
     * 示例?5：
     * 输入：s = "{[]}"
     * 输出：true
     */
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            if (c == ')') {
                if (st.size() == 0 || (st.size() > 0 && st.pop() != '(')) {
                    return false;
                }

            }
            if (c == ']') {
                if (st.size() == 0 || (st.size() > 0 && st.pop() != '[')) {
                    return false;
                }

            }
            if (c == '}') {
                if (st.size() == 0 || (st.size() > 0 && st.pop() != '{')) {
                    return false;
                }

            }
        }
        if (st.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 给你一个字符串?date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
     * 示例 1：
     * 输入：date = "2019-01-09"
     * 输出：9
     * 解释：给定日期是2019年的第九天。
     * 示例 2：
     * 输入：date = "2019-02-10"
     * 输出：41
     * 提示：
     * date.length == 10
     * date[4] == date[7] == '-'，其他的?date[i]?都是数字
     * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
     */
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        if (month == 1) {
            return day;
        }
        int index = 0;
        if (year % 100 == 0) {
            year = year / 100;
        }
        int febday = year % 4 == 0 ? 29 : 28;
        for (int i = 1; i < month; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                index += 30;
            } else if (i == 2) {
                index += febday;
            } else {
                index += 31;
            }
        }
        return index + day;
    }

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * 示例 2：
     * 输入：head = [1,2,3,4,5]
     * 输出：[1,5,2,4,3]
     * 提示：
     * 链表的长度范围为 [1, 5 * 104]
     * 1 <= node.val <= 1000
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            ListNode l1 = list.get(left);
            ListNode next = l1.next;
            ListNode ln = list.get(right);
            l1.next = ln;
            ln.next = next;
            left++;
            right--;
        }
        list.get(left).next = null;
    }

    /**
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。
     * 每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，
     * 下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。
     * 比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
     * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，
     * 因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     * 返回规则如下：
     * 如果?version1?>?version2?返回?1，
     * 如果?version1?<?version2 返回 -1，
     * 除此之外返回 0。
     * 示例 1：
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
     * 示例 2：
     * 输入：version1 = "1.0", version2 = "1.0.0"
     * 输出：0
     * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
     * 示例 3：
     * 输入：version1 = "0.1", version2 = "1.1"
     * 输出：-1
     * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
     * 提示：
     * 1 <= version1.length, version2.length <= 500
     * version1 和 version2 仅包含数字和 '.'
     * version1 和 version2 都是 有效版本号
     * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
     */
    public int compareVersion(String version1, String version2) {
        int a = 0;
        int b = 0;
        while (a < version1.length() && b < version2.length()) {
            while (a < version1.length() && version1.charAt(a) != '.') {
                a++;
            }
            while (b < version2.length() && version2.charAt(b) != '.') {
                b++;
            }
            int num1 = 0;
            if (a < version1.length()) {
                num1 = Integer.valueOf(version1.substring(0, a));
                version1 = version1.substring(a + 1);
                a = 0;
            }else{
                num1 = Integer.valueOf(version1);
            }
            int num2 = 0;
            if (b < version2.length()) {
                num2 = Integer.valueOf(version2.substring(0, b));
                version2 = version2.substring(b + 1);
                b = 0;
            }else{
                num2 = Integer.valueOf(version2);
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }

        }
        return 0;
    }
}
