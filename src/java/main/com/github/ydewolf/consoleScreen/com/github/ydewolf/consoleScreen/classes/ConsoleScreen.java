package com.github.ydewolf.consoleScreen.classes;

import java.util.ArrayList;

import com.github.ydewolf.consoleScreen.interfaces.ScreenInterface;
import com.github.ydewolf.consoleScreen.interfaces.WidgetInterface;

public class ConsoleScreen implements ScreenInterface {
    public final int SIZE_X = 50;
    public final int SIZE_Y = 20;

    public int[][] screen = new int[SIZE_X][SIZE_Y];

    public ArrayList<WidgetInterface> widgets = new ArrayList<WidgetInterface>();
    public final String[] screen_mask = {};

    @Override
    public String[][] getMasked() {
        String[][] final_screen = new String[SIZE_Y][SIZE_X];
        
        for (int y = 0; y < SIZE_X; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if (this.screen[y][x] > screen_mask.length || this.screen[y][x] < 0) {
                    System.err.println("ERROR: Can't apply Screen Mask | Value at Screen can't be mapped");
                    return final_screen;
                }

                final_screen[y][x] = this.screen_mask[this.screen[y][x]];
            }
        }

        return final_screen;
    }

    @Override
    public int getWidgetIdx(Widget widget) {
        return this.widgets.indexOf(widget);
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
}
