package com.test.algorithm.tree.multinode;

import java.util.Arrays;

public class GenerateDataFromChildNodes {

    public static void main(String[] args) {
        MultiTreeNode root = new MultiTreeNode();
        MultiTreeNode node1 = new MultiTreeNode(6);
        MultiTreeNode node2 = new MultiTreeNode();
        root.setNodes(Arrays.asList(node1, node2));
        MultiTreeNode secondLevelNode1 = new MultiTreeNode(2);
        MultiTreeNode secondLevelNode2 = new MultiTreeNode(4);
        MultiTreeNode secondLevelNode3 = new MultiTreeNode(5);
        node2.setNodes(Arrays.asList(secondLevelNode1, secondLevelNode2, secondLevelNode3));

        generateDataUsingSumOfChildNodes(root);
        System.out.println(root);
    }

    private static void generateDataUsingSumOfChildNodes(MultiTreeNode root) {
        if (root.getData() == null) {
            if (root.getNodes() == null || root.getNodes().isEmpty()) {
                return;
            }
            int rootData = 0;
            for (MultiTreeNode node : root.getNodes()) {
                if (node.getData() == null) {
                    generateDataUsingSumOfChildNodes(node);
                }
                rootData = rootData + node.getData();
            }
            root.setData(rootData);
        }
    }
}
