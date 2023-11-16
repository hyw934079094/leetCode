package houyw.java.myself.leetcode.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/6 16:43
 * @Description:
 */
public class Day15 {
    public static void main(String[] args) {
        Day15 day = new Day15();
        int[] arr  = {3,7,2};
        System.out.println(day.lastStoneWeight(arr));
    }

    /**
     * ��һ��ʯͷ��ÿ��ʯͷ������������������
     * ÿһ�غϣ�����ѡ������ ���ص� ʯͷ��Ȼ������һ����顣����ʯͷ�������ֱ�Ϊ?x ��?y����?x <= y��
     * ��ô����Ŀ��ܽ�����£�
     * ���?x == y����ô����ʯͷ���ᱻ��ȫ���飻
     * ���?x != y����ô����Ϊ?x?��ʯͷ������ȫ���飬������Ϊ?y?��ʯͷ������Ϊ?y-x��
     * ������ֻ��ʣ��һ��ʯͷ�����ش�ʯͷ�����������û��ʯͷʣ�£��ͷ��� 0��
     * ʾ����
     * ���룺[2,7,4,1,8,1]
     * �����1
     * ���ͣ�
     * ��ѡ�� 7 �� 8���õ� 1����������ת��Ϊ [2,4,1,1,1]��
     * ��ѡ�� 2 �� 4���õ� 2����������ת��Ϊ [2,1,1,1]��
     * ������ 2 �� 1���õ� 1����������ת��Ϊ [1,1,1]��
     * ���ѡ�� 1 �� 1���õ� 0����������ת��Ϊ [1]����������ʣ���ǿ�ʯͷ��������
     * ?
     * <p>
     * ��ʾ��
     * 1 <= stones.length <= 30
     * 1 <= stones[i] <= 1000
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        if (stones.length == 2) {
            return stones[1] == stones[0] ? 0 : stones[1] - stones[0];
        }

        int a = stones[stones.length - 1];
        int b = stones[stones.length - 2];
        int[] newStones;
        if (a == b) {
            newStones = Arrays.copyOf(stones, stones.length - 2);
        }else{
            newStones = Arrays.copyOf(stones, stones.length - 1);
            newStones[newStones.length-1] = a-b;
        }

        return lastStoneWeight(newStones);
    }

}
