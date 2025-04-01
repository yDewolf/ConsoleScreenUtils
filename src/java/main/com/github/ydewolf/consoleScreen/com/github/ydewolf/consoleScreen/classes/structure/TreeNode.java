package com.github.ydewolf.consoleScreen.classes.structure;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public class TreeNode implements TreeNodeInterface {
    protected NodeTree tree = null;
    protected ArrayList<Integer> child_nodes = new ArrayList<Integer>();

    @Override
    public int addNode(TreeNodeInterface node) {
        int node_idx = this.tree.listen_add(this, node);
        this.child_nodes.add(node_idx);

        return node_idx;
    }

    @Override
    public void removeNode(int idx) {
        this.tree.listen_remove(idx);
        this.child_nodes.remove((Object) idx);
    }

    @Override
    public TreeNode getNode(int idx) {
        return getNodes()[idx];   
    }
    
    @Override
    public TreeNode[] getNodes() {
        TreeNode[] tree_nodes = this.tree.getNodes();
        TreeNode[] nodes = new TreeNode[this.child_nodes.size()];
        for (int idx : child_nodes) {
            nodes[idx] = tree_nodes[idx];
        }

        return nodes;
    }
}
