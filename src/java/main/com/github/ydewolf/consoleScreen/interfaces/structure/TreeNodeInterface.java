package com.github.ydewolf.consoleScreen.interfaces.structure;

import java.util.ArrayList;

public interface TreeNodeInterface {
    public static ArrayList<Integer> child_nodes = new ArrayList<Integer>();
    
    public static NodeTreeInterface tree = null;
    public static NodeTreeInterface parent = null;

    // Returns the node Idx inside widgets.
    public int addNode(TreeNodeInterface node);
    public void removeNode(int idx);

    public TreeNodeInterface getNode(int idx);
    public TreeNodeInterface[] getNodes();
}
