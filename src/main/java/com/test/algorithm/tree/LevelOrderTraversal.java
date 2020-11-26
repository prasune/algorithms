package com.test.algorithm.tree;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        printInLevelOrder(root);
    }

    private static void printInLevelOrder(TreeNode root) {

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            System.out.println(node);
            if (node.getLeft() != null) {
                treeNodeQueue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                treeNodeQueue.add(node.getRight());
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
