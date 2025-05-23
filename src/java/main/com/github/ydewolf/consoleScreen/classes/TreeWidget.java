package com.github.ydewolf.consoleScreen.classes;

import com.github.ydewolf.consoleScreen.abstract_classes.structural.BaseTreeNode;
import com.github.ydewolf.consoleScreen.classes.style.Style;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.enums.MaskIndexes;
import com.github.ydewolf.consoleScreen.interfaces.TreeWidgetInterface;
import com.github.ydewolf.consoleScreen.interfaces.style.StyleInterface;

public class TreeWidget extends BaseTreeNode implements TreeWidgetInterface{
    public Style style;
    public int[][] content;

    public TreeWidget(int size_x, int size_y, FillTypes fill_type) {
        Style style = new Style(size_x, size_y, fill_type);
        this.style = style;

        this.content = new int[this.style.size[1]][this.style.size[0]];
        this.selectFillType(style.fill_type);
        this.init();
    }

    public TreeWidget(Style style) {
        this.style = style;
        this.init();
    }

    protected void init() {
        this.content = new int[this.style.size[1]][this.style.size[0]];
        this.selectFillType(style.fill_type);
    }

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
        BaseTreeNode[] nodes = this.getNodes();
        for (BaseTreeNode node : nodes) {
            if (TreeWidget.class.isAssignableFrom(node.getClass())) {
                widget_amount++;
            }
        }

        TreeWidget[] widgets = new TreeWidget[widget_amount];
        for (int idx = 0; idx < nodes.length; idx++) {
            if (TreeWidget.class.isAssignableFrom(nodes[idx].getClass())) {
                widgets[idx] = (TreeWidget) nodes[idx];
            }
        }

        return widgets;
    }  

    protected void selectFillType(FillTypes type) {
        if (type == null) {return;};
        switch (type) {
            case FillTypes.CHECKERS -> fill_grid();
            
            case FillTypes.BORDER -> apply_border();

            default -> {
            }
        }
    }

    protected void fill_grid() {
        int count = 1;
        int[] size = this.style.size;

        for (int y = 0; y < size[1]; y++) {
            for (int x = 0; x < size[0]; x++) {
                int[] pos = {x, y};
                setPos(pos, count);;

                count++;
                if (count > 2) {
                    count = 1;
                }
            }
        }
    }

    // Destructive
    protected void apply_border() {
        int[] size = this.style.size;
        final int[][] CORNERS = {
            {0, 0},
            {0, size[1] - 1},
            {size[0] - 1, 0},
            {size[0] - 1, size[1] - 1}
        };

        for (int y = 0; y < size[1]; y++) {
            for (int x = 0; x < size[0]; x++) {
                int[] pos = {x, y};
                if (x == 0 || x == size[0] - 1) {
                    setPos(pos, MaskIndexes.BORDER_SIDE.ordinal());
                    continue;
                }

                if (y == 0) {
                    setPos(pos, MaskIndexes.BORDER_TOP.ordinal());
                    continue;
                }

                if (y == size[1] - 1) {
                    setPos(pos, MaskIndexes.BORDER_BOTTOM.ordinal());
                }
            }
        }

        for (int[] pos : CORNERS) {
            setPos(pos, MaskIndexes.CORNER.ordinal());
        }
    }
}
