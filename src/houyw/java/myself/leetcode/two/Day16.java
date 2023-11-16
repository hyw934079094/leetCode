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
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     * 实现 MyQueue 类：
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     * 说明：
     * 你 只能 使用标准的栈操作 —— 也就是只有?push to top,?peek/pop from top,?size, 和?is empty?操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 示例 1：
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     * 解释：
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     * 提示：
     * 1 <= x <= 9
     * 最多调用 100 次 push、pop、peek 和 empty
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
     * 进阶：
     * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
     */
    static class MyQueue {
        private Stack<Integer> st1;
        private Stack<Integer> st2;

        public MyQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        public void push(int x) {
            //入栈，每次入栈必须保证st1为空
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(x);
        }

        public int pop() {
            //出栈，每次st2必须为空
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
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * 实现 MinStack 类:
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     * 示例 1:
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * 提示：
     * -231?<= val <= 231?- 1
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push,?pop,?top, and?getMin最多被调用?3 * 104?次
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
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
     * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
     * 请你实现 Trie 类：
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串?word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * 示例：
     * 输入
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * 输出
     * [null, null, true, false, true, null, true]
     * 解释
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // 返回 True
     * trie.search("app");     // 返回 False
     * trie.startsWith("app"); // 返回 True
     * trie.insert("app");
     * trie.search("app");     // 返回 True
     * 提示：
     * 1 <= word.length, prefix.length <= 2000
     * word 和 prefix 仅由小写英文字母组成
     * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
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
