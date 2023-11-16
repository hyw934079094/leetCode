package houyw.common;

import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/6/28 11:19
 * @Description:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
    }
}
