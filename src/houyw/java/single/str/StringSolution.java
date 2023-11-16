package houyw.java.single.str;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/3/17 16:08
 * @Description:
 */
public class StringSolution {
    /**
     * ����ַ���������������֮һ������Գ�֮Ϊ ��Ч�����ַ�����valid parentheses string�����Լ�дΪ VPS����
     * �ַ�����һ�����ַ��� ""��������һ����Ϊ "(" �� ")" �ĵ��ַ���
     * �ַ�������дΪ AB��A �� B?�ַ������ӣ������� A �� B ���� ��Ч�����ַ��� ��
     * �ַ�������дΪ (A)������ A ��һ�� ��Ч�����ַ��� ��
     * ���Ƶأ����Զ����κ���Ч�����ַ���?S �� Ƕ����� depth(S)��
     * depth("") = 0
     * depth(C) = 0������ C �ǵ����ַ����ַ������Ҹ��ַ����� "(" ���� ")"
     * depth(A + B) = max(depth(A), depth(B))������ A �� B ���� ��Ч�����ַ���
     * depth("(" + A + ")") = 1 + depth(A)������ A ��һ�� ��Ч�����ַ���
     * ���磺""��"()()"��"()(()())" ���� ��Ч�����ַ�����Ƕ����ȷֱ�Ϊ 0��1��2������ ")(" ��"(()" ������ ��Ч�����ַ��� ��
     * <p>
     * ����һ�� ��Ч�����ַ��� s�����ظ��ַ����� s Ƕ����� ��
     * ���룺s = "(1+(2*3)+((8)/4))+1"
     * �����3
     * ���ͣ����� 8 ��Ƕ�׵� 3 �������С�
     * complete
     */
    public static int maxDepth(String s) {
        int count = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                leftCount++;
            }
            if (s.charAt(i) == ')') {
                if (leftCount > count) {
                    count = leftCount;
                }
                leftCount--;
            }

        }
        return count;
    }

    /**
     * ����һ���ַ��� s�����㷵�� ������ͬ�ַ�֮�������ַ����ĳ��� �����㳤��ʱ�����������ַ���
     * ������������������ַ��������� -1 ��
     * ���ַ��� ���ַ����е�һ�������ַ����С�
     * complete
     */
    public static int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        int max = -1;
        if (chars.length >= 2) {
            for (int i = chars.length - 1; i >= 0 && max < i; i--) {
                String str = String.valueOf(chars[i]);
                int start = s.indexOf(str);
                if (start < i) {
                    int temp = i - start - 1;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }


    /**
     * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
     * complete
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            while (i < j && !String.valueOf(chars[i]).matches("[0-9a-z]")) {
                i++;
            }

            while (i < j && !String.valueOf(chars[j]).matches("[0-9a-z]")) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * ����һ���ַ���?text������Ҫʹ�� text �е���ĸ��ƴ�վ����ܶ�ĵ���?"balloon"�����򣩡�
     * �ַ���?text �е�ÿ����ĸ���ֻ�ܱ�ʹ��һ�Ρ����㷵��������ƴ�ճ����ٸ�����?"balloon"��
     * complete
     */
    public static int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int n = 0;
        int o = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).equals("a")) {
                a++;
            }
            if (text.substring(i, i + 1).equals("b")) {
                b++;
            }
            if (text.substring(i, i + 1).equals("l")) {
                l++;
            }
            if (text.substring(i, i + 1).equals("n")) {
                n++;
            }
            if (text.substring(i, i + 1).equals("o")) {
                o++;
            }
        }
        if (a == 0 || b == 0 || l == 0 || n == 0 || o == 0) {
            return 0;
        }
        int x = a;
        if (b < x) {
            x = b;
        }
        if (n < x) {
            x = n;
        }
        int y = l;
        if (o < y) {
            y = o;
        }
        if (y > 2 * x) {
            return x;
        } else {
            return y / 2;
        }
    }

    /**
     * ����һ���������� nums �������һֵ�������г��� �������� ������ true ��
     * ���������ÿ��Ԫ�ػ�����ͬ������ false ��
     * ʾ�� 1��
     * ���룺nums = [1,2,3,1]
     * �����true
     * ʾ�� 2��
     * ���룺nums = [1,2,3,4]
     * �����false
     * ʾ��?3��
     * ���룺nums = [1,1,1,3,3,4,3,2,4,2]
     * �����true
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * complete
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * ����һ����������?nums ��һ������?k ���ж��������Ƿ�������� ��ͬ������?i?��?j ��
     * ���� nums[i] == nums[j] �� abs(i - j) <= k ��������ڣ����� true �����򣬷��� false ��
     * ʾ��?1��
     * ���룺nums = [1,2,3,1], k = 3
     * �����true
     * ʾ�� 2��
     * ���룺nums = [1,0,1,1], k = 1
     * �����true
     * ʾ�� 3��
     * ���룺nums = [1,2,3,1,2,3], k = 2
     * �����false
     * complete
     * nice
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.getOrDefault(nums[i], null) == null) {
                mp.put(nums[i], i);
            } else {
                if (i - mp.get(nums[i]) <= k) {
                    return true;
                }
                mp.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * ��дһ���㷨���ж�һ���� n �ǲ��ǿ�������
     * ����������?����Ϊ��
     * ����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���͡�
     * Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ������ ����ѭ�� ��ʼ�ձ䲻�� 1��
     * ���������� ���Ϊ?1����ô��������ǿ�������
     * ��� n �� ������ �ͷ��� true �����ǣ��򷵻� false ��
     * ʾ�� 1��
     * ���룺n = 19
     * �����true
     * ���ͣ�
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * ʾ�� 2��
     * ���룺n = 2
     * �����false
     */
    public boolean isHappy(int n) {
        Set set = new HashSet();
        int sum = 0;
        while (n != 1) {
            while (n / 10 > 0) {
                int num = n % 10;
                n = n / 10;
                sum += num * num;
            }
            n = n % 10;
            sum += n * n;
            if (sum == 1) {
                return true;
            } else {
                if (set.contains(sum)) {
                    return false;
                }
                set.add(sum);
            }
            n = sum;
            sum = 0;
        }
        return true;
    }

    /**
     * ���������ַ���?s?��?t?���ж������Ƿ���ͬ���ġ�
     * t.length == s.length
     * ���?s?�е��ַ����԰�ĳ��ӳ���ϵ�滻�õ�?t?����ô�������ַ�����ͬ���ġ�
     * ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���ͬʱ���ı��ַ���˳��
     * ��ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
     * ʾ�� 1:
     * ���룺s = "egg", t = "add"
     * �����true
     * ʾ�� 2��
     * ���룺s = "foo", t = "bar"
     * �����false
     * ʾ�� 3��
     * ���룺s = "paper", t = "title"
     * �����true
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mps = new HashMap();
        Map<Character, Character> mpt = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (mps.getOrDefault(sc, null) != null) {
                if (mps.get(sc) != tc) {
                    return false;
                }
            } else {
                mps.put(sc, tc);
            }

            if (mpt.getOrDefault(tc, null) != null) {
                if (mpt.get(tc) != sc) {
                    return false;
                }
            } else {
                mpt.put(tc, sc);
            }
        }
        return true;
    }


    /**
     * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
     * ע�⣺��?s �� t?��ÿ���ַ����ֵĴ�������ͬ�����?s �� t?��Ϊ��ĸ��λ�ʡ�
     * ʾ��?1:
     * ����: s = "anagram", t = "nagaram"
     * ���: true
     * ʾ�� 2:
     * ����: s = "rat", t = "car"
     * ���: false
     * ��ʾ:
     * 1 <= s.length, t.length <= 5 * 104
     * s �� t?������Сд��ĸ
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * ����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����������������
     * ʾ�� 1:
     * ����: num = 38
     * ���: 2
     * ����: ��λ��ӵĹ���Ϊ��
     * 38 --> 3 + 8 --> 11
     * 11 --> 1 + 1 --> 2
     * ����?2 ��һλ�������Է��� 2��
     * ʾ�� 2:
     * ����: num = 0
     * ���: 0
     * ��ʾ��
     * 0 <= num <= 231?- 1
     */
    public int addDigits(int num) {
        int newNum = num;
        while (newNum >= 10) {
            num = newNum;
            newNum = 0;
            while (num != 0) {
                newNum += num % 10;
                num = num / 10;
            }
        }
        return newNum;
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String str = "";
        int wei = 0;
        for (int i = 0; i < num1.length(); i++) {
            int numOne = Integer.valueOf(String.valueOf(num1.charAt(num1.length() - 1 - i)));
            int numTwo = 0;
            if (i < num2.length()) {
                numTwo = Integer.valueOf(num2.substring(num2.length() - 1 - i, num2.length() - i));
            }
            int sum = numOne + numTwo + wei;
            if (sum >= 10) {
                sum = sum - 10;
                wei = 1;
            } else {
                wei = 0;
            }
            str = sum + str;
        }
        if (wei > 0) {
            str = wei + str;
        }
        return str;
    }

    public int alternateDigitSum(int n) {
        int num1 = 0;
        int num2 = 0;
        int wei = 0;
        while (n > 0) {
            int num = n % 10;
            if (wei % 2 == 0) {
                num2 += num;
            } else {
                num1 += num;
            }
            wei++;
            n = n / 10;
        }
        if (wei % 2 == 0) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        List<String> list = new ArrayList();
        for (int i = 0; i < jewels.length(); i++) {
            list.add((String.valueOf(jewels.charAt(i))));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (list.contains(String.valueOf(stones.charAt(i)))) {
                count++;
            }
        }
        return count;
    }


    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int count = 0;
        while (left != right) {
            while (height[left] == 0 && left < right) {
                left++;
            }
            while (height[right] == 0 && left < right) {
                right--;
            }
            int x = Math.min(height[left], height[right]);
            for (int i = left; i <= right; i++) {
                height[i] = height[i] - x;
                if (height[i] < 0) {
                    count += height[i];
                    height[i] = 0;
                }
            }
        }

        return -count;
    }


    /**
     * ����һ�� n x n �� ���� �������� matrix �������ҳ�������ͨ�� matrix ���½�·�� �� ��С�� ��
     * �½�·�� ���Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�
     * ����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�У���λ�����·������ضԽ�������������ҵĵ�һ��Ԫ�أ���
     * ������˵��λ�� (row, col) ����һ��Ԫ��Ӧ���� (row + 1, col - 1)��(row + 1, col) ���� (row + 1, col + 1) ��
     */

    public int minFallingPathSum(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int length = result.length;
        int min  = 0;
        for (int i = 0; i < result[length - 1].length; i++) {
            result[length - 1][i] = matrix[length - 1][i];
        }
        for (int i = result.length - 2; i >= 0; i--) {
            for (int j = 0; j < result[i].length; j++) {
                int x = result[i + 1][j] + matrix[i][j];
                if (j == 0) {
                    result[i][j] = Math.min( matrix[i][j]+result[i+1][j+1],x);
                }else if(j==  result[i].length - 1){
                    result[i][j] = Math.min( matrix[i][j]+result[i+1][j-1],x);
                }else{
                    result[i][j] = Math.min(Math.min( matrix[i][j]+result[i+1][j-1],matrix[i][j]+result[i+1][j+1]),x);
                }
            }
        }
        for (int i = 0; i < result[0].length; i++) {
            if(i == 0){
                min = result[0][i];
            }else{
                min = Math.min(min,result[0][i]);
            }
        }
        return min;
    }



}
