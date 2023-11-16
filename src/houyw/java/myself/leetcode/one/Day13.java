package houyw.java.myself.leetcode.one;

import houyw.common.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DELL
 * @Date: 2022/7/5 09:55
 * @Description:
 */
public class Day13 {

    public static void main(String[] args) {
        Day13 day = new Day13();
        int[] nums = {3,2,4};
        int[] ints = day.twoSum(nums, 6);
        ArrayUtils.print(ints);
       // System.out.println(day.getHint("1123","0111"));
    }

    /**
     * ����һ���������� nums?��һ������Ŀ��ֵ target�������ڸ��������ҳ�
     * ��ΪĿ��ֵ target? ����?����?���������������ǵ������±ꡣ
     * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
     * ����԰�����˳�򷵻ش𰸡�
     * ʾ�� 1��
     * ���룺nums = [2,7,11,15], target = 9
     * �����[0,1]
     * ���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
     * ʾ�� 2��
     *
     * ���룺nums = [3,2,4], target = 6
     * �����[1,2]
     * ʾ�� 3��
     * ���룺nums = [3,3], target = 6
     * �����[0,1]
     * ��ʾ��
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * ֻ�����һ����Ч��
     * ���ף���������һ��ʱ�临�Ӷ�С�� O(n2) ���㷨��
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(mp.getOrDefault(target-nums[i], -1)>=0){
                return new int[]{mp.get(target-nums[i]),i};
            }
            mp.put(nums[i],i );
        }
        return null;
    }

    /**
     * ���ں�����һ���� �����֣�Bulls and Cows����Ϸ������Ϸ�������£�
     * д��һ���������֣��������Ѳ���������Ƕ��١�����ÿ�²�һ�Σ���ͻ����һ������������Ϣ����ʾ��
     * �²��������ж���λ�������ֺ�ȷ��λ�ö��¶��ˣ���Ϊ "Bulls"����ţ����
     * �ж���λ�������ֲ¶��˵���λ�ò��ԣ���Ϊ "Cows"����ţ����Ҳ����˵����β²����ж���λ�ǹ�ţ���ֿ���ͨ����������ת���ɹ�ţ���֡�
     * ����һ����������?secret �����Ѳ²������?guess �����㷵�ض�������β²����ʾ��
     * ��ʾ�ĸ�ʽΪ "xAyB" ��x �ǹ�ţ������ y ����ţ������A ��ʾ��ţ��B?��ʾ��ţ��
     * ��ע���������ֺ����Ѳ²�����ֶ����ܺ����ظ����֡�
     * ʾ�� 1��
     * ���룺secret = "1807", guess = "7810"
     * �����"1A3B"
     * ���ͣ����ֺ�λ�ö��ԣ���ţ���� '|' ���ӣ����ֲ¶�λ�ò��ԣ���ţ���Ĳ���б��Ӵֱ�ʶ��
     * "1807"
     *   |
     * "7810"
     * ʾ�� 2��
     * ���룺secret = "1123", guess = "0111"
     * �����"1A1B"
     * ���ͣ����ֺ�λ�ö��ԣ���ţ���� '|' ���ӣ����ֲ¶�λ�ò��ԣ���ţ���Ĳ���б��Ӵֱ�ʶ��
     * "1123"        "1123"
     *   |      or     |
     * "0111"        "0111"
     * ע�⣬������ƥ��� 1 �У�ֻ��һ����������ţ�����ֲ¶�λ�ò��ԣ���ͨ���������зǹ�ţ���֣����н���һ�� 1 ���Գ�Ϊ��ţ���֡�
     * ?
     * ��ʾ��
     * 1 <= secret.length, guess.length <= 1000
     * secret.length == guess.length
     * secret �� guess �����������
     */
    public String getHint(String secret, String guess) {
        Map<Character,Integer> mpX = new HashMap<>();
        Map<Character,Integer> mpY = new HashMap<>();

        int countX = 0;
        int countY = 0;
        for(int i = 0;i<secret.length();i++){
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if(c==g){
                countX++;
            }else{
                mpX.put(c, mpX.getOrDefault(c, 0)+1);
                mpY.put(g, mpY.getOrDefault(g, 0)+1);
                if(mpX.getOrDefault(g,0)>0){
                    mpY.put(g, mpY.get(g)-1);
                    mpX.put(g, mpX.get(g)-1);
                    countY++;
                }
                if(mpY.getOrDefault(c,0)>0){
                    mpY.put(c, mpY.get(c)-1);
                    mpX.put(c, mpX.get(c)-1);
                    countY++;
                }
            }
        }
        String ss = countX+"A"+countY+"B";
        return  ss;
    }
}
