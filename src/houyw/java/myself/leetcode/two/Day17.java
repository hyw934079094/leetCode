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
     * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
     * ����ϲ������ص������䣬������?һ�����ص����������飬��������ǡ�ø��������е���������?��
     * ʾ�� 1��
     * ���룺intervals = [[1,3],[2,6],[8,10],[15,18]]
     * �����[[1,6],[8,10],[15,18]]
     * ���ͣ����� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
     * ʾ��?2��
     * ���룺intervals = [[1,4],[4,5]]
     * �����[[1,5]]
     * ���ͣ����� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
     * ��ʾ��
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
     * ����һ�� ���ص��� ������������ʼ�˵�����������б�
     * ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
     * ʾ��?1��
     * ���룺intervals = [[1,3],[6,9]], newInterval = [2,5]
     * �����[[1,5],[6,9]]
     * ʾ�� 2��
     * ���룺intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * �����[[1,2],[3,10],[12,16]]
     * ���ͣ�������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10]?�ص���
     * ʾ�� 3��
     * ���룺intervals = [], newInterval = [5,7]
     * �����[[5,7]]
     * ʾ�� 4��
     * ���룺intervals = [[1,5]], newInterval = [2,3]
     * �����[[1,5]]
     * ʾ�� 5��
     * ���룺intervals = [[1,5]], newInterval = [2,7]
     * �����[[1,7]]
     * ��ʾ��
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <=?intervals[i][0] <=?intervals[i][1] <= 105
     * intervals ���� intervals[i][0] �� ���� ����
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
