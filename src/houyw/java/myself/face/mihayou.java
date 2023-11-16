package houyw.java.myself.face;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/8/10 10:25
 * @Description:
 */
public class mihayou {
    public static void main(String[] args) {
        mihayou mh = new mihayou();
        int i = mh.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))");
        System.out.println(i);
    }

    /**
     * ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
     * ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
     * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
     * ʾ�� 1:
     * ����: [3,2,1,5,6,4], k = 2
     * ���: 5
     * ʾ��?2:
     * ����: [3,2,3,1,2,4,5,5,6], k = 4
     * ���: 4
     * ��ʾ��
     * 1 <= k <= nums.length <= 105
     * -104?<= nums[i] <= 104
     */
    public int findKthLargest(int[] nums, int k) {

        return 0;
    }

    /**
     * ��һ�� ƽ���ַ��� �У�'L' �� 'R' �ַ�����������ͬ�ġ�
     * ����һ��ƽ���ַ���?s�����㽫���ָ�ɾ����ܶ��ƽ���ַ�����
     * ע�⣺�ָ�õ���ÿ���ַ�����������ƽ���ַ������ҷָ�õ���ƽ���ַ�����ԭƽ���ַ����������Ӵ���
     * ���ؿ���ͨ���ָ�õ���ƽ���ַ����� ������� ��
     * ʾ�� 1��
     * ���룺s = "RLRRLLRLRL"
     * �����4
     * ���ͣ�s ���Էָ�Ϊ "RL"��"RRLL"��"RL"��"RL" ��ÿ�����ַ����ж�������ͬ������ 'L' �� 'R' ��
     * ʾ�� 2��
     * ���룺s = "RLLLLRRRLR"
     * �����3
     * ���ͣ�s ���Էָ�Ϊ "RL"��"LLLRRR"��"LR" ��ÿ�����ַ����ж�������ͬ������ 'L' �� 'R' ��
     * ʾ�� 3��
     * ���룺s = "LLLLRRRR"
     * �����1
     * ���ͣ�s ֻ�ܱ���ԭ�� "LLLLRRRR".
     * ʾ�� 4��
     * ���룺s = "RLRRRLLRLL"
     * �����2
     * ���ͣ�s ���Էָ�Ϊ "RL"��"RRRLLRLL" ��ÿ�����ַ����ж�������ͬ������ 'L' �� 'R' ��
     */
    public int balancedStringSplit(String s) {
        int a = 0;
        int b = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                a++;
            }
            if (s.charAt(i) == 'L') {
                b++;
            }
            if (a == b) {
                count++;
            }
        }
        return count;
    }

    /**
     * ������������ˮƽ���ϰ�������˳��д�� nums1 �� nums2 �е�������
     * ���ڣ����Ի���һЩ������������ nums1[i]?�� nums2[j]?��ֱ�ߣ���Щֱ����Ҫͬʱ�������㣺
     * ?nums1[i] == nums2[j]
     * �һ��Ƶ�ֱ�߲����κ��������ߣ���ˮƽ�ߣ��ཻ��
     * ��ע�⣬���߼�ʹ�ڶ˵�Ҳ�����ཻ��ÿ������ֻ������һ�����ߡ�
     * �����ַ������������������ؿ��Ի��Ƶ������������
     * ʾ�� 1��
     * ���룺nums1 = [1,4,2], nums2 = [1,2,4]
     * �����2
     * ���ͣ����Ի���������������ߣ�����ͼ��ʾ��
     * ���޷��������������ཻ��ֱ�ߣ���Ϊ�� nums1[1]=4 �� nums2[2]=4 ��ֱ�߽���� nums1[2]=2 �� nums2[1]=2 ��ֱ���ཻ��
     * ʾ�� 2��
     * ���룺nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
     * �����3
     * ʾ�� 3��
     * ���룺nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
     * �����2
     * ��ʾ��
     * 1 <= nums1.length, nums2.length <= 500
     * 1 <= nums1[i], nums2[j] <= 2000
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] fn = new int[nums1.length][nums2.length];
        if (nums1[0] == nums2[0]) {
            fn[0][0] = 1;
        }
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                fn[i][0] = 1;
            } else {
                fn[i][0] = fn[i - 1][0];
            }
        }

        for (int i = 1; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                fn[0][i] = 1;
            } else {
                fn[0][i] = fn[0][i - 1];
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    fn[i][j] = fn[i - 1][j - 1] + 1;
                } else {
                    fn[i][j] = Math.max(fn[i - 1][j], fn[i][j - 1]);
                }
            }
        }
        return fn[nums1.length - 1][nums2.length - 1];
    }

    /**
     * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
     * ע��:������ʹ���κν��ַ�����Ϊ��ѧ���ʽ��������ú��������� eval() ��
     * ʾ�� 1��
     * ���룺s = "1 + 1"
     * �����2
     * ʾ�� 2��
     * ���룺s = " 2-1 + 2 "
     * �����3
     * ʾ�� 3��
     * ���룺s = "(1+(4+5+2)-3)+(6+8)"
     * �����23
     * ��ʾ��
     * 1 <= s.length <= 3?* 105
     * s �����֡�'+'��'-'��'('��')'���� ' ' ���
     * s ��ʾһ����Ч�ı��ʽ
     * '+' ��������һԪ����(���磬 "+1"?�� "+(2 + 3)"?��Ч)
     * '-' ��������һԪ����(�� "-1"?�� "-(2 + 3)"?����Ч��)
     * �����в��������������Ĳ�����
     * ÿ�����ֺ����еļ��㽫�ʺ���һ���з��ŵ� 32λ ����
     */
    public int calculate(String s) {
        //ȥ����
        s = s.replaceAll(" ", "");
        while (s.indexOf(')') > 0) {
            int end = s.indexOf(')');
            for (int i = end - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    int ret = calculateEx(s.substring(i + 1, end));
                    String pre = "";
                    if (i > 0) {
                        //���ܳ���--�����
                        if (ret < 0&&(s.charAt(i - 1) == '-'||s.charAt(i - 1) == '+')) {
                            if (s.charAt(i - 1) == '-') {
                                pre = s.substring(0, i - 1) + "+" + (-ret);
                            } else {
                                pre = s.substring(0, i - 1) + ret;
                            }
                        } else {
                            pre = s.substring(0, i) + ret;
                        }
                    } else {
                        pre = String.valueOf(ret);
                    }

                    if (end < s.length()) {
                        s = pre + s.substring(end + 1);
                    } else {
                        s = pre;
                    }
                    break;
                }
            }
        }
        return calculateEx(s.trim());
    }

    public int calculateEx(String s) {
        //�򵥱��ʽ����
        Queue<Integer> que = new LinkedList();
        Queue<Character> q = new LinkedList<>();
        if (s.charAt(0) == '-') {
            que.add(0);
        }
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                q.add(s.charAt(index));
                if (index > 0 && index < s.length()) {
                    que.add(Integer.valueOf(s.substring(0, index)));
                }
                s = s.substring(index + 1);
                index = 0;
            } else {
                index++;
            }

        }
        que.add(Integer.valueOf(s));
        int num1 = que.poll();
        while (q.size() > 0) {
            int num2 = que.poll();
            char poll = q.poll();
            if (poll == '+') {
                num1 += num2;
            } else {
                num1 -= num2;
            }
        }
        return num1;
    }
}
