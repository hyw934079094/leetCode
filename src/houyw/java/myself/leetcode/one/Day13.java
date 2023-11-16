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
     * 给定一个整数数组 nums?和一个整数目标值 target，请你在该数组中找出
     * 和为目标值 target? 的那?两个?整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * 提示：
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
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
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * 给你一个秘密数字?secret 和朋友猜测的数字?guess ，请你返回对朋友这次猜测的提示。
     * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B?表示奶牛。
     * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
     * 示例 1：
     * 输入：secret = "1807", guess = "7810"
     * 输出："1A3B"
     * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
     * "1807"
     *   |
     * "7810"
     * 示例 2：
     * 输入：secret = "1123", guess = "0111"
     * 输出："1A1B"
     * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
     * "1123"        "1123"
     *   |      or     |
     * "0111"        "0111"
     * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
     * ?
     * 提示：
     * 1 <= secret.length, guess.length <= 1000
     * secret.length == guess.length
     * secret 和 guess 仅由数字组成
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
