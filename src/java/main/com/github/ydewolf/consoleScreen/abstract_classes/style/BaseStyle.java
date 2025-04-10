package com.github.ydewolf.consoleScreen.abstract_classes.style;

import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.interfaces.style.StyleInterface;

public abstract class BaseStyle implements StyleInterface {
    public int[] offset = new int[2];
    public int[] size = new int[2];

    public FillTypes fill_type = FillTypes.NONE;

    public BaseStyle(BaseStyle parent_style) {
        inherit(parent_style);
    }

    public BaseStyle(int size_x, int size_y, FillTypes fill_type) {
        this.size[0] = size_x;
        this.size[1] = size_y;
        this.fill_type = fill_type;
    }

    public BaseStyle() {
        this.size = new int[2];
        this.offset = new int[2];
    }

    @Override
    public void inherit(BaseStyle style) {
        this.size = style.size;
        this.offset = style.offset;
    }
}
