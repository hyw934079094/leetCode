package houyw.java.myself.leetcode.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/11 20:44
 * @Description:
 */
public class Day12 {

    public static void main(String[] args) {
        Day12 day = new Day12();
        int[] coins = {186, 419, 83, 408};//6249
        //int[] coins = {1, 2, 5};
        System.out.println(day.coinChange(coins, 6249));
    }

    /**
     * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
     * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� ��
     * ���û���κ�һ��Ӳ�����������ܽ�����?-1 ��
     * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
     * ʾ��?1��
     * ���룺coins = [1, 2, 5], amount = 11
     * �����3
     * ���ͣ�11 = 5 + 5 + 1
     * ʾ�� 2��
     * ���룺coins = [2], amount = 3
     * �����-1
     * ʾ�� 3��
     * ���룺coins = [1], amount = 0
     * �����0
     * ��ʾ��
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] fn = new int[amount + 1];
        fn[0] = 0;
        for (int i = 1; i <= amount; i++) {
            fn[i] = -1;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                if (fn[i - coin] == -1) {
                    continue;
                }
                if (fn[i] == -1) {
                    fn[i] = fn[i - coin] + 1;
                } else {
                    if (fn[i] > fn[i - coin] + 1) {
                        fn[i] = fn[i - coin] + 1;
                    }
                }
            }
        }
        return fn[amount];
    }
}
