package com.github.ydewolf.consoleScreen.interfaces.style;

import com.github.ydewolf.consoleScreen.classes.style.Style;
import com.github.ydewolf.consoleScreen.enums.FillTypes;

public interface StyleInterface {
    public int[] offset = new int[2];
    public int[] size = new int[2];

    public FillTypes fill_type = FillTypes.NONE;

    public void inherit(Style style);
}
