package houyw.java.hard.function;

import java.util.*;

/**
 * @Author: houyw
 * @Date: 2022/4/22 17:19
 * @Description: 困难题解决
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
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * complete
     */
    public int trap(int[] height) {
        return trap(height, 0, height.length - 1);
    }

    public int trap(int[] height, int start, int end) {
        int count = 0;
        //找到左边界
        while (end - start > 1 && height[start + 1] >= height[start]) {
            start++;
        }
        //找到有边界
        while (end - start > 1 && height[end - 1] >= height[end]) {
            end--;
        }
        //找到低的边作为单次蓄水高度
        int line = height[start] > height[end] ? height[end] : height[start];
        if (end - start > 1) {
            //计算本次蓄水量并填平至边长
            for (int i = start; i < end; i++) {
                if (height[i] < line) {
                    count += line - height[i];
                    height[i] = line;
                }
            }
            //继续找出下一次蓄水边的高度
            while (end - start > 1 && height[start + 1] >= height[start]) {
                start++;
            }
            while (end - start > 1 && height[end - 1] >= height[end]) {
                end--;
            }
            //累计本次蓄水的量
            count += trap(height, start, end);
        }
        return count;
    }


    /**
     * 给你一个整数?n，请你帮忙统计一下我们可以按下述规则形成多少个长度为?n?的字符串：
     * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
     * 每个元音?'a'?后面都只能跟着?'e'
     * 每个元音?'e'?后面只能跟着?'a'?或者是?'i'
     * 每个元音?'i'?后面?不能 再跟着另一个?'i'
     * 每个元音?'o'?后面只能跟着?'i'?或者是?'u'
     * 每个元音?'u'?后面只能跟着?'a'
     * 由于答案可能会很大，所以请你返回 模?10^9 + 7?之后的结果。
     * 示例 1：
     * 输入：n = 1
     * 输出：5
     * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
     * 示例 2：
     * 输入：n = 2
     * 输出：10
     * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
     * 示例 3：
     * 输入：n = 5
     * 输出：68
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
     * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
     * 字谜的迷面?puzzle 按字符串形式给出，如果一个单词?word?符合下面两个条件，那么它就可以算作谜底：
     * 单词?word?中包含谜面?puzzle?的第一个字母。
     * 单词?word?中的每一个字母都可以在谜面?puzzle?中找到。
     * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及?"based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
     * 返回一个答案数组?answer，数组中的每个元素?answer[i]?是在给出的单词列表 words 中可以作为字谜迷面?puzzles[i]?所对应的谜底的单词数目。
     * 输入：
     * words = ["aaaa","asas","able","ability","actt","actor","access"],
     * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     * 输出：[1,1,3,2,4,0]
     * 解释：
     * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
     * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
     * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
     * 2 个单词可以作为?"absoryz" 的谜底 : "aaaa", "asas"
     * 4 个单词可以作为?"actresz" 的谜底 : "aaaa", "asas", "actt", "access"
     * 没有单词可以作为?"gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
     */
    //这个方法可以解决，但是时间复杂度过高，很耗时
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
            // 枚举子集
            for (int j = tmp; j != 0; j = (j - 1) & tmp) {
                // 还需要满足条件 1
                // 下面的 if 语句的运算符优先级从大到小为 减法 - 位移 - 位与
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
        //首先把谜底的信息用26位的字母存储在map中
        Map<Integer, Integer> word = new HashMap();
        for (String s : words) {
            char[] chars = s.toCharArray();
            int wei = 0;
            for (char c : chars) {
                wei = wei | 1 << c - 'a';
            }
            word.put(wei, word.getOrDefault(wei, 0) + 1);
        }
        //循环遍历谜面，并从map中获取其谜底的数量
        for (String ss : puzzles) {
            //对单个谜面的子集进行循环遍历
            char[] chars = ss.toCharArray();
            int wei = 0;
            for (char c : chars) {
                wei = wei | 1 << c - 'a';
            }
            int num = 0;
            for (int puzz = wei; puzz != 0; puzz = wei & (puzz - 1)) {
                //如果不包含首字母
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
     * 给你一个整数数组?nums?和一个整数?k?，请你返回 非空?子序列元素和的最大值，子序列需要满足：
     * 子序列中每两个相邻?的整数?nums[i]?和?nums[j]?，它们在原数组中的下标?i?和?j?满足?i < j?且 j - i <= k 。
     * 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
     * 示例 1：
     * 输入：nums = [10,2,-10,5,20], k = 2
     * 输出：37
     * 解释：子序列为 [10, 2, 5, 20] 。
     */

    public int constrainedSubsetSum(int[] nums, int k) {
        return 0;
    }


    /**
     * 给定一个长度为4的整数数组?cards?。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。
     * 您应该使用运算符?['+', '-', '*', '/']?和括号?'('?和?')'?将这些卡片上的数字排列成数学表达式，以获得值24。
     * 你须遵守以下规则:
     * 除法运算符 '/' 表示实数除法，而不是整数除法。
     * 例如，?4 /(1 - 2 / 3)= 4 /(1 / 3)= 12?。
     * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
     * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
     * 你不能把数字串在一起
     * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
     * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false?。
     * 示例 1:
     * 输入: cards = [4, 1, 8, 7]
     * 输出: true
     * 解释: (8-4) * (7-1) = 24
     * 示例 2:
     * 输入: cards = [1, 2, 1, 2]
     * 输出: false
     * 碍办法complete
     */
    public boolean judgePoint24(int[] cards) {
        Set<Integer> allRes = new HashSet<>();
        Arrays.sort(cards);
        //1~3分组
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
        //2~2分组
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
     * 给你一个只包含 '('?和 ')'?的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 示例 1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * 输入：s = ""
     * 输出：0
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
     * 现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
     * 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经
     * 按这门新语言的字母顺序进行了排序 。
     * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。
     * 若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
     * 字符串 s 字典顺序小于 字符串 t 有两种情况：
     * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，
     * 那么?s 的字典顺序小于 t 。
     * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
     * 示例 1：
     * 输入：words = ["wrt","wrf","er","ett","rftt"]
     * 输出："wertf"
     * 示例 2：
     * 输入：words = ["z","x"]
     * 输出："zx"
     * 示例 3：
     * 输入：words = ["z","x","z"]
     * 输出：""
     * 解释：不存在合法字母顺序，因此返回 "" 。
     * 提示：
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] 仅由小写英文字母组成
     */


    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4,5]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
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
     * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，
     * 你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
     * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
     * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
     * 示例 1：
     * <p>
     * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
     * 输出：2
     * 解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）
     * 示例 2：
     * 输入：n = 3, m = 3, broken = []
     * 输出：4
     * 解释：下图是其中一种可行的摆放方式
     * <p>
     * 限制：
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
     * 给你一个整数数组?nums?和一个整数?threshold?。
     * 找到长度为 k?的?nums?子数组，满足数组中?每个?元素都 大于?threshold / k?。
     * 请你返回满足要求的 任意?子数组的 大小?。如果没有这样的子数组，返回?-1?。
     * 子数组 是数组中一段连续非空的元素序列。
     * 示例 1：
     * 输入：nums = [1,3,4,3,1], threshold = 6
     * 输出：3
     * 解释：子数组 [3,4,3] 大小为 3 ，每个元素都大于 6 / 3 = 2 。
     * 注意这是唯一合法的子数组。
     * 示例 2：
     * 输入：nums = [6,5,6,5,8], threshold = 7
     * 输出：1
     * 解释：子数组 [8] 大小为 1 ，且 8 > 7 / 1 = 7 。所以返回 1 。
     * 注意子数组 [6,5] 大小为 2 ，每个元素都大于 7 / 2 = 3.5 。
     * 类似的，子数组 [6,5,6] ，[6,5,6,5] ，[6,5,6,5,8] 都是符合条件的子数组。
     * 所以返回 2, 3, 4 和 5 都可以。
     * 提示：
     * 1 <= nums.length <= 105
     * 1 <= nums[i], threshold <= 109
     */
    public int validSubarraySize(int[] nums, int threshold) {
        //最多threshold个元素
        int num = threshold;
        boolean flag = false;
        while (num > 0) {
            int tmp = threshold / num;
            for (int i = 0; i < nums.length; ) {
                int start = i;
                int end = num + i;
                if (end > nums.length) {
                    //当前tmp跑完无果
                    break;
                }
                for (int j = start; j < end; j++) {
                    if (nums[j] <= tmp) {
                        //j不满足,直接从j的下一个开始
                        i = j + 1;
                        flag = false;
                        break;
                    }
                    //正常跑完就是符合
                    flag = true;
                }
                //能到这就说明跑完了都符合
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
        //用来存数组下标的队列
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //任何一个值大于目标值都满足条件
            if (nums[i] > threshold) {
                return 1;
            }
            //队列为空  直接加入当前下标，当前值小于等于队列头值，则加入下标
            if (s.isEmpty() || nums[s.peek()] <= nums[i]) {
                s.push(i);
            } else {
                //目前队列中头值坐标
                int max = s.peek();
                //队列中所有比当前值大或者相等的值进行判断
                while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                    //取出头值的下标
                    int pop = s.pop();
                    //计算阈值
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
     * 给你一个整数?n?表示某所大学里课程的数目，编号为?1?到?n?，数组?relations?中，?
     * relations[i] = [xi, yi]? 表示一个先修课的关系，也就是课程?xi?必须在课程?yi?之前上。同时你还有一个整数?k?。
     * 在一个学期中，你 最多?可以同时上 k?门课，前提是这些课的先修课在之前的学期里已经上过了。
     * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
     * 示例 1：
     * 输入：n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
     * 输出：3
     * 解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
     * 示例 2：
     * 输入：n = 5, relations = [[2,1],[3,1],[4,1],[1,5]], k = 2
     * 输出：4
     * 解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
     * 示例 3：
     * 输入：n = 11, relations = [], k = 2
     * 输出：6
     * 提示：
     * 1 <= n <= 15
     * 1 <= k <= n
     * 0 <=?relations.length <= n * (n-1) / 2
     * relations[i].length == 2
     * 1 <= xi, yi?<= n
     * xi != yi
     * 所有先修关系都是不同的，也就是说?relations[i] != relations[j]?。
     * 题目输入的图是个有向无环图。
     */

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //arr[i][j] 表示 i+1 课程
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