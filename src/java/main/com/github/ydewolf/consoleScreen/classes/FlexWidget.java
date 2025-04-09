package com.github.ydewolf.consoleScreen.classes;

import com.github.ydewolf.consoleScreen.classes.style.FlexStyle;

import com.github.ydewolf.consoleScreen.deprecated.classes.Widget;

import com.github.ydewolf.consoleScreen.classes.TreeWidget;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;
import com.github.ydewolf.consoleScreen.interfaces.structure.TreeNodeInterface;

public class FlexWidget extends TreeWidget {
public boolean[] auto_resize = {false, false};

    public FlexStyle style;

    public FlexWidget(int size_x, int size_y, FlexDirection flex_direction) {
        super(size_x, size_y, null);
        this.style = new FlexStyle(super.style);
        this.style.flex_direction = flex_direction;

        auto_resize[0] = size_x == 0;
        auto_resize[1] = size_y == 0;
    }

    @Override
    public int addNode(TreeNodeInterface node) {
        int node_idx = super.addNode(node);
        update_size();

        return node_idx;
    }

    @Override
    public void removeNode(int idx) {
        super.removeNode(idx);
        update_size();
    }


    private void update_size() {
        for (int axis = 0; axis < 2; axis++) {
            if (auto_resize[axis]) {
                
                int[] total_size = {this.style.size[0], this.style.size[1]};
                for (TreeWidget wdgt : this.getWidgets()) {
                    int[] widget_size = wdgt.style.size;
                    // If the grow direction is different from the axis,
                    // The size of this axis should be the greater widget size
                    if (this.style.flex_direction.ordinal() != axis) {
                        total_size[axis] = widget_size[axis] > total_size[axis] ? widget_size[axis] : total_size[axis];
                    } else {
                        total_size[axis] += widget_size[axis];
                    }
                }
        
                setSize(total_size);
            }
        }
    }

    @Override
    public void mapWidgets() {
        this.clearContent();

        flex_widgets(this.style.flex_direction);

        for (TreeWidget widget : this.getWidgets()) {
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

        TreeWidget[] widgets = this.getWidgets();
        for (TreeWidget widget : widgets) {
            total_size += widget.style.size[axis];
        }

        spacing = get_equal_spacing(total_size, this.style.size[axis], widgets.length);
        int current_offset = 0;
        for (int idx = 0; idx < widgets.length; idx++) {
            TreeWidget widget = widgets[idx];
            int[] offset = widget.style.offset;
            int[] size = widget.style.size;

            offset[axis] = current_offset + spacing;

            current_offset = offset[axis] + size[axis] + (widget.style.size[axis] / this.style.size[axis]);
        }

        // Do a final center considering the whole 'object' (all the objects already spaced)
        // Checar esse + 1 aí depois
        int border_space = get_equal_spacing(total_size + spacing * (widgets.length + 1), this.style.size[axis], 1);
        for (TreeWidget widget : widgets) {
            widget.style.offset[axis] += border_space;
        }
    }

    private static int get_equal_spacing(int size, int max_size, int object_count) {
        return (max_size - size) / (object_count + 1);
    }
}
