package houyw.java.myself.suanfa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/8/3 10:42
 * @Description:
 */
public class Day10 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Day10 day = new Day10();
        List<List<Integer>> listList = day.combinationSum2(nums, 30);
        System.out.println(listList);
    }

    /**
     * 给定一个候选人编号的集合?candidates?和一个目标数?target?，找出?candidates?
     * 中所有可以使数字和为?target?的组合。
     * candidates?中的每个数字在每个组合中只能使用?一次?。
     * 注意：解集不能包含重复的组合。?
     * 示例?1:
     * 输入: candidates =?[10,1,2,7,6,1,5], target =?8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例?2:
     * 输入: candidates =?[2,5,2,1,2], target =?5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     * 提示:
     * 1 <=?candidates.length <= 100
     * 1 <=?candidates[i] <= 50
     * 1 <= target <= 30
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int index) {
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            //再往后都找不到匹配的值了
            if (candidates[i] > target) {
                break;
            }
            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                lst.add(list);
                return lst;
            }
            if (candidates[i] < target) {
                List<List<Integer>> ls = combinationSum2(candidates, target - candidates[i], i + 1);
                if (ls.size() > 0) {
                    for (List<Integer> l : ls) {
                        l.add(0, candidates[i]);
                        if (!lst.contains(l)) {
                            lst.add(l);
                        }
                    }
                }
            }
        }
        return lst;
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        rollback(candidates, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void rollback(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int sum, int k) {
        if (sum == target) ans.add(new ArrayList<>(list));
        for (int i = k; i < candidates.length; i++) {
            if (i > k && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] <= target) {
                list.add(candidates[i]);
                rollback(candidates, target, ans, list, sum + candidates[i], i + 1);
                list.remove(list.size() - 1);
            } else{
                break;
            }
        }
    }
}
