package com.test.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printRightView(root);
    }

    private static void printRightView(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (queue1.size() == 0) {
                    System.out.println(node.getData());
                }
                if (node.getLeft() != null) {
                    queue2.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue2.add(node.getRight());
                }
            }
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                if (queue2.size() == 0) {
                    System.out.println(node.getData());
                }
                if (node.getLeft() != null) {
                    queue1.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue1.add(node.getRight());
                }
            }
        }
    }
}
