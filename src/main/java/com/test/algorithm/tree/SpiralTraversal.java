package com.test.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        printSpirally(root);
    }

    private static void printSpirally(TreeNode root) {

        Stack<TreeNode> rightToLeftStack = new Stack<>();
        rightToLeftStack.push(root);
        Stack<TreeNode> leftToRightStack = new Stack<>();
        while(!rightToLeftStack.isEmpty() || !leftToRightStack.isEmpty()) {
            while(!rightToLeftStack.isEmpty()) {
                TreeNode node = rightToLeftStack.pop();
                System.out.println(node);
                if (node.getLeft() != null) {
                    leftToRightStack.push(node.getLeft());
                }
                if (node.getRight() != null) {
                    leftToRightStack.push(node.getRight());
                }
            }
            while(!leftToRightStack.isEmpty()) {
                TreeNode node = leftToRightStack.pop();
                System.out.println(node);
                if (node.getRight() != null) {
                    rightToLeftStack.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    rightToLeftStack.push(node.getLeft());
                }
            }
        }
    }

    private static void printTreeInOrder(TreeNode root) {
        if (root == null){
            return;
        }
        printTreeInOrder(root.getLeft());
        System.out.println(root);
        printTreeInOrder(root.getRight());
    }
}
