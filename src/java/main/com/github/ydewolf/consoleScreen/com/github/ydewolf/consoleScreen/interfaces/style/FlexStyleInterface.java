package com.github.ydewolf.consoleScreen.interfaces.style;

import com.github.ydewolf.consoleScreen.enums.AlignTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

// Will be passed to a Widget object
public interface FlexStyleInterface {
    public FlexDirection flex_type = FlexDirection.ROW;
    public AlignTypes align_type = AlignTypes.CENTER;
}
