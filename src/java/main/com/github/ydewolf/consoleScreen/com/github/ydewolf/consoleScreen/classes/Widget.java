package com.github.ydewolf.consoleScreen.classes;

import com.github.ydewolf.consoleScreen.interfaces.WidgetInterface;

public class Widget implements WidgetInterface {
    public int[][] content = new int[SIZE_Y][SIZE_X];
    
    @Override
    public void set_pos_value(int[] pos, int value) {
        this.content[pos[1]][pos[0]] = value;
    }
}
