package com.github.ydewolf.consoleScreen;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.classes.widgets.ConsoleScreen;
import com.github.ydewolf.consoleScreen.classes.widgets.FlexWidget;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public class MainTest {
    public static void main(String[] args) {
        FlexWidget flex_widget = new FlexWidget(0, 15, FlexDirection.COLUMN);
        FlexWidget flex_widget2 = new FlexWidget(50, 15, FlexDirection.ROW);
        String[] mask = {" ", "+", "|", "=", "="};

        ConsoleScreen root = new ConsoleScreen(50, 15, mask);
        
        Widget widget1 = new Widget(10, 5, FillTypes.BORDER);
        Widget widget2 = new Widget(5, 3, FillTypes.CHECKERS);
        Widget widget3 = new Widget(5, 5, FillTypes.CHECKERS);
        Widget widget4 = new Widget(5, 5, FillTypes.CHECKERS);
        
        
        flex_widget.addWidget(widget1);
        flex_widget.addWidget(widget2);
        
        flex_widget2.addWidget(flex_widget);
        // flex_widget.addWidget(widget3);
        // flex_widget.addWidget(widget4);
        flex_widget.mapWidgets();
        flex_widget2.mapWidgets();
        
        root.addWidget(flex_widget2);
        root.mapWidgets();
        System.out.print(root.getPrintable());
    }
}
