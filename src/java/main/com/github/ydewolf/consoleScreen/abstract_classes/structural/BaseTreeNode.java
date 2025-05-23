package com.github.ydewolf.consoleScreen.abstract_classes.structural;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.structure.NodeTreeInterface;
import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public abstract class BaseTreeNode implements TreeNodeInterface{
    protected BaseNodeTree tree = null;
    protected ArrayList<Integer> child_nodes = new ArrayList<Integer>();

    @Override
    public int addNode(TreeNodeInterface node) {
        if (this.tree.getNodeList().indexOf(node) != -1) {
            System.err.println("ERROR: can't add a node that is already added to the tree");
            return -1;
        }
        int node_idx = this.tree.listen_add(this, node);
        this.child_nodes.add(node_idx);

        return node_idx;
    }

    @Override
    public void removeNode(int idx) {
        if (idx < 0 || idx >= this.tree.getNodeCount()) {
            System.err.println("ERROR: Can't remove node at index " + idx + " because it isn't valid");
            return;
        }
        this.tree.listen_remove(idx);
        this.child_nodes.remove((Object) idx);
    }

    @Override
    public BaseTreeNode getNode(int idx) {
        return getNodes()[idx];   
    }
    
    @Override
    public BaseTreeNode[] getNodes() {
        BaseTreeNode[] tree_nodes = this.tree.getNodes();
        BaseTreeNode[] nodes = new BaseTreeNode[this.child_nodes.size()];
        int current_idx = 0;
        for (int idx : this.child_nodes) {
            nodes[current_idx] = tree_nodes[idx];
            current_idx++;
        }

        return nodes;
    }

    @Override
    public void setTree(NodeTreeInterface tree) {
        this.tree = (BaseNodeTree) tree;
    }
}
