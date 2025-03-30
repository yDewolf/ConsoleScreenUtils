package com.github.ydewolf.consoleScreen.classes.style;

import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.interfaces.style.StyleInterface;

public class Style implements StyleInterface {
    public int[] size = new int[2];
    public int[] offset = new int[2];

    public FillTypes fill_type = FillTypes.NONE;

    public Style(Style parent_style) {
        inherit(parent_style);
    }

    public Style() {
        this.size = new int[2];
        this.offset = new int[2];
    }

    @Override
    public void inherit(Style style) {
        this.size = style.size;
        this.offset = style.offset;
    }
}
