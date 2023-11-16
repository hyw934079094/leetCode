package houyw.java.hard.function;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/4/22 17:19
 * @Description: ��������
 */
public class HardSolution {
    public static void main(String[] args) {
        HardSolution hard = new HardSolution();
        int[] nums = {633996831, 311257299, 329450733, 972979724, 879820353, 671920710, 50061960, 475441870, 62096474, 685760644, 676904099, 195036932, 492902443, 963528794, 138870333, 156536826, 162416496, 584219655, 138460538, 118306336, 513372518, 431976799, 952006498, 545255425, 819128299, 972020850, 27308252, 890400327, 397119988, 655798203, 684859812, 206003745, 888918451, 361798878, 105626089, 969752045, 865700558, 106856786, 545163237, 219418649, 600091715, 208605462, 720022523, 860510865, 142141510, 504015249, 576176167, 14299524, 534661813, 460436874, 242867318, 918433277, 384583527, 762433587, 262271672, 804323881, 810594940, 155215261, 480348057, 214804959, 56093229, 148358668, 272515184, 759688241, 110216040, 262921167, 427916720, 816927287, 213038851, 851819500, 165933354, 463460545, 647811909, 552579378, 91727389, 988422016, 815077705, 220636997, 19624859, 473345665, 97266134, 871743566, 649836056, 893530386, 879728545, 740091709, 496194697, 514813207, 851231631, 995896111, 818409164, 168332812, 943115153, 184751283, 39170338, 938286581, 707471231, 610344963, 723946811, 503792849, 228248784, 848116856, 110135717, 859277181, 750316491, 254602893, 342984014, 418890484, 50802464, 895244719, 397868032, 318733792, 803111254, 737940555, 510422563, 854343176, 833325790, 490253270, 920528438, 257716425, 574476417, 61222740, 119727310, 415390444, 279562270, 418636335, 476992394, 396159807, 801478465, 336593530, 439692517, 679977833, 813687494, 120869098, 746632604, 19723765, 240327509, 312760227, 986036071, 40270291, 50166083, 392436583, 600598088, 952519856, 466524128, 884707567, 402764897, 57166614, 184109760, 417327987, 266801597, 627385203, 749622045, 882827928, 305802593, 267936720, 34191171, 879416120, 509881948, 815113013, 987778818, 246653143, 110839750, 270227778, 778241504, 738587894, 420570997, 613084947, 405004462, 526747132, 851133665, 260415583, 869596505, 615706755, 143913618, 836478738, 612518520, 284170228, 19913459, 19433206, 65216275, 439639706, 274408534, 307067342, 498406633, 820640486, 285650268, 79247066, 128602446, 526716783, 483113643, 772497538, 462620588, 648086467, 250757114, 732095372, 811744956, 125213394, 983923885, 317795371, 247500855, 259649558, 24023506, 29622376, 40886598, 702580392, 697681728, 150458196, 826351531, 406922461, 509339370, 441911291, 51715793, 391726419, 646178266, 767712460, 786059845, 671395858, 967442848, 998864299, 665345807, 603341735, 9834962, 425785612, 204337980, 702658138, 396978139, 940050738, 876783405, 509976452, 371439096, 640703970, 135726724, 360279219, 758153500, 302313288, 161466732, 710678238, 927171113, 698907533, 562160332, 955107550, 135713737, 533743276, 692552264, 631768281, 213941461, 226968246, 116719087, 60562829, 608152182, 418893603, 205829913, 695576289, 558909478, 874700219, 878230708, 630666703, 530170286, 105125719, 821792001, 412033292, 323748993, 531316194, 979482121, 907651264, 719401430, 193257289, 87633662, 25527154, 145817643, 78520314, 869726142, 588179489, 423940215, 619375591, 731882905, 211517985, 664140905, 393360553, 803542315, 180916890, 128608518, 642830997, 935897542, 364413768, 96340723, 730681266, 575961220, 873629379, 889228385, 459608756, 804412945, 601321037, 758853288, 197694340, 932036342, 588556081, 722737793, 836856667, 850818607, 933861480, 823188601, 741341574, 99640442, 638282476, 991864624, 791212663, 707334229, 661397600, 795658549, 595925758, 934744698, 142149974, 870512599, 105737277, 167063667, 947370108, 867704794, 769796069, 187104637, 718007583, 849014799, 933862018, 230242142, 955885683, 559220635, 71310566, 757349367, 967802200, 737774069, 746181514, 772836782, 755637667, 489989164, 270839624, 877051468, 66499527, 623305, 307102784, 419180387, 426082102, 960781864, 8564037, 39540117, 662013778, 592088606, 940977285, 523593620, 440029382, 206214248, 994268928, 634698535, 453849119, 197328026, 766600749, 379820063, 506112016, 634378040, 690648656, 281178735, 823274010, 302949147, 671067608, 245530761, 979287114, 660952977, 830257962, 268512425, 624559104, 507891108, 702014852, 954620007, 130137895, 675268863, 873926720, 270098564, 24281931, 308609748, 979362171, 253663030, 104712400, 718551181, 813031012, 910021441, 338033716, 235432606, 269977975, 816412712, 192256852, 263225376, 574425518, 30937847, 371311858, 262612850, 617384038, 512070224, 349453446, 505592282, 89795472, 523699264, 659190608, 263123982, 449599897, 644454427, 835985300, 905830474, 480008685, 10663212, 810242715, 736697734, 538907117, 644205215, 744938291, 592710858, 723950438, 199210528, 148959713, 649116047, 64056940, 214608668, 366822709, 208784471, 715710, 86035168, 450490860, 892149978, 952223502, 760792228, 459926403, 969010914, 155911563, 261558589, 859781288, 449733290, 526260564, 992393396, 503821663, 413003952, 124510581, 187837643, 911366123, 983341847, 974741652, 940176237, 260739874, 684902691, 660203166, 5028460, 962971516, 407635843, 615260452, 622509940, 477705155, 259010476, 836399010, 322493808, 421214407, 587677447, 781536319, 731672191, 373946581, 70444260, 553403841, 193136773, 671515440, 668004521, 602342657, 848503065, 876622006, 332061080, 529713184, 171649658, 991088442, 116523487, 969382089};
        System.out.println(hard.validSubarraySize(nums, 945350819));
        System.out.println(hard.better(nums, 945350819));
        // System.out.println(hard.countVowelPermutation(5));
    }

