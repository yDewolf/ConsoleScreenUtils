package com.github.ydewolf.consoleScreen.classes.style;

import com.github.ydewolf.consoleScreen.enums.AlignTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;
import com.github.ydewolf.consoleScreen.interfaces.style.FlexStyleInterface;

public class FlexStyle extends Style implements FlexStyleInterface{
    public FlexDirection flex_direction = FlexDirection.ROW;
    public AlignTypes align_type = AlignTypes.CENTER;

    public FlexStyle(FlexDirection flex_direction, AlignTypes align_type) {
        this.flex_direction = flex_direction;
        this.align_type = align_type;
    }

    public FlexStyle(Style style) {
        this.inherit(style);
    }
}
