package houyw.java.myself.suanfa2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DELL
 * @Date: 2022/7/28 10:32
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        Day4 day = new Day4();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(day.maxArea(height));
    }

    /**
     * ���� s �� t �����ַ����������Ƿֱ����뵽�հ׵��ı��༭�������������ȣ����� true ��# �����˸��ַ���
     * <p>
     * ע�⣺����Կ��ı������˸��ַ����ı�����Ϊ�ա�
     * <p>
     * ?
     * <p>
     * ʾ�� 1��
     * <p>
     * ���룺s = "ab#c", t = "ad#c"
     * �����true
     * ���ͣ�s �� t ������ "ac"��
     * ʾ�� 2��
     * <p>
     * ���룺s = "ab##", t = "c#d#"
     * �����true
     * ���ͣ�s �� t ������ ""��
     * ʾ�� 3��
     * <p>
     * ���룺s = "a#c", t = "b"
     * �����false
     * ���ͣ�s ���� "c"���� t ��Ȼ�� "b"��
     * ?
     * <p>
     * ��ʾ��
     * <p>
     * 1 <= s.length, t.length <= 200
     * s �� t ֻ����Сд��ĸ�Լ��ַ� '#'
     * ?
     */
    public boolean backspaceCompare(String s, String t) {
        Stack ss = new Stack();
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                ss.push(s.charAt(i));
            }
            if (ss.size() > 0 && s.charAt(i) == '#') {
                ss.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                st.push(t.charAt(i));
            }
            if (st.size() > 0 && t.charAt(i) == '#') {
                st.pop();
            }
        }
        if (ss.size() != st.size()) {
            return false;
        }
        while (ss.size() > 0) {
            if (ss.pop() != st.pop()) {
                return false;
            }
        }
        return true;
    }


    /**
     * ����һ������Ϊ n ����������?height?����?n?�����ߣ��� i ���ߵ������˵���?(i, 0)?��?(i, height[i])?��
     * �ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
     * �����������Դ�������ˮ����
     * ˵�����㲻����б������
     * ʾ�� 1��
     * ���룺[1,8,6,2,5,4,8,3,7]
     * �����49
     * ���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ?49��
     * ʾ�� 2��
     * ���룺height = [1,1]
     * �����1
     * ��ʾ��
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     */
    public int maxArea(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int max = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] < height[i]) {
                    if ((j - i) * height[j] > max) {
                        max = (j - i) * height[j];
                    }
                    continue;
                } else {
                    if ((j - i) * height[i] > max) {
                        max = (j - i) * height[i];
                    }
                    break;
                }
            }
            if (sum < max) {
                sum = max;
            }
        }

        return sum;
    }

    /**
     * ����������һЩ ������ ��ɵ��б�firstList �� secondList ��
     * ���� firstList[i] = [starti, endi] ��?secondList[j] = [startj, endj] ��
     * ÿ�������б��ǳɶ� ���ཻ �ģ����� �Ѿ����� ��
     * ������ ���������б�Ľ��� ��
     * ��ʽ�ϣ�������?[a, b]������?a <= b����ʾʵ��?x?�ļ��ϣ���?a <= x <= b ��
     * ����������� ���� ��һ��ʵ����ҪôΪ�ռ���ҪôΪ�����䡣���磬[1, 3] �� [2, 4] �Ľ���Ϊ [2, 3] ��
     * ʾ�� 1��
     * ���룺firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
     * �����[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * ʾ�� 2��
     * <p>
     * ���룺firstList = [[1,3],[5,9]], secondList = []
     * �����[]
     * ʾ�� 3��
     * ���룺firstList = [], secondList = [[4,8],[10,12]]
     * �����[]
     * ʾ�� 4��
     * ���룺firstList = [[1,7]], secondList = [[3,10]]
     * �����[[3,7]]
     * ��ʾ��
     * 0 <= firstList.length, secondList.length <= 1000
     * firstList.length + secondList.length >= 1
     * 0 <= starti < endi <= 109
     * endi < starti+1
     * 0 <= startj < endj <= 109
     * endj < startj+1
     */

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //�ཻ---��������ȡ��ģ�������ȡС��
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            int[] f1 = firstList[i];
            for (int j = 0; j < secondList.length; j++) {
                //�ҵ��ཻ��
                int[] f2 = secondList[j];
                //���������ڶ��ڵ�ǰǰ��
                if (f1[0] > f2[1]) {
                    continue;
                }
                //���ζ��ں���,����Ķ��ں�����
                if (f2[0] > f1[1]) {
                    break;
                }
                //�����ཻƬ�ε�
                int[] arr = new int[2];
                if (f1[0] >= f2[0]) {
                    arr[0] = f1[0];
                } else {
                    arr[0] = f2[0];
                }
                if (f1[1] <= f2[1]) {
                    arr[1] = f1[1];
                } else {
                    arr[1] = f2[1];
                }
                list.add(arr);
            }
        }
        int[][] ret = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
