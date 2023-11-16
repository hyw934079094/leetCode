package houyw.java.myself.suanfa;

import houyw.java.myself.utils.MyUtils;

/**
 * @Author: DELL
 * @Date: 2022/6/21 17:33
 * @Description:
 */
public class Day13 {
    public static void main(String[] args) throws Exception {
        Day13 day = new Day13();
        //System.out.println(day.isPowerOfTwo(0));
        String ss ="11111111111111111111111111111101";
        int num = MyUtils.stringToNum2(ss);
        System.out.println(num);
        System.out.println( MyUtils.num10ToString(num));
        System.out.println(MyUtils.num10ToString(day.reverseBits(num)));
        System.out.println(day.reverseBits(num));
    }

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。
     * 如果是，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：n = 1
     * 输出：true
     * 解释：20 = 1
     * 示例 2：
     * 输入：n = 16
     * 输出：true
     * 解释：24 = 16
     * 示例 3：
     * 输入：n = 3
     * 输出：false
     * 示例 4：
     * 输入：n = 4
     * 输出：true
     * 示例 5：
     * 输入：n = 5
     * 输出：false
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int m = n >> 1;
        while (m != 0) {
            if ((m & n) != 0) {
                return false;
            }
            m = m >> 1;
        }
        return true;
    }

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
     * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     * 提示：
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
     * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的?示例 3?中，输入表示有符号整数 -3。
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011?中，共有三位为 '1'。
     * 示例 2：
     * <p>
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000?中，共有一位为 '1'。
     * 示例 3：
     * <p>
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     */
    public int hammingWeight(int n) throws Exception {
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            count += n & 1;
            n >>= 1;
            //System.out.println(MyUtils.num10ToString(n));

        }
        return count;
    }

    /**
     * 颠倒给定的 32 位无符号整数的二进制位。
     * 输入：n = 00000010100101000001111010011100
     * 输出：964176192 (00111001011110000010100101000000)
     * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     * 示例 2：
     * <p>
     * 输入：n = 11111111111111111111111111111101
     * 输出：3221225471 (10111111111111111111111111111111)
     * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     * ? 因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
     */
    public int reverseBits(int n) {
        int m = n & 1;
        for (int i = 0; i < 31; i++) {
            n = n >>1;
            m = m <<1;
            m += n & 1;
        }
        return m;
    }

    /**
     * 给定一个非空整数数组，
     * 除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。
     * 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例?2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]^nums[i-1];
        }
        return nums[nums.length-1];
    }
}
