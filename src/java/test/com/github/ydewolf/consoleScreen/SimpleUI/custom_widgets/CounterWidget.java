package com.github.ydewolf.consoleScreen.SimpleUI.custom_widgets;

import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.enums.MaskIndexes;

public class CounterWidget extends DynamicWidget {
    public double seconds = 0;

    public CounterWidget(int size_x, int size_y, FillTypes fill_type) {
        super(size_x, size_y, fill_type);
        
    }

    @Override
    public void on_frame_update(double delta) {
        super.on_frame_update(delta);
        
        clearContent();
        int[] origin = {1, 1};
        seconds += delta * 0.001;

        if (seconds > this.style.size[0] - 2) {
            seconds = 0;
        }

        for (int idx = 0; idx < seconds; idx++) {
            int[] pos = {origin[0] + idx, origin[1]};
            set_pos_value(pos, MaskIndexes.CORNER.ordinal());
        }

        apply_border();
    }
}
