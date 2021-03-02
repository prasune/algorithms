package com.test.algorithm.tree;

public class KthMaxValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        int k = 3;
        printKthMaxValue(root, k, new IntegerHolder());
    }

    private static void printKthMaxValue(TreeNode root, int k, IntegerHolder countHolder) {
        if (root == null || k < countHolder.count) {
            return;
        }
        printKthMaxValue(root.getRight(), k, countHolder);
        countHolder.count++;
        if (k == countHolder.count) {
            System.out.println("Kth maximum value is " + root.getData());
            return;
        }
        printKthMaxValue(root.getLeft(), k, countHolder);
    }

    public static class IntegerHolder {
        private int count = 0;
    }

    private static void printTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printTreeInOrder(root.getLeft());
        System.out.println(root.getData());
        printTreeInOrder(root.getRight());
    }
}
