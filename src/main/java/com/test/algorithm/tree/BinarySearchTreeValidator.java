package com.test.algorithm.tree;

public class BinarySearchTreeValidator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        System.out.println("isBinarySearchTree: " + isBinarySearchTree(root));
    }

    private static boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() != null && root.getData() <= root.getLeft().getData() ||
                root.getRight() != null && root.getData() >= root.getRight().getData()) {
            return false;
        }
        return isBinarySearchTree(root.getLeft()) && isBinarySearchTree(root.getRight());
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
