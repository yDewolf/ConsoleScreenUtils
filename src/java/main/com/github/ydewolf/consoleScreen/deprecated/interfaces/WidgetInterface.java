package com.github.ydewolf.consoleScreen.deprecated.interfaces;

import com.github.ydewolf.consoleScreen.classes.style.Style;

import com.github.ydewolf.consoleScreen.deprecated.classes.Widget;

import java.util.ArrayList;

public interface WidgetInterface {
    public int[] size = new int[2];
    public int[] offset = new int[2];
    // Screen.screen_mask will be applied, modifying the final result
    public int[][] content = new int[size[1]][size[0]];
    public ArrayList<Widget> widgets = new ArrayList<Widget>();

    public Style style = new Style();

    public void set_pos_value(int[] pos, int value);

    public void set_style(Style style);

    public void set_size(int[] size);
    public void set_size(int x, int y);

    public void clearContent();

    public int getWidgetIdx(Widget widget);
    /*
     * Returns -1 if the widget couldn't be added
     * Returns the widget Idx if the widget was added
     */
    public int addWidget(Widget widget);
    // True if the widget was removed
    public boolean removeWidget(int idx);

    // Maps all the Widgets inside this.widgets
    // Can modify their offsets to properly fit them inside SIZE_X and SIZE_Y
    public void mapWidgets();

    // Maps the widget content to this.content using its offset
    public void mapWidget(Widget widget);
}
