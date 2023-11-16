package houyw.java.myself.leetcode.two;

import houyw.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DELL
 * @Date: 2022/7/19 20:49
 * @Description:
 */
public class Day15 {

    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 示例 1:
     * 输入:?[1,2,3,null,5,null,4]
     * 输出:?[1,3,4]
     * 示例 2:
     * 输入:?[1,null,3]
     * 输出:?[1,3]
     * 示例 3:
     * 输入:?[]
     * 输出:?[]
     * 提示:
     * 二叉树的节点个数的范围是 [0,100]
     * -100?<= Node.val <= 100?
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(list.size()>0){
            lst.add(list.get(list.size()-1).val);
            List<TreeNode> l = new ArrayList<>();
            for(TreeNode node: list){
                if(node.left!=null){
                    l.add(node.left);
                }
                if(node.right!=null){
                    l.add(node.right);
                }
            }
            list = l;

        }
        return lst;
    }
}
