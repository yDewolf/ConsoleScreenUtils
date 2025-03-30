package com.github.ydewolf.consoleScreen.SimpleUI.custom_widgets;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.classes.widgets.ConsoleScreen;
import com.github.ydewolf.consoleScreen.interfaces.DynamicWidgetInterface;

public class DynamicScreen extends ConsoleScreen implements DynamicWidgetInterface{
    // public ArrayList<Widget> widgets = new ArrayList<Widget>();

    public DynamicScreen(int size_x, int size_y, String[] mask) {
        super(size_x, size_y, mask);
    }

    @Override
    public void on_frame_update(double delta) {
        for (Widget widget : this.getWidgets()) {
            if (DynamicWidget.class.isAssignableFrom(widget.getClass())) {
                ((DynamicWidget) widget).on_frame_update(delta);
            }
        }

        mapWidgets();
    }
    
}
