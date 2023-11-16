package houyw.java.myself.suanfa;

/**
 * @Author: houyw
 * @Date: 2022/6/9 20:05
 * @Description:
 */
public class Day1 {
    public static void main(String[] args) {
        Day1 day = new Day1();

        System.out.println(day.firstBadVersion(Integer.MAX_VALUE));
    }

    /**
     * ����һ��?n?��Ԫ������ģ�������������?nums ��һ��Ŀ��ֵ?target ?��
     * дһ����������?nums?�е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
     * ʾ�� 1:
     * ����: nums = [-1,0,3,5,9,12], target = 9
     * ���: 4
     * ����: 9 ������ nums �в����±�Ϊ 4
     * ʾ��?2:
     * ����: nums = [-1,0,3,5,9,12], target = 2
     * ���: -1
     * ����: 2 ������ nums ����˷��� -1
     * ��ʾ��
     * ����Լ��� nums?�е�����Ԫ���ǲ��ظ��ġ�
     * n?����?[1, 10000]֮�䡣
     * nums?��ÿ��Ԫ�ض�����?[-9999, 9999]֮�䡣
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = end / 2;
        while (end > start) {
            if (nums[index] == target) {
                break;
            } else {
                if (nums[index] > target) {
                    if (index == end) {
                        end--;
                    } else {
                        end = index;
                    }
                } else {
                    if (index == start) {
                        start++;
                    } else {
                        start = index;
                    }
                }
            }
            index = (start + end) / 2;
        }
        if (nums[index] == target) {
            return index;
        }
        return -1;
    }

    /**
     * ���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣
     * ����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
     * �������� n ���汾 [1, 2, ..., n]�������ҳ�����֮�����а汾����ĵ�һ������İ汾��
     * �����ͨ������?bool isBadVersion(version)?�ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
     * ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����
     * ʾ�� 1��
     * ���룺n = 5, bad = 4
     * �����4
     * ���ͣ�
     * ���� isBadVersion(3) -> false
     * ���� isBadVersion(5)?-> true
     * ���� isBadVersion(4)?-> true
     * ���ԣ�4 �ǵ�һ������İ汾��
     * ʾ�� 2��
     * ���룺n = 1, bad = 1
     * �����1
     * ��ʾ��
     * 1 <= bad <= n <= 231 - 1
     */

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int version = start + (end - start) / 2;
        while (start < end) {
            if (isBadVersion(version)) {
                end = version;
            } else {
                start = version + 1;
            }
            version = start + (end - start) / 2;
        }
        return start;
    }

    public boolean isBadVersion(int n) {
        int bad = 100000000;
        if (n >= bad) {
            return true;
        }
        return false;
    }

    /**
     * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
     * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
     * �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
     * ʾ�� 1:
     * ����: nums = [1,3,5,6], target = 5
     * ���: 2
     * ʾ��?2:
     * ����: nums = [1,3,5,6], target = 2
     * ���: 1
     * ʾ�� 3:
     * ����: nums = [1,3,5,6], target = 7
     * ���: 4
     * ��ʾ:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums Ϊ?���ظ�Ԫ��?��?����?��������
     * -104 <= target <= 104
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = end / 2;
        while (start < end) {
            if (nums[index] == target) {
                break;
            } else {
                if (nums[index] > target) {
                    if (index == end) {
                        break;
                    } else {
                        end = index;
                    }
                } else {
                    if (index == start) {
                        break;
                    } else {
                        start = index;
                    }
                }
            }
            index = (start + end) / 2;
        }
        if (nums[index] == target) {
            return index;
        }
        if (nums[start] > target) {
            return start;
        }
        if (nums[end] < target) {
            return end + 1;
        } else {
            return end;
        }
    }
}
