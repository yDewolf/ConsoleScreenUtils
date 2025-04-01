package com.github.ydewolf.consoleScreen.deprecated.interfaces;

// import java.util.ArrayList;

public interface ScreenInterface extends WidgetInterface {
    /*
     * Values in content should be mapped to a value in screen_mask
     * Basically like an index that points to a value in the mask
     */
    public String[] screen_mask = {};

    public String[][] getMasked();
}