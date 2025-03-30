package com.github.ydewolf.consoleScreen.SimpleUI;

import java.util.Timer;
import java.util.TimerTask;

import com.github.ydewolf.consoleScreen.SimpleUI.custom_widgets.CounterWidget;
import com.github.ydewolf.consoleScreen.SimpleUI.custom_widgets.DynamicScreen;
// import com.github.ydewolf.consoleScreen.classes.widgets.FlexWidget;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
// import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public class Main {
    public static void main(String[] args) {
        // FlexWidget main_row = new FlexWidget(50, 10, FlexDirection.ROW);
        CounterWidget counter = new CounterWidget(10, 5, FillTypes.BORDER);
        // main_row.addWidget(counter);

        String[] mask = {" ", "+", "|", "=", "="};
        DynamicScreen screen = new DynamicScreen(50, 10, mask);
        screen.addWidget(counter);

        int update_rate_ms = 1000 / 60;
        long time = System.currentTimeMillis();

        Timer timer = new Timer();
        Runnable main_update = new Runnable() {
            public void run() {
                // System.out.print("\033[H\033[2J");
                System.out.flush();
                
                screen.on_frame_update(update_rate_ms);
                System.out.print(screen.getPrintable());
            }   
        };

        timer.schedule(new TimerTask() {
        public void run() {
            main_update.run();
        }
        }, time % update_rate_ms, update_rate_ms);
    }
}
