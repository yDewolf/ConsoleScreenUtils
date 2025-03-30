package com.github.ydewolf.consoleScreen;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.classes.widgets.ConsoleScreen;
import com.github.ydewolf.consoleScreen.classes.widgets.FlexWidget;

import enums.FlexDirection;

public class Main {
    public static void main(String[] args) {
        FlexWidget flex_widget = new FlexWidget(5, 15, FlexDirection.COLUMN);
        FlexWidget flex_widget2 = new FlexWidget(50, 15, FlexDirection.ROW);
        String[] mask = {"_", "o", "."};
        ConsoleScreen root = new ConsoleScreen(50, 15, mask);
        flex_widget2.addWidget(flex_widget);
        root.addWidget(flex_widget2);

        Widget widget1 = new Widget(5, 3, true);
        Widget widget2 = new Widget(5, 5, true);
        Widget widget3 = new Widget(5, 5, true);
        Widget widget4 = new Widget(5, 5, true);

        flex_widget.addWidget(widget1);
        // flex_widget.addWidget(widget2);
        // flex_widget.addWidget(widget3);
        // flex_widget.addWidget(widget4);
        flex_widget.mapWidgets();
        flex_widget2.mapWidgets();
        
        // int count = 0;
        // for (int y = 0; y < 10; y++) {
        //     for (int x = 0; x < 10; x++) {
        //         int[] pos = {x, y};
        //         widget1.set_pos_value(pos, count % 2 == 0 ? 1 : 0);
        //         if (x < 5 && y < 5) {
        //             widget2.set_pos_value(pos, count % 2 == 0 ? 0 : 1);

        //         }
        //         count += 1;
        //         if (count > 1) {
        //             count = 0;
        //         }    
        //     }        
        // }

        root.mapWidgets();
        System.out.print(root.getPrintable());
    }
}
