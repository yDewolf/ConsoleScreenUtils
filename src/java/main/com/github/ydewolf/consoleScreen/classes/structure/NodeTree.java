package com.github.ydewolf.consoleScreen.classes.structure;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.structure.NodeTreeInterface;
import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public class NodeTree extends TreeNode implements NodeTreeInterface {
    private ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
    private int node_count = 0;

    @Override
    public void listen_remove(int node_idx) {
        super.child_nodes.remove(node_idx);
        this.nodes.remove(node_idx);

        this.setNodeCount(this.nodes.size());
    }

    @Override
    public int addNode(TreeNodeInterface node) {
        this.nodes.add((TreeNode) node);
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
    public TreeNode getNode(int node_idx) {
        TreeNode node = this.nodes.get(node_idx);

        return node;
    }

    @Override
    public TreeNode[] getNodes() {
        TreeNode[] nodes = new TreeNode[this.nodes.size()];
        for (int idx = 0; idx < this.nodes.size(); idx++) {
            nodes[idx] = this.nodes.get(idx);
        }

        return nodes;
    }

    public ArrayList<TreeNode> getNodeList() {
        return this.nodes;
    }

    public int getNodeCount() {
        return this.node_count;
    } 

    private void setNodeCount(int value) {
        this.node_count = value;
    }

}
