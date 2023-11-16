package houyw.java.myself.leetcode.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/21 09:45
 * @Description:
 */
public class Day17 {
    public static void main(String[] args) {
        Day17 day= new Day17();
        int[][] arr = {{1,3},{2,6},{8,6},{15,18}};

        int[][] merge = day.merge(arr);
    }
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回?一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间?。
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例?2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 提示：
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     */
    public int[][] merge(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int next = 1;
        while(index<starts.length){
            if(index == starts.length-1){
                list.add(new int[]{starts[index],ends[index]});
                break;
            }
            if(starts[next]>ends[index]){
                list.add(new int[]{starts[index],ends[index]});
                
            }else if(starts[next]<=ends[index]){
                starts[next] = starts[index];
            }
            index++;
            next++;
        }
        int[][] merge = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            merge[i] = list.get(i);
        }
        return merge;
    }

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 示例?1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]?重叠。
     * 示例 3：
     * 输入：intervals = [], newInterval = [5,7]
     * 输出：[[5,7]]
     * 示例 4：
     * 输入：intervals = [[1,5]], newInterval = [2,3]
     * 输出：[[1,5]]
     * 示例 5：
     * 输入：intervals = [[1,5]], newInterval = [2,7]
     * 输出：[[1,7]]
     * 提示：
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <=?intervals[i][0] <=?intervals[i][1] <= 105
     * intervals 根据 intervals[i][0] 按 升序 排列
     * newInterval.length == 2
     * 0 <=?newInterval[0] <=?newInterval[1] <= 105
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] starts = new int[intervals.length+1];
        int[] ends = new int[intervals.length+1];
        for(int i = 0;i<intervals.length;i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        starts[intervals.length] = newInterval[0];
        ends[intervals.length] = newInterval[1];
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();
        int index = 0;
        int next = 1;
        while(index<starts.length){
            if(index == starts.length-1){
                list.add(new int[]{starts[index],ends[index]});
                break;
            }
            if(starts[next]>ends[index]){
                list.add(new int[]{starts[index],ends[index]});

            }else if(starts[next]<=ends[index]){
                starts[next] = starts[index];
            }
            index++;
            next++;
        }
        int[][] merge = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            merge[i] = list.get(i);
        }
        return merge;
    }
}
