package houyw.java.myself.suanfa;

/**
 * @Author: DELL
 * @Date: 2022/6/14 21:45
 * @Description:
 */
public class Day4 {
    public static void main(String[] args) {
        Day4 day = new Day4();
        String ss= "hello";
        char[] chars = ss.toCharArray();
        //day.reverseString(chars);
       // System.out.println(chars);

        String s = "Let's take LeetCode contest";
        String s1 = day.reverseWords(s);
        System.out.println(s1);
    }

    /**
     * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� s ����ʽ������
     *
     * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺s = ["h","e","l","l","o"]
     * �����["o","l","l","e","h"]
     * ʾ�� 2��
     *
     * ���룺s = ["H","a","n","n","a","h"]
     * �����["h","a","n","n","a","H"]
     * ?
     *
     * ��ʾ��
     * 1 <= s.length <= 105
     * s[i] ���� ASCII ����еĿɴ�ӡ�ַ�
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        char c ;
        while(start<end){
            c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    /**
     * ����һ���ַ���?s?������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
     * ʾ�� 1��
     *
     * ���룺s = "Let's take LeetCode contest"
     * �����"s'teL ekat edoCteeL tsetnoc"
     * ʾ�� 2:
     * ���룺 s = "God Ding"
     * �����"doG gniD"
     * ��ʾ��
     * 1 <= s.length <= 5 * 104
     * s?�����ɴ�ӡ�� ASCII �ַ���
     * s?�������κο�ͷ���β�ո�
     * s?�� ���� ��һ���ʡ�
     * s?�е����е��ʶ���һ���ո������
     */
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String sss = "";
        for(String ss:s1) {
          ss = reverseString(ss);
          sss+=ss;
          sss+=" ";
        }
        return sss.substring(0,sss.length()-1);
    }

    public String reverseString(String ss) {
        char[] s = ss.toCharArray();
        int start = 0;
        int end = s.length-1;
        char c ;
        while(start<end){
            c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
        return String.valueOf(s);
    }
}
