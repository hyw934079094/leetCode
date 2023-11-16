package houyw.common.utils;

import houyw.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: houyw
 * @Date: 2021/8/31 16:56
 * @Description:
 */
public class TreeUtils {


    //树的深度
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    //将树以数组的形式输出
    public static Integer[] transferToIntegers(TreeNode treeNode) {
        List<TreeNode> allList = new ArrayList<>();
        List<TreeNode> lst = new ArrayList<>();
        allList.add(treeNode);
        lst.add(treeNode);
        boolean flag = true;
        while (flag) {
            List<TreeNode> newList = new ArrayList<>();
            int count = 0;
            for (TreeNode node : lst) {
                if (node != null) {
                    if (node.left == null && node.right == null) {
                        continue;
                    }
                    allList.add(node.left);
                    allList.add(node.right);
                    newList.add(node.left);
                    newList.add(node.right);
                    count++;
                }
            }
            lst = newList;
            if (count == 0) {
                flag = false;
            }
        }
        Integer[] integers = new Integer[allList.size()];
        for (int i = 0; i < integers.length; i++) {
            if (allList.get(i) == null) {
                integers[i] = null;
            } else {
                integers[i] = allList.get(i).val;
            }
        }
        return integers;
    }

    //将数组转化为一棵树
    public static TreeNode transferToTreeNode(Integer[] integers) {
        if (integers.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(integers[0]);
        List<TreeNode> lst = new ArrayList<>();
        lst.add(head);
        int index = 1;
        while (index < integers.length) {
            List<TreeNode> newlst = new ArrayList<>();
            for (TreeNode node : lst) {
                TreeNode left = null;
                TreeNode right = null;
                if (index < integers.length && integers[index] != null) {
                    left = new TreeNode(integers[index]);
                    newlst.add(left);
                }
                index++;
                if (index < integers.length && integers[index] != null) {
                    right = new TreeNode(integers[index]);
                    newlst.add(right);
                }
                index++;
                node.left = left;
                node.right = right;
            }
            lst = newlst;
        }
        return head;
    }

    public static void printTree(TreeNode root) {
        Integer[] integers = TreeUtils.transferToIntegers(root);
        String str = "[";
        boolean flag = integers.length ==1 &&integers[0] ==null;
        if (!flag) {
            for (Integer i : integers) {
                str += i + ",";
            }

            str = str.substring(0, str.length() - 1);


        }
        str += "]";
        System.out.println(str);
    }
}
