package com.github.ydewolf.consoleScreen;

import com.github.ydewolf.consoleScreen.classes.ConsoleScreen;
import com.github.ydewolf.consoleScreen.classes.Widget;

public class Main {
    public static void main(String[] args) {
        Widget test_widget = new Widget(10, 10);
        String[] mask = {" ", "o"};
        ConsoleScreen root = new ConsoleScreen(50, 15, mask);
        root.addWidget(test_widget);
        Widget some_other_widget = new Widget(5, 5);
        root.addWidget(some_other_widget);
        
        int count = 0;
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                int[] pos = {x, y};
                test_widget.set_pos_value(pos, count % 2 == 0 ? 1 : 0);
                if (x < 5 && y < 5) {
                    some_other_widget.set_pos_value(pos, count % 2 == 0 ? 0 : 1);

                }
                count += 1;
                if (count > 1) {
                    count = 0;
                }    
            }        
        }

        root.mapWidgets();
        String stringified = root.getPrintable();
        System.out.print(stringified);
    }
}
