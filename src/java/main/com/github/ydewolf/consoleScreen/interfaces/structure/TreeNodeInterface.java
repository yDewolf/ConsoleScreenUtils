package com.github.ydewolf.consoleScreen.interfaces.structure;

public interface TreeNodeInterface {
    // Returns the node Idx inside widgets.
    public int addNode(TreeNodeInterface node);
    public void removeNode(int idx);

    public TreeNodeInterface getNode(int idx);
    public TreeNodeInterface[] getNodes();

    public void setTree(NodeTreeInterface tree);
}