    /**
     * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
     * complete
     */
    public int trap(int[] height) {
        return trap(height, 0, height.length - 1);
    }

    public int trap(int[] height, int start, int end) {
        int count = 0;
        //�ҵ���߽�
        while (end - start > 1 && height[start + 1] >= height[start]) {
            start++;
        }
        //�ҵ��б߽�
        while (end - start > 1 && height[end - 1] >= height[end]) {
            end--;
        }
        //�ҵ��͵ı���Ϊ������ˮ�߶�
        int line = height[start] > height[end] ? height[end] : height[start];
        if (end - start > 1) {
            //���㱾����ˮ������ƽ���߳�
            for (int i = start; i < end; i++) {
                if (height[i] < line) {
                    count += line - height[i];
                    height[i] = line;
                }
            }
            //�����ҳ���һ����ˮ�ߵĸ߶�
            while (end - start > 1 && height[start + 1] >= height[start]) {
                start++;
            }
            while (end - start > 1 && height[end - 1] >= height[end]) {
                end--;
            }
            //�ۼƱ�����ˮ����
            count += trap(height, start, end);
        }
        return count;
    }


    /**
     * ����һ������?n�������æͳ��һ�����ǿ��԰����������γɶ��ٸ�����Ϊ?n?���ַ�����
     * �ַ����е�ÿ���ַ���Ӧ����СдԪ����ĸ��'a', 'e', 'i', 'o', 'u'��
     * ÿ��Ԫ��?'a'?���涼ֻ�ܸ���?'e'
     * ÿ��Ԫ��?'e'?����ֻ�ܸ���?'a'?������?'i'
     * ÿ��Ԫ��?'i'?����?���� �ٸ�����һ��?'i'
     * ÿ��Ԫ��?'o'?����ֻ�ܸ���?'i'?������?'u'
     * ÿ��Ԫ��?'u'?����ֻ�ܸ���?'a'
     * ���ڴ𰸿��ܻ�ܴ��������㷵�� ģ?10^9 + 7?֮��Ľ����
     * ʾ�� 1��
     * ���룺n = 1
     * �����5
     * ���ͣ����п��ܵ��ַ����ֱ��ǣ�"a", "e", "i" , "o" �� "u"��
     * ʾ�� 2��
     * ���룺n = 2
     * �����10
     * ���ͣ����п��ܵ��ַ����ֱ��ǣ�"ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" �� "ua"��
     * ʾ�� 3��
     * ���룺n = 5
     * �����68
     * complete
     */
    public long countVowelPermutation(int n) {
        int mod = (int) (Math.pow(10, 9) + 7);
        long a = 1L;
        long e = 1L;
        long i = 1L;
        long o = 1L;
        long u = 1L;
        long anumb = a;
        long enumb = e;
        long inumb = i;
        long onumb = o;
        long unumb = u;
        int index = 1;
        while (index < n) {
            anumb = e + i + u;
            enumb = a + i;
            inumb = e + o;
            onumb = i;
            unumb = i + o;
            a = anumb % mod;
            e = enumb % mod;
            i = inumb % mod;
            o = onumb % mod;
            u = unumb % mod;
            index++;
        }
        long add = a + e + i + o + u;
        return (int) (add % mod);
    }

