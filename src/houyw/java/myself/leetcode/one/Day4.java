package houyw.java.myself.leetcode.one;

/**
 * @Author: DELL
 * @Date: 2022/6/27 10:16
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        Day4 day = new Day4();
        String ss = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int i = day.longestPalindrome(ss);
        System.out.println(i);
    }

    /**
     * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
     * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ��
     * ���һ���㷨�����������ܻ�ȡ���������
     * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
     * ʾ�� 1��
     * ���룺[7,1,5,3,6,4]
     * �����5
     * ���ͣ��ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     * ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
     * ʾ�� 2��
     * ���룺prices = [7,6,4,3,1]
     * �����0
     * ���ͣ������������, û�н������, �����������Ϊ 0��
     * ��ʾ��
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int low = prices[0];
        int high = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = 0;
            }
            if (prices[i] > high) {
                high = prices[i];
            }
            if (high - low > max) {
                max = high - low;
            }
        }
        return max;
    }

    /**
     * ����һ��������д��ĸ��Сд��ĸ���ַ���?s?������?ͨ����Щ��ĸ����ɵ� ��Ļ��Ĵ�?��
     * �ڹ�������У���ע�� ���ִ�Сд ������?"Aa"?���ܵ���һ�������ַ�����
     * ʾ�� 1:
     * ����:s = "abccccdd"
     * ���:7
     * ����:
     * ���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
     * ʾ�� 2:
     * ����:s = "a"
     * ����:1
     * ʾ�� 3:
     * ����:s = "bb"
     * ����: 2
     * ��ʾ:
     * 1 <= s.length <= 2000
     * s?ֻ����Сд��/���дӢ����ĸ���
     */
    public int longestPalindrome(String s) {
        int[] nums = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 90) {
                //A~Z  0~25
                nums[c - 'A']++;
            } else {
                //a~z  26~51
                nums[c - 'A' - 6]++;
            }
        }
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (nums[i] % 2 == 1) {
                count--;
                max = 1;
            }
        }
        return count + max;
    }
}
