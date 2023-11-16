package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/2 18:20
 * @Description:
 */
public class Day9 {
    public static void main(String[] args) {
        Day9 day = new Day9();
        int[] nums = {1,2,2};
        System.out.println(day.subsetsWithDup(nums));
    }

    /**
     * 给你一个整数数组?nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * 提示：
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> tmps = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> lst = new ArrayList<>();
            lst.add(nums[i]);
            //现在list中的每一个都可以跟当前数组合成新的子集
            for (List<Integer> l : list) {
                List<Integer> newLit = new ArrayList<>();
                newLit.addAll(l);
                newLit.add(0, nums[i]);
                tmps.add(newLit);
            }
            list.addAll(tmps);
            tmps.clear();
            list.add(lst);
        }
        list.add(new ArrayList<>());
        return list;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> tmps = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> lst = new ArrayList<>();
            lst.add(nums[i]);
            //现在list中的每一个都可以跟当前数组合成新的子集
            for (List<Integer> l : list) {
                List<Integer> newLit = new ArrayList<>();
                newLit.addAll(l);
                newLit.add(0, nums[i]);
                tmps.add(newLit);
            }
            for (List<Integer> tmp : tmps) {
                if (!list.contains(tmp)) {
                    list.add(tmp);
                }
            }
            tmps.clear();
            if(!list.contains(lst)){
                list.add(lst);
            }
        }
        list.add(new ArrayList<>());
        return list;
    }
}
