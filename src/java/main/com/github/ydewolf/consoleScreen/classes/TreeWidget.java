package com.github.ydewolf.consoleScreen.classes;

import com.github.ydewolf.consoleScreen.classes.structure.TreeNode;
import com.github.ydewolf.consoleScreen.classes.style.Style;
import com.github.ydewolf.consoleScreen.deprecated.classes.Widget;
import com.github.ydewolf.consoleScreen.interfaces.TreeWidgetInterface;
import com.github.ydewolf.consoleScreen.interfaces.style.StyleInterface;

public class TreeWidget extends TreeNode implements TreeWidgetInterface{
    public Style style;
    public int[][] content;

    @Override
    public void setPos(int[] pos, int value) {
        this.content[pos[1]][pos[0]] = value;
    }

    @Override
    public void setStyle(StyleInterface style) {
        this.style = (Style) style;
        setSize(this.style.size);
    }

    @Override
    public void setSize(int x, int y) {
        int[] pos = {x, y};
        setSize(pos);
    }

    @Override
    public void setSize(int[] new_size) {
        this.style.size = new_size;
        this.content = new int[new_size[1]][new_size[0]];
    }

    @Override
    public void clearContent() {
        for (int[] row : this.content) {
            for (int x = 0; x < this.style.size[0]; x++) {
                row[x] = 0;
            }
        }
    }

    @Override
    public void mapWidgets() {
        this.clearContent();

        // Place widgets one below the other 
        int current_y_offset = 0;
        for (TreeWidget widget : this.getWidgets()) {
            widget.style.offset[1] = current_y_offset;
            current_y_offset += widget.style.size[1];
        }

        for (TreeWidget widget : this.getWidgets()) {
            mapWidget(widget);
        }
    }

    @Override
    public void mapWidget(TreeWidgetInterface widget) {
        TreeWidget widget_obj = (TreeWidget) widget;
        Style widget_style = widget_obj.style;
        for (int y = 0; y < widget_style.size[1]; y++) {

            for (int x = 0; x < widget_style.size[0]; x++) {
                this.content[y + widget_style.offset[1]][x + widget_style.offset[0]] = widget_obj.content[y][x];
            }
        }
    }
    
    protected TreeWidget[] getWidgets() {
        int widget_amount = 0;
        TreeNode[] nodes = this.getNodes();
        for (TreeNode node : nodes) {
            if (TreeWidget.class.isAssignableFrom(node.getClass())) {
                widget_amount++;
            }
        }

        TreeWidget[] widgets = new TreeWidget[widget_amount];
        for (int idx = 0; idx < nodes.length; idx++) {
            if (TreeWidget.class.isAssignableFrom(nodes[idx].getClass())) {
                nodes[idx] = nodes[idx];
            }
        }

        return widgets;
    }  
}
