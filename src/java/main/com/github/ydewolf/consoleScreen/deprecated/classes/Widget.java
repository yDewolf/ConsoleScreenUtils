package com.github.ydewolf.consoleScreen.deprecated.classes;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.classes.style.Style;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.enums.MaskIndexes;

import deprecated.interfaces.WidgetInterface;

public class Widget implements WidgetInterface {
    public int[][] content;
    public ArrayList<Widget> widgets = new ArrayList<Widget>();

    public Style style;

    public Widget(int size_x, int size_y, FillTypes fill_type) {
        Style style = new Style();
        set_style(style);

        set_size(size_x, size_y);

        this.content = new int[this.style.size[1]][this.style.size[0]];
        select_fill_type(fill_type);
    }

    public Widget(Style style) {
        set_style(style);
    }

    @Override
    public void set_pos_value(int[] pos, int value) {
        this.content[pos[1]][pos[0]] = value;
    }

    public ArrayList<Widget> getWidgets() {
        return this.widgets;
    }

    @Override
    public void set_style(Style style) {
        this.style = style;
    }

    public void set_size(int[] size) {
        this.style.size = size;

        this.content = new int[this.style.size[1]][this.style.size[0]];
    }

    public void set_size(int x, int y) {
        this.style.size[0] = x;
        this.style.size[1] = y;

        this.content = new int[this.style.size[1]][this.style.size[0]];
    }

    public void clearContent() {
        for (int[] row : this.content) {
            for (int x = 0; x < this.style.size[0]; x++) {
                row[x] = 0;
            }
        }
    }

    @Override
    public int addWidget(Widget widget) {
        if (this.widgets.contains(widget)) {
            return -1;
        }

        this.widgets.add(widget);
        return this.widgets.size() - 1;
    }

    @Override
    public boolean removeWidget(int idx) {
        if (idx >= this.widgets.size() || idx < 0) {
            return false; 
        }

        this.widgets.remove(idx);
        return true;
    }

    @Override
    public int getWidgetIdx(Widget widget) {
        return this.widgets.indexOf(widget);
    }

    // Maps all the Widgets inside this.widgets
    // Can modify their offsets to properly fit them inside SIZE_X and SIZE_Y
    public void mapWidgets() {
        this.clearContent();

        // Place widgets one below the other 
        int current_y_offset = 0;
        for (Widget widget : this.widgets) {
            widget.style.offset[1] = current_y_offset;
            current_y_offset += widget.style.size[1];
        }

        for (Widget widget : this.widgets) {
            mapWidget(widget);
        }
    }

    // Maps the widget content to this.content using its offset
    public void mapWidget(Widget widget) {
        Style widget_style = widget.style;
        for (int y = 0; y < widget_style.size[1]; y++) {

            for (int x = 0; x < widget_style.size[0]; x++) {
                this.content[y + widget_style.offset[1]][x + widget_style.offset[0]] = widget.content[y][x];
            }
        }
    }

    // Utils

    protected void select_fill_type(FillTypes type) {
        if (type == null) {return;};
        switch (type) {
            case FillTypes.CHECKERS:
                fill_grid();
                break;
            
            case FillTypes.BORDER:
                apply_border();
                break;
        

            default:
                break;
        }
    }

    protected void fill_grid() {
        int count = 1;
        int[] size = this.style.size;

        for (int y = 0; y < size[1]; y++) {
            for (int x = 0; x < size[0]; x++) {
                int[] pos = {x, y};
                set_pos_value(pos, count);;

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
                    set_pos_value(pos, MaskIndexes.BORDER_SIDE.ordinal());
                    continue;
                }

                if (y == 0) {
                    set_pos_value(pos, MaskIndexes.BORDER_TOP.ordinal());
                    continue;
                }

                if (y == size[1] - 1) {
                    set_pos_value(pos, MaskIndexes.BORDER_BOTTOM.ordinal());
                }
            }
        }


        for (int[] pos : CORNERS) {
            set_pos_value(pos, MaskIndexes.CORNER.ordinal());
        }
    }
}
