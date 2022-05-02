package ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * 问题：输入一个整数和一棵二元树。
 * * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
 * * 打印出和与输入整数相等的所有路径。
 * * 例如输入整数22和如下二元树
 * *  10
 * *  /\
 * *  5 12
 * *  /\
 * * 4  7
 * * 则打印出两条路径：10,12和10,5,7
 *
 * @author yuchao
 * @create 2022-03-02-9:01 下午
 */
public class TreePath {

    public static class Node {

        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> treePathSum(Node node, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        if (node == null) {
            return ans;
        }

        process(node, sum - node.val, ans,  Arrays.asList(node.val));

        return ans;
    }

    private static void process(Node node, int sum,List<List<Integer>> ans, List<Integer> path) {

        if (node.right != null) {
            ArrayList tmp = new ArrayList();
            tmp.addAll(path);
            tmp.add(node.right.val);
            process(node.right, sum - node.right.val, ans, tmp);
        }

        if (node.left != null) {
            ArrayList tmp = new ArrayList();
            tmp.addAll(path);
            tmp.add(node.left.val);
            process(node.left, sum - node.left.val, ans, tmp);
        }

        if (sum == 0) {
            ans.add(path);
        }
        return;

    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(5);
        head.right = new Node(12);

        head.left.left = new Node(4);
        head.left.right = new Node(7);

        List<List<Integer>> lists = treePathSum(head, 22);

        System.out.println(lists);

    }
}
