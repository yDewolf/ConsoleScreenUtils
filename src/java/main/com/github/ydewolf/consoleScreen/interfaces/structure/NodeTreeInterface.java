package com.github.ydewolf.consoleScreen.interfaces.structure;

public interface NodeTreeInterface extends TreeNodeInterface {
    /*
        The two functions below should be called by: 
            TreeNodeInterface.addWidget
            TreeNodeInterface.removeWidget
     */ 
    // Removes the target node from parent nodes
    // Also updates all_nodes
    public void listen_remove(int node_idx);
    // Adds the target node to the parent nodes
    // Also updates all_nodes
    public int listen_add(TreeNodeInterface parent, TreeNodeInterface node);
}
