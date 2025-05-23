package com.github.ydewolf.consoleScreen.classes;

import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.interfaces.WidgetScreenInterface;

public class WidgetScreen extends TreeWidget implements WidgetScreenInterface{
    public String[] screen_mask;

    public WidgetScreen(int size_x, int size_y, String[] mask) {
        super(size_x, size_y, FillTypes.NONE);
        this.screen_mask = mask;
    }

    @Override
    public String[][] getMasked() {
        String[][] final_screen = new String[super.style.size[1]][super.style.size[0]];

        for (int y = 0; y < super.style.size[1]; y++) {
            for (int x = 0; x < super.style.size[0]; x++) {
                if (super.content[y][x] > this.screen_mask.length || super.content[y][x] < 0) {
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
        for (int y = 0; y < super.style.size[1]; y++) {
            String row_str = "";
            for (int x = 0; x < super.style.size[0]; x++) {
                row_str += screen_matrix[y][x];
            }

            stringified += row_str + "\n";
        }

        return stringified;
    }
}
