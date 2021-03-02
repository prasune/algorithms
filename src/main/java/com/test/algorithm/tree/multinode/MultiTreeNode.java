package com.test.algorithm.tree.multinode;

import java.util.List;

public class MultiTreeNode {

    private Integer data;

    private List<MultiTreeNode> nodes;

    public MultiTreeNode() {
    }

    public MultiTreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public List<MultiTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<MultiTreeNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "MultiTreeNode{" +
                "data=" + data +
                ", nodes=" + nodes +
                '}';
    }
}
