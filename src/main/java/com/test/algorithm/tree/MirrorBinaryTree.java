package com.test.algorithm.tree;

public class MirrorBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(5));

        printTreeInOrder(root);

        mirrorBinaryTree(root);
        printTreeInOrder(root);
    }

    private static TreeNode mirrorBinaryTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode leftMirror = mirrorBinaryTree(root.getRight());
        TreeNode rightMirror = mirrorBinaryTree(root.getLeft());

        root.setLeft(leftMirror);
        root.setRight(rightMirror);
        return root;
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
