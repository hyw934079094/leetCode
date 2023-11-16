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
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     * ?
     *
     * 提示：
     * 1 <= s.length <= 105
     * s[i] 都是 ASCII 码表中的可打印字符
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
     * 给定一个字符串?s?，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 示例 1：
     *
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 示例 2:
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     * 提示：
     * 1 <= s.length <= 5 * 104
     * s?包含可打印的 ASCII 字符。
     * s?不包含任何开头或结尾空格。
     * s?里 至少 有一个词。
     * s?中的所有单词都用一个空格隔开。
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
