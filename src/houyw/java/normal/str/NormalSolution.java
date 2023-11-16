package houyw.java.normal.str;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/4/26 16:53
 * @Description:
 */
public class NormalSolution {


    public static void main(String[] args) {
        NormalSolution no = new NormalSolution();
        //int[] fips = {5, 4, 3, 2, 1, 6, 7, 8};
        // System.out.println(no.numTimesAllBlue(fips));
        String s = "ninmjmj";
        int[][] queries = {{6, 6, 0}, {1, 1, 1}, {2, 5, 4}, {1, 3, 1}, {5, 6, 1}};
        System.out.println(no.canMakePaliQueries(s, queries));


    }

    /**
     * �����ַ����е�������Ӵ�
     * 1 <= s.length <= 1000
     * s �������ֺ�Ӣ����ĸ���
     * complete
     */
    public String maxRetStr(String s) {
        List<String> lst = new ArrayList<>();
        String ret = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int start = i;
            int end = s.lastIndexOf(c);
            while (end != start) {
                int x = start;
                int y = end;
                while (y - x > 2 && s.charAt(x) == s.charAt(y)) {
                    x++;
                    y--;
                }
                if (y - x <= 2 && s.charAt(x) == s.charAt(y)) {
                    lst.add(s.substring(start, end + 1));
                    break;
                }
                end--;

                while (s.charAt(start) != s.charAt(end)) {
                    end--;
                }
            }

        }
        if (lst.size() > 0) {
            for (String str : lst) {
                if (str.length() > ret.length()) {
                    ret = str;
                }
            }
        }
        return ret;
    }

    /**
     * �����ַ������������õ�ǰ���ո�
     * �����һ���ַ������軹δ���ַ�ĩβ��Ϊ�����Ǹ��ţ���ȡ���ַ�������У��� ȷ�����ս���Ǹ������������� ������߶������ڣ���ٶ����Ϊ����
     * ������һ���ַ���ֱ��������һ���������ַ��򵽴�����Ľ�β���ַ��������ಿ�ֽ������ԡ�
     * ��ǰ�沽��������Щ����ת��Ϊ����������"123" -> 123�� "0032" -> 32�������û�ж������֣�������Ϊ 0 ����Ҫʱ���ķ��ţ��Ӳ��� 2 ��ʼ����
     * ������������� 32 λ�з���������Χ [?231,? 231?? 1] ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ��̶�Ϊ ?231 ������ 231?? 1 ������Ӧ�ñ��̶�Ϊ 231?? 1 ��
     * ����������Ϊ���ս����
     * complete
     */

    public int myAtoi(String s) {
        s = s.trim();
        int fuhao = 1;
        int start = 0;
        if (s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        if (c == '+' || c == '-') {
            start = 1;
            if (c == '-') {
                fuhao = -1;
            }
        }
        String ss = "";
        while (start < s.length() && s.charAt(start) >= 48 && s.charAt(start) <= 57) {
            ss += s.charAt(start);
            start++;
        }
        int num = 0;
        if (ss == "") {
            return 0;
        }
        try {
            num = Integer.valueOf(ss);
        } catch (NumberFormatException e) {
            if (fuhao < 0) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }


        return num * fuhao;
    }

    /**
     * ����һ���� n ��������ɵ�����?nums ����һ��Ŀ��ֵ target �������ҳ���������������ȫ�������Ҳ��ظ�����Ԫ��?[nums[a], nums[b], nums[c], nums[d]]?����������Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����
     * 0 <= a, b, c, d?< n
     * a��b��c �� d ������ͬ
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * ����԰� ����˳�� ���ش� ��
     * ʾ�� 1��
     * ���룺nums = [1,0,-1,0,-2,2], target = 0
     * �����[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * ʾ�� 2��
     * ���룺nums = [2,2,2,2,2], target = 8
     * �����[[2,2,2,2]]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**
     * ���� n?�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
     * ʾ�� 1��
     * ���룺n = 3
     * �����["((()))","(()())","(())()","()(())","()()()"]
     * ʾ�� 2��
     * ���룺n = 1
     * �����["()"]
     * complete
     */
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        Set<String> set = new HashSet();
        set.add("()");
        for (int i = 1; i <= n; i++) {
            Set<String> st = new HashSet();
            for (String s : set) {
                for (String s1 : set) {
                    st.add(s);
                    st.add("(" + s + ")");
                    if (s.length() + s1.length() <= i * 2) {
                        st.add(s + s1);
                        st.add(s1 + s);
                    }
                }
            }
            set = st;
        }
        for (String str : set) {
            if (str.length() == n * 2) {
                lst.add(str);
            }
        }
        return lst;
    }


    /**
     * ���������ַ���?a �� b��Ѱ���ظ������ַ��� a ����С������ʹ���ַ��� b ��Ϊ���Ӻ���ַ��� a ���Ӵ�������������򷵻� -1��
     * ע�⣺�ַ��� "abc"?�ظ����� 0 ���� ""���ظ����� 1 ����?"abc"���ظ����� 2 ����?"abcabc"��
     * ʾ�� 1��
     * ���룺a = "abcd", b = "cdabcdab"
     * �����3
     * ���ͣ�a �ظ����������Ϊ "abcdabcdabcd", ��ʱ b �����Ӵ���
     * ʾ�� 2��
     * ���룺a = "a", b = "aa"
     * �����2
     * ʾ�� 3��
     * ���룺a = "a", b = "a"
     * �����1
     * ʾ�� 4��
     * ���룺a = "abc", b = "wxyz"
     * �����-1
     * complete
     */
    public int repeatedStringMatch(String a, String b) {
        if (b == "") {
            return 0;
        }
        if (a.indexOf(b) > -1) {
            return 1;
        }
        String ss = a + a;
        //����һ�λ�û����Ҫô˵��Ҫô��Ҫ���Ӷ��Ҫô�Ͳ�������
        //���Ӷ�ε������b�бض���a
        if (ss.indexOf(b) == -1 && b.indexOf(a) == -1) {
            return -1;
        }
        if (ss.indexOf(b) > -1) {
            return 2;
        }
        //���Ӷ��
        if (b.indexOf(a) > -1) {
            int count = 2;
            while (ss.length() <= b.length()) {
                ss += a;
                count++;
                if (ss.indexOf(b) > -1) {
                    return count;
                }
            }
            ss += a;
            if (ss.indexOf(b) > -1) {
                return count + 1;
            }

        }
        return -1;
    }

    /**
     * ����һ������Ϊ n ���������� nums �� һ��Ŀ��ֵ target������� nums ��ѡ������������ʹ���ǵĺ��� target ��ӽ���
     * �������������ĺ͡�
     * �ٶ�ÿ������ֻ����ǡ��һ���⡣
     * ʾ�� 1��
     * ���룺nums = [-1,2,1,-4], target = 1
     * �����2
     * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2) ��
     * ʾ�� 2��
     * ���룺nums = [0,0,0], target = 1
     * �����0
     * complete
     */

    //��ʱ�ܳ�
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    set.add(sum);
                }
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (int n : set) {
            arr[index] = n;
            index++;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                if (i > 0) {
                    if (target - arr[i - 1] > arr[i] - target) {
                        return arr[i];
                    } else {
                        return arr[i - 1];
                    }
                } else {
                    return arr[i];
                }
            }
        }
        return arr[arr.length - 1];
    }

    //�����Ż�
    public int threeSumClosest1(int[] nums, int target) {
        // ����
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // ����Ѿ�����target�Ļ�, �϶�����ӽ���
                    return target;
                }

            }

        }

        return closestNum;
    }

    /**
     * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums �е��������� ������ͬ
     * ʾ�� 1��
     * ���룺nums = [1,2,3]
     * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * ʾ�� 2��
     * ���룺nums = [0,1]
     * �����[[0,1],[1,0]]
     * ʾ�� 3��
     * ���룺nums = [1]
     * �����[[1]]
     * complete
     * nice
     */
    public List<List<Integer>> permute(int[] nums) {
        //������һ����Ϊ���һλ�����Ϊ��׼��Ϊǰ��n-������ȫ���������������
        List<List<Integer>> retList = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> integers = new ArrayList<>();
            integers.add(nums[0]);
            retList.add(integers);
            return retList;
        }
        for (int i = 0; i < nums.length; i++) {
            //��׼��
            int end = nums[i];
            //��Ӧ����
            int[] numStart = new int[nums.length - 1];
            boolean isFand = false;
            for (int j = 0; j < numStart.length; j++) {
                if (nums[j] == end) {
                    //��׼��֮�����е����±�+1
                    isFand = true;
                }
                if (!isFand) {
                    numStart[j] = nums[j];
                } else {
                    numStart[j] = nums[j + 1];
                }
            }
            List<List<Integer>> list = permute(numStart);
            for (List<Integer> lst : list) {
                lst.add(end);
            }
            retList.addAll(list);

        }

        return retList;
    }

    /**
     * ����һ�� ���ظ�Ԫ�� ����������?candidates ��һ��Ŀ������?target?��
     * �ҳ�?candidates?�п���ʹ���ֺ�ΪĿ����?target �� ����?��ͬ��� �������б���ʽ���ء�
     * ����԰� ����˳�� ������Щ��ϡ�
     * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ��
     * �������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
     * ���ڸ��������룬��֤��Ϊ?target �Ĳ�ͬ��������� 150 ����
     * ʾ��?1��
     * ���룺candidates = [2,3,6,7], target = 7
     * �����[[2,2,3],[7]]
     * ���ͣ�
     * 2 �� 3 �����γ�һ���ѡ��2 + 2 + 3 = 7 ��ע�� 2 ����ʹ�ö�Ρ�
     * 7 Ҳ��һ����ѡ�� 7 = 7 ��
     * ������������ϡ�
     * ʾ��?2��
     * ����: candidates = [2,3,5], target = 8
     * ���: [[2,2,2,2],[2,3,3],[3,5]]
     * ʾ�� 3��
     * ����: candidates = [2], target = 1
     * ���: []
     * complete
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            //������i����Ϊ��׼��list
            int num = target - candidates[i];
            if (num < 0) {
                continue;
            }
            if (num == 0) {
                List<Integer> l = new ArrayList<>();
                l.add(target);
                retList.add(l);
            }
            List<List<Integer>> lst = combinationSum(candidates, num);
            if (lst.size() > 0) {
                for (List<Integer> list : lst) {
                    if (list.get(list.size() - 1) > candidates[i]) {
                        continue;
                    }
                    list.add(candidates[i]);
                    retList.add(list);
                }
            }
        }
        return retList;
    }

    /**
     * �� "100 game" �����Ϸ�У������������ѡ��� 1 �� 10 ������������
     * �ۼ������ͣ���ʹ���ۼ������� �ﵽ�򳬹�? 100 ����ң���Ϊʤ�ߡ�
     * ������ǽ���Ϸ�����Ϊ ����� ���� �ظ�ʹ�������� �أ�
     * ���磬������ҿ��������ӹ����������г�ȡ�� 1 �� 15 �����������Żأ���ֱ���ۼ������� >= 100��
     * ������������?maxChoosableInteger?���������п�ѡ������������?desiredTotal���ۼƺͣ���
     * ���ȳ��ֵ�����Ƿ�����Ӯ�򷵻� true?�����򷵻� false ��������λ�����Ϸʱ������ ��� ��
     * 1 <= maxChoosableInteger <= 20
     * 0 <= desiredTotal <= 300
     * ʾ�� 1��
     * ���룺maxChoosableInteger = 10, desiredTotal = 11
     * �����false
     * ���ͣ�
     * ���۵�һ�����ѡ���ĸ�������������ʧ�ܡ�
     * ��һ����ҿ���ѡ��� 1 �� 10 ��������
     * �����һ�����ѡ�� 1����ô�ڶ������ֻ��ѡ��� 2 �� 10 ��������
     * �ڶ�����ҿ���ͨ��ѡ������ 10����ô�ۻ���Ϊ 11 >= desiredTotal�����Ӷ�ȡ��ʤ��.
     * ͬ���أ���һ�����ѡ�����������������ڶ�����Ҷ���Ӯ��
     * ʾ�� 2:
     * ���룺maxChoosableInteger = 10, desiredTotal = 0
     * �����true
     * ʾ�� 3:
     * ���룺maxChoosableInteger = 10, desiredTotal = 1
     * �����true
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (desiredTotal - maxChoosableInteger < maxChoosableInteger) {
            return true;
        }
        int max = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (desiredTotal <= max) {
            //�ȳ��ֵĶ�����취��֤���ֺ��öԷ��������ʤ���־�

        }
        return false;
    }

    /**
     * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
     * ʾ�� 1��
     * <p>
     * ���룺nums = [1,1,2]
     * �����
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * ʾ�� 2��
     * ���룺nums = [1,2,3]
     * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * ��ʾ��
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[0]);
            lst.add(oneList);
        } else {
            List<Integer> allNums = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (allNums.contains(nums[i])) {
                    continue;
                } else {
                    allNums.add(nums[i]);
                }
                int[] newNum = new int[nums.length - 1];
                for (int j = 0; j < newNum.length; j++) {
                    if (j >= i) {
                        newNum[j] = nums[j + 1];
                    } else {
                        newNum[j] = nums[j];
                    }
                }
                List<List<Integer>> lists = permuteUnique(newNum);
                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                }
                lst.addAll(lists);
            }
        }
        return lst;
    }

    /**
     * ��������������������?dividend?�ͳ���?divisor�������������Ҫ
     * ��ʹ�ó˷��������� mod �������
     * ���ر�����?dividend?���Գ���?divisor?�õ����̡�
     * ���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2
     * ʾ��?1:
     * ����: dividend = 10, divisor = 3
     * ���: 3
     * ����: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * ʾ��?2:
     * ����: dividend = 7, divisor = -3
     * ���: -2
     * ����: 7/-3 = truncate(-2.33333..) = -2
     * ��ʾ��
     * �������ͳ�����Ϊ 32 λ�з���������
     * ������Ϊ?0��
     * �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [?231,? 231?? 1]�������У�����������������򷵻� 231?? 1��
     * ͨ������168,553�ύ����759,951
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        //������������Ƿ��������
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            //�ҳ��㹻�����2^n*divisor
            if ((t >> i) >= d) {
                //���������2^n
                result += 1 << i;
                //����������ȥ2^n*divisor
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }


    /**
     * �����ַ����б�?strs ���������� ����������� �������������в����ڣ����� -1 ��
     * �������� �������£�������Ϊĳ�ַ��� ���е������У��������������ַ����������У���
     * ?s?��?�����п���ͨ��ɾȥ�ַ���?s?�е�ĳЩ�ַ�ʵ�֡�
     * ���磬"abc"?�� "aebdc"?�������У���Ϊ������ɾ��"aebdc"�е��»����ַ����õ� "abc"?��
     * "aebdc"�������л�����"aebdc"�� "aeb"?�� ""?(���ַ���)��
     * ʾ�� 1��
     * ����: strs = ["aba","cdc","eae"]
     * ���: 3
     * ʾ�� 2:
     * ����: strs = ["aaa","aaa","aa"]
     * ���: -1
     * ��ʾ:
     * 2 <= strs.length <= 50
     * 1 <= strs[i].length <= 10
     * strs[i]?ֻ����СдӢ����ĸ
     */
    public int findLUSlength(String[] strs) {
        int len = 0;
        int num = 0;
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                nums[i] = nums[i] | (1 << 'z' - c);
            }
        }
        return nums[0];
    }

    /**
     * ����һ����������?nums�������������г�?nums[0] < nums[1] > nums[2] < nums[3]...?��˳��
     * ����Լ��������������鶼���Եõ�������ĿҪ��Ľ����
     * ʾ�� 1��
     * <p>
     * ���룺nums = [1,5,1,1,6,4]
     * �����[1,6,1,5,1,4]
     * ���ͣ�[1,4,1,5,1,6] ͬ���Ƿ�����ĿҪ��Ľ�������Ա����������ܡ�
     * ʾ�� 2��
     * ���룺nums = [1,3,2,2,3,1]
     * �����[2,3,1,3,1,2]?
     * <p>
     * ��ʾ��
     * 1 <= nums.length <= 5 * 104
     * 0 <= nums[i] <= 5000
     * ��Ŀ���ݱ�֤�����ڸ��������� nums �����ܲ���������ĿҪ��Ľ��
     */

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        int length = clone.length;
        Arrays.sort(clone);
        int middle = (length & 1) == 0 ? (length >> 1) : ((length + 1) >> 1);
        int r = middle - 1;
        int l = length - 1;
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 0) {
                nums[i] = clone[r--];
            } else {
                nums[i] = clone[l--];
            }
        }
    }

    /**
     * �������ְ������������ַ���?I��?V��?X��?L��C��D?��?M��
     * <p>
     * �ַ�          ��ֵ
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * ���磬 �������� 2 д��?II?����Ϊ�������е� 1��12 д��?XII?����Ϊ?X?+?II?��
     * 27 д��??XXVII,��Ϊ?XX?+?V?+?II?��
     * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��?IIII������?IV��
     * ���� 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ?IX��
     * �������Ĺ���ֻ�������������������
     * I?���Է���?V?(5) ��?X?(10) ����ߣ�����ʾ 4 �� 9��
     * X?���Է���?L?(50) ��?C?(100) ����ߣ�����ʾ 40 ��?90��?
     * C?���Է���?D?(500) ��?M?(1000) ����ߣ�����ʾ?400 ��?900��
     * ����һ������������תΪ�������֡�
     * ʾ��?1:
     * ����:?num = 3
     * ���: "III"
     * ʾ��?2:
     * ����:?num = 4
     * ���: "IV"
     * ʾ��?3:
     * ����:?num = 9
     * ���: "IX"
     * ʾ��?4:
     * ����:?num = 58
     * ���: "LVIII"
     * ����: L = 50, V = 5, III = 3.
     * ʾ��?5:
     * ����:?num = 1994
     * ���: "MCMXCIV"
     * ����: M = 1000, CM = 900, XC = 90, IV = 4.
     * 1 <= num <= 3999
     * complete
     */
    public String intToRoman(int num) {
        String str = "";
        String str1 = "";
        String str2 = "";
        String str3 = "";
        int ge = num % 10;
        int shi = num % 100;
        int bai = num % 1000;
        int qian = num / 1000;
        //��λ
        if (ge > 0) {
            if (ge == 9) {
                str = "IX";
            } else {
                int k = ge;
                if (ge == 4) {
                    str = "IV";
                    k = 0;
                } else if (ge > 4) {
                    str = "V";
                    k = ge - 5;
                }
                while (k > 0) {
                    str += "I";
                    k--;
                }
            }
        }
        //ʮλ
        if (shi >= 10) {
            shi = shi - ge;
            if (shi == 90) {
                str1 = "XC";
            } else {
                int k = shi;
                if (shi == 40) {
                    str1 = "XL";
                    k = 0;
                } else if (shi > 40) {
                    str1 = "L";
                    k = shi - 50;
                }
                while (k > 0) {
                    str1 += "X";
                    k = k - 10;
                }
            }
        }
        //��λ
        if (bai / 100 > 0) {
            bai = bai / 100;
            if (bai == 9) {
                str2 = "CM";
            } else {
                int k = bai;
                if (bai == 4) {
                    str2 = "CD";
                    k = 0;
                } else if (bai > 4) {
                    str2 = "D";
                    k = bai - 5;
                }
                while (k > 0) {
                    str2 += "C";
                    k = k - 1;
                }
            }
        }
        //ǧλ
        while (qian > 0) {
            str3 += "M";
            qian--;
        }
        return str3 + str2 + str1 + str;
    }

    /**
     * ����һ�������ֺ��������ɵ��ַ���?expression ������ͬ���ȼ�������ֺ��������
     * ���㲢�������п�����ϵĽ��������� ������˳�� ���ش𰸡�
     * ���ɵĲ��������������Ӧ���ֵ���� 32 λ������Χ����ͬ��������������� 104 ��
     * ʾ�� 1��
     * ���룺expression = "2-1-1"
     * �����[0,2]
     * ���ͣ�
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     * ʾ�� 2��
     * ���룺expression = "2*3-4*5"
     * �����[-34,-14,-10,-10,10]
     * ���ͣ�
     * (2*(3-(4*5))) = -34    112
     * ((2*3)-(4*5)) = -14   22
     * ((2*(3-4))*5) = -10   121
     * (2*((3-4)*5)) = -10   121
     * (((2*3)-4)*5) = 10   211
     * ��ʾ��
     * 1 <= expression.length <= 20
     * expression �����ֺ���� '+'��'-' �� '*' ��ɡ�
     * ������ʽ�е���������ֵ�ڷ�Χ [0, 99]?
     * complete
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> inexList = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                inexList.add(i);
            }
        }
        if (inexList.size() > 0) {
            nums.add(Integer.valueOf(expression.substring(0, inexList.get(0))));
        } else {
            nums.add(Integer.valueOf(expression));
        }

        for (int i = 0; i < inexList.size(); i++) {
            if (i == inexList.size() - 1) {
                nums.add(Integer.valueOf(expression.substring(inexList.get(i) + 1)));
            } else {
                nums.add(Integer.valueOf(expression.substring(inexList.get(i) + 1, inexList.get(i + 1))));
            }
        }
        return getList(nums, inexList, expression);
    }


    private List<Integer> getList(List<Integer> nums, List<Integer> exps, String expression) {
        List<Integer> result = new ArrayList<>();
        if (exps.size() == 0) {
            return nums;
        }
        if (exps.size() == 1) {
            result.add(getResult(nums.get(0), expression.charAt(exps.get(0)), nums.get(1)));
            return result;
        }
        for (int i = 0; i < nums.size() - 1; i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> leftExps = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            List<Integer> rightExps = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                left.add(nums.get(j));
                if (j < i) {
                    leftExps.add(exps.get(j));
                }
            }
            for (int j = i + 1; j < nums.size(); j++) {
                right.add(nums.get(j));
                if (j > i + 1) {
                    rightExps.add(exps.get(j - 1));
                }
            }
            List<Integer> list = getList(left, leftExps, expression);
            List<Integer> list1 = getList(right, rightExps, expression);
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list1.size(); k++) {
                    result.add(getResult(list.get(j), expression.charAt(exps.get(i)), list1.get(k)));
                }
            }
        }
        return result;
    }

    private int getResult(int left, char c, int right) {
        if (c == '+') {
            return left + right;
        } else if (c == '-') {
            return left - right;
        } else if (c == '*') {
            return left * right;
        }
        return -1;
    }

    /**
     * ����һ������Ϊ n ���±�� 1 ��ʼ�Ķ������ַ���������λ�ʼ���� 0 ��
     * ���ǻᰴ����ת�ö������ַ���������λ�������� 0 ��Ϊ 1����
     * ����һ���±�� 1 ��ʼ���������� flips ������ flips[i] ��ʾ��Ӧ�±� i ��λ�����ڵ� i ����ת��
     * �������ַ��� ǰ׺һ�� �����㣺�ڵ� i ��֮���� �� ����?[1, i] �ڵ�����λ���� 1 ��������λ���� 0 ��
     * ���ض������ַ����ڷ�ת������ ǰ׺һ�� �Ĵ�����
     * ʾ�� 1��
     * ���룺flips = [3,2,4,1,5]
     * �����2
     * ���ͣ��������ַ����ʼ�� "00000" ��
     * ִ�е� 1 �����ַ�����Ϊ "00100" ��������ǰ׺һ�µ������
     * ִ�е� 2 �����ַ�����Ϊ "01100" ��������ǰ׺һ�µ������
     * ִ�е� 3 �����ַ�����Ϊ "01110" ��������ǰ׺һ�µ������
     * ִ�е� 4 �����ַ�����Ϊ "11110" ������ǰ׺һ�µ������
     * ִ�е� 5 �����ַ�����Ϊ "11111" ������ǰ׺һ�µ������
     * �ڷ�ת�����У�ǰ׺һ�µĴ���Ϊ 2 �����Է��� 2 ��
     * ʾ�� 2��
     * <p>
     * ���룺flips = [4,1,2,3]
     * �����1
     * ���ͣ��������ַ����ʼ�� "0000" ��
     * ִ�е� 1 �����ַ�����Ϊ "0001" ��������ǰ׺һ�µ������
     * ִ�е� 2 �����ַ�����Ϊ "1001" ��������ǰ׺һ�µ������
     * ִ�е� 3 �����ַ�����Ϊ "1101" ��������ǰ׺һ�µ������
     * ִ�е� 4 �����ַ�����Ϊ "1111" ������ǰ׺һ�µ������
     * �ڷ�ת�����У�ǰ׺һ�µĴ���Ϊ 1 �����Է��� 1 ��
     */
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        //��ǰ�Ƿ�תһ������
        boolean[] result = new boolean[n];
        //�������ַ�����Ӧ��������
        int[] nums = new int[n];
        int count = 0;
        //ǰnλ����1�����ֵ
        int max = 0;
        for (int i = 0; i < n; i++) {
            //��ǰ�±�λ��1�� ��ǰ�±��1λ�Ƿ�תһ�£���ǰ�±귭תһ��
            nums[flips[i] - 1] = 1;
            if (nums[max] == 1) {
                result[max] = true;
                for (int j = max + 1; j < n; j++) {
                    if (nums[j] == 1 && result[j - 1]) {
                        result[j] = true;
                        max = j;
                    } else {
                        break;
                    }
                }
            }
            if (result[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * ����һ���ַ���?s�������?s?���Ӵ����м�⡣
     * ÿ�μ�⣬�����Ӵ������Ա�ʾΪ?queries[i] = [left, right, k]��
     * ���ǿ��� �������� �Ӵ�?s[left], ..., s[right]��������ѡ�� ��� k?���滻���κ�СдӢ����ĸ��?
     * ����������������У��Ӵ����Ա�ɻ�����ʽ���ַ�������ô�����Ϊ?true��������Ϊ?false��
     * ���ش�����?answer[]������?answer[i]?�ǵ�?i?�������Ӵ�?queries[i]?�ļ������
     * ע�⣺���滻ʱ���Ӵ��е�ÿ����ĸ��������Ϊ ������ ����м�����Ҳ����˵��
     * ���?s[left..right] = "aaa"?��?k = 2������ֻ���滻���е�������ĸ��
     * �����⣬�κμ�ⶼ�����޸�ԭʼ�ַ��� s��������Ϊÿ�μ�ⶼ�Ƕ����ģ�
     * ʾ����
     * ���룺s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
     * �����[true,false,false,true,true]
     * ���ͣ�
     * queries[0] : �Ӵ� = "d"�����ġ�
     * queries[1] :?�Ӵ� = "bc"�����ǻ��ġ�
     * queries[2] :?�Ӵ� = "abcd"��ֻ�滻 1 ���ַ��Ǳ䲻�ɻ��Ĵ��ġ�
     * queries[3] :?�Ӵ� = "abcd"�����Ա�ɻ��ĵ� "abba"�� Ҳ���Ա�� "baab"�������������� "bacd"��Ȼ��� "cd" �滻Ϊ "ab"��
     * queries[4] :?�Ӵ� = "abcda"�����Ա�ɻ��ĵ� "abcba"��
     * ��ʾ��
     * <p>
     * 1 <= s.length,?queries.length?<= 10^5
     * 0 <= queries[i][0] <= queries[i][1] <?s.length
     * 0 <= queries[i][2] <= s.length
     * s ��ֻ��СдӢ����ĸ
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>(queries.length);
        //ʹ�����鱣��ǰi+1λ�������Ӵ��Ķ�����λ�ã����磺 a��1 ��b��10.ab��11 aa����bb��0 ,������Ҫ�����
        //n��ʾ�ַ�����,��Ҫ0~n ��n+1λ������ 0~2����λ����Ҫ��0~0���0~2
        int[] arr = new int[s.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ (1 << (s.charAt(i - 1) - 'a'));
        }
        for (int i = 0; i < queries.length; i++) {
            //������1�ĸ�������ʾ�䵥���ַ�����
            int count = 0;
            //�����0~4 ��Ҫ��0~4���0~0
            //�����3~4 ��Ҫ��0~4���0~2
            //��ʾ�Ӵ���Ӧ����
            int num = arr[queries[i][0]] ^ arr[queries[i][1] + 1];
            while (num != 0) {
                num = num & (num - 1);
                count++;
            }
            list.add(count / 2 <= queries[i][2]);
        }
        return list;

    }
}