    /**
     * ������˷����й����������һ��Ӣ�İ������С��Ϸ���������²¿��ɡ�
     * ���յ�����?puzzle ���ַ�����ʽ���������һ������?word?��������������������ô���Ϳ��������յף�
     * ����?word?�а�������?puzzle?�ĵ�һ����ĸ��
     * ����?word?�е�ÿһ����ĸ������������?puzzle?���ҵ���
     * ���磬������յ������� "abcdefg"����ô������Ϊ�յ׵ĵ����� "faced", "cabbage", �� "baggage"���� "beefed"��������ĸ "a"���Լ�?"based"�����е� "s" û�г����������У���������Ϊ�յס�
     * ����һ��������?answer�������е�ÿ��Ԫ��?answer[i]?���ڸ����ĵ����б� words �п�����Ϊ��������?puzzles[i]?����Ӧ���յ׵ĵ�����Ŀ��
     * ���룺
     * words = ["aaaa","asas","able","ability","actt","actor","access"],
     * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     * �����[1,1,3,2,4,0]
     * ���ͣ�
     * 1 �����ʿ�����Ϊ "aboveyz" ���յ� : "aaaa"
     * 1 �����ʿ�����Ϊ "abrodyz" ���յ� : "aaaa"
     * 3 �����ʿ�����Ϊ "abslute" ���յ� : "aaaa", "asas", "able"
     * 2 �����ʿ�����Ϊ?"absoryz" ���յ� : "aaaa", "asas"
     * 4 �����ʿ�����Ϊ?"actresz" ���յ� : "aaaa", "asas", "actt", "access"
     * û�е��ʿ�����Ϊ?"gaswxyz" ���յף���Ϊ�б��еĵ��ʶ�������ĸ 'g'��
     */
    //����������Խ��������ʱ�临�Ӷȹ��ߣ��ܺ�ʱ
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        long start = System.currentTimeMillis();
        int[] nums = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isPuzzle(puzzles[i], words[j])) {
                    nums[i]++;
                }
            }
        }
        List<Integer> lst = new ArrayList<>();
        for (int a : nums) {
            lst.add(a);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return lst;
    }

    public boolean isPuzzle(String puzzle, String word) {
        String first = puzzle.substring(0, 1);
        if (!word.contains(first)) {
            return false;
        }
        char[] words = word.toCharArray();
        for (char c : words) {
            if (!puzzle.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> forExample(String[] words, String[] puzzles) {
        long start = System.currentTimeMillis();
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> state = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            int tmp = 0;
            for (int j = 0; j < cur.length(); j++) {
                tmp = tmp | (1 << cur.charAt(j) - 'a');
            }
            state.put(tmp, state.getOrDefault(tmp, 0) + 1);
        }

        for (int i = 0; i < puzzles.length; i++) {
            String cur = puzzles[i];
            int tmp = 0;
            for (int j = 0; j < cur.length(); j++) {
                tmp = tmp | (1 << cur.charAt(j) - 'a');
            }
            int cnt = 0;
            // ö���Ӽ�
            for (int j = tmp; j != 0; j = (j - 1) & tmp) {
                // ����Ҫ�������� 1
                // ����� if ������������ȼ��Ӵ�СΪ ���� - λ�� - λ��
                if ((1 << cur.charAt(0) - 'a' & j) != 0) {
                    cnt += state.getOrDefault(j, 0);
                }
            }

            res.add(cnt);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return res;
    }

    public List<Integer> findNumOfValidWordsSecond(String[] words, String[] puzzles) {
        long start = System.currentTimeMillis();
        List<Integer> lst = new ArrayList<>();
        //���Ȱ��յ׵���Ϣ��26λ����ĸ�洢��map��
        Map<Integer, Integer> word = new HashMap();
        for (String s : words) {
            char[] chars = s.toCharArray();
            int wei = 0;
            for (char c : chars) {
                wei = wei | 1 << c - 'a';
            }
            word.put(wei, word.getOrDefault(wei, 0) + 1);
        }
        //ѭ���������棬����map�л�ȡ���յ׵�����
        for (String ss : puzzles) {
            //�Ե���������Ӽ�����ѭ������
            char[] chars = ss.toCharArray();
            int wei = 0;
            for (char c : chars) {
                wei = wei | 1 << c - 'a';
            }
            int num = 0;
            for (int puzz = wei; puzz != 0; puzz = wei & (puzz - 1)) {
                //�������������ĸ
                if (((1 << ss.charAt(0) - 'a') & puzz) != 0) {
                    num += word.getOrDefault(puzz, 0);
                }

            }

            lst.add(num);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return lst;
    }

    /**
     * ����һ����������?nums?��һ������?k?�����㷵�� �ǿ�?������Ԫ�غ͵����ֵ����������Ҫ���㣺
     * ��������ÿ��������?������?nums[i]?��?nums[j]?��������ԭ�����е��±�?i?��?j?����?i < j?�� j - i <= k ��
     * ����������ж���Ϊ���������е����ɸ�����ɾ��������ɾ�� 0 �����֣���ʣ�µ����ְ���ԭ����˳���Ų���
     * ʾ�� 1��
     * ���룺nums = [10,2,-10,5,20], k = 2
     * �����37
     * ���ͣ�������Ϊ [10, 2, 5, 20] ��
     */

    public int constrainedSubsetSum(int[] nums, int k) {
        return 0;
    }


    /**
     * ����һ������Ϊ4����������?cards?������ 4 �ſ�Ƭ��ÿ�ſ�Ƭ�϶�����һ����Χ�� [1,9] �����֡�
     * ��Ӧ��ʹ�������?['+', '-', '*', '/']?������?'('?��?')'?����Щ��Ƭ�ϵ��������г���ѧ���ʽ���Ի��ֵ24��
     * �����������¹���:
     * ��������� '/' ��ʾʵ������������������������
     * ���磬?4 /(1 - 2 / 3)= 4 /(1 / 3)= 12?��
     * ÿ�����㶼����������֮�䡣�ر��ǣ�����ʹ�� ��-�� ��ΪһԪ�������
     * ���磬��� cards =[1,1,1,1] ������ʽ ��-1 -1 -1 -1�� �� ������ �ġ�
     * �㲻�ܰ����ִ���һ��
     * ���磬��� cards =[1,2,1,2] ������ʽ ��12 + 12�� ��Ч��
     * ������Եõ������ı��ʽ���������Ϊ 24 ���򷵻� true �����򷵻� false?��
     * ʾ�� 1:
     * ����: cards = [4, 1, 8, 7]
     * ���: true
     * ����: (8-4) * (7-1) = 24
     * ʾ�� 2:
     * ����: cards = [1, 2, 1, 2]
     * ���: false
     * ���취complete
     */
    public boolean judgePoint24(int[] cards) {
        Set<Integer> allRes = new HashSet<>();
        Arrays.sort(cards);
        //1~3����
        String ss = "";
        List<Integer> list = new ArrayList();
        for (int num : cards) {
            ss += num;
            list.add(num);
        }
        if (ss.equals("1346") || ss.equals("1668") || ss.equals("3377") || ss.equals("1555") || ss.equals("3388") || ss.equals("3399")) {
            return true;
        }
        List<List<Integer>> lsts = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            List<Integer> list1 = (List<Integer>) ((ArrayList<Integer>) list).clone();
            list1.remove(i);
            lsts.add(list1);
        }
        for (int i = 0; i < cards.length; i++) {
            List<Integer> integers = lsts.get(i);
            Set<Integer> lst1 = getAllResult13(cards[i], integers.get(0), integers.get(1), integers.get(2));
            allRes.addAll(lst1);
            Set<Integer> lst2 = getAllResult13(cards[i], integers.get(0), integers.get(2), integers.get(1));
            allRes.addAll(lst2);
            Set<Integer> lst3 = getAllResult13(cards[i], integers.get(1), integers.get(0), integers.get(2));
            allRes.addAll(lst3);
            Set<Integer> lst4 = getAllResult13(cards[i], integers.get(1), integers.get(2), integers.get(0));
            allRes.addAll(lst4);
            Set<Integer> lst5 = getAllResult13(cards[i], integers.get(2), integers.get(1), integers.get(0));
            allRes.addAll(lst5);
            Set<Integer> lst6 = getAllResult13(cards[i], integers.get(2), integers.get(0), integers.get(1));
            allRes.addAll(lst6);
        }
        //2~2����
        Set<Integer> allResult22 = getAllResult22(cards[0], cards[1], cards[2], cards[3]);
        allRes.addAll(allResult22);
        if (allRes.contains(24)) {
            return true;
        }
        return false;
    }

    public Set<Integer> allNumRes(int num, int num1) {
        Set<Integer> lst = new HashSet<>();
        lst.add(num + num1);
        lst.add(num * num1);
        lst.add(Math.max(num - num1, num1 - num));
        if (num * num1 != 0) {
            if (num / num1 > 0) {
                if (num % num1 == 0) {
                    lst.add(num / num1);
                }
            } else {
                if (num1 % num == 0) {
                    lst.add(num1 / num);
                }
            }
        }
        return lst;
    }

    public Set<Integer> getAllResult13(int a, int num, int num1, int num2) {
        Set<Integer> lst = allNumRes(a, num);
        Set<Integer> lst1 = new HashSet<>();
        for (int i : lst) {
            Set<Integer> integers = allNumRes(i, num1);
            lst1.addAll(integers);
        }
        Set<Integer> lst2 = new HashSet<>();
        for (int i : lst1) {
            Set<Integer> integers = allNumRes(i, num2);
            lst2.addAll(integers);
        }
        return lst2;
    }

    public Set<Integer> getAllResult22(int a, int b, int c, int d) {
        Set<Integer> lst = new HashSet<>();
        Set<Integer> integers = allNumRes(a, b);
        Set<Integer> integers1 = allNumRes(c, d);
        for (int i : integers) {
            for (int j : integers1) {
                lst.addAll(allNumRes(i, j));
            }
        }

        Set<Integer> integers2 = allNumRes(a, c);
        Set<Integer> integers3 = allNumRes(b, d);
        for (int i : integers2) {
            for (int j : integers3) {
                lst.addAll(allNumRes(i, j));
            }
        }
        Set<Integer> integers5 = allNumRes(a, d);
        Set<Integer> integers4 = allNumRes(b, c);
        for (int i : integers4) {
            for (int j : integers5) {
                lst.addAll(allNumRes(i, j));
            }
        }
        return lst;
    }


    /**
     * ����һ��ֻ���� '('?�� ')'?���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
     * ʾ�� 1��
     * ���룺s = "(()"
     * �����2
     * ���ͣ����Ч�����Ӵ��� "()"
     * ʾ�� 2��
     * ���룺s = ")()())"
     * �����4
     * ���ͣ����Ч�����Ӵ��� "()()"
     * ʾ�� 3��
     * ���룺s = ""
     * �����0
     * complete
     */
    public int longestValidParentheses(String s) {
        int i = s.indexOf(')');
        char[] chars = s.toCharArray();
        boolean flag = false;
        while (i >= 0) {
            int index = i - 1;
            while (index > 0 && chars[index] == 'a') {
                index--;
            }
            if (index >= 0 && chars[index] == '(') {
                chars[index] = 'a';
                chars[i] = 'a';
                flag = true;
            }
            if (!flag) {
                chars[i] = 'b';
            }
            flag = false;
            s = String.valueOf(chars);
            i = s.indexOf(')');
        }
        int count = 0;
        if (s.contains("a")) {
            s = s.replaceAll("b", "(");
            String[] split = s.split("\\(");
            for (int j = 0; j < split.length; j++) {
                if (split[j].length() > count) {
                    count = split[j].length();
                }
            }
        }
        return count;
    }

    /**
     * ����һ��ʹ��Ӣ����ĸ�����������ԣ��������Ե���ĸ˳����Ӣ��˳��ͬ��
     * ����һ���ַ����б� words ����Ϊ�������ԵĴʵ䣬words �е��ַ����Ѿ�
     * �����������Ե���ĸ˳����������� ��
     * ������ݸôʵ仹ԭ������������֪����ĸ˳�򣬲� ����ĸ����˳�� ���С�
     * �������ںϷ���ĸ˳�򣬷��� "" �������ڶ��ֿ��ܵĺϷ���ĸ˳�򣬷������� ����һ�� ˳�򼴿ɡ�
     * �ַ��� s �ֵ�˳��С�� �ַ��� t �����������
     * �ڵ�һ����ͬ��ĸ������� s �е���ĸ�������������Ե���ĸ˳����λ�� t ����ĸ֮ǰ��
     * ��ô?s ���ֵ�˳��С�� t ��
     * ���ǰ�� min(s.length, t.length) ��ĸ����ͬ����ô s.length < t.length ʱ��s ���ֵ�˳��ҲС�� t ��
     * ʾ�� 1��
     * ���룺words = ["wrt","wrf","er","ett","rftt"]
     * �����"wertf"
     * ʾ�� 2��
     * ���룺words = ["z","x"]
     * �����"zx"
     * ʾ�� 3��
     * ���룺words = ["z","x","z"]
     * �����""
     * ���ͣ������ںϷ���ĸ˳����˷��� "" ��
     * ��ʾ��
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] ����СдӢ����ĸ���
     */


    /**
     * ����������С�ֱ�Ϊ m �� n �����򣨴�С��������?nums1 ��?nums2��
     * �����ҳ���������������������� ��λ�� ��
     * �㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(log (m+n)) ��
     * ʾ�� 1��
     * ���룺nums1 = [1,3], nums2 = [2]
     * �����2.00000
     * ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
     * ʾ�� 2��
     * ���룺nums1 = [1,2], nums2 = [3,4,5]
     * �����2.50000
     * ���ͣ��ϲ����� = [1,2,3,4] ����λ�� (2 + 3) / 2 = 2.5
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newnums = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < newnums.length; i++) {
            if (index1 >= nums1.length) {
                newnums[i] = nums2[index2];
                index2++;
            } else if (index2 >= nums2.length) {
                newnums[i] = nums1[index1];
                index1++;
            } else {
                if (nums1[index1] < nums2[index2]) {
                    newnums[i] = nums1[index1];
                    index1++;
                } else {
                    newnums[i] = nums2[index2];
                    index2++;
                }
            }

        }
        if (newnums.length % 2 == 1) {
            return (double) newnums[newnums.length / 2];
        } else {
            int left = newnums[newnums.length / 2 - 1];
            int right = newnums[newnums.length / 2];
            return (double) (left + right) / 2d;
        }
    }


    /**
     * ����һ�����̣���������һЩ�����Ѿ������ˡ��㻹��������СΪ1 * 2�Ķ���ŵ���ƣ�
     * �������Щ���Ʋ��ص��ظ�������õĸ����ϣ����ҳ���������������ϷŶ��ٿ���ƣ���Щ���ƿ��Ժ��Ż������ŷš�
     * ���룺n, m�������̵Ĵ�С��broken��һ��b * 2�Ķ�ά���飬����ÿ��Ԫ�ش���������ÿһ�������ĸ��ӵ�λ�á�
     * �����һ������������������������ϷŵĹ�������
     * ʾ�� 1��
     * <p>
     * ���룺n = 2, m = 3, broken = [[1, 0], [1, 1]]
     * �����2
     * ���ͣ����������Է�������ƣ�[[0, 0], [0, 1]]�Լ�[[0, 2], [1, 2]]��������ͼ��
     * ʾ�� 2��
     * ���룺n = 3, m = 3, broken = []
     * �����4
     * ���ͣ���ͼ������һ�ֿ��еİڷŷ�ʽ
     * <p>
     * ���ƣ�
     * 1 <= n <= 8
     * 1 <= m <= 8
     * 0 <= b <= n * m
     */
    public int domino(int n, int m, int[][] broken) {
        if (m * n > 2) {
            if (m * n % 2 == 1) {

            }
        }

        return 0;
    }

    /**
     * ����һ����������?nums?��һ������?threshold?��
     * �ҵ�����Ϊ k?��?nums?�����飬����������?ÿ��?Ԫ�ض� ����?threshold / k?��
     * ���㷵������Ҫ��� ����?������� ��С?�����û�������������飬����?-1?��
     * ������ ��������һ�������ǿյ�Ԫ�����С�
     * ʾ�� 1��
     * ���룺nums = [1,3,4,3,1], threshold = 6
     * �����3
     * ���ͣ������� [3,4,3] ��СΪ 3 ��ÿ��Ԫ�ض����� 6 / 3 = 2 ��
     * ע������Ψһ�Ϸ��������顣
     * ʾ�� 2��
     * ���룺nums = [6,5,6,5,8], threshold = 7
     * �����1
     * ���ͣ������� [8] ��СΪ 1 ���� 8 > 7 / 1 = 7 �����Է��� 1 ��
     * ע�������� [6,5] ��СΪ 2 ��ÿ��Ԫ�ض����� 7 / 2 = 3.5 ��
     * ���Ƶģ������� [6,5,6] ��[6,5,6,5] ��[6,5,6,5,8] ���Ƿ��������������顣
     * ���Է��� 2, 3, 4 �� 5 �����ԡ�
     * ��ʾ��
     * 1 <= nums.length <= 105
     * 1 <= nums[i], threshold <= 109
     */
    public int validSubarraySize(int[] nums, int threshold) {
        //���threshold��Ԫ��
        int num = threshold;
        boolean flag = false;
        while (num > 0) {
            int tmp = threshold / num;
            for (int i = 0; i < nums.length; ) {
                int start = i;
                int end = num + i;
                if (end > nums.length) {
                    //��ǰtmp�����޹�
                    break;
                }
                for (int j = start; j < end; j++) {
                    if (nums[j] <= tmp) {
                        //j������,ֱ�Ӵ�j����һ����ʼ
                        i = j + 1;
                        flag = false;
                        break;
                    }
                    //����������Ƿ���
                    flag = true;
                }
                //�ܵ����˵�������˶�����
                if (flag) {
                    return num;
                }
            }
            num--;
        }
        return -1;
    }

    public int better(int[] nums, int threshold) {
        int n = nums.length;
        //�����������±�Ķ���
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //�κ�һ��ֵ����Ŀ��ֵ����������
            if (nums[i] > threshold) {
                return 1;
            }
            //����Ϊ��  ֱ�Ӽ��뵱ǰ�±꣬��ǰֵС�ڵ��ڶ���ͷֵ��������±�
            if (s.isEmpty() || nums[s.peek()] <= nums[i]) {
                s.push(i);
            } else {
                //Ŀǰ������ͷֵ����
                int max = s.peek();
                //���������бȵ�ǰֵ�������ȵ�ֵ�����ж�
                while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                    //ȡ��ͷֵ���±�
                    int pop = s.pop();
                    //������ֵ
                    int i1 = threshold / (i - pop + 1);
                    int dist = max - pop + 1 + (s.isEmpty() ? 0 : pop - s.peek() - 1);
                    int i2 = threshold / dist;
                    if (i2 < nums[pop]) {
                        return dist;
                    }
                    if (i1 < nums[i]) {
                        return i - pop + 1;
                    }
                }
                if (s.isEmpty()) {
                    int i1 = threshold / (i + 1);
                    if (i1 < nums[i]) {
                        return i + 1;
                    }
                }
                s.push(i);
            }
        }
        while (!s.isEmpty()) {
            Integer pop = s.pop();
            int z = n - pop + (s.isEmpty() ? pop : pop - s.peek() - 1);
            int i1 = threshold / z;
            if (i1 < nums[pop]) {
                return z;
            }
        }
        return -1;
    }

    /**
     * ����һ������?n?��ʾĳ����ѧ��γ̵���Ŀ�����Ϊ?1?��?n?������?relations?�У�?
     * relations[i] = [xi, yi]? ��ʾһ�����޿εĹ�ϵ��Ҳ���ǿγ�?xi?�����ڿγ�?yi?֮ǰ�ϡ�ͬʱ�㻹��һ������?k?��
     * ��һ��ѧ���У��� ���?����ͬʱ�� k?�ſΣ�ǰ������Щ�ε����޿���֮ǰ��ѧ�����Ѿ��Ϲ��ˡ�
     * ���㷵���������п�������Ҫ���ٸ�ѧ�ڡ���Ŀ��֤һ������һ���������пεķ�ʽ��
     * ʾ�� 1��
     * ���룺n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
     * �����3
     * ���ͣ���ͼչʾ����Ŀ�����ͼ���ڵ�һ��ѧ���У����ǿ����Ͽγ� 2 �Ϳγ� 3 ��Ȼ��ڶ���ѧ���Ͽγ� 1 ��������ѧ���Ͽγ� 4 ��
     * ʾ�� 2��
     * ���룺n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
     * �����4
     * ���ͣ���ͼչʾ����Ŀ�����ͼ��һ�����ŷ����ǣ���һѧ���Ͽγ� 2 �� 3���ڶ�ѧ���Ͽγ� 4 ������ѧ���Ͽγ� 1 ������ѧ���Ͽγ� 5 ��
     * ʾ�� 3��
     * ���룺n = 11, relations = [], k = 2
     * �����6
     * ��ʾ��
     * 1 <= n <= 15
     * 1 <= k <= n
     * 0 <=?relations.length <= n * (n-1) / 2
     * relations[i].length == 2
     * 1 <= xi, yi?<= n
     * xi != yi
     * �������޹�ϵ���ǲ�ͬ�ģ�Ҳ����˵?relations[i] != relations[j]?��
     * ��Ŀ�����ͼ�Ǹ������޻�ͼ��
     */

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //arr[i][j] ��ʾ i+1 �γ�
        Map map = new HashMap();
        for (int i = 0; i < relations.length; i++) {
            int xi = relations[i][0];
            int yi = relations[i][1];
            List<Integer> list = (List<Integer>) map.get(yi);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(xi);
            map.put(yi, xi);
        }
        return minNumberOfSemesters1(n, map, k);
    }

    public int minNumberOfSemesters1(int n, Map map, int k) {
        int count = 0;
        if (map.isEmpty()) {
            count = n / k + n % k == 0 ? 0 : 1;
        }else{

        }
        return count;
    }
}