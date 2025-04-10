package com.github.ydewolf.consoleScreen.abstract_classes.structural;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.structure.NodeTreeInterface;
import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public abstract class BaseNodeTree extends BaseTreeNode implements NodeTreeInterface {
    protected ArrayList<BaseTreeNode> nodes = new ArrayList<BaseTreeNode>();
    protected int node_count = 0;

    @Override
    public void listen_remove(int node_idx) {
        super.child_nodes.remove(node_idx);
        this.nodes.remove(node_idx);

        this.setNodeCount(this.nodes.size());
    }

    @Override
    public int addNode(TreeNodeInterface node) {
        this.nodes.add((BaseTreeNode) node);
        node.setTree(this);
        int node_idx = this.nodes.size() - 1;

        this.setNodeCount(this.nodes.size());
        
        return node_idx;    
    }

    @Override
    public int listen_add(TreeNodeInterface parent, TreeNodeInterface node) {
        node.setTree(this);
        this.setNodeCount(this.nodes.size());

        return this.addNode(node);
    }
    
    @Override
    public BaseTreeNode getNode(int node_idx) {
        BaseTreeNode node = this.nodes.get(node_idx);

        return node;
    }

    @Override
    public BaseTreeNode[] getNodes() {
        BaseTreeNode[] nodes = new BaseTreeNode[this.nodes.size()];
        for (int idx = 0; idx < this.nodes.size(); idx++) {
            nodes[idx] = this.nodes.get(idx);
        }

        return nodes;
    }

    public ArrayList<BaseTreeNode> getNodeList() {
        return this.nodes;
    }

    public int getNodeCount() {
        return this.node_count;
    } 

    protected void setNodeCount(int value) {
        this.node_count = value;
    }
}
