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
     * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
     * ��Ч�ַ��������㣺
     * �����ű�������ͬ���͵������űպϡ�
     * �����ű�������ȷ��˳��պϡ�
     * ʾ�� 1��
     * ���룺s = "()"
     * �����true
     * ʾ��?2��
     * ���룺s = "()[]{}"
     * �����true
     * ʾ��?3��
     * ���룺s = "(]"
     * �����false
     * ʾ��?4��
     * ���룺s = "([)]"
     * �����false
     * ʾ��?5��
     * ���룺s = "{[]}"
     * �����true
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
     * ����һ���ַ���?date ���� YYYY-MM-DD ��ʽ��ʾһ�� ���й�Ԫ���귨 ���ڡ����ظ������ǵ���ĵڼ��졣
     * ʾ�� 1��
     * ���룺date = "2019-01-09"
     * �����9
     * ���ͣ�����������2019��ĵھ��졣
     * ʾ�� 2��
     * ���룺date = "2019-02-10"
     * �����41
     * ��ʾ��
     * date.length == 10
     * date[4] == date[7] == '-'��������?date[i]?��������
     * date ��ʾ�ķ�Χ�� 1900 �� 1 �� 1 ���� 2019 �� 12 �� 31 ��
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
     * ����һ�������� L ��ͷ�ڵ� head �������� L ��ʾΪ��
     * L0 �� L1 �� �� �� Ln - 1 �� Ln
     * �뽫���������к��Ϊ��
     * L0 �� Ln �� L1 �� Ln - 1 �� L2 �� Ln - 2 �� ��
     * ����ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
     * ʾ�� 1��
     * ���룺head = [1,2,3,4]
     * �����[1,4,2,3]
     * ʾ�� 2��
     * ���룺head = [1,2,3,4,5]
     * �����[1,5,2,4,3]
     * ��ʾ��
     * ����ĳ��ȷ�ΧΪ [1, 5 * 104]
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
     * ���������汾�� version1 �� version2 ������Ƚ����ǡ�
     * �汾����һ�������޶�����ɣ����޶�����һ�� '.' ���ӡ�
     * ÿ���޶����� ��λ���� ��ɣ����ܰ��� ǰ���� ��ÿ���汾�����ٰ���һ���ַ����޶��Ŵ����ұ�ţ�
     * �±�� 0 ��ʼ������ߵ��޶����±�Ϊ 0 ����һ���޶����±�Ϊ 1 ���Դ����ơ����磬2.5.33 �� 0.1 ������Ч�İ汾�š�
     * �Ƚϰ汾��ʱ���밴�����ҵ�˳�����αȽ����ǵ��޶��š�
     * �Ƚ��޶���ʱ��ֻ��Ƚ� �����κ�ǰ����������ֵ ��Ҳ����˵���޶��� 1 ���޶��� 001 ��� ��
     * ����汾��û��ָ��ĳ���±괦���޶��ţ�����޶�����Ϊ 0 �����磬�汾 1.0 С�ڰ汾 1.1 ��
     * ��Ϊ�����±�Ϊ 0 ���޶�����ͬ�����±�Ϊ 1 ���޶��ŷֱ�Ϊ 0 �� 1 ��0 < 1 ��
     * ���ع������£�
     * ���?version1?>?version2?����?1��
     * ���?version1?<?version2 ���� -1��
     * ����֮�ⷵ�� 0��
     * ʾ�� 1��
     * ���룺version1 = "1.01", version2 = "1.001"
     * �����0
     * ���ͣ�����ǰ���㣬"01" �� "001" ����ʾ��ͬ������ "1"
     * ʾ�� 2��
     * ���룺version1 = "1.0", version2 = "1.0.0"
     * �����0
     * ���ͣ�version1 û��ָ���±�Ϊ 2 ���޶��ţ�����Ϊ "0"
     * ʾ�� 3��
     * ���룺version1 = "0.1", version2 = "1.1"
     * �����-1
     * ���ͣ�version1 ���±�Ϊ 0 ���޶����� "0"��version2 ���±�Ϊ 0 ���޶����� "1" ��0 < 1������ version1 < version2
     * ��ʾ��
     * 1 <= version1.length, version2.length <= 500
     * version1 �� version2 ���������ֺ� '.'
     * version1 �� version2 ���� ��Ч�汾��
     * version1 �� version2 �������޶��Ŷ����Դ洢�� 32 λ���� ��
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
