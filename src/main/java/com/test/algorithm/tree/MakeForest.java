package com.test.algorithm.tree;

import java.util.*;

public class MakeForest {
    public static List<TreeNode> makeForestByDeletingNodes(TreeNode root, int[] toDeleteValueList) {
        List<TreeNode> forestNodes = new ArrayList<>();
        boolean isRootDeleted = false;
        for (int i=0; i<toDeleteValueList.length; i++) {
            if (root.getData() == toDeleteValueList[i]) {
                isRootDeleted = true;
            }
            List<TreeNode> childNodes = searchAndDeleteNodeAndReturnChildren(root, toDeleteValueList[i]);
            forestNodes.addAll(childNodes);
        }
        if (!isRootDeleted) {
            forestNodes.add(root);
        }
        return forestNodes;
    }

    public static List<TreeNode> searchAndDeleteNodeAndReturnChildren(TreeNode root, int toDeleteValue) {
        if (root == null) {
            return null;
        }

        List<TreeNode> childNodes = null;
        if(root.getData() == toDeleteValue) {
            childNodes = new ArrayList<>();
            if (root.getLeft() != null) {
                childNodes.add(root.getLeft());
            }
            if (root.getRight() != null) {
                childNodes.add(root.getRight());
            }
            return childNodes;
        }
        if(root.getLeft() != null && root.getLeft().getData() == toDeleteValue) {
            childNodes = new ArrayList<>();
            if (root.getLeft().getLeft() != null) {
                childNodes.add(root.getLeft().getLeft());
            }
            if (root.getLeft().getRight() != null) {
                childNodes.add(root.getLeft().getRight());
            }
            root.setLeft(null);
            return childNodes;
        }
        if(root.getRight() != null && root.getRight().getData() == toDeleteValue) {
            childNodes = new ArrayList<>();
            if (root.getRight().getLeft() != null) {
                childNodes.add(root.getRight().getLeft());
            }
            if (root.getRight().getRight() != null) {
                childNodes.add(root.getRight().getRight());
            }
            root.setRight(null);
            return childNodes;
        }
        childNodes = searchAndDeleteNodeAndReturnChildren(root.getLeft(), toDeleteValue);
        if (childNodes == null) {
            childNodes = searchAndDeleteNodeAndReturnChildren(root.getRight(), toDeleteValue);
        }
        return childNodes;
    }


    public static void main(String args[] ) throws Exception {
        TreeNode root = makeTree();
        List<TreeNode> forest = makeForestByDeletingNodes(root, new int[]{3,5});
        for (TreeNode node : forest) {
            printTree(node);
            System.out.println();
        }
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        printTree(node.getLeft());
        printTree(node.getRight());
    }

    private static TreeNode makeTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node6.setRight(node8);
        node7.setLeft(node9);
        node7.setRight(node10);

        return root;
    }
}

