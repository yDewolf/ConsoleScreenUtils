package com.github.ydewolf.consoleScreen.classes.style;

import com.github.ydewolf.consoleScreen.abstract_classes.style.BaseFlexStyle;
import com.github.ydewolf.consoleScreen.abstract_classes.style.BaseStyle;
import com.github.ydewolf.consoleScreen.enums.AlignTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public class FlexStyle extends BaseFlexStyle{

    public FlexStyle(BaseStyle style) {
        super(style);
    }
    
    public FlexStyle(FlexDirection flex_direction, AlignTypes align_type) {
        super(flex_direction, align_type);
    }
}
