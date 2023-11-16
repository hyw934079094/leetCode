package houyw.common;

/**
 * @Author: DELL
 * @Date: 2022/7/30 14:41
 * @Description:
 */
public class TNode {
    public int val;
    public TNode left;
    public TNode right;
    public TNode next;

    public TNode() {}

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, TNode _left, TNode _right, TNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
