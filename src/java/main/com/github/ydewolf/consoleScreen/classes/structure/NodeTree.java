package com.github.ydewolf.consoleScreen.classes.structure;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.structure.NodeTreeInterface;
import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public class NodeTree extends TreeNode implements NodeTreeInterface {
    private ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();


    @Override
    public void listen_remove(int node_idx) {
        super.child_nodes.remove((Object) node_idx);
        this.nodes.remove(node_idx);
    }

    @Override
    public int addNode(TreeNodeInterface node) {
        this.nodes.add((TreeNode) node);
        int node_idx = this.nodes.size() - 1;
        
        return node_idx;
    }

    @Override
    public int listen_add(TreeNodeInterface parent, TreeNodeInterface node) {
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
}
