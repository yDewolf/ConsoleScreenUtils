package com.github.ydewolf.consoleScreen.classes;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.WidgetInterface;

public class Widget implements WidgetInterface {
    public int SIZE_X;
    public int SIZE_Y;

    public int[] offset = new int[2];

    public int[][] content;
    public ArrayList<Widget> widgets = new ArrayList<Widget>();
    
    public Widget(int size_x, int size_y) {
        this.SIZE_X = size_x;
        this.SIZE_Y = size_y;

        this.content = new int[this.SIZE_Y][this.SIZE_X];
    }

    @Override
    public void set_pos_value(int[] pos, int value) {
        this.content[pos[1]][pos[0]] = value;
    }

    public void clearContent() {
        for (int[] row : this.content) {
            for (int x = 0; x < this.SIZE_X; x++) {
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
            widget.offset[1] = current_y_offset;
            current_y_offset += widget.SIZE_Y;
        }

        for (Widget widget : this.widgets) {
            mapWidget(widget);
        }
    }

    // Maps the widget content to this.content using its offset
    public void mapWidget(Widget widget) {
        for (int y = 0; y < widget.SIZE_Y; y++) {
            for (int x = 0; x < widget.SIZE_X; x++) {
                this.content[y + widget.offset[1]][x + widget.offset[0]] = widget.content[y][x];
            }
        }
    }
}
