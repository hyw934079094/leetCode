package houyw.java.myself.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/20 19:49
 * @Description:
 */
public class Day12 {
    public static void main(String[] args) {
        Day12 day = new Day12();
        int i = day.climbStairs(45);
        // System.out.println(i);
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        //int[] nums = {2,1,1,2};
        int rob = day.rob(nums);
        System.out.println(rob);
    }

    /**
     * ������������¥�ݡ���Ҫ n?������ܵ���¥����
     * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
     * ʾ�� 1��
     * ���룺n = 2
     * �����2
     * ���ͣ������ַ�����������¥����
     * 1. 1 �� + 1 ��
     * 2. 2 ��
     * ʾ�� 2��
     * ���룺n = 3
     * �����3
     * ���ͣ������ַ�����������¥����
     * 1. 1 �� + 1 �� + 1 ��
     * 2. 1 �� + 2 ��
     * 3. 2 �� + 1 ��
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int bef = 1;
        int aft = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = bef + aft;
            bef = aft;
            aft = sum;
        }
        return sum;
    }

    /**
     * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
     * Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
     * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
     * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��
     * һҹ֮���ܹ�͵�Ե�����߽�
     * ʾ�� 1��
     * <p>
     * ���룺[1,2,3,1]
     * �����4
     * ���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
     * ?    ͵�Ե�����߽�� = 1 + 3 = 4 ��
     * ʾ�� 2��
     * <p>
     * ���룺[2,7,9,3,1]
     * �����12
     * ���ͣ�͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
     * ?    ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
     * ?
     * ��ʾ��
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * ͨ������570,705�ύ����
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // ��̬�滮
        // dp[i]���麬�壺dp[i] ����͵ȡ��i���������͵ȡ������߽��
        // ���ƹ�ʽ��dp[i] = max(dp[i-2], dp[i-3]) + nums[i];
        // ��ʼ����dp[0] = nums[0], dp[1] =nums[1];
        // ����˳�򣺴�0���������������֮�󽫵õ���Ͷ���������
        // ��ӡdp����
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int maxValue = Math.max(dp[2], dp[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }


    /**
     * ����һ�������� triangle ���ҳ��Զ����µ���С·���͡�
     * ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
     * ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
     * Ҳ����˵�������λ�ڵ�ǰ�е��±� i ����ô��һ�������ƶ�����һ�е��±� i �� i + 1 ��
     * ʾ�� 1��
     * ���룺triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * �����11
     * ���ͣ��������ͼ��ʾ��
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * �Զ����µ���С·����Ϊ?11������2?+?3?+?5?+?1?= 11����
     * ʾ�� 2��
     * ���룺triangle = [[-10]]
     * �����-10
     * ��ʾ��
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     * ���ף�
     * �����ֻʹ�� O(n)?�Ķ���ռ䣨n Ϊ�����ε�����������������������
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        //f(n)[]������ʾĳ�о����õ����С��·��������
        //f(n)[i] = min(f(n-1)[i],f(n-1)[i-1])+triangle.get(n-1).get(i))
        //1<=n<=triangle.size(),0<+i<=triangle.get(n-1).size()
        //f(1)[0] = triangle.get(0).get(0)
        //f(2)[0] = f(1)[0]+triangle.get(1).get(0) f(2)[1] = f(1)[0]+triangle.get(1).get(1)
        List<List<Integer>> list = new ArrayList<>();
        for (int n = 0; n < triangle.size(); n++) {
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                int thisValue = triangle.get(n).get(i);
                if (n - 1 < 0) {
                    lst.add(thisValue);
                } else {
                    int bef = 0;
                    if (i - 1 < 0) {
                        bef = list.get(n - 1).get(i);
                    } else if (i == n) {
                        bef = list.get(n - 1).get(i - 1);
                    } else {
                        bef = Math.min(list.get(n - 1).get(i), list.get(n - 1).get(i - 1));
                    }
                    lst.add(thisValue + bef);
                }
            }
            list.add(lst);
        }
        List<Integer> lastList = list.get(list.size() - 1);
        Collections.sort(lastList);
        return lastList.get(0);
    }
}
