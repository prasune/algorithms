package com.test.algorithm.tree;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        System.out.println("lowestCommonAncestor for: " + lowestCommonAncestor(root, 3, 1));
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int data1, int data2) {
        if(root == null) {
            return null;
        }
        if (root.getData() < data1 && root.getData() < data2) {
            return lowestCommonAncestor(root.getRight(), data1, data2);
        } else if (root.getData() > data1 && root.getData() > data2) {
            return lowestCommonAncestor(root.getLeft(), data1, data2);
        }
        return root;
    }

    private static void printTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printTreeInOrder(root.getLeft());
        System.out.println(root);
        printTreeInOrder(root.getRight());
    }
}
