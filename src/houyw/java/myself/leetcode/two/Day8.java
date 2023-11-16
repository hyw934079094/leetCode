package houyw.java.myself.leetcode.two;

/**
 * @Author: DELL
 * @Date: 2022/7/12 09:29
 * @Description:
 */
public class Day8 {

    /**
     * �������� nums ���������У������е�ֵ ������ͬ ��
     * �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��
     * ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ ��������
     * ���磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ?[4,5,6,7,0,1,2] ��
     * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻�?-1?��
     * ��������һ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
     * ʾ�� 1��
     * ���룺nums = [4,5,6,7,0,1,2], target = 0
     * �����4
     * ʾ��?2��
     * ���룺nums = [4,5,6,7,0,1,2], target = 3
     * �����-1
     * ʾ�� 3��
     * ���룺nums = [1], target = 0
     * �����-1
     * ��ʾ��
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums �е�ÿ��ֵ�� ��һ�޶�
     * ��Ŀ���ݱ�֤ nums ��Ԥ��δ֪��ĳ���±��Ͻ�������ת
     * -104 <= target <= 104
     */

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ��дһ����Ч���㷨���ж�?m x n?�����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
     * ÿ���е����������Ұ��������С�
     * ÿ�еĵ�һ����������ǰһ�е����һ��������
     * ʾ�� 1��
     * ���룺matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * �����true
     * ʾ�� 2��
     * ���룺matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * �����false
     * ��ʾ��
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            if (matrix[i][0] > target) {
                return false;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
                if(matrix[i][j]>target){
                    return false;
                }
            }
        }
        return false;
    }
}
