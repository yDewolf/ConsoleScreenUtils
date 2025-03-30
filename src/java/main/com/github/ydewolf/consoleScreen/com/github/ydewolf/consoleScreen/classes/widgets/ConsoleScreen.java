package com.github.ydewolf.consoleScreen.classes.widgets;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.interfaces.ScreenInterface;

public class ConsoleScreen extends Widget implements ScreenInterface {
    public String[] screen_mask = {};

    public ConsoleScreen(int size_x, int size_y, String[] mask) {
        super(size_x, size_y, null);
        this.screen_mask = mask;
    }

    @Override
    public String[][] getMasked() {
        String[][] final_screen = new String[super.size[1]][super.size[0]];
        
        for (int y = 0; y < super.size[1]; y++) {
            for (int x = 0; x < super.size[0]; x++) {
                if (super.content[y][x] > screen_mask.length || super.content[y][x] < 0) {
                    System.err.println("ERROR: Can't apply Screen Mask | Value at this.content can't be mapped");
                    return final_screen;
                }

                final_screen[y][x] = this.screen_mask[super.content[y][x]];
            }
        }

        return final_screen;
    }

    public String getPrintable() {
        String[][] screen_matrix = getMasked();

        String stringified = "";
        for (int y = 0; y < super.size[1]; y++) {
            String row_str = "";
            for (int x = 0; x < super.size[0]; x++) {
                row_str += screen_matrix[y][x];
            }

            stringified += row_str + "\n";
        }

        return stringified;
    }
}
