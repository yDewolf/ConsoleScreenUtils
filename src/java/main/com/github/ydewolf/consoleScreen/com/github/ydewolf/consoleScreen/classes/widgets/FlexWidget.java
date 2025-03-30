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

        // Place widgets one below the other 
        offset_widgets(this.direction);
        space_widgets(this.direction);

        for (Widget widget : this.widgets) {
            mapWidget(widget);
        }
    }

    private void offset_widgets(FlexDirection flex) {
        int offset = 0;
        switch (flex) {
            case FlexDirection.ROW:
                offset = 0;

                for (Widget widget : this.widgets) {
                    widget.offset[0] = offset;
                    offset += widget.SIZE_X;
                }
                break;
        
            case FlexDirection.COLUMN:
                offset = 0;

                for (Widget widget : this.widgets) {
                    widget.offset[1] = offset;
                    offset += widget.SIZE_Y;
                }
                break;

            default:
                break;
        }
    }

    private void space_widgets(FlexDirection flex) {
        int spacing = 0;
        int total_size = 0;

        switch (flex) {
            case FlexDirection.ROW:
                for (Widget widget : this.widgets) {
                    total_size += widget.SIZE_X;
                }

                spacing = get_equal_spacing(total_size, SIZE_X, this.widgets.size());
                int current_offset = 0;
                for (int idx = 0; idx < this.widgets.size(); idx++) {
                    Widget widget = this.widgets.get(idx);
                    widget.offset[0] = current_offset + spacing;
                    current_offset = widget.offset[0] + widget.SIZE_X + (widget.SIZE_X / this.SIZE_X);
                }

                break;
        
            case FlexDirection.COLUMN:
                // for (Widget widget : this.widgets) {
                //     total_size += widget.SIZE_Y;
                // }
                // spacing = (this.SIZE_Y - total_size) / this.widgets.size();
                
                // for (Widget widget : this.widgets) {
                //     widget.offset[1] += spacing / 2;
                // }

                break;

            default:
                break;
        }
    }

    private static int get_equal_spacing(int size, int max_size, int object_count) {
        return (max_size - size) / (object_count + 1);
    }
}
