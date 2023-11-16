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
     * ����һ����������?nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
     * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
     * ʾ�� 1��
     * ���룺nums = [1,2,3]
     * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * ʾ�� 2��
     * ���룺nums = [0]
     * �����[[],[0]]
     * ��ʾ��
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums �е�����Ԫ�� ������ͬ
     */
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> tmps = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> lst = new ArrayList<>();
            lst.add(nums[i]);
            //����list�е�ÿһ�������Ը���ǰ����ϳ��µ��Ӽ�
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
            //����list�е�ÿһ�������Ը���ǰ����ϳ��µ��Ӽ�
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
