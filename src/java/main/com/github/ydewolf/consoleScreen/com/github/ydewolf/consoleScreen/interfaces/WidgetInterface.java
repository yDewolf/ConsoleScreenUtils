package com.github.ydewolf.consoleScreen.interfaces;

public interface WidgetInterface {
    public static final int SIZE_X = 10;
    public static final int SIZE_Y = 10;

    public static final int[] offset = new int[2];
    // Screen.screen_mask will be applied, modifying the final result
    public int[][] content = new int[SIZE_X][SIZE_Y];

    public void set_pos_value(int[] pos, int value);
}
