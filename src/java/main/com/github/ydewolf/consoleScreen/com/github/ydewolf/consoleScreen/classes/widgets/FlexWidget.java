package com.github.ydewolf.consoleScreen.classes.widgets;

import com.github.ydewolf.consoleScreen.classes.Widget;
import com.github.ydewolf.consoleScreen.classes.style.FlexStyle;
import com.github.ydewolf.consoleScreen.enums.AlignTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public class FlexWidget extends Widget {
    // FlexDirection direction;
    public boolean[] auto_resize = {false, false};

    public FlexStyle flex_style;

    public FlexWidget(int size_x, int size_y, FlexDirection flex_direction) {
        super(size_x, size_y, null);
        this.flex_style = new FlexStyle(flex_direction, AlignTypes.LEFT);
        
        auto_resize[0] = size_x == 0;
        auto_resize[1] = size_y == 0;
    }

    @Override
    public int addWidget(Widget widget) {
        int idx = super.addWidget(widget);
        update_size();

        return idx;
    }

    @Override
    public boolean removeWidget(int idx) {
        boolean result = super.removeWidget(idx);
        update_size();

        return result;
    }


    private void update_size() {
        for (int axis = 0; axis < 2; axis++) {
            if (auto_resize[axis]) {
                
                int[] total_size = {this.style.size[0], this.style.size[1]};
                for (Widget wdgt : this.widgets) {
                    int[] widget_size = wdgt.style.size;
                    // If the grow direction is different from the axis,
                    // The size of this axis should be the greater widget size
                    if (this.flex_style.flex_direction.ordinal() != axis) {
                        total_size[axis] = widget_size[axis] > total_size[axis] ? widget_size[axis] : total_size[axis];

                    } else {
                        total_size[axis] += widget_size[axis];
                    }
                }
        
                set_size(total_size);
            }
        }
    }

    @Override
    public void mapWidgets() {
        this.clearContent();

        flex_widgets(this.flex_style.flex_direction);

        for (Widget widget : this.widgets) {
            mapWidget(widget);
        }
    }

    private void flex_widgets(FlexDirection flex) {        
        int axis = 0;

        switch (flex) {
            case FlexDirection.ROW:
                axis = 0;

                break;
        
            case FlexDirection.COLUMN:
                axis = 1;

                break;

            default:
                break;
        }

        int spacing = 0;
        int total_size = 0;

        for (Widget widget : this.widgets) {
            total_size += widget.style.size[axis];
        }

        spacing = get_equal_spacing(total_size, this.style.size[axis], this.widgets.size());
        int current_offset = 0;
        for (int idx = 0; idx < this.widgets.size(); idx++) {
            Widget widget = this.widgets.get(idx);
            int[] offset = widget.style.offset;
            int[] size = widget.style.size;

            offset[axis] = current_offset + spacing;

            current_offset = offset[axis] + size[axis] + (widget.style.size[axis] / this.style.size[axis]);
        }

        // Do a final center considering the whole 'object' (all the objects already spaced)
        int border_space = get_equal_spacing(total_size + spacing * (this.widgets.size() + 1), this.style.size[axis], 1);
        for (Widget widget : this.widgets) {
            widget.style.offset[axis] += border_space;
        }
    }

    private static int get_equal_spacing(int size, int max_size, int object_count) {
        return (max_size - size) / (object_count + 1);
    }
}
