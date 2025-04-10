package com.github.ydewolf.consoleScreen.interfaces;

import com.github.ydewolf.consoleScreen.interfaces.style.StyleInterface;

public interface TreeWidgetInterface {
    public void setPos(int[] pos, int value);

    public void setStyle(StyleInterface style);

    public void setSize(int x, int y);
    public void setSize(int[] new_size);

    public void clearContent();

    public void mapWidgets();
    public void mapWidget(TreeWidgetInterface widget);
}
