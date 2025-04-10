
import com.github.ydewolf.consoleScreen.classes.TreeWidget;
import com.github.ydewolf.consoleScreen.classes.WidgetScreen;
import com.github.ydewolf.consoleScreen.classes.structural.NodeTree;
import com.github.ydewolf.consoleScreen.classes.FlexWidget;
import com.github.ydewolf.consoleScreen.enums.FillTypes;
import com.github.ydewolf.consoleScreen.enums.FlexDirection;

public class MainTest {
    public static void main(String[] args) {
        NodeTree tree = new NodeTree();

        String[] mask = {" ", "+", "|", "=", "="};
        WidgetScreen screen = new WidgetScreen(10, 5, mask);
        FlexWidget flex = new FlexWidget(10, 5, FlexDirection.COLUMN);
        TreeWidget widget = new TreeWidget(10, 3, FillTypes.BORDER);

        tree.addNode(screen);
        screen.addNode(flex);
        flex.addNode(widget);
        
        flex.mapWidgets();
        screen.mapWidgets();
        System.out.print(screen.getPrintable());
        
    }
}
