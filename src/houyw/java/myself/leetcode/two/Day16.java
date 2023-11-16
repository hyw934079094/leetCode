package houyw.java.myself.leetcode.two;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: DELL
 * @Date: 2022/7/20 11:39
 * @Description:
 */
public class Day16 {
    public static void main(String[] args) {
        //Queue<Integer> que = new ArrayDeque<>();
        MinStack que = new MinStack();
        que.push(1);
        System.out.println(que.getMin());
        que.push(-1);
        System.out.println(que.getMin());
        que.push(-1);
        que.pop();
        que.pop();
        System.out.println(que.getMin());
    }

    /**
     * �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в�����push��pop��peek��empty����
     * ʵ�� MyQueue �ࣺ
     * void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
     * int pop() �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
     * int peek() ���ض��п�ͷ��Ԫ��
     * boolean empty() �������Ϊ�գ����� true �����򣬷��� false
     * ˵����
     * �� ֻ�� ʹ�ñ�׼��ջ���� ���� Ҳ����ֻ��?push to top,?peek/pop from top,?size, ��?is empty?�����ǺϷ��ġ�
     * ����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
     * ʾ�� 1��
     * ���룺
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * �����
     * [null, null, null, 1, 1, false]
     * ���ͣ�
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     * ��ʾ��
     * 1 <= x <= 9
     * ������ 100 �� push��pop��peek �� empty
     * �������в���������Ч�� �����磬һ���յĶ��в������ pop ���� peek ������
     * ���ף�
     * ���ܷ�ʵ��ÿ��������̯ʱ�临�Ӷ�Ϊ O(1) �Ķ��У����仰˵��ִ�� n ����������ʱ�临�Ӷ�Ϊ O(n) ����ʹ����һ���������ܻ��ѽϳ�ʱ�䡣
     */
    static class MyQueue {
        private Stack<Integer> st1;
        private Stack<Integer> st2;

        public MyQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        public void push(int x) {
            //��ջ��ÿ����ջ���뱣֤st1Ϊ��
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(x);
        }

        public int pop() {
            //��ջ��ÿ��st2����Ϊ��
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            return st1.pop();
        }

        public int peek() {
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            return st1.peek();
        }

        public boolean empty() {
            if (st1.isEmpty() && st2.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /**
     * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
     * ʵ�� MinStack ��:
     * MinStack() ��ʼ����ջ����
     * void push(int val) ��Ԫ��val�����ջ��
     * void pop() ɾ����ջ������Ԫ�ء�
     * int top() ��ȡ��ջ������Ԫ�ء�
     * int getMin() ��ȡ��ջ�е���СԪ�ء�
     * ʾ�� 1:
     * ���룺
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * �����
     * [null,null,null,null,-3,null,0,-2]
     * ���ͣ�
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> ���� -3.
     * minStack.pop();
     * minStack.top();      --> ���� 0.
     * minStack.getMin();   --> ���� -2.
     * ��ʾ��
     * -231?<= val <= 231?- 1
     * pop��top �� getMin ���������� �ǿ�ջ �ϵ���
     * push,?pop,?top, and?getMin��౻����?3 * 104?��
     */
    static class MinStack {
        private Stack<Integer> st;
        List<Integer> list;
        int min;
        int mintimes;

        public MinStack() {
            st = new Stack<>();
            list = new ArrayList<>();
        }

        public void push(int val) {
            if (list.size() == 0) {
                min = val;
                mintimes = 1;
            } else {
                if (mintimes > 0) {
                    if (min == val) {
                        mintimes++;
                    }
                    if (val < min) {
                        min = val;
                        mintimes = 1;
                    }
                }

            }
            st.push(val);
            list.add(val);
        }

        public void pop() {
            Integer pop = st.pop();
            list.remove(list.size() - 1);
            if (pop == min && mintimes > 0) {
                mintimes--;
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            if (mintimes == 0) {
                min = list.get(0);
                for (int i = 0; i < list.size(); i++) {
                    if (min > list.get(i)) {
                        min = list.get(i);
                    }
                }
            }
            return min;
        }
    }

    /**
     * Trie���������� "try"������˵ ǰ׺�� ��һ���������ݽṹ�����ڸ�Ч�ش洢�ͼ����ַ������ݼ��еļ���
     * ��һ���ݽṹ���൱���Ӧ���龰�������Զ������ƴд��顣
     * ����ʵ�� Trie �ࣺ
     * Trie() ��ʼ��ǰ׺������
     * void insert(String word) ��ǰ׺���в����ַ��� word ��
     * boolean search(String word) ����ַ��� word ��ǰ׺���У����� true�������ڼ���֮ǰ�Ѿ����룩�����򣬷��� false ��
     * boolean startsWith(String prefix) ���֮ǰ�Ѿ�������ַ���?word ��ǰ׺֮һΪ prefix ������ true �����򣬷��� false ��
     * ʾ����
     * ����
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * ���
     * [null, null, true, false, true, null, true]
     * ����
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // ���� True
     * trie.search("app");     // ���� False
     * trie.startsWith("app"); // ���� True
     * trie.insert("app");
     * trie.search("app");     // ���� True
     * ��ʾ��
     * 1 <= word.length, prefix.length <= 2000
     * word �� prefix ����СдӢ����ĸ���
     * insert��search �� startsWith ���ô��� �ܼ� ������ 3 * 104 ��
     */

    class Trie {
        List<String> words;

        public Trie() {
            words = new ArrayList<>();
        }

        public void insert(String word) {
            words.add(word);
        }

        public boolean search(String word) {
            return words.contains(word);
        }

        public boolean startsWith(String prefix) {
            for (String word : words) {
                if (word.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
}
