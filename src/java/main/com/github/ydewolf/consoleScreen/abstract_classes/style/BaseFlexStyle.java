package com.github.ydewolf.consoleScreen.abstract_classes.style;

import com.github.ydewolf.consoleScreen.enums.AlignTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public abstract class BaseFlexStyle extends BaseStyle {
    public FlexDirection flex_direction = FlexDirection.ROW;
    public AlignTypes align_type = AlignTypes.CENTER;

    public BaseFlexStyle(FlexDirection flex_direction, AlignTypes align_type) {
        this.flex_direction = flex_direction;
        this.align_type = align_type;
    }

    public BaseFlexStyle(BaseStyle style) {
        this.inherit(style);
    }
}
