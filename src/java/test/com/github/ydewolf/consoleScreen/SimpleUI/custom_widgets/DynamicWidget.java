package com.github.ydewolf.consoleScreen.SimpleUI.custom_widgets;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.interfaces.DynamicWidgetInterface;

public class DynamicWidget extends Widget implements DynamicWidgetInterface {

    public DynamicWidget(int size_x, int size_y, FillTypes fill_type) {
        super(size_x, size_y, fill_type);
    }

    @Override
    public void on_frame_update(double delta) {
        for (Widget widget : this.getWidgets()) {
            if (DynamicWidget.class.isAssignableFrom(widget.getClass())) {
                ((DynamicWidget) widget).on_frame_update(delta);
            }
        }
    }
}
