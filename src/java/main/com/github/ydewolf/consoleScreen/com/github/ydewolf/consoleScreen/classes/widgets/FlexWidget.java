package com.github.ydewolf.consoleScreen.classes.widgets;

import com.github.ydewolf.consoleScreen.classes.Widget;

import enums.FlexDirection;

public class FlexWidget extends Widget {
    FlexDirection direction;

    public FlexWidget(int size_x, int size_y, FlexDirection flex_direction) {
        super(size_x, size_y, false);
        this.direction = flex_direction;
    }

    @Override
    public void mapWidgets() {
        this.clearContent();

        flex_widgets(this.direction);

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
            total_size += widget.size[axis];
        }

        spacing = get_equal_spacing(total_size, this.size[axis], this.widgets.size());
        int current_offset = 0;
        for (int idx = 0; idx < this.widgets.size(); idx++) {
            Widget widget = this.widgets.get(idx);
            widget.offset[axis] = current_offset + spacing;

            current_offset = widget.offset[axis] + widget.size[axis] + (widget.size[axis] / this.size[axis]);
        }

        // Do a final center considering the whole 'object' (all the objects already spaced)
        int border_space = get_equal_spacing(total_size + spacing * (this.widgets.size() + 1), this.size[axis], 1);
        for (Widget widget : this.widgets) {
            widget.offset[axis] += border_space;
        }
    }

    private static int get_equal_spacing(int size, int max_size, int object_count) {
        return (max_size - size) / (object_count + 1);
    }
}
