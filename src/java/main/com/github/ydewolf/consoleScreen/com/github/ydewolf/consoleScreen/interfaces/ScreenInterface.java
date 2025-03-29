package com.github.ydewolf.consoleScreen.interfaces;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.classes.Widget;

public interface ScreenInterface {
    public final int SIZE_X = 50;
    public final int SIZE_Y = 20;

    /*
     * Values in screen should be mapped to a value in screen_mask
     * Basically like an index that points to a value in the mask
     */
    public int[][] screen = new int[SIZE_X][SIZE_Y];
    public static final String[] screen_mask = {};

    public ArrayList<WidgetInterface> widgets = new ArrayList<WidgetInterface>();

    public String[][] getMasked();

    public int getWidgetIdx(Widget widget);
    /*
     * Returns -1 if the widget couldn't be added
     * Returns the widget Idx if the widget was added
     */
    public int addWidget(Widget widget);
    // True if the widget was removed
    public boolean removeWidget(int idx);
}