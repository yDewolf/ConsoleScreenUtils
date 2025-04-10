package com.github.ydewolf.consoleScreen.abstract_classes.style;

public abstract class BaseScreenStyle {
    public String[] mask = {" ", "+", "|", "=", "="};
    // ANSI -> Reset, Red, Green, Blue
    public String[] colors = {"\u001B[0m", "\u001B[31m", "\u001B[32m", "\u001B[34m"};
}
