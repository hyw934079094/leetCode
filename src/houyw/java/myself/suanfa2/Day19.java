package houyw.java.myself.suanfa2;

/**
 * @Author: DELL
 * @Date: 2022/8/3 14:38
 * @Description:
 */
public class Day19 {
    public static void main(String[] args) {
        Day19 day = new Day19();
        int i = day.rangeBitwiseAnd(2147483646, 2147483647);
        System.out.println(i);

    }

    /**
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     * 示例 1：
     * 输入：left = 5, right = 7
     * 输出：4
     * 示例 2：
     * 输入：left = 0, right = 0
     * 输出：0
     * 示例 3：
     * 输入：left = 1, right = 2147483647
     * 输出：0
     * 提示：
     * 0 <= left <= right <= 231 - 1
     */
    public int rangeBitwiseAnd(int left, int right) {
        int sum = 0;
        int i = left;
        while (i <= right && i > 0) {
            if (i == left) {
                sum = i;
            } else {
                sum = sum & i;
            }
            if (sum == 0) {
                return 0;
            }
            i++;
        }

        return sum;
    }
}
