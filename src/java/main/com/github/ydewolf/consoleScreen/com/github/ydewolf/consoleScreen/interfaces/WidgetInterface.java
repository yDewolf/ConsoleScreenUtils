package com.github.ydewolf.consoleScreen.interfaces;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.classes.Widget;

public interface WidgetInterface {
    public int SIZE_X = 10;
    public int SIZE_Y = 10;

    public int[] offset = new int[2];
    // Screen.screen_mask will be applied, modifying the final result
    public int[][] content = new int[SIZE_Y][SIZE_X];
    public ArrayList<Widget> widgets = new ArrayList<Widget>();

    public void set_pos_value(int[] pos, int value);

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
